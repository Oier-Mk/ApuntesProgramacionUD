package Strings;
import javax.swing.JOptionPane;

public class Comprueba_mail {

	public static void main(String[] args) {
		int arroba = 0;
		boolean punto = false;
			String mail = JOptionPane.showInputDialog("Introduce mail");
			for(int i = 0; i<mail.length(); i++) {
				if(mail.charAt(i)=='@') { //Los datos de tipo char van en comilla simple
					//CharAt = Si la 'x' posición (0,1,2,3..) es igual a @ entonces:
					arroba++;
				if(mail.charAt(i)== '.');
					punto = true;
				}
			}
			if(arroba==1 && punto == true){
				System.out.println("Es correcto");
			}
			else {
				System.out.println("No es correcto");
			}
	}

}
