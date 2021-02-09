package algorithm.core.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import algorithm.core.dto.RomanNumeral;
import algorithm.core.service.RomanNumeralsService;
import algorithm.core.service.impl.RomanNumeralsServiceImpl;
import algorithm.core.util.Constants;
import io.micrometer.core.annotation.Timed;

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
@Timed
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
	 * @return output RomanNumeral object for valid integer; otherwise warning
	 *         message asking for valid input.
	 */
	@GetMapping
	@ResponseBody
	public RomanNumeral getRomannumeral(@RequestParam(value = Constants.QUERY) int inputInteger) {
		String romanNumeral = null;
		LOGGER.finest(Constants.INPUT + inputInteger);
		romanNumeral = romanNumerals.convertNumberToRomanNumeral(inputInteger);
		return new RomanNumeral(inputInteger, romanNumeral);
	}

}
