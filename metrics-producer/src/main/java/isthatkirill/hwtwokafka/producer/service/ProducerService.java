package isthatkirill.hwtwokafka.producer.service;

import isthatkirill.hwtwokafka.producer.web.dto.MetricDto;

/**
 * @author Kirill Emelyanov
 */

public interface ProducerService {

    void send(MetricDto metric);

}
