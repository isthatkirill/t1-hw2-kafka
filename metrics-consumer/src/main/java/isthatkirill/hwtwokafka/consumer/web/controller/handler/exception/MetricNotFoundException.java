package isthatkirill.hwtwokafka.consumer.web.controller.handler.exception;

/**
 * @author Kirill Emelyanov
 */

public class MetricNotFoundException extends RuntimeException {

    public MetricNotFoundException(Long id) {
        super("Metric with id = " + id + " not found.");
    }
}
