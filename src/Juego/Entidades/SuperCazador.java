package Juego.Entidades;

import Juego.Tablero.Tablero;

public class SuperCazador extends Cazadores {

    private static final Character skinSuperCazador = 'S';

    /**
     * Constructor para pasarle la skin y la posicion ya instanciada
     * @param posicion
     */
    public SuperCazador(Coordenadas posicion) {
        super(skinSuperCazador, posicion);
    }


    /**
     * Método moverPersonaje
     * Según el movimiento aleatorio que realice el programa, mueve el personaje 2 casillas. No deja que se salga del tablero
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
                y-=2;
                break;
            case 'a': //izquierda
                x-=2;
                break;
            case 's': // baja
                y+=2;
                break;
            case 'd' : //derecha
                x+=2;
                break;
        }

        //No deja que se salga del tablero
        if (x >= Tablero.COLUMNAS)
            x = Tablero.COLUMNAS -1;
        if (x < 0)
            x = 0;
        if (y >= Tablero.FILAS)
            y = Tablero.FILAS -1;
        if (y < 0)
            y = 0;

        super.posicion = new Coordenadas(x,y);
        return true;
    }
}
