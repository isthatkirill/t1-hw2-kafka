package isthatkirill.hwtwokafka.producer.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

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

    @Null(message = "Id must be null")
    Long id;

    @NotBlank(message = "Method cannot be blank")
    @Length(min = 3, max = 16, message = "Method must be between 3 and 16 characters")
    String method;

    @NotBlank(message = "Path cannot be blank")
    @Length(min = 1, max = 256, message = "Path must be between 1 and 256 characters")
    String path;

    @NotNull(message = "Time cannot be null")
    @PastOrPresent(message = "requestedAt should me in past or present")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime requestedAt;

    @Positive(message = "Response time must be positive")
    Long responseTime;

    @Positive(message = "Response time must be positive")
    Long memoryUsedMB;

}
