package isthatkirill.hwtwokafka.consumer.mapper;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

public interface Mappable<E, D> {

    E toEntity(D d);

    D toDto(E e);

    List<E> toEntity(List<D> d);

    List<D> toDto(List<E> e);

}
