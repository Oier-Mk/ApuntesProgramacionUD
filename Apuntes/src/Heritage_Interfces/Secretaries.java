package Heritage_Interfces;

public class Secretaries extends Person {

		public Secretaries(String name, String surname, String department, int office, int salary) {
			super(name, surname, department, office, salary);
			setSalary(salary);
			setOffice(office);
		}
		public void setSalary(int salary) {
			this.salary = 1050 + 1000 + salary;
		}
		public void setOffice(int office) {
			this.office = office + 300 ;
		}
		@Override
		public String toString() {
			return name + " " + surname + "is a secretary working ath the department of " + department + " in the office " + office + " with a salary of " + salary + "€.";
}
	}