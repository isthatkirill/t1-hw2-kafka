package isthatkirill.hwtwokafka.consumer.mapper.impl;

import isthatkirill.hwtwokafka.consumer.mapper.Mappable;
import isthatkirill.hwtwokafka.consumer.model.Metric;
import isthatkirill.hwtwokafka.consumer.web.dto.MetricDto;
import org.mapstruct.Mapper;

/**
 * @author Kirill Emelyanov
 */

@Mapper(componentModel = "spring")
public interface MetricMapper extends Mappable<Metric, MetricDto> {
}
