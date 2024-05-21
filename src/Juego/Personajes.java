package Juego;

public abstract class Personajes extends Entidad implements Movimiento {

    public Personajes(char s, Coordenadas posicion) {
        super(s, posicion);
    }

    public Personajes(char skin, int x, int y) {
        super(skin, x, y);
    }
}
