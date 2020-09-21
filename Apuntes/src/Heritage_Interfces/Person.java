package Heritage_Interfces;

public class Person {

	protected String name;
	protected String surname;
	protected String department;
	protected int office;
	protected int salary;
	
	public Person(String name,String surname,String department,int office, int salary) {
		
		setName(name);
		setSurname(surname);
		setDepartment(department);
		setOffice(office);
		setSalary(salary);
		
		
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = 1050 + salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
	}
	
	@Override
	public String toString() {
		return name + " " + surname + "is an employee working ath the department of " + department + " in the office " + office + " with a salary of " + salary + "€.";

	}

}
