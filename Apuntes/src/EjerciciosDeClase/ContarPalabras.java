package EjerciciosDeClase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Library.Counter;

public class ContarPalabras {
	static HashMap<String, Counter> map = new HashMap<String, Counter>();
	public static void main(String[] args) {
		try {	contarPalabras(new Scanner(new FileInputStream( new File("src/EjerciciosDeClase/texto.txt"))));   } catch (FileNotFoundException e) {   e.printStackTrace();	}
	}

	private static void contarPalabras(Scanner file) {
		if(!file.hasNext()) {
			System.out.println("La cantidad de veces que se ha escrito la palabra es la siguiente");
			imprimirCantidades();		
			return;
		}else{
			String palabra = file.next();
			if(map.get(palabra)==null) {
				System.out.println("palabra nula");
				map.put(palabra, new Counter());
			}else{
				System.out.println("palabra existente"); 
				map.get(palabra).inc();
			}
			contarPalabras(file);
		}
	}

	private static void imprimirCantidades() {
		System.out.println("En "+map.get("en"));
		System.out.println("un "+map.get("un"));
		System.out.println("lugar "+map.get("lugar"));
		System.out.println("de "+map.get("de"));
		System.out.println("la "+map.get("la"));
		System.out.println("mancha "+map.get("mancha"));

	}
}
