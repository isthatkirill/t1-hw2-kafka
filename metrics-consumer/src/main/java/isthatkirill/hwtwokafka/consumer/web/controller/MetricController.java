package isthatkirill.hwtwokafka.consumer.web.controller;

import isthatkirill.hwtwokafka.consumer.service.MetricService;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class MetricController {

    private final MetricService metricService;

    @GetMapping
    public ResponseEntity<List<MetricDto>> getAll() {
        return ResponseEntity.ok(metricService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetricDto> getById(@PathVariable Long id) {
        return ResponseEntity.of(metricService.getById(id));
    }

}
