package Juego.Entidades;

import Juego.Entidades.Coordenadas;
import Juego.Entidades.Entidad;

public class Tesoro extends Entidad {

    private static final char TESORO = 'O';

    /**
     * Constructor para pasar la posicion
     * @param posicion
     */
    public Tesoro(Coordenadas posicion) {
        super(TESORO,posicion);
    }

}
