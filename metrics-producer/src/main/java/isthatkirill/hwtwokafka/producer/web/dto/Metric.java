package isthatkirill.hwtwokafka.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
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
public class Metric {

    @Null(message = "Id must be null")
    Long id;

    @NotBlank(message = "Method cannot be blank")
    String method;

    @NotBlank(message = "Path cannot be blank")
    String path;

    @NotNull(message = "Time cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime requestedAt;

    @Positive(message = "Response time must be positive")
    Long responseTime;

    @Positive(message = "Response time must be positive")
    Long memoryUsedMB;

}
