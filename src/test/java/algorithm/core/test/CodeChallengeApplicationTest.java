package algorithm.core.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import algorithm.core.controller.RomanNumeralsController;

/**
 * @author Ramya
 * 
 *         Test Class that is used to test if Spring boot application context is
 *         creating Controller successfully. @SpringBootTest annotation tells
 *         Spring Boot to look for a main configuration class
 *         (CodeChallengeApplication - one with @SpringBootApplication) and use
 *         that to start a Spring application context.
 */
@SpringBootTest
public class CodeChallengeApplicationTest {

	@Autowired
	private RomanNumeralsController controller;

	/**
	 * @throws Exception
	 * 
	 *                   Test case to test if Spring application context is creating
	 *                   your controller
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}