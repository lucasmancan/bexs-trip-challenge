package route.usecases;

import route.Route;

import java.util.List;
import java.util.Optional;

public interface FindBestRouteOption {
    Optional<Route> find(List<Route> routes);
}
