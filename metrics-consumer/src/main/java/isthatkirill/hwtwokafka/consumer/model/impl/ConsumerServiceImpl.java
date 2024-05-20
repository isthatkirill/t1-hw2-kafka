package isthatkirill.hwtwokafka.consumer.model.impl;

import com.google.gson.Gson;
import isthatkirill.hwtwokafka.consumer.model.ConsumerService;
import isthatkirill.hwtwokafka.consumer.model.MetricService;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

/**
 * @author Kirill Emelyanov
 */

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
                    metricService.save(metricDto);
                    rec.receiverOffset().acknowledge();
                });
    }

}
