package isthatkirill.hwtwokafka.consumer.web.controller.handler;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    String error;
    String description;

}