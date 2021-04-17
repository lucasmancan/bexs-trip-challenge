import segment.Segment;
import trip.Trip;
import segment.SegmentRepository;
import segment.SegmentRepositoryImpl;
import route.usecases.FindBestRouteOption;
import route.usecases.FindBestRouteOptionImpl;
import route.usecases.RouteCalculator;
import route.usecases.RouteCalculatorImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        // given
        Trip trip = new Trip("GRU", "CDG");

        SegmentRepository segmentRepository = new SegmentRepositoryImpl();
        var list = new ArrayList<Segment>();

        list.add(new Segment("GRU", "BRC", new BigDecimal("10")));
        list.add(new Segment("BRC", "SCL", new BigDecimal("5")));
        list.add(new Segment("GRU", "CDG", new BigDecimal("75")));
        list.add(new Segment("GRU", "SCL", new BigDecimal("20")));
        list.add(new Segment("GRU", "ORL", new BigDecimal("56")));
        list.add(new Segment("ORL", "CDG", new BigDecimal("5")));
        list.add(new Segment("SCL", "ORL", new BigDecimal("20")));

        list.forEach(segment -> segmentRepository.save(segment.getOrigin(), segment.getDestiny(), segment.getPrice()));

        RouteCalculator routeCalculator = new RouteCalculatorImpl(segmentRepository);
        FindBestRouteOption findBestRouteOption = new FindBestRouteOptionImpl();

        // when
        var routes = routeCalculator.calculate(trip);
        var oRoute = findBestRouteOption.find(routes);

        System.out.println(oRoute.get());
    }
}
