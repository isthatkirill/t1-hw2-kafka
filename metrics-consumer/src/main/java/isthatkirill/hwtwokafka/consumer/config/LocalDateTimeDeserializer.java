package isthatkirill.hwtwokafka.consumer.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kirill Emelyanov
 */

@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonElement jsonElement, Type type,
                                     JsonDeserializationContext jsonDeserializationContext) {
        String dateTimeStr = jsonElement.getAsString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

}
