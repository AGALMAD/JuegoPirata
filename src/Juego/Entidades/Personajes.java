package Juego.Entidades;

public abstract class Personajes extends Entidad implements Movimiento {

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param skin
     * @param posicion
     */
    public Personajes(char skin, Coordenadas posicion) {
        super(skin, posicion);
    }

    /**
     * Constructor para pasarle la skin y la posicion x e y
     * @param skin caracter que va tener cada entidad
     * @param x posicion X
     * @param y posicion Y
     */
}
