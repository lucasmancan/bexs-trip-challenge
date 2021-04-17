package segment;

import exceptions.InvalidConfigurationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SegmentRepositoryImpl implements SegmentRepository {

    private List<Segment> segments = new ArrayList<>();

    @Override
    public Optional<Segment> find(String from, String to) {

        var segmentStream = segments.stream()
                .filter(segment -> segment.getOrigin().equals(from) && segment.getDestiny().equals(to));

        if (segmentStream.count() > 1) {
            throw new InvalidConfigurationException("There's more than one registered segment to this route.");
        }

        return segmentStream
                .findFirst();
    }

    @Override
    public List<Segment> findAll() {
        return new ArrayList<>(this.segments);
    }

    @Override
    public Segment save(String from, String to, BigDecimal price) {
        var segment = new Segment(from, to, price);
        this.segments.add(segment);
        return segment;
    }

    @Override
    public List<Segment> findByOrigin(String origin) {
        return this.segments.stream()
                .filter(segment -> segment.getOrigin().equals(origin))
                .collect(Collectors.toList());
    }

    @Override
    public List<Segment> findByDestiny(String destiny) {
        return this.segments.stream().filter(segment -> segment.getDestiny().equals(destiny)).collect(Collectors.toList());
    }
}
