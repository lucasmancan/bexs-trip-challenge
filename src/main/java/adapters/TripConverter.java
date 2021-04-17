package adapters;

import trip.Trip;

public interface TripConverter {
    Trip toTrip(String[] airports);
}
