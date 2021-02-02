/**
 * 
 */
package algorithm.core.service.impl;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import algorithm.core.service.RomanNumeralsService;
import algorithm.core.util.Constants;
import algorithm.core.util.RomanNumeralsUtil;

/**
 * @author Ramya
 * 
 *         Service implementation to RomanNumerals Service that includes method
 *         to convert an Integer to Roman numeral
 *
 */
public class RomanNumeralsServiceImpl implements RomanNumeralsService {

	private final static Logger LOGGER = Logger.getLogger(RomanNumeralsServiceImpl.class.getName());
	TreeMap<Integer, String> RomanNumeralMapping = RomanNumeralsUtil.getRomanNumeralMapping();

	@Override
	public String convertNumberToRomanNumeral(int input) throws NullPointerException, NumberFormatException {
		LOGGER.finest(Constants.INPUT + input);
		String output = null;
		output = ifInputIsZero(input, output);
		output = ifInputIsInvalidInteger(input, output);
		output = ifInputIsValidInteger(input, output);
		LOGGER.finest(Constants.OUTPUT + output);
		return output;
	}

	/**
	 * This method checks if an input is 0, and returns the appropriate output.
	 * 
	 * @param input  - Input Integer that is passed for Roman numeral API
	 * @param output - String assigned as output
	 * @return Returns "No Roman numeral representation for 0" string if 0 is passed
	 *         as input; otherwise returns null
	 */
	private String ifInputIsZero(int input, String output) {
		if (input == 0) {
			LOGGER.log(Level.INFO, Constants.INPUT_ZERO);
			output = Constants.INPUT_ZERO;
		}
		return output;
	}

	/**
	 * This method checks if an input is lesser than 0 or greater than 3999, and
	 * returns the appropriate output.
	 * 
	 * @param input  - Input Integer that is passed for Roman numeral API
	 * @param output - String assigned as output
	 * @return Returns "No Roman numeral representation" string if integer less than
	 *         0 or greater than 3999 is passed as input; otherwise returns null
	 */
	private String ifInputIsInvalidInteger(int input, String output) {
		if (input > 3999 || input < 0) {
			LOGGER.log(Level.WARNING, Constants.WARNING_INPUT_GREATER_THAN_3999_LESS_THAN_ZERO);
			output = Constants.WARNING_INPUT_GREATER_THAN_3999_LESS_THAN_ZERO;
		}
		return output;
	}

	/**
	 * This method checks if an input is greater than 0 or lesser than or equals to
	 * 3999, and returns the Roman numeral representation.
	 * 
	 * @param input  - Input Integer that is passed for Roman numeral API
	 * @param output - String assigned as output
	 * @return Returns Roman numeral string representation for the valid input
	 *         integer; otherwise returns null
	 */
	private String ifInputIsValidInteger(int input, String output) {
		if (input > 0 && input <= 3999) {
			output = Constants.ROMAN_NUMERAL_IS + convertIntegerToRomanNumeral(input);
		}
		return output;
	}

	/**
	 * This method converts an input integer to a Roman numeral.
	 * 
	 * @param input - Input Integer that is passed for Roman numeral API
	 * @return Returns Roman numeral string representation for the input integer
	 */
	private String convertIntegerToRomanNumeral(int input) {

		LOGGER.finest(Constants.INPUT + input);
		/*
		 * Get greatest key from Roman numeral mapping(TreeMap) where key is lesser than
		 * or equal to given input
		 */
		int key = RomanNumeralMapping.floorKey(input);
		LOGGER.finest(Constants.KEY + key);

		/*
		 * Base case for recursive solution is when input equals a key in Roman numeral
		 * mapping(TreeMap)
		 */
		if (input == key) {
			return RomanNumeralMapping.get(input);
		}

		/*
		 * Roman numeral is recursively built from left to right by appending the Roman
		 * numeral equivalent for each, from highest to lowest
		 */
		return RomanNumeralMapping.get(key) + convertIntegerToRomanNumeral(input - key);

	}

}
