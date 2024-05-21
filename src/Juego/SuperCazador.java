package Juego;

public class SuperCazador extends Personajes{
    public SuperCazador(char s, Coordenadas posicion) {
        super(s, posicion);
    }

    public SuperCazador(char skin, int x, int y) {
        super(skin, x, y);
    }


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
        if (x > Tablero.COLUMNAS)
            x = Tablero.COLUMNAS;
        if (x < 0)
            x = 0;
        if (y > Tablero.FILAS)
            y = Tablero.FILAS;
        if (y < 0)
            y = 0;

        super.posicion = new Coordenadas(x,y);
        return true;
    }
}
