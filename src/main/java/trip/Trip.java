package trip;

public final class Trip {
    private final String origin;
    private final String destiny;

    public Trip(String origin, String destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }
}
