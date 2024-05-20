package isthatkirill.hwtwokafka.consumer.repository;

import isthatkirill.hwtwokafka.consumer.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
}
