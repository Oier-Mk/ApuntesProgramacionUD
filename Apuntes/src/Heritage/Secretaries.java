package Heritage;

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
			return "Secretaries [name=" + name + ", surname=" + surname + ", department=" + department + ", office="
					+ office + ", salary=" + salary + "]";
		}
	}