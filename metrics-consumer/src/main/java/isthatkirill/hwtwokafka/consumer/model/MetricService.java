package isthatkirill.hwtwokafka.consumer.model;

import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;

/**
 * @author Kirill Emelyanov
 */

public interface MetricService {

    void save(MetricDto metricDto);

}
