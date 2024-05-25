package Juego.Entidades;

import Juego.Tablero.Tablero;

public class CazadorMalo extends Cazadores {

    private static final Character skinCazador = 'C';

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param posicion
     */
    public CazadorMalo(Coordenadas posicion) {
        super(skinCazador, posicion);
    }


    /**
     * Método moverPersonaje
     * Según el movimiento aleatorio que realice el programa, mueve el personaje. No deja que se salga del tablero
     * @param movimiento
     * @return false si se sale del tablero | true si se ha podido mover correctamente
     */
    @Override
    public boolean moverPersonaje(Character movimiento) {
        int x = 0,y = 0 ;
        x = super.posicion.getX();
        y = super.posicion.getY();

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
