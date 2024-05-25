package Juego.Entidades;

public class ExcepcionPropiaMovimiento extends Exception{

    String definicion;

    /**
     * Constructor para pasale la definicion
     * @param definicion
     */
    public ExcepcionPropiaMovimiento(String definicion){
        this.definicion = definicion;
    }

    @Override
    public String toString() {
        return "ExcepcionPropiaMovimiento{" +
                "definicion='" + definicion + '\'' +
                "} " + super.toString();
    }
}
