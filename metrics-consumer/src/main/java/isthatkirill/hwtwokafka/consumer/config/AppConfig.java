package isthatkirill.hwtwokafka.consumer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final LocalDateTimeDeserializer deserializer;

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, deserializer)
                .create();
    }

}
