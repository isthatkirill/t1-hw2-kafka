package isthatkirill.hwtwokafka.consumer.repository;

import isthatkirill.hwtwokafka.consumer.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {


    @Query("SELECT m FROM Metric m " +
            "WHERE (m.memoryUsedMB > (SELECT 2 * avg(m2.memoryUsedMB) FROM Metric m2 WHERE m2.method = m.method AND m2.path = m.path) " +
            "OR m.responseTime > (SELECT 2 * avg(m3.responseTime) FROM Metric m3 WHERE m3.method = m.method AND m3.path = m.path))")
    List<Metric> findAbnormalMetrics();

}
