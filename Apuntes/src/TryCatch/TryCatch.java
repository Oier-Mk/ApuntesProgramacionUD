
package TryCatch;

public class TryCatch {

	public static void main(String[] args) {
		int [] array = {1, 2, 3, 4, 5};

		for (int i = 0; i < 10 ;i++) {

			try {
				System.out.println(array[i]);

			} catch(Exception e) {

				System.out.println("it is impossible to print that number");
				//e.printStackTrace();
			}			
		}
	}
}
