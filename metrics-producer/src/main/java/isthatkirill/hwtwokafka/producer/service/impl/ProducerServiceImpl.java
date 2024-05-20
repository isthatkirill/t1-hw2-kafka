package isthatkirill.hwtwokafka.producer.service.impl;

import isthatkirill.hwtwokafka.producer.service.ProducerService;
import isthatkirill.hwtwokafka.producer.web.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaSender<String, Object> kafkaSender;

    @Override
    public void send(MetricDto metric) {
        log.info("New metric send via producer service --> {}", metric);
        kafkaSender.send(
                Mono.just(
                        SenderRecord.create(
                                "metrics-topic",
                                0,
                                System.currentTimeMillis(),
                                String.valueOf(metric.hashCode()),
                                metric,
                                null
                        )
                )
        ).subscribe();
    }

}
