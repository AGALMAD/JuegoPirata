package Juego;

public class CazadorMalo extends Cazadores{


    public CazadorMalo(char s, Coordenadas posicion) {
        super(s, posicion);
    }

    public CazadorMalo(char skin, int x, int y) {
        super(skin, x, y);
    }


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
        if (x > Tablero.COLUMNAS || x < 0 || y > Tablero.FILAS || y < 0)
            return false;

        super.posicion = new Coordenadas(x,y);
        return true;

    }


    @Override
    public Cazadores clone() {
        return new CazadorMalo(super.skin,super.posicion);
    }


}
