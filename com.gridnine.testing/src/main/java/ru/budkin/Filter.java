package ru.budkin;

import java.util.List;
import java.util.Set;

public interface Filter {

    void showAllFlights (List<Flight> flights);

    Set<Flight> getDepartureBeforeNow (List<Flight> flights);

    Set<Flight> getArrivalBeforeDeparture (List<Flight> flights);

    Set<Flight> getWaitingTimeMoreTwoHours (List<Flight> flights);


}
