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
 */
@RestController
@RequestMapping("/" + Constants.ROMAN_NUMERAL)
public class RomanNumeralsController {
	
	private final static Logger LOGGER =  
            Logger.getLogger(RomanNumeralsController.class.getName());
	RomanNumeralsService romanNumerals = new RomanNumeralsServiceImpl();
	
	@GetMapping
	public String getRomannumeral(@RequestParam(value=Constants.QUERY) int inputInteger) {
		String romanNumeral = null;
		try {
	    romanNumeral = romanNumerals.convertNumberToRomanNumeral(inputInteger);
	    
		} catch (NullPointerException ne) {
			LOGGER.log(Level.SEVERE, romanNumeral);
		} catch (NumberFormatException nfe) {
			LOGGER.log(Level.SEVERE, romanNumeral);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, romanNumeral);
		} finally {
			//Is this needed? anything to close?
		}
	    
		return romanNumeral;
	}
	

}
