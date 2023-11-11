package icc.clases;

import java.util.ArrayList;
import icc.colors.Colors;
import icc.clases.Modelo;


public class Simulacion{

	public int[] anotaciones;
    public int[] aFavor;
    public int[] enContra;
    public int[] setsFavor;
    public int[] setsContra;
    public int[] juegosG;
    public int[] juegosP;

    //Metodos de la clase Simulacion.

    /*
      Este metodo lo que hace es inicializar los multiples arreglos correspondientes a cada equipo (esto tomando en cuenta 
      el valor ingresado por el usuario por la cantidad de equipos). Todos los datos de los equipos (sets, anotaciones, etc)
      seran guardados en un solo arreglo correspondiente dependiendo el dato a guardar, el cual, compartiran todos los equipos
      y la manera de acceder cada equipo a sus elementos en especifico sera mediante un ciclo for el cual les dara su valor 
      correspondiente.
      Cada equipo por default comenzara con valores 0 en todos los aspectos y a medida que el usuario simule el partido y se
      generen nuevos datos aleatorios, estos seran guardados en estos arreglos.
        */
    public void estadisticas(int max) {//Metodo para empezar a inicializar los arreglos para cada equipo de acuerdo al numero que ingreso el usuario.
        anotaciones = new int[max];
        aFavor = new int[max];
        enContra = new int[max];
        setsFavor = new int[max];
        setsContra = new int[max];
        juegosG = new int[max];
        juegosP = new int[max];

        for (int i = 0; i < max; i++) {//Inicializa todos los arreglos de acuerdo al numero elegido por el usuario y empiezan teniendo 0 todos sus valores.
            anotaciones[i] = 0;
            aFavor[i] = 0;
            enContra[i] = 0;
            setsFavor[i] = 0;
            setsContra[i] = 0;
            juegosG[i] = 0;
            juegosP[i] = 0;
        }
    }




//Método para continuar simulación (isaac)




//Método para calendarización

        

    //<>: restringir entradas/parámetros al método
    public ArrayList<int[][]> Calendario (int numEquipos) {
        ArrayList<int[][]> calendario = new ArrayList<>();

        //Lista con los ID's o bueno identificadores de los equipos
        int[] equipos = new int[numEquipos];
        for (int i = 0; i < numEquipos; i++) {
            equipos[i] = i;
        }

        // Si el número de equipos es impar se crea un equipo falso para q fuera par
        if (numEquipos % 2 != 0) {
            equipos = agregarEquipoFicticio(equipos);
            numEquipos++;
        }


        int numRondas = numEquipos - 1;
        int numPartidosPorRonda = numEquipos / 2;

        for (int ronda = 0; ronda < numRondas; ronda++) {
            int[][] enfrentamientos = new int[numPartidosPorRonda][2];

            for (int partido = 0; partido < numPartidosPorRonda; partido++) {
                int equipoLocal = equipos[(ronda + partido) % numEquipos];
                int equipoVisitante = equipos[(ronda + numEquipos - partido) % numEquipos];

                // Ignorar el equipo falso
                if (equipoLocal != -1 && equipoVisitante != -1) {
                    enfrentamientos[partido][0] = equipoLocal;
                    enfrentamientos[partido][1] = equipoVisitante;
                }
            }

            // Agregar el enfrentamiento a la lista de calendario
            calendario.add(enfrentamientos);
        }

        return calendario; 
    }

    // Método q agrega un equipo ficticio si el número de equipos es impar
    private int[] agregarEquipoFicticio(int[] equipos) {
        int[] equiposConFicticio = new int[equipos.length + 1];
        System.arraycopy(equipos, 0, equiposConFicticio, 0, equipos.length);
        equiposConFicticio[equipos.length] = -1;
        return equiposConFicticio;
    }
}
