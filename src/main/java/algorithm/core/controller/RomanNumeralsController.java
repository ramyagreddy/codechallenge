package algorithm.core.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import algorithm.core.service.RomanNumeralsService;
import algorithm.core.service.impl.RomanNumeralsServiceImpl;
import algorithm.core.util.Constants;

/**
 * @author Ramya
 * 
 *         Rest Controller class that handles the requests with RequestMapping
 *         "romannumeral". This class has method to read request parameter from
 *         GET requests and pass it to RomanNumeralService to convert the input
 *         number to Roman numeral.
 *
 */
@RestController
@RequestMapping("/" + Constants.ROMAN_NUMERAL)
public class RomanNumeralsController {

	private final static Logger LOGGER = Logger.getLogger(RomanNumeralsController.class.getName());
	RomanNumeralsService romanNumerals = new RomanNumeralsServiceImpl();

	/**
	 * This method is invoked for any GET requests handled by RestController. It
	 * reads the input integer request parameter and converts it to Roman numeral
	 * for valid input.
	 * 
	 * @param inputInteger input from web api that needs to be converted to Roman
	 *                     numeral
	 * @return output string Romannumeral for valid integer; otherwise warning
	 *         message asking for valid input.
	 */
	@GetMapping
	public String getRomannumeral(@RequestParam(value = Constants.QUERY) int inputInteger) {
		String romanNumeral = null;
		try {
			LOGGER.finest(Constants.INPUT + inputInteger);
			LOGGER.finest(Constants.ROMAN_NUMERAL + romanNumerals);
			romanNumeral = romanNumerals.convertNumberToRomanNumeral(inputInteger);

		} catch (NullPointerException ne) {

			LOGGER.log(Level.SEVERE, romanNumeral);

		} catch (NumberFormatException nfe) {

			LOGGER.log(Level.SEVERE, romanNumeral);

		} catch (ArithmeticException ae) {

			LOGGER.log(Level.SEVERE, romanNumeral);

		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, romanNumeral);

		}

		return romanNumeral;
	}

}
