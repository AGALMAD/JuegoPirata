package Juego;

public class Entidad {

    protected char skin;
    protected Coordenadas posicion;

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param skin
     * @param posicion
     */
    public Entidad(char skin, Coordenadas posicion) {
        this.skin = skin;
        this.posicion = posicion;
    }

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param skin caracter que va tener cada entidad
     * @param x posicion X
     * @param y posicion Y
     */
    public Entidad(char skin, int x, int y) {
        this.skin = skin;
        this.posicion = new Coordenadas(x,y);
    }


    @Override
    public String toString() {
        return "Entidad{" +
                "skin=" + skin +
                ", posicion=" + posicion +
                '}';
    }
}
