package isthatkirill.hwtwokafka.consumer.service;

import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;

/**
 * @author Kirill Emelyanov
 */

public interface MetricService {

    void save(MetricDto metricDto);

}
