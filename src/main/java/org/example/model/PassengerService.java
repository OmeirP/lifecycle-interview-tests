package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PassengerService {

    public List<Passenger> filterPassengersByType(List<Passenger> people, PassengerType... passengerType)
    {
        // started running out of time.
        allowedTypesList = passengerType
        ArrayList<Passenger> filtered = new ArrayList<>();

        for person in people:
            if person.getType in allowedTypesList:
                filtered.add(person);

        return filtered;
        //throw new UnsupportedOperationException ("Implement function that filters passengers by given types");
    }

    public List<Passenger> filterPassengersByFareAsInt(List<Passenger> people, int fareTo)
    {
        // same as above but condition to check is passenger fare price less than fareTo.
        throw new UnsupportedOperationException ("Implement function that filters passengers with a fare price less than or equal to fareTo");
    }

    public Passenger upgradeToFirstClass(Passenger passenger)
    {
        // Can't see setters for the Passenger class, make a new instance of a passenger and use the same attributes, passing in FIRST_CLASS for type.

        throw new UnsupportedOperationException ("Implement function that returns a new passenger with upgraded type to FIRST_CLASS");
    }

    public Double computeTotalCost(Passenger passenger)
    {
        // 
        throw new UnsupportedOperationException ("Implement function that returns total cost of passenger (fare price + (5 * luggage count))");
    }

    public List<Passenger> filterByType(List<Passenger> passengers, PassengerType... passengerType)
    {
        throw new UnsupportedOperationException ("Implement function that filters passengers by given types");
    }

    public List<Passenger> filterByFare(List<Passenger> passengers, int fareFrom)
    {
        throw new UnsupportedOperationException ("Implement function that filters passengers by given fareFrom");
    }

    public PassengerType findMostCommonPassengerType(List<Passenger> passengers)
    {
        throw new UnsupportedOperationException ("Return the most common passenger type among all passengers");
    }

    public int boardOrder(Passenger passenger) {
        throw new UnsupportedOperationException ("Return the boarding order of the passenger");
    }

    public  List<Passenger> sortBySeatNumber(List<Passenger> passengers) {
        throw new UnsupportedOperationException ("Implement function that sorts passengers by seat number");
    }

    public UUID findPassengerIdBySeatNumber(List<Passenger> passengers, String seatNumber) {
        throw new UnsupportedOperationException ("Implement function that returns passenger id by seat number");
    }

    public UUID findPassengerIdWithLowestSeatNumber(List<Passenger> passengers) {
        throw new UnsupportedOperationException ("Implement function that returns passenger id with lowest seat number");
    }
}
