package ru.budkin;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterImpl implements Filter {


    @Override
    public void showAllFlights(List<Flight> flights) {
        for (Flight flight : flights){
            System.out.println("Flight Number :  " + flight.getId());
            for (int i = 0; i < flight.getSegments().size() ; i++) {
                System.out.println("Segment       : " +flight.getSegments().get(i));
            }
            System.out.println("-----------------------------------------------------");
        }

    }

    @Override
    public Set<Flight> getDepartureBeforeNow(List<Flight> flights) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Set<Flight> set = new HashSet<>();
        List<Segment> list = new ArrayList<>();
        for (Flight flight : flights){
            list.addAll(flight.getSegments());
            while (list.size() > 0){
                LocalDateTime departure = list.get(0).getDepartureDate();
                LocalDateTime arrival = list.remove(0).getArrivalDate();
                if (departure.isBefore(localDateTime)){
                    System.out.println( "Flight Number  : " + flight.getId() + " - Flight departing in the past");
                    showInformation(arrival, departure);
                    set.add(flight);
                }
            }
        }
        return set;
    }

    @Override
    public Set<Flight> getArrivalBeforeDeparture(List<Flight> flights) {
        Set<Flight> set = new HashSet<>();
        List<Segment> list = new ArrayList<>();
        for (Flight flight : flights){
            list.addAll(flight.getSegments());
            while (list.size() > 0){
                LocalDateTime departure = list.get(0).getDepartureDate();
                LocalDateTime arrival = list.remove(0).getArrivalDate();
                if (arrival.isBefore(departure)){
                    System.out.println( "Flight Number  : " + flight.getId() + " - Flight that departs before it arrives");
                    showInformation(arrival, departure);
                    set.add(flight);
                }
            }
        }
        return set;
    }

    @Override
    public Set<Flight> getWaitingTimeMoreTwoHours(List<Flight> flights) {
        Set<Flight> set = new HashSet<>();
        List<Segment> list = new ArrayList<>();
        for (Flight flight : flights ) {
            int countHours = 0;
            list.addAll(flight.getSegments());
            if (list.size() >= 2) {
                while (list.size() >= 2) {
                    LocalDateTime arrival = list.remove(0).getArrivalDate();
                    LocalDateTime departure = list.get(0).getDepartureDate();
                    countHours = countHours + timeOnEarth(arrival,departure);
                    if(countHours > 2) {
                        System.out.println( "Flight Number  : " + flight.getId() + " - Flight with more than two hours ground time");
                        showInformation(arrival, departure);
                        set.add(flight);
                    }
                }
            }
            list.clear();
        }
        return set;
    }

    private void showInformation(LocalDateTime arrival, LocalDateTime departure) {
        System.out.println("Departure time : " + departure);
        System.out.println("Arrival time   : " + arrival);
        System.out.println("-----------------------------------------------------");
    }

    public int timeOnEarth(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
