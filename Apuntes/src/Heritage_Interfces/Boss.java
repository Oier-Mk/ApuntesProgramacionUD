package Heritage_Interfces;

public class Boss extends Person implements BossMethods {

	public Boss(String name, String surname, String department, int office, int salary) {
		super(name, surname, department, office, salary);
		setSalary(salary);
		setOffice(office);
	}
	public void setSalary(int salary) {
		this.salary = 1050 + 1500 + salary;
	}
	public void setOffice(int office) {
		this.office = office + 500;
	}
	@Override
	public String toString() {
		return name + " " + surname + "is a boss working ath the department of " + department + " in the office " + office + " with a salary of " + salary + "€.";
	}
	@Override
	public String takeDecision(String decision) {
		
		return "The boss " + this.getName() + " " + this.getSurname() + " has taken the decision of " + decision + ".";
	}
}
