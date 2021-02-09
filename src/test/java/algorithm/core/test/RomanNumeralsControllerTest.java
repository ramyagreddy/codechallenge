
package algorithm.core.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import algorithm.core.controller.RomanNumeralsController;
import algorithm.core.service.RomanNumeralsService;
import algorithm.core.util.Constants;

/**
 * Class which includes unit test cases for unit testing
 * RomanNumeralsController. In this test class, the full Spring application
 * context is started but without the server. Tests are narrowed to only the web
 * layer by using @WebMvcTest
 * 
 * 
 * @author Ramya
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(RomanNumeralsController.class)
public class RomanNumeralsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RomanNumeralsService service;

	/**
	 * Method that tests if input is valid integer, response status is 200
	 */
	@Test
	public void testWhenInputIsValid_thenStatusOk() throws Exception {
		this.mvc.perform(get("/" + Constants.ROMAN_NUMERAL).queryParam(Constants.QUERY, "9")).andExpect(status().isOk())
				.andDo(print());
	}

	/**
	 * Method that tests if input is decimal, response status is 400 (Bad request)
	 */
	@Test
	public void testWhenInputIsInvalid_thenBadRequest() throws Exception {
		this.mvc.perform(get("/" + Constants.ROMAN_NUMERAL).queryParam(Constants.QUERY, "9.9"))
				.andExpect(status().isBadRequest()).andDo(print());
	}

	/**
	 * Method that tests if input is null, response status is 400 (Bad request)
	 */
	@Test
	public void testWhenInputIsNull_thenBadRequest() throws Exception {
		this.mvc.perform(get("/" + Constants.ROMAN_NUMERAL).queryParam(Constants.QUERY, "null"))
				.andExpect(status().isBadRequest()).andDo(print());
	}

	/**
	 * Method that tests if there is no request parameter, response status is 400
	 * (Bad request)
	 */
	@Test
	public void testWhenNoParam_thenBadRequest() throws Exception {
		this.mvc.perform(get("/" + Constants.ROMAN_NUMERAL)).andExpect(status().isBadRequest());
	}

}
