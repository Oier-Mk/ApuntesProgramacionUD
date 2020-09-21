package FileManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TextFile {
	public static void main(String[] args) {
		String str = "";
		String SavedData = "FileManagement/TextData.txt";
		File data = new File(SavedData);
		if (data.exists()) {
			str += ReadFromTXT(SavedData) ;
		}

		WriteToTXT(StartNote(str), SavedData);

	}

	public static String StartNote(String str) {

		boolean loop = true;

		int times = 0;

		while(loop) {
			String newNote = JOptionPane.showInputDialog("Write your note here");
			if (newNote != null) {
				if (times < 1){
					str += "\n" + currentTimeF1() + " \t " + newNote + "\n\n";
					times ++;
				}
				else {
					str += currentTimeF2() + " \t " + newNote + "\n\n";
				}
			}
			else {
				loop = false;

			}
		}

		System.out.println(str);
		return str;

	}

	public static String currentTimeF1() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String currentTime = formatter.format(date);
		return currentTime;
	}
	private static String currentTimeF2() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String currentTime = formatter.format(date);
		return currentTime;
	}


	private static void WriteToTXT(String str, String fileName ) {
		try {
			PrintStream write = new PrintStream( fileName );
			write.println(str);
			write.close();
		} catch (IOException e) {
			System.out.println( "It hasn not been able to save it to a file" );
		}
	}

	private static String ReadFromTXT( String fileName ) {
		String str = "";
		try {
			Scanner read = new Scanner( new FileInputStream( fileName ) );
			while (read.hasNext()) {
				str += read.nextLine()+"\n";
			}
			read.close();
			return str;
		} catch (IOException e) {
			return ( "It hasn not been able to read from the file" );
		}
	}
}

