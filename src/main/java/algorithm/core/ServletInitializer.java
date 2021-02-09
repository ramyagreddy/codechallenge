package algorithm.core;

import java.util.logging.Logger;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import algorithm.core.util.Constants;

/**
 * @author Ramya
 * 
 *         ServletInitializer extends the SpringBootServletInitializer class and
 *         allows us to configure our application when it's run by the servlet
 *         container, by overriding the configure() method.
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	private final static Logger LOGGER = Logger.getLogger(ServletInitializer.class.getName());

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.finest(Constants.DEBUG_SERVLET_INITIALIZER);
		return application.sources(CodeChallengeApplication.class);
	}

}
