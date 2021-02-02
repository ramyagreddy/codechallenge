package algorithm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import algorithm.core.controller.RomanNumeralsController;

/**
 * @author Ramya
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = RomanNumeralsController.class)
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}
