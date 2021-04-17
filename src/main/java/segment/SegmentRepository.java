package segment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SegmentRepository {
    /**
     *
     * @param from
     * @param to
     * @return
     */
    Optional<Segment> find(String from, String to);

    List<Segment> findAll();

    Segment save(String from, String to, BigDecimal price);

    List<Segment> findByOrigin(String origin);
    List<Segment> findByDestiny(String destiny);

}
