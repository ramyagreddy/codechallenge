
package algorithm.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.Test;

import algorithm.core.service.RomanNumeralsService;
import algorithm.core.service.impl.RomanNumeralsServiceImpl;
import algorithm.core.util.Constants;

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
		assertThrows(IllegalArgumentException.class, () -> romanNumerals.convertNumberToRomanNumeral(0),
				Constants.INPUT_ZERO);
	}

	/**
	 * Method that tests if input is greater than 3999(largest number that has a
	 * valid Roman numeral representation), an exception IllegalArgumentException
	 * should be thrown indicating inappropriate input being passed
	 */
	@Test
	public void testIfInputIsGreaterThan3999() {
		assertThrows(IllegalArgumentException.class, () -> romanNumerals.convertNumberToRomanNumeral(4000),
				Constants.WARNING_INPUT_GREATER_THAN_3999);
	}

	/**
	 * Method that tests if input is less than 0 (negative integers), an exception
	 * IllegalArgumentException should be thrown indicating inappropriate input
	 * being passed
	 */
	@Test
	public void testIfInputIsNegativeInteger() {
		assertThrows(IllegalArgumentException.class, () -> romanNumerals.convertNumberToRomanNumeral(-1),
				Constants.WARNING_INPUT_LESS_THAN_ZERO);
	}

	/**
	 * Method that tests if input is 90 (one of 6 numbers that uses subtractive
	 * notation for Roman numeral representation); output should be XC instead of
	 * LXXXX
	 */
	@Test
	public void testSubtractiveNotation() {
		testNumberToRomanNumeralConversion(90, Constants.ROMAN_NUMERAL_90);
	}

	/**
	 * Method that tests if input is 18 (number that uses additive notation for
	 * Roman numeral representation); output should be XVIII
	 */
	@Test
	public void testAdditiveNotation() {
		testNumberToRomanNumeralConversion(18, "XVIII");
	}

	/**
	 * Method that tests if input is 99; output should be XCIX
	 */
	@Test
	public void testIfInputIsValidInteger() {
		testNumberToRomanNumeralConversion(99, Constants.ROMAN_NUMERAL_99);
	}

	/**
	 * Method that tests if input is 1; output should be I
	 */
	@Test
	public void testFirstRomanNumeral() {
		testNumberToRomanNumeralConversion(1, Constants.ROMAN_NUMERAL_I);
	}

	/**
	 * Method that tests if input is 3999; output should be MMMCMXCIX
	 */
	@Test
	public void testLastRomanNumeral() {
		testNumberToRomanNumeralConversion(3999, Constants.ROMAN_NUMERAL_3999);
	}

	/**
	 * Method that tests that output(Roman Numeral) is uppercase for a given input
	 * 
	 */
	@Test
	public void testRomanNumeralIsUpperCase() {
		String output = romanNumerals.convertNumberToRomanNumeral(3999);
		assertEquals(output, output.toUpperCase());
	}

	/**
	 * Method that tests if input is single digit; output should be V
	 */
	@Test
	public void testSingleDigitNumeral() {
		testNumberToRomanNumeralConversion(5, Constants.ROMAN_NUMERAL_5);
	}

	/**
	 * Method that tests if input is 2 digits; output should be XIV
	 */
	@Test
	public void testTwoDigitNumeral() {
		testNumberToRomanNumeralConversion(14, Constants.ROMAN_NUMERAL_14);
	}

	/**
	 * Method that tests if input is 3 digits; output should be CLII
	 */
	@Test
	public void testThreeDigitNumeral() {
		testNumberToRomanNumeralConversion(152, Constants.ROMAN_NUMERAL_152);
	}

	/**
	 * Method that tests if input is 4 digits less than 3999; output should be
	 * MMCMLVII
	 */
	@Test
	public void testValidFourDigitNumeral() {
		testNumberToRomanNumeralConversion(2957, Constants.ROMAN_NUMERAL_2957);
	}

	/**
	 * Method that tests if input is 1000; output should be M
	 */
	@Test
	public void testThousand() {
		testNumberToRomanNumeralConversion(1000, Constants.ROMAN_NUMERAL_1000);
	}

	/**
	 * Method that tests if input is 2000; output should be MM
	 */
	@Test
	public void testTwoThousand() {
		testNumberToRomanNumeralConversion(2000, Constants.ROMAN_NUMERAL_2000);
	}

	/**
	 * Method that tests if input is 3000; output should be MMM
	 */
	@Test
	public void testThreeThousand() {
		testNumberToRomanNumeralConversion(3000, Constants.ROMAN_NUMERAL_3000);
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
