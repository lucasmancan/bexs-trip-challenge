package route;

import segment.Segment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Route {
    private final List<Segment> segments = new ArrayList<>();
    private BigDecimal price = BigDecimal.ZERO;

    public List<Segment> getSegments() {
        return segments;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Route addSegments(List<Segment> segments) {
        this.segments.addAll(segments);

        var totalPrice = segments.stream()
                .map(Segment::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        this.price = this.price.add(totalPrice);

        return this;
    }

    @Override
    public String toString() {
        return "route.Route{" +
                "segments=" + segments +
                ", price=" + price +
                '}';
    }
}
