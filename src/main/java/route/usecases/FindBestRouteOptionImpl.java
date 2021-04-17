package route.usecases;

import route.Route;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindBestRouteOptionImpl implements FindBestRouteOption {
    @Override
    public Optional<Route> find(List<Route> routes) {

        if(routes == null || routes.isEmpty())
            throw new IllegalArgumentException("route.Route options weren't provided.");

        return routes.stream().min(Comparator.comparing(Route::getPrice));
    }
}
