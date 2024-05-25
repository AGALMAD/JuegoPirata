package Juego.Entidades;

import Juego.Tablero.Tablero;

public class Pirata extends Personajes {
    //Caracter que va a representar al pirata
    private static final Character skinPirata = 'P';

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param posicion
     */
    public Pirata(Coordenadas posicion) {
        super(skinPirata, posicion);
    }

    /**
     * Método moverPersonaje
     * Según la tecla que pulse el jugador, mueve el personaje. No deja que se salga del tablero
     * @param movimiento
     * @return false si se sale del tablero | true si se ha podido mover correctamente
     */
    @Override
    public boolean moverPersonaje(Character movimiento) {
        //Recoge la posicion actual
        int x = super.posicion.getX();
        int y = super.posicion.getY();
        //Mueve la posicion
        switch (movimiento){
            case 'w': //sube
                y--;
                break;
            case 'a': //izquierda
                x--;
                break;
            case 's': // baja
                y++;
                break;
            case 'd' : //derecha
                x++;
                break;
        }
        //Si se sale del tablero no cambia la posicion
        if (x >= Tablero.COLUMNAS || x < 0 || y >= Tablero.FILAS || y < 0)
            return false;

        super.posicion = new Coordenadas(x,y);
        return true;
    }



}
