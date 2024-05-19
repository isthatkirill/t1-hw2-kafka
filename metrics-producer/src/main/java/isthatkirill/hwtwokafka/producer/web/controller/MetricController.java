package isthatkirill.hwtwokafka.producer.web.controller;

import isthatkirill.hwtwokafka.producer.service.ProducerService;
import isthatkirill.hwtwokafka.producer.web.dto.MetricDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kirill Emelyanov
 */

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class MetricController {

    private final ProducerService producerService;

    @PostMapping
    public MetricDto addMetric(@Valid @RequestBody MetricDto metricDto) {
        producerService.send(metricDto);
        return metricDto;
    }

}
