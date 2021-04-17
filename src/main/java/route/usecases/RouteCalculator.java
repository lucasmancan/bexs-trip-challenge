package route.usecases;

import trip.Trip;
import route.Route;

import java.util.List;

public interface RouteCalculator {
    List<Route> calculate(Trip trip);
}
