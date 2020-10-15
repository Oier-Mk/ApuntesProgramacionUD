package Library;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;

import org.junit.Test;


/**
 * @author Mentxaka
 */
public class TestPersonalFuncions {
	int[] arrayTests = {123,12,1,-1,-12,-123};
	int[] arrayAnswers = {3,2,1,1,2,3};
	String[] arrayStrings = {"123","12","1","-1","-12","-123"};

	@Test
	public void testGetNumSize() {
		for(int i = 0; i < Array.getLength(arrayTests); i++) {
			assertEquals("No match betwen lenghts",arrayAnswers[i],PersonalFuncions.getNumSize(arrayTests[i])); 
		}
	}
	public void testNum2threeDigitStr() {
		for(int i = 0; i < Array.getLength(arrayTests); i++) {
			assertEquals("No match betwen number and string",arrayStrings[i],PersonalFuncions.num2threeDigitStr(arrayTests[i])); 
		}
	}
}
