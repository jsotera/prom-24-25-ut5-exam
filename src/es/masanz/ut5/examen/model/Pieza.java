package es.masanz.ut5.examen.model;

public class Pieza {
    private int[][] forma;
    private String color;
    private String letra;

    public Pieza(TipoPieza tipo) {
        this.forma = tipo.getForma();
        this.color = tipo.getColor();
        this.letra = tipo.getLetra();
    }

    public void rotar() {
        int filas = forma.length;
        int columnas = forma[0].length;
        int[][] nuevaMatriz = new int[columnas][filas];

        // Rotar 90 grados en el sentido de las agujas del reloj
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[j][filas - 1 - i] = forma[i][j];
            }
        }

        forma = nuevaMatriz;
    }

    public void mostrarPieza() {
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[i].length; j++) {
                if (forma[i][j] == 1) {
                    System.out.print("["+color + letra + "\u001B[0m]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public int[][] getForma() {
        return forma;
    }

    public String getColor() {
        return color;
    }

    public String getLetra() {
        return letra;
    }
}