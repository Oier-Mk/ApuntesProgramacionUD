package FileManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryFile {
	public static ArrayList<Person> array;
	public static String myName = "";
	public static BinaryFile newFile;
	public static String SavedData;
	static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		newFile = new BinaryFile();

		SavedData = "src/FileManagement/BinaryData.dat";

		File data = new File(SavedData);

		if (data.exists()) {
			newFile.binaryDataReading(SavedData);
			System.out.println("Wellcome, " + myName);
		}
		else {

			System.out.println("Wellcome, new user!");

			System.out.println("Whats your name?");

			myName = input.next();

			array = new ArrayList<Person>();
			array.add(new Person("Oier",19));
			array.add(new Person("Izei",-1));
			array.add(new Person("Maddi",4));
			array.add(new Person("Margarita",99));
			array.add(new Person("Leticia",90));
			array.add(new Person("Hodei",0));
		}
		addUser();
		printUser();
		newFile.binaryDataWriting(SavedData);
	}

	//ADD USER

	public static void addUser(){
		boolean add = true;
		while (add == true){
			System.out.println("Do you want to add any person? Y/N\t");
			String addMore = input.next();
			if(addMore.equalsIgnoreCase("Y")) {
				System.out.println("Which is the name you want to add?\t");
				String name = input.next();
				System.out.println("How old is the person you want to add?\t");
				int age = input.nextInt();
				Person newPerson = new Person(name,age);
				array.add(newPerson);

			}else{
				add = false;
			}
		}
	}

	//PRINT USER
	public static void printUser() {
		for (Person person: array) {
			System.out.println(person.toString());
		}
	}

	//DATA READING 

	@SuppressWarnings("unchecked")
	public void binaryDataReading(String fileName) {
		try {
			ObjectInputStream readData = new ObjectInputStream(new FileInputStream(fileName));
			array = (ArrayList<Person>) readData.readObject();
			myName = (String) readData.readObject();
			readData.close();
		}catch(Exception e){
			System.out.println("An exception has been founded");
		}
	}

	//DATA WRITING
	public void binaryDataWriting(String fileName) {
		try {
			ObjectOutputStream writeData = new ObjectOutputStream(new FileOutputStream(fileName));
			writeData.writeObject(array);
			writeData.writeObject(myName);
			writeData.close();
		}catch(Exception e){
			System.out.println("An exception has been founded");
			e.printStackTrace();
		}
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	boolean alive = true;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		if (age < 0 || age > 90) {
			this.alive = false;
		}

	}

	public String toString() {
		String aliveS = "alive";

		if (this.alive == false) {
			aliveS = "not alive";
		}

		return "The person " + name + " is " + age + " year old and it is " + aliveS;
	}

}