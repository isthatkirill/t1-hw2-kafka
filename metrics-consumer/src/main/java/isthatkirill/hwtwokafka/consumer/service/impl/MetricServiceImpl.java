package isthatkirill.hwtwokafka.consumer.service.impl;

import isthatkirill.hwtwokafka.consumer.mapper.impl.MetricMapper;
import isthatkirill.hwtwokafka.consumer.model.Metric;
import isthatkirill.hwtwokafka.consumer.repository.MetricRepository;
import isthatkirill.hwtwokafka.consumer.service.MetricService;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {

    private final MetricMapper mapper;
    private final MetricRepository metricRepository;

    @Override
    @Transactional
    public void save(MetricDto metricDto) {
        Metric metric = mapper.toEntity(metricDto);
        metricRepository.save(metric);
    }
}
