package isthatkirill.hwtwokafka.consumer.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetricDto {

    Long id;
    String method;
    String path;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime requestedAt;
    Long responseTime;
    Long memoryUsedMB;

}
