package algorithm.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import algorithm.core.util.Constants;

/**
 * @author Ramya
 * 
 *         Specialization of @Component for classes that
 *         declares @ExceptionHandler methods to be shared across
 *         multiple @Controller classes. By default, the methods in
 *         an @ControllerAdvice apply globally to all controllers.
 *
 */
@ControllerAdvice
public class CodeChallengeExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * @param exception
	 * @return HttpEntity with the given body, headers, and status code Method that
	 *         handles MethodArgumentTypeMismatchException
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

		CodeChallengeApiError apiError = new CodeChallengeApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),
				error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * @param exception
	 * @return HttpEntity with the given body, headers, and status code Method that
	 *         handles IllegalArgumentException & IllegalStateException exceptions
	 */
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String error = Constants.BAD_REQUEST;
		CodeChallengeApiError apiError = new CodeChallengeApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),
				error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * @param exception
	 * @return HttpEntity with the given body, headers, and status code Method that
	 *         handles CustomRuntimeException
	 */
	@ExceptionHandler(value = CustomRuntimeException.class)
	public ResponseEntity<Object> exception(CustomRuntimeException exception) {
		return new ResponseEntity<>("CustomRuntimeException", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * @param exception
	 * @return HttpEntity with the given body, headers, and status code Default
	 *         ExceptionHandler method that will handle all exceptions
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		CodeChallengeApiError apiError = new CodeChallengeApiError(HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getLocalizedMessage(), "error occurred");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}