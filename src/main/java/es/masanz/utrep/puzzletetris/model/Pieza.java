package es.masanz.utrep.puzzletetris.model;

public class Pieza {

    public static final String RESET = "\u001B[0m";

    private int[][] forma;
    private String color;
    private String letra;

    public Pieza(TipoPieza tipoPieza) {
        this.forma = tipoPieza.getForma();
        this.color = tipoPieza.getColor();
        this.letra = tipoPieza.getLetra();
    }

    public void rotar(){
        int filas = forma.length;
        int columnas = forma[0].length;
        int[][] aux = new int[columnas][filas];

        /*
        // CONVERSION FILAS
        1ºF --> Ultima C
        2ºF --> Ultima-1 C
        Ultima - 1 F --> 1º - 1 C
        Ultima F --> 1º C
        for (int fila = 0; fila < forma.length; fila++) {
            int columnasAux = aux[0].length;
            aux[???][columnasAux-1-fila] = forma[fila][???];
        }
        // CONVERSION COLUMNAS
        for (int columna = 0; columna < forma[0].length; columna++) {
            aux[columna][???] = forma[???][columna];
        }
        //FUSION
        for (int fila = 0; fila < forma.length; fila++) {
            for (int columna = 0; columna < forma[0].length; columna++) {
                int columnasAux = aux[0].length;
                aux[???][columnasAux-1-fila] = forma[fila][???];
                aux[columna][???] = forma[???][columna];
            }
        }
        */

        for (int fila = 0; fila < forma.length; fila++) {
            for (int columna = 0; columna < forma[0].length; columna++) {
                int columnasAux = aux[0].length;
                aux[columna][columnasAux-1-fila] = forma[fila][columna];
            }
        }

        forma = aux;
    }

    public void mostrarPieza() {
        for (int fila = 0; fila < forma.length; fila++) {
            for (int columna = 0; columna < forma[0].length; columna++) {
                System.out.print("[");
                int valor = forma[fila][columna];
                if(valor==0){
                    System.out.print(" ");
                } else {
                    System.out.print(color+letra+RESET);
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public int[][] getForma() {
        return forma;
    }

    public void setForma(int[][] forma) {
        this.forma = forma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
