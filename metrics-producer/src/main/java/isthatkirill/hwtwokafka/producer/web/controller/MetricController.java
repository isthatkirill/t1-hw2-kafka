package isthatkirill.hwtwokafka.producer.web.controller;

import isthatkirill.hwtwokafka.producer.web.dto.MetricDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class MetricController {

    @PostMapping
    public MetricDto addMetric(@Valid @RequestBody MetricDto metricDto) {
        log.info("{}", metricDto);
        return metricDto;
    }

}
