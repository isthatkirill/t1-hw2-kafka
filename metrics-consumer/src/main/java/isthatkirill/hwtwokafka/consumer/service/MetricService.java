package isthatkirill.hwtwokafka.consumer.service;

import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

public interface MetricService {

    void save(MetricDto metricDto);

    List<MetricDto> getAll();

    MetricDto getById(Long id);

    List<MetricDto> getAbnormal();
}
