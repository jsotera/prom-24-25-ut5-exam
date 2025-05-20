package es.masanz.ut5.examen;

import es.masanz.ut5.examen.model.Pieza;
import es.masanz.ut5.examen.model.Puzzle;
import es.masanz.ut5.examen.model.TipoPieza;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Dimensiones del tablero (hardcodeadas)
        int filas = 6;
        int columnas = 10;
        Puzzle puzzle = new Puzzle(filas, columnas);

        System.out.println("Selecciona el modo de juego: \n1. Automático \n2. Manual");
        int opcion = scanner.nextInt();

        String[] letrasPiezas = new String[TipoPieza.values().length];
        int[] contadorPiezas = new int[TipoPieza.values().length];
        int index = 0;
        for (TipoPieza tipo : TipoPieza.values()) {
            letrasPiezas[index] = tipo.getLetra();
            contadorPiezas[index] = 0;
            index++;
        }

        if (opcion == 1) {
            System.out.println("Modo automático iniciado...");
            for (int i = 0; i < filas * columnas; i++) {
                Pieza pieza = puzzle.generarPieza();
                int x = random.nextInt(filas);
                int y = random.nextInt(columnas);

                // Rotar pieza con 50% de probabilidad repetidamente
                while (random.nextBoolean()) {
                    pieza.rotar();
                }

                if (puzzle.colocarPieza(pieza, x, y)) {
                    for (int j = 0; j < letrasPiezas.length; j++) {
                        if (letrasPiezas[j].equals(pieza.getLetra())) {
                            contadorPiezas[j]++;
                        }
                    }
                }
            }
            puzzle.mostrarTablero();
            System.out.println(puzzle.tableroCompletado() ? "El tablero ha sido completado correctamente!" : "El tablero NO ha sido completado.");
        } else if (opcion == 2) {
            System.out.println("Modo manual iniciado...");
            while (!puzzle.tableroCompletado()) {
                Pieza pieza = puzzle.generarPieza();
                System.out.println("Pieza a colocar: " + pieza.getLetra());
                pieza.mostrarPieza();
                System.out.println("Quieres rotar la pieza? (s/n)");
                String rotar = scanner.next();
                while (rotar.equalsIgnoreCase("s")) {
                    pieza.rotar();
                    pieza.mostrarPieza();
                    System.out.println("Rotar de nuevo? (s/n)");
                    rotar = scanner.next();
                }
                System.out.println("Introduce coordenadas x e y para colocar la pieza:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (puzzle.colocarPieza(pieza, x, y)) {
                    for (int j = 0; j < letrasPiezas.length; j++) {
                        if (letrasPiezas[j].equals(pieza.getLetra())) {
                            contadorPiezas[j]++;
                        }
                    }
                } else {
                    System.out.println("No se pudo colocar la pieza en esas coordenadas.");
                }
                puzzle.mostrarTablero();
            }
            System.out.println("Has completado el tablero!");
        } else {
            System.out.println("Opción no válida.");
        }

        // Ordenación de burbuja para mostrar resumen de piezas usadas
        for (int i = 0; i < contadorPiezas.length - 1; i++) {
            for (int j = 0; j < contadorPiezas.length - 1 - i; j++) {
                if (contadorPiezas[j] < contadorPiezas[j + 1]) {
                    int temp = contadorPiezas[j];
                    contadorPiezas[j] = contadorPiezas[j + 1];
                    contadorPiezas[j + 1] = temp;

                    String tempLetra = letrasPiezas[j];
                    letrasPiezas[j] = letrasPiezas[j + 1];
                    letrasPiezas[j + 1] = tempLetra;
                }
            }
        }

        System.out.println("\nResumen de piezas utilizadas:");
        for (int i = 0; i < letrasPiezas.length; i++) {
            System.out.println("Pieza " + letrasPiezas[i] + ": " + contadorPiezas[i] + " usos");
        }

        scanner.close();
    }

    public static void mainOtro(String[] args) {
        Puzzle tablero = new Puzzle(10, 10);
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            Pieza pieza = tablero.generarPieza();
            int x = random.nextInt(tablero.getFilas());
            int y = random.nextInt(tablero.getColumnas());

            // Rotar la pieza con una probabilidad del 50%, en un bucle aleatorio
            while (random.nextBoolean()) {
                pieza.rotar();
            }

            // Intentar colocar la pieza en el tablero
            if (tablero.validarPieza(pieza, x, y)) {
                tablero.colocarPieza(pieza, x, y);
                System.out.println("Pieza colocada en (" + x + ", " + y + ")");
            } else {
                System.out.println("No se pudo colocar la pieza en (" + x + ", " + y + ")");
            }
        }

        // Mostrar el tablero al final
        tablero.mostrarTablero();

        // Verificar si el tablero está completamente lleno
        if (tablero.tableroCompletado()) {
            System.out.println("¡El tablero ha sido completado con éxito!");
        } else {
            System.out.println("El tablero no se ha podido completar.");
        }
    }

    public static void mainViejo(String[] args) {
        Puzzle tablero = new Puzzle(10, 10);
        Pieza pieza = tablero.generarPieza();

        System.out.println("Tablero inicial:");
        tablero.mostrarTablero();

        System.out.println("Intentando colocar una pieza...");
        boolean colocada = tablero.colocarPieza(pieza, 0, 0);

        if (colocada) {
            System.out.println("Pieza colocada:");
        } else {
            System.out.println("No se pudo colocar la pieza.");
        }
        tablero.mostrarTablero();

        System.out.println("Rotando la pieza...");
        pieza.rotar();
        tablero.mostrarTablero();
    }
}
