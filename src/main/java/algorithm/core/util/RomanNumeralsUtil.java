package algorithm.core.util;

import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Util class that returns a TreeMap mapping of numerals to symbols representing
 * Roman numerals.
 * 
 * @author Ramya
 *
 */
public final class RomanNumeralsUtil {

	private RomanNumeralsUtil() {
	}

	private final static Logger LOGGER = Logger.getLogger(RomanNumeralsUtil.class.getName());
	final static TreeMap<Integer, String> RomanNumeralMapping = new TreeMap<Integer, String>();

	/**
	 * This method returns a mapping of 7 integer values mapping to symbols
	 * represented as Roman numerals. There are 6 special numerals - 4, 9, 40, 90,
	 * 400, 900 that are written using subtractive notation; where first symbol is
	 * subtracted from the larger one(IV for 4) avoiding the clumsier additive
	 * notation(IIII).
	 * 
	 * @return Returns TreeMap object with integers mapping to symbols representing
	 *         Roman numerals.
	 */
	public static TreeMap<Integer, String> getRomanNumeralMapping() {

		RomanNumeralMapping.put(1000, "M");
		RomanNumeralMapping.put(900, "CM");
		RomanNumeralMapping.put(500, "D");
		RomanNumeralMapping.put(400, "CD");
		RomanNumeralMapping.put(100, "C");
		RomanNumeralMapping.put(90, "XC");
		RomanNumeralMapping.put(50, "L");
		RomanNumeralMapping.put(40, "XL");
		RomanNumeralMapping.put(10, "X");
		RomanNumeralMapping.put(9, "IX");
		RomanNumeralMapping.put(5, "V");
		RomanNumeralMapping.put(4, "IV");
		RomanNumeralMapping.put(1, "I");

		LOGGER.finest(Constants.TREEMAP_SIZE + RomanNumeralMapping.size());

		return RomanNumeralMapping;

	}
}
