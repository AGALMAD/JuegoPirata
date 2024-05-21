package Juego;

public abstract class Cazadores extends Personajes implements Cloneable{
    public Cazadores(char s, Coordenadas posicion) {
        super(s, posicion);
    }

    public Cazadores(char skin, int x, int y) {
        super(skin, x, y);
    }


    @Override
    public abstract Cazadores clone();
}
