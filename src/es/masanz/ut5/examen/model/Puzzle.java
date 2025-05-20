package es.masanz.ut5.examen.model;

public class Puzzle {
    private final int filas;
    private final int columnas;
    private final String[][] tablero;

    public Puzzle(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new String[filas][columnas];
    }

    public Pieza generarPieza() {
        return new Pieza(TipoPieza.getAleatoria());
    }

    public boolean colocarPieza(Pieza pieza, int x, int y) {
        int[][] forma = pieza.getForma();
        int filasPieza = forma.length;
        int columnasPieza = forma[0].length;

        if(!validarPieza(pieza, x, y)){
            return false;
        }

        for (int i = 0; i < filasPieza; i++) {
            for (int j = 0; j < columnasPieza; j++) {
                if (forma[i][j] == 1) {
                    tablero[x + i][y + j] = pieza.getColor() + pieza.getLetra() + "\u001B[0m";
                }
            }
        }

        return true;
    }

    public boolean validarPieza(Pieza pieza, int x, int y) {
        int[][] forma = pieza.getForma();
        int filasPieza = forma.length;
        int columnasPieza = forma[0].length;

        for (int i = 0; i < filasPieza; i++) {
            for (int j = 0; j < columnasPieza; j++) {
                if (forma[i][j] == 1) {
                    int filaTablero = x + i;
                    int columnaTablero = y + j;

                    if (filaTablero < 0 || filaTablero >= filas || columnaTablero < 0 || columnaTablero >= columnas) {
                        return false;
                    }

                    if (tablero[filaTablero][columnaTablero] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean tableroCompletado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + tablero[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public String[][] getTablero() {
        return tablero;
    }
}