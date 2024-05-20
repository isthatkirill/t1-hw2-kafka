package isthatkirill.hwtwokafka.consumer.service.impl;

import com.google.gson.Gson;
import isthatkirill.hwtwokafka.consumer.service.ConsumerService;
import isthatkirill.hwtwokafka.consumer.service.MetricService;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final Gson gson;
    private final KafkaReceiver<String, Object> receiver;
    private final MetricService metricService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        receiver.receive()
                .subscribe(rec -> {
                    MetricDto metricDto = gson.fromJson(rec.value().toString(), MetricDto.class);
                    log.info("Fetched via [metrics-consumer] --> {}", metricDto);
                    metricService.save(metricDto);
                    rec.receiverOffset().acknowledge();
                });
    }

}
