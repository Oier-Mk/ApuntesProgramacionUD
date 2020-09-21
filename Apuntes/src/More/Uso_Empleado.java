package More;
import java.util.*;
public class Uso_Empleado {
	public static void main(String[] args) {
		//Crear la primera instancia = Primer objeto perteneciente a la clase empleado
		/*Empleado empleado1 = new Empleado("Alejandra Arche", 85000.0, 1990, 12, 17);
		Empleado empleado2 = new Empleado("Eugenia Vicente", 95000.0, 1195, 06, 02);
		Empleado empleado3 = new Empleado("Gonzalo Vicente", 105000.0, 2002, 03, 15);
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo : "  + empleado1.dameSueldo() + " Fecha de Alta : " + empleado1.dameFechaContrato());
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo : "  + empleado2.dameSueldo() + " Fecha de Alta : " + empleado2.dameFechaContrato());
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo : "  + empleado3.dameSueldo() + " Fecha de Alta : " + empleado3.dameFechaContrato());*/
	
		Empleado [] misEmpleados = new Empleado [3];
		
		
		//Como en java no se puede crear un array de diferentes tipos de datos
		//Por lo que hemos creado una clase Empleado con los distintos tipos de datos y luego hemos creado el array
		misEmpleados[0] = new Empleado("Alejandra Arche", 85000.0, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Eugenia Vicente", 95000.0, 1195, 06, 02);
		misEmpleados[2] = new Empleado("Gonzalo Vicente", 105000.0, 2002, 03, 15);
		/*for(int i = 0; i<3; i++) {
			misEmpleados[i].subeSueldo(5);
		}
		for(int i = 0; i<3; i++) {
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + "Sueldo: " + misEmpleados[i].dameSueldo() + " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		
		for(Empleado e: misEmpleados){
			System.out.println("Nombre: " +e.dameNombre() + " Sueldo: " + e.dameSueldo() + " Fecha de alta: " + e.dameFechaContrato());
		}
	
	}
}

class Empleado{
	public Empleado(String nom, double sue, int agno, int mes, int dia) { //Constructor siempre public para acceder desde otras clases	
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		altaContrato = calendario.getTime(); 
		//Cuando ponemos un new estamos lamando al constructor de la clase	
	}
	public String dameNombre() { //GETTER
		return nombre;
	}
	public double dameSueldo() {
		return sueldo;
	}
	public Date dameFechaContrato() {
		return altaContrato;
	}
	public void subeSueldo (double porcentaje) { //SETTER
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento;
	}
	private String nombre;
	private double sueldo;
	private Date altaContrato;
}