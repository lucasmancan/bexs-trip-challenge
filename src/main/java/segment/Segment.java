package segment;

import java.math.BigDecimal;

public final class Segment {
    private String origin;
    private String destiny;
    private BigDecimal price;

    public Segment(String origin, String destiny, BigDecimal price) {
        this.origin = origin;
        this.destiny = destiny;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "segment.Segment{" +
                "origin='" + origin + '\'' +
                ", destiny='" + destiny + '\'' +
                ", price=" + price +
                '}';
    }
}
