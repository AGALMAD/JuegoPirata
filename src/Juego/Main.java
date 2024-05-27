package Juego;

import Juego.Entidades.ExcepcionPropiaMovimiento;
import Juego.Tablero.Tablero;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        int salida = 0;
        char movimiento;
        boolean win = false;
        //Dificultad Extrema
        int numCazadores = 6, numSupercazadores = 4;
        int dificultad = 1;

        //Pide la dificultad
        try {
            System.out.println("""
                    Dificultad
                    1. Facil
                    2. Dificil
                    3. Extremo""");
            dificultad = sc.nextInt();
            sc.nextLine();
        }
        catch (InputMismatchException e){
            System.err.println("Solo puedes introducir números");
        }

        //Introduce el número de cazadores y de super cazadores, según la dificultad
        switch (dificultad){
            case 1:
                System.out.println("Tienes miedo ?\n");
                numCazadores = 2;
                numSupercazadores = 2;
                break;
            case 2:
                System.out.println("No lo tienes facil\n");
                numCazadores = 4;
                numSupercazadores = 3;
                break;
            case 3:
                System.out.println("Chiquito LOCO!!\n");
                break;
            default:
                System.err.println("Dificultad incorrecta, se ha asignado dificultad EXTREMA");
        }
        Tablero tablero = new Tablero(numCazadores, numSupercazadores);

        System.out.println("""
                Moviminetos posibles\s
                W : Subir
                A : Derecha
                S : Bajar
                D : Izquierda
                """);


        //Sigue el juego hasta que se produzca una opción de salida
        while (salida >= 0){

            tablero.mostrarTablero();

            try {
                System.out.print("Movimiento : ");
                movimiento = sc.nextLine().charAt(0);

                //Si no introduce un movimiento válido, muestra el error
                if (movimiento != 'w' && movimiento != 'a' && movimiento != 's' && movimiento != 'd' )
                    throw new ExcepcionPropiaMovimiento("Movimiento nulo, solo puedes pulsar wasd");
                else {
                    salida = tablero.moverPirata(movimiento);
                    if (salida == -1)
                        System.err.println("Te has topado con un Cazador");
                    //Si se intenta salir del tablero, muestra un error
                    else if (salida == 1)
                        throw new ExcepcionPropiaMovimiento("No te puedes salir del tablero");
                    else if (salida == -2) {
                        win = true;
                    } else {
                        salida = tablero.moverCazadores();
                        if (salida == -1)
                            System.err.println("Has sido cazado");
                        else if (salida == -2)
                            System.err.println("Los cazadores han encontrado el tesoro");

                    }
                }
            }
            //Muestra la excepción recogida
            catch (ExcepcionPropiaMovimiento e){
                System.err.println(e.toString());
            }

        }


        tablero.mostrarTablero();

        //Si ha ganado, recibe una copa
        if (win) {
            System.out.println("Has encontrado el tesoro\n");
            System.out.println("VICTORIA");
            System.out.println(
                    """
                            *********
                             *******\s
                              ***** \s
                               ***  \s
                                *   \s
                               ***  \s
                               ***  \s
                               ***  \s"""
            );
        }
        //Si pierde, carita triste
        else {
            System.err.println("PERDISTE");
            System.err.println(
                    """
                               _____  \s
                              /     \\ \s
                             | () () |\s
                              \\  ^  / \s
                               _____  \s
                            """

            );
        }
    }
}
