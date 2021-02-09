package algorithm.core.metrics;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import algorithm.core.util.Constants;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

/**
 * @author Ramya Class that defines custom metrics for counter and gauge.
 *
 */
@Component
public class CodeChallengeMetricService {

	private final AtomicInteger testGauge;
	private final Counter testCounter;

	public CodeChallengeMetricService(MeterRegistry meterRegistry) {
		testGauge = meterRegistry.gauge(Constants.CUSTOM_GAUGE, new AtomicInteger(0));
		testCounter = meterRegistry.counter(Constants.CUSTOM_COUNTER);
	}

	@Scheduled(fixedRateString = "1000", initialDelayString = "0")
	public void schedulingTask() {
		testGauge.set(CodeChallengeMetricService.getRandomNumberInRange(0, 100));
		testCounter.increment();
	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException(Constants.MAX_GREATER_THAN_MIN);
		}

		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
}