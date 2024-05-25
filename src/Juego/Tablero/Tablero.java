package Juego.Tablero;

import Juego.Entidades.*;

import java.util.ArrayList;

public class Tablero {

    private Entidad[][] tablero;
    ArrayList<Cazadores> listaCazadores;
    private Pirata pirata;
    //Núemero de filas y columnas que va a tener el tablero
    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;
    //Otras entidades
    private static final char VACIO = '-';
    private static final char WIN = 'G';
    private static final char DEAD = '*';
    private static final char ROBADO = (char)157;





    /**
     * Contructor Tablero
     * Según la dificultad, inicializa el trablero con más o menos cazadores
     * @param numCazadores
     * @param numSupercazadores
     */
    public Tablero(int numCazadores, int numSupercazadores){
        tablero = new Entidad[FILAS][COLUMNAS];
        //Crea los personajes
        listaCazadores = new ArrayList<Cazadores>();
        insertarCazadores(numCazadores);
        insertarSuperCazadores(numSupercazadores);
        pirata = new Pirata(posicionNoUsada());
        Tesoro tesoro = new Tesoro(posicionNoUsada());

        //Inicializa el tablero vacio
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new Entidad(VACIO,new Coordenadas(i,j));
            }
        }

        //Posiciona los Cazadores en el tablero
        for (Cazadores c : listaCazadores){
            tablero[c.getPosicion().getY()][c.getPosicion().getX()] = c;
        }
        //Posiciona el pirata y el tesoro
        tablero[pirata.getPosicion().getY()][pirata.getPosicion().getX()] = pirata;
        tablero[tesoro.getPosicion().getY()][tesoro.getPosicion().getX()] = tesoro;

    }

    /**
     * Método mostrarTablero
     * Muestra el tablero con las skin de cada Entidad
     */
    public void mostrarTablero(){

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j].getSkin() + " ");
            }
            System.out.print("\n");
        }
    }


    /**
     *
     * @param movimiento
     * @return 0 si se ha movido correctamente | 1 si no se ha movido | -1 si se ha encontrado con un cazador | -2 si ha encontrado el tesoro
     */
    public int moverPirata(char movimiento){
        //Recoge la coordenada anterior del pirata
        int oldY = pirata.getPosicion().getY();
        int oldX = pirata.getPosicion().getX();
        //Si el pirata no se ha movido, retorna 1
        if (!pirata.moverPersonaje(movimiento))
            return 1;

        //Recoge las nuevas coordenadas
        int newY = pirata.getPosicion().getY();
        int newX = pirata.getPosicion().getX();

        //Si se topa con un cazador retorna -1 para que termine el programa
        if (tablero[newY][newX] instanceof Cazadores) {
            tablero[oldY][oldX] = new Entidad(VACIO,new Coordenadas(oldX,oldY));
            tablero[newY][newX] = new Entidad(DEAD,new Coordenadas(newX,newY));
            return -1;
        }
        //Si ha encontrado el tesoro, retorna 2
        if (tablero[newY][newX] instanceof Tesoro) {
            tablero[oldY][oldX] = new Entidad(VACIO,new Coordenadas(oldX,oldY));
            tablero[newY][newX] = new Entidad(WIN,new Coordenadas(newX,newY));
            return -2;
        }
        //Si se ha movido correctamente retorna 0
        tablero[oldY][oldX] = new Entidad(VACIO,new Coordenadas(oldX,oldY));
        tablero[newY][newX] = pirata;
        return 0;
    }

    /**
     * Método moverCazadores
     * Mueve todos los cazadores aleatoriamente por el tablero
     * @return -1 si atrapan al Pirata | -2 si encuentran el tesoro | 0 si termina correctamente
     */
    public int moverCazadores(){

        int oldX, oldY, newX, newY;

        for(Cazadores c : listaCazadores){
            //Recoge los datos de la posicion del cazador
            oldX = c.getPosicion().getX();
            oldY = c.getPosicion().getY();
            //Lo mueve
            c.moverPersonaje(movimientoAleatorio());
            //Recoge la nueva posicion
            newX = c.getPosicion().getX();
            newY = c.getPosicion().getY();

            //Si se encuentra con el pirata, lo mata y retorna -1
            if (tablero[newY][newX] instanceof Pirata) {
                tablero[oldY][oldX] = new Entidad(VACIO, new Coordenadas(oldX,oldY));
                tablero[newY][newX] = new Entidad(DEAD, new Coordenadas(newX,newY));
                return -1;
            }
            //Si encuentra el tesoro antes que el pirata, lo roba y retorna -2
            if (tablero[newY][newX] instanceof Tesoro) {
                tablero[oldY][oldX] = new Entidad(VACIO, new Coordenadas(oldX,oldY));
                tablero[newY][newX] = new Entidad(ROBADO, new Coordenadas(newX,newY));
                return -2;
            }

            //Si no pisa ningun otro cazador, mueve este
            if (!(tablero[newY][newX] instanceof Cazadores)){
                tablero[oldY][oldX] = new Entidad(VACIO, new Coordenadas(oldX,oldY));
                tablero[newY][newX] = c;
            }

        }

        return 0;
    }

    /**
     * Método movimientoAleatorio
     * devuelve un movimiento aleatorio para poder mover los Cazadores
     * @return
     */
    private char movimientoAleatorio(){

        char[] movimientos = {'w','a','s','d'};

        return movimientos[nrandom(4)];
    }



    /**
     * Método insertarCazadores
     * Inserta en la lista, el número de cazadores indicados
     * @param numCazadores
     */
    private void insertarCazadores(int numCazadores){
        //Inserta los cazadores
        for (int i = 0; i < numCazadores; i++) {
            listaCazadores.add(new CazadorMalo(posicionNoUsada()));
        }
    }

    /**
     * Método insertarCazadores
     * Inserta en la lista, el número de Super Cazadores indicados
     * @param numSuperCazadores
     */
    private void insertarSuperCazadores(int numSuperCazadores){
        //Inserta los cazadores
        for (int i = 0; i < numSuperCazadores; i++) {
            listaCazadores.add(new SuperCazador(posicionNoUsada()));
        }
    }


    /**
     * Método privado posicionNoUsada
     * @return posicion que no esté utilizada por otra Entidad
     */
    private Coordenadas posicionNoUsada(){

        Coordenadas posicion;

        if (listaCazadores.isEmpty()) {
            posicion = new Coordenadas(nrandom(FILAS),nrandom(COLUMNAS));
            return posicion;
        }

        do {
            posicion = new Coordenadas(nrandom(FILAS),nrandom(COLUMNAS));
        }while (posicionUsada(posicion));

        return posicion;
    }

    /**
     * Método privado posicionUsada
     * Muestra si la posición está usada por un cazador
     * @param posicion
     * @return true si está utilizado | false si no está utilizada
     */
    private boolean posicionUsada(Coordenadas posicion){
        for(Entidad e : listaCazadores)
            if (e.getPosicion().equals(posicion))
                return true;

        return false;
    }

    /**
     * Método privado nrandom
     * Devuelve un número random entre 0 y n
     * @param n
     * @return
     */
    private int nrandom(int n){
        return (int) (Math.random()*n);
    }


}
