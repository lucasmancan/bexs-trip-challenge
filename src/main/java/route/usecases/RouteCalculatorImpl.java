package route.usecases;

import route.Route;
import segment.Segment;
import trip.Trip;
import segment.SegmentRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorImpl implements RouteCalculator {

    private final SegmentRepository segmentRepository;

    public RouteCalculatorImpl(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Override
    public List<Route> calculate(Trip trip) {

        var routeAlternatives = new ArrayList<Route>();

        var segmentsFromTripOrigin = segmentRepository
                .findByOrigin(trip.getOrigin());

        for(Segment segment: segmentsFromTripOrigin){
            var route = new Route()
                    .addSegments(calculateSegments(segment, trip.getDestiny()));

            routeAlternatives.add(route);
        }

        return routeAlternatives;
    }

    public List<Segment> calculateSegments(Segment segment, String destiny){

        var segments = new ArrayList<Segment>();

        segments.add(segment);

        if(segment.getDestiny().equals(destiny)){
            return segments;
        } else {
            var segmentsFromDestiny = segmentRepository
                    .findByOrigin(segment.getDestiny());

            for (Segment segmentFromDestiny: segmentsFromDestiny){
                segments.addAll(calculateSegments(segmentFromDestiny, destiny));
            }
        }

        return segments;
    }

}
