package icc.clases;

import icc.colors.Colors;
import java.util.Scanner;
import icc.clases.Simulacion;


public class Modelo{

	Simulacion sim = new Simulacion();
	public String name [];
	

	//Metodos de la clase Modelo.

	/*
	  Este metodo almacena los nombres de los equipos en un arreglo de tipo String donde su limite de 
	  equipos radica en que valor ingreso el usuario al momento de escoger la cantidad de equipos a 
	  simular.
	*/
	public void equipos(int max){
        Scanner scn = new Scanner(System.in);
        name = new String[max];
		for(int i = 0; i<max; i++){
			System.out.println("Ingresa el nombre de algun equipo: ");
			this.name[i]=scn.nextLine();
		}

	}        


	/*
      Este metodo lo que hace es que expone los valores que tiene cada equipo y (como su nombre lo indica), 
	  el usuario podra consultar el puntaje de cada equipo, ademas que dentro de este metodo existe otro metodo 
	  el cual pertene a la clase Simulacion el cual simplemente inicializa los arreglos de cada equipo el cual
	  depende del valor ingresado por el usuario por la cantidad de equipos.
	*/
	public void consultar(int max){
        
        sim.estadisticas(max);

		for(int i = 0; i<max; i++){
			Colors.println("ID: " + i, Colors.YELLOW+Colors.HIGH_INTENSITY);
            Colors.println("Nombre: "+this.name[i], Colors.BLUE+Colors.HIGH_INTENSITY);
            Colors.println("Anotaciones: "+sim.anotaciones[i], Colors.YELLOW+Colors.HIGH_INTENSITY);
            Colors.println("Total a favor: "+sim.aFavor[i], Colors.GREEN+Colors.HIGH_INTENSITY);
            Colors.println("Total en contra: "+sim.enContra[i], Colors.RED+Colors.HIGH_INTENSITY);
            Colors.println("Sets a favor: "+sim.setsFavor[i], Colors.GREEN+Colors.HIGH_INTENSITY);
            Colors.println("Sets en contra: "+sim.setsContra[i], Colors.RED+Colors.HIGH_INTENSITY);
            Colors.println("Juegos Ganados: "+sim.juegosG[i], Colors.GREEN+Colors.HIGH_INTENSITY);
            Colors.println("Juegos Perdidos: "+sim.juegosP[i]+"\n", Colors.RED+Colors.HIGH_INTENSITY);
			
		}       
	}

}