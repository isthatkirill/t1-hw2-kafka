package isthatkirill.hwtwokafka.consumer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@Entity
@Table(name = "metrics")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String method;
    String path;
    LocalDateTime requestedAt;
    Long responseTime;

    @Column(name = "memory_used")
    Long memoryUsedMB;

}
