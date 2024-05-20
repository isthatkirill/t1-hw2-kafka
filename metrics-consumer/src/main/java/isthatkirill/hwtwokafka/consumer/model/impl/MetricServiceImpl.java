package isthatkirill.hwtwokafka.consumer.model.impl;

import isthatkirill.hwtwokafka.consumer.model.MetricService;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {


    @Override
    public void save(MetricDto metricDto) {
        log.error("New metric received --> {}", metricDto);
    }
}
