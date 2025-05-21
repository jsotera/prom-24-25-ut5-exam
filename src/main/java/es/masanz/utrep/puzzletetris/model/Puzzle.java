package es.masanz.utrep.puzzletetris.model;

public class Puzzle {

    private String[][] tablero;
    private int filas, columnas;

    public Puzzle(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new String[filas][columnas];
    }

    public Pieza generarPieza() {
        TipoPieza[] tipoPiezas = TipoPieza.values();
        TipoPieza tipoPiezaRandom = tipoPiezas[(int) (Math.random()*tipoPiezas.length)];
        Pieza pieza = new Pieza(tipoPiezaRandom);
        return pieza;
    }

    public boolean validarPieza(Pieza pieza, int fila, int columna) {
        // validar dimensiones del tablero
        int columnasTablero = tablero[0].length;
        int columnasPieza = pieza.getForma()[0].length;
        if(columna > (columnasTablero - columnasPieza)){
            return false;
        }
        if(columna < 0){
            return false;
        }
        int filasTablero = tablero.length;
        int filasPieza = pieza.getForma().length;
        if(fila > (filasTablero - filasPieza)){
            return false;
        }
        if(fila < 0){
            return false;
        }
        // validar que el tablero tiene las casilla necesarias libres
        for (int filaPieza = 0; filaPieza < pieza.getForma().length; filaPieza++) {
            for (int columnaPieza = 0; columnaPieza < pieza.getForma()[0].length; columnaPieza++) {
                if(pieza.getForma()[filaPieza][columnaPieza] == 1){
                    if(tablero[fila+filaPieza][columna+columnaPieza]!=null) {
                        return false;
                    }
                }
            }
        }
        //si to va bien, genial
        return true;
    }

    public boolean colocarPieza(Pieza pieza, int fila, int columna) {
        if(validarPieza(pieza, fila, columna)){
            for (int filaPieza = 0; filaPieza < pieza.getForma().length; filaPieza++) {
                for (int columnaPieza = 0; columnaPieza < pieza.getForma()[0].length; columnaPieza++) {
                    if(pieza.getForma()[filaPieza][columnaPieza] == 1){
                        tablero[fila+filaPieza][columna+columnaPieza] = pieza.getColor()+pieza.getLetra()+Pieza.RESET;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean tableroCompletado() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[0].length; columna++) {
                String contenido = tablero[fila][columna];
                if(contenido==null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarTablero() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[0].length; columna++) {
                String contenido = tablero[fila][columna];
                System.out.print("[");
                if(contenido==null){
                    System.out.print(" ");
                } else {
                    System.out.print(contenido);
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
