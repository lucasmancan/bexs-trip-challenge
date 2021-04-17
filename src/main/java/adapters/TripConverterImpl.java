package adapters;

import trip.Trip;

public class TripConverterImpl implements TripConverter {
    @Override
    public Trip toTrip(String[] airports) {
        return new Trip(airports[0], airports[1]);
    }
}
