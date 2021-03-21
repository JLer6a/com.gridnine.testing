package ru.budkin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();

        Filter segmentFilter = new FilterImpl();

        segmentFilter.showAllFlights(flightList);

        segmentFilter.getDepartureBeforeNow(flightList);

        segmentFilter.getArrivalBeforeDeparture(flightList);

        segmentFilter.getWaitingTimeMoreTwoHours(flightList);



    }
}
