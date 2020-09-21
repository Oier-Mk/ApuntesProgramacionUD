package Heritage_Interfces;

import java.util.ArrayList;
;

public class Main {
	public static  ArrayList<Person> PeopleList;

	public static void main(String[] args) {
		Person miguel = new Person("Miguel", "De Unamuno", "Literature", 12, 0);
		Boss maria = new Boss("Maria", "Zamudio", "Marketing", 55, 60);
		Secretaries gotzone = new Secretaries("Gotzone", "Gutierrez", "Marketing", 2, 0);
		

		PeopleList = new ArrayList<Person>();
		
		PeopleList.add(miguel);
		PeopleList.add(maria);
		PeopleList.add(gotzone);
		
		System.out.println(sysoArray());
		
		

		System.out.println(gotzone.toString());
		System.out.println(maria.toString());
		System.out.println(miguel.toString());
		
//		System.out.println(gotzone.takeDecision("more vacation days")); NO FUNCIONAN, EL METÓDO SOLO LO HEREDA DE LA INTERFAZ LA CLASE BOSS
		System.out.println(maria.takeDecision("more vacation days"));
//		System.out.println(miguel.takeDecision("more vacation days"));

	}
	public static String sysoArray() {
		String string = "";
		for (Person person: PeopleList) {
			string += "[" + person.getName() + " " + person.getSurname() + "] ";
		}
		return string;
	}
}
