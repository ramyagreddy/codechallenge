
package algorithm.core.test;

import algorithm.core.service.RomanNumeralsService;
import algorithm.core.service.impl.RomanNumeralsServiceImpl;
import algorithm.core.util.Constants;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.logging.Logger;

/**
 * Class which includes junit test cases for unit testing Roman Numeral service
 * implementation.
 * 
 * @author Ramya
 *
 */
public class RomanNumeralsImplTest {

	private final static Logger LOGGER = Logger.getLogger(RomanNumeralsImplTest.class.getName());
	RomanNumeralsService romanNumerals = new RomanNumeralsServiceImpl();

	/**
	 * Method that tests if input is 0; output should be "No Roman numeral
	 * representation" text
	 */
	@Test
	public void testIfInputIsZero() {
		testNumberToRomanNumeralConversion(0, Constants.INPUT_ZERO);
	}

	/**
	 * Method that tests if input is greater than 3999(largest number that has a
	 * valid Roman numeral representation); output should be "No Roman numeral
	 * representation" text
	 */
	@Test
	public void testIfInputIsGreaterThan3999() {
		testNumberToRomanNumeralConversion(4000, Constants.WARNING_INPUT_GREATER_THAN_3999_LESS_THAN_ZERO);
	}

	/**
	 * Method that tests if input is less than 0; output should be "No Roman numeral
	 * representation" text
	 */
	@Test
	public void testIfInputIsLessThanZero() {
		testNumberToRomanNumeralConversion(-1, Constants.WARNING_INPUT_GREATER_THAN_3999_LESS_THAN_ZERO);
	}

	/**
	 * Method that tests if input is 90 (one of 6 numbers that uses subtractive
	 * notation for Roman numeral representation); output should be XC instead of
	 * LXXXX
	 */
	@Test
	public void testSubtractiveNotation() {
		testNumberToRomanNumeralConversion(90, Constants.ROMAN_NUMERAL_IS + Constants.ROMAN_NUMERAL_90);
	}

	/**
	 * Method that tests if input is 99; output should be XCIX
	 */
	@Test
	public void testIfInputIsValidInteger() {
		testNumberToRomanNumeralConversion(99, Constants.ROMAN_NUMERAL_IS + Constants.ROMAN_NUMERAL_99);
	}

	/**
	 * Method that tests if input is 1; output should be I
	 */
	@Test
	public void testFirstRomanNumeral() {
		testNumberToRomanNumeralConversion(1, Constants.ROMAN_NUMERAL_IS + Constants.ROMAN_NUMERAL_I);
	}

	/**
	 * Method that tests if input is 3999; output should be MMMCMXCIX
	 */
	@Test
	public void testLastRomanNumeral() {
		testNumberToRomanNumeralConversion(3999, Constants.ROMAN_NUMERAL_IS + Constants.ROMAN_NUMERAL_3999);
	}

	/**
	 * Method that asserts a condition is true - compares the Roman numeral output
	 * from RomanNumerals service is equal to the expected output If it isn't true,
	 * throws AssertionError without a message
	 */
	private void testNumberToRomanNumeralConversion(int input, String romanNumeral) {
		String output = romanNumerals.convertNumberToRomanNumeral(input);
		LOGGER.finest(Constants.INPUT + input + Constants.OUTPUT + output);
		assertTrue(output.equals(romanNumeral));
	}

}
