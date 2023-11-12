package icc.clases;

public class Calendario{

//Lo que hace éste método es crear una calendarización tomando como parámetro la cantidad de equipos que participan en la simulación

int numEquipos = 3; //Por ejemplo
    public static void Calendarizacion(int numEquipos) {
        if (numEquipos <= 0) {
            System.out.println("El número de equipos debe ser mayor que 0");
            return;
        }

        // Calcular el número total de partidos
        int numPartidos = numEquipos * (numEquipos - 1) / 2;

        // Crear un arreglo bidimensional para almacenar la información de los partidos
        int[][] calendario = new int[numPartidos][2];

        int ronda = 0;

        // Caso para n impar
        if (numEquipos % 2 != 0) {
            for (int r = 0; r < numEquipos; r++) {
                for (int k = 1; k <= (numEquipos - 1) / 2; k++) {
                    int equipoLocal = (r + k) % numEquipos;
                    int equipoVisitante = (r + numEquipos - k) % numEquipos;

                    calendario[ronda][0] = equipoLocal;
                    calendario[ronda][1] = equipoVisitante;

                    ronda++;
                }
            }
        } else { // Caso para n par
            for (int r = 0; r < numEquipos - 1; r++) {
                for (int k = 1; k <= numEquipos / 2; k++) {
                    int equipoLocal = (r + k) % (numEquipos - 1);
                    int equipoVisitante = (r + numEquipos - k) % (numEquipos - 1);

                    calendario[ronda][0] = equipoLocal;
                    calendario[ronda][1] = equipoVisitante;

                    ronda++;
                }
            }

            // Agregar el enfrentamiento directo del equipo que descansa contra el equipo con identificador n - 1
            for (int id = 0; id < numEquipos - 1; id++) {
                calendario[ronda][0] = id;
                calendario[ronda][1] = numEquipos - 1;
                ronda++;
            }
        }

        // Imprimir el calendario de partidos
        System.out.println("Calendario de partidos:");
        for (int i = 0; i < numPartidos; i++) {
            System.out.println("Partido " + (i + 1) + ": Equipo " + calendario[i][0] + " vs. Equipo " + calendario[i][1]);
        }
    }

}