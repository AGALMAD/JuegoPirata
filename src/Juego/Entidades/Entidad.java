package Juego.Entidades;

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

    /**Métodos getter para obtener la posición y la skin de la entidad **/
    public Coordenadas getPosicion() {
        return posicion;
    }

    public char getSkin() {
        return skin;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "skin=" + skin +
                ", posicion=" + posicion +
                '}';
    }
}
