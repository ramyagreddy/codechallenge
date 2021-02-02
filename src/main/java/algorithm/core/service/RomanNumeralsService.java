package algorithm.core.service;

import java.util.TreeMap;

/**
 * @author Ramya
 * 
 *         Service interface that includes method to convert input number to a
 *         Roman numeral
 *
 */
public interface RomanNumeralsService {

	TreeMap<String, Integer> RomanNumeralMapping = null;

	public String convertNumberToRomanNumeral(int integer) throws NullPointerException, NumberFormatException;

}
