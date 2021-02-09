package algorithm.core;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import algorithm.core.util.Constants;

/**
 * @author Ramya
 * 
 *         This class is our SpringBootApplication class which scans for
 *         RomanNumeralsController class and runs CodeChallengeApplication
 */
@SpringBootApplication(scanBasePackages = Constants.APPLICATION_BASE_PACKAGE)
public class CodeChallengeApplication {

	private final static Logger LOGGER = Logger.getLogger(CodeChallengeApplication.class.getName());

	public static void main(String[] args) {
		LOGGER.finest(Constants.APPLICATION_MAIN_DEBUG);
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}
