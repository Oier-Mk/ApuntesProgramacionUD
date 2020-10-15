package Library;

/**
 * @author Mentxaka
 */
public class PersonalFuncions {
	
	/**
	 * @param integer number you want the size of
	 * @return length of the number
	 */
	public static int getNumSize(int number) {
		if (number < 0 ) return (number+"").length()-1;
		return (number+"").length();
	}
	
	/**
	 * @param integer number you want to convert to a 3 digit string (add 0 on the left)
	 * @return String with a 3 digit number
	 */
	public static String num2threeDigitStr(int number) {
		String sNumber = "";
		if (number < 0) {
			sNumber = "-";
			number *= -1;
		}
		if (PersonalFuncions.getNumSize(number)==2) {
			return sNumber += "0"+number;
		}
		if (PersonalFuncions.getNumSize(number)==1) {
			return sNumber += "00"+number;
		}
		return sNumber += number;		
	}
}
