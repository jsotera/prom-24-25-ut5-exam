package es.masanz.utrep.puzzletetris;


import es.masanz.utrep.puzzletetris.model.Pieza;
import es.masanz.utrep.puzzletetris.model.Puzzle;
import es.masanz.utrep.puzzletetris.model.TipoPieza;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        Puzzle puzzle = new Puzzle(10, 10);
/*
        Pieza pieza = puzzle.generarPieza();
        pieza.rotar();
        pieza.rotar();
        pieza.rotar();

        puzzle.colocarPieza(pieza, 0, 0);

        pieza = puzzle.generarPieza();
        puzzle.colocarPieza(pieza, 5, 5);

        puzzle.mostrarTablero();
*/
        while(true){
            Pieza pieza = puzzle.generarPieza();
            mostrarMenu(pieza, puzzle);
            puzzle.mostrarTablero();
        }


    }

    public static void mostrarMenu(Pieza pieza, Puzzle puzzle){
        System.out.println("Esta es tu pieza, ¿Qué hacer? [c - colocar (por defecto), r - rotar]");
        pieza.mostrarPieza();
        String respuesta = scanner.nextLine();
        if(respuesta.equalsIgnoreCase("c")){
            System.out.println("Dame la fila:");
            int fila = scanner.nextInt();
            System.out.println("Dame la columna:");
            int columna = scanner.nextInt();
            puzzle.colocarPieza(pieza, fila, columna);
        } else if(respuesta.equalsIgnoreCase("r")){
            pieza.rotar();
            mostrarMenu(pieza, puzzle);
        }
    }

}