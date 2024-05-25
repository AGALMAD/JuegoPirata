package Juego.Entidades;

public class Coordenadas {
    /**
     * Atributos (x, y) para poder almacenar las coordenadas de una entidad
     */
    private int x;
    private int y;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Método equals
     * para saber si una coordenada es igual que otra
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenadas that)) return false;
        return x == that.x && y == that.y;
    }

    /**
     * Método obtenerCoordenadas
     * Para poder pasar las coordenadas completas para poder compararlas
     * @return coordenada propia
     */
    public Coordenadas obtenerCoordenadas(){
        return new Coordenadas(this.x, this.y);
    }

    /**
     * Método getX
     * @return posicion X
     */
    public int getX() {
        return x;
    }

    /**
     * Método getY
     * @return posicion Y
     */
    public int getY() {
        return y;
    }
}
