package Heritage;

public class Boss extends Person {

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
		return "Boss [name=" + name + ", surname=" + surname + ", department=" + department + ", office=" + office
				+ ", salary=" + salary + "]";
	}
}
