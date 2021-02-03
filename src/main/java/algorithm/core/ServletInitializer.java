package algorithm.core;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Ramya
 * 
 *         ServletInitializer extends the SpringBootServletInitializer class and
 *         allows us to configure our application when it's run by the servlet
 *         container, by overriding the configure() method.
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CodeChallengeApplication.class);
	}

}
