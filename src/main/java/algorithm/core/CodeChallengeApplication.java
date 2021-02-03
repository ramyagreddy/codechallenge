package algorithm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import algorithm.core.controller.RomanNumeralsController;

/**
 * @author Ramya
 * 
 *         This class is our SpringBootApplication class which scans for
 *         RomanNumeralsController class and runs CodeChallengeApplication
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = RomanNumeralsController.class)
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}
