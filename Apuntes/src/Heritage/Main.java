package Heritage;

public class Main {

	public static void main(String[] args) {
		Person miguel = new Person("Miguel", "De Unamuno", "Literature", 12, 0);
		Boss maria = new Boss("Maria", "Zamudio", "Marketing", 55, 60);
		Secretaries gotzone = new Secretaries("Gotzone", "Gutierrez", "Marketing", 2, 0);
		
		System.out.println(gotzone.toString());
		System.out.println(maria.toString());
		System.out.println(miguel.toString());
	}

}
