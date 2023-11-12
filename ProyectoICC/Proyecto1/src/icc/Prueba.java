//Código mío

package icc;

import java.util.Scanner;
import icc.colors.Colors;
import icc.clases.Modelo;
import icc.clases.Calendario;

public class Prueba {

    private static final Scanner scn = new Scanner(System.in);

    public static int getInt(String mensaje, String error, int min, int max) {
        int val;
        while (true) {
            Colors.println(mensaje, Colors.WHITE + Colors.HIGH_INTENSITY);
            if (scn.hasNextInt()) {
                val = scn.nextInt();
                if (val < min || max < val) {
                    System.out.println(error);
                } else {
                    return val;
                }
            } else {
                scn.next();
                System.out.println(error);
            }
        }
    }

    public static void main(String args[]) {
        int menu, opcion, opcionMenu;
        Scanner scn = new Scanner(System.in);
        Modelo modelo = new Modelo();
        Calendario calendario = new Calendario();
        Colors.println("Bienvenido, este programa es un simulador de un torneo Round-Robin de voleibol...\n",
                Colors.WHITE + Colors.HIGH_INTENSITY);
        opcion = getInt("¿Cuántos equipos tendrá tu simulación? (a partir de 2 equipos o más)",
                "Opción no válida. Introduce un número mayor o igual a 2.", 2, 10);

        // Método para la creación de equipos de acuerdo al número ingresado por el usuario y también le pedirá el nombre de cada equipo.
        modelo.equipos(opcion);

        menu = 1;

        do {
            if (menu == 1) {
                Colors.println("1. Consultar puntuaciones.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("2. Continuar simulación.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("0. Salir", Colors.WHITE + Colors.HIGH_INTENSITY);
                opcionMenu = getInt("", "Opción no válida.", 0, 2);

                switch (opcionMenu) {
                    case 1: {
                        modelo.consultar(opcion);
                        break;
                    }
                    case 2: {
                        calendario.calendarizacion(opcion);
                        break;
                    }
                    case 0: {
                        Colors.print("Vuelve pronto :)\n", Colors.CYAN + Colors.HIGH_INTENSITY);
                        break;
                    }
                }
            } else {
                Colors.println("Ya terminó el torneo.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("1. Consultar todas las puntuaciones.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("2. Consultar alguna puntuación en particular.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("3. Ver campeón.", Colors.WHITE + Colors.HIGH_INTENSITY);
                Colors.println("0. Salir", Colors.WHITE + Colors.HIGH_INTENSITY);
                opcionMenu = getInt("", "Opción no válida.", 0, 3);

                switch (opcionMenu) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 0: {
                        Colors.print("Vuelve pronto :)\n", Colors.CYAN + Colors.HIGH_INTENSITY);
                        break;
                    }
                }
            }

        } while (opcionMenu != 0);
    }
}
