package es.masanz.ut5.examen.model;

import java.util.Random;

public enum TipoPieza {
    I(new int[][]{{1, 1, 1, 1}}, "\u001B[32m", "I"), // VERDE
    O(new int[][]{{1, 1}, {1, 1}}, "\u001B[33m", "O"), // AMARILLO
    T(new int[][]{{0, 1, 0}, {1, 1, 1}}, "\u001B[31m", "T"), // ROJO
    L(new int[][]{{1, 0}, {1, 0}, {1, 1}}, "\u001B[34m", "L"), // AZUL
    J(new int[][]{{0, 1}, {0, 1}, {1, 1}}, "\u001B[35m", "J"), // MORADO
    S(new int[][]{{0, 1, 1}, {1, 1, 0}}, "\u001B[36m", "S"), // CIAN
    Z(new int[][]{{1, 1, 0}, {0, 1, 1}}, "\u001B[91m", "Z"); // ROJO_CLARO

    private final int[][] forma;
    private final String color;
    private final String letra;

    TipoPieza(int[][] forma, String color, String letra) {
        this.forma = forma;
        this.color = color;
        this.letra = letra;
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

    public static TipoPieza getAleatoria() {
        TipoPieza[] piezas = values();
        return piezas[new Random().nextInt(piezas.length)];
    }
}