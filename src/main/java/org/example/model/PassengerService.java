package org.example.model;

import java.util.*;

public class PassengerService {

    public List<Passenger> filterPassengersByType(List<Passenger> people, PassengerType... passengerType)
    {
        // Make list out of allowed types.
        List<PassengerType> allowedTypesList = List.of(passengerType);

        ArrayList<Passenger> filtered = new ArrayList<>();

        for (Passenger person : people) {
            if (allowedTypesList.contains(person.getType())) {
                filtered.add(person);
            }
        }

        return filtered;
        //throw new UnsupportedOperationException ("Implement function that filters passengers by given types");
    }

    public List<Passenger> filterPassengersByFareAsInt(List<Passenger> people, int fareTo)
    {
        // same as above but condition to check is passenger fare price less than fareTo.
        ArrayList<Passenger> filtered = new ArrayList<>();

        for (Passenger person : people) {
            if (person.getFarePrice() < fareTo) {
                filtered.add(person);
            }
        }
        return filtered;

        //throw new UnsupportedOperationException ("Implement function that filters passengers with a fare price less than or equal to fareTo");
    }

    public Passenger upgradeToFirstClass(Passenger passenger)
    {
        // Can't see setters for the Passenger class, maybe make a new instance of a passenger and use the same attributes, passing in FIRST_CLASS for type.
        if (passenger == null) {
            return null;
        }

        return new Passenger(
                passenger.getId(),
                passenger.getName(),
                PassengerType.FIRST_CLASS,
                passenger.getLuggageCount(),
                passenger.getFarePrice(),
                passenger.getDescription(),
                passenger.getSeatNumber()
        );

        //throw new UnsupportedOperationException ("Implement function that returns a new passenger with upgraded type to FIRST_CLASS");
    }

    public Double computeTotalCost(Passenger passenger)
    {
        Double total = 0.0;
        total += (passenger.getFarePrice() + 5* passenger.getLuggageCount());
        return total;
        //throw new UnsupportedOperationException ("Implement function that returns total cost of passenger (fare price + (5 * luggage count))");
    }

    public List<Passenger> filterByType(List<Passenger> passengers, PassengerType... passengerType)
    {
        // Same as before??
        List<PassengerType> allowedTypesList = List.of(passengerType);

        ArrayList<Passenger> filtered = new ArrayList<>();

        for (Passenger person : passengers) {
            if (allowedTypesList.contains(person.getType())) {
                filtered.add(person);
            }
        }

        return filtered;

        //throw new UnsupportedOperationException ("Implement function that filters passengers by given types");
    }

    public List<Passenger> filterByFare(List<Passenger> passengers, int fareFrom)
    {
        // Same as last fare sort but with opposite condition
        ArrayList<Passenger> filtered = new ArrayList<>();

        for (Passenger person : passengers) {
            if (person.getFarePrice() >= fareFrom) {
                filtered.add(person);
            }
        }
        return filtered;
        //throw new UnsupportedOperationException ("Implement function that filters passengers by given fareFrom");
    }

    public PassengerType findMostCommonPassengerType(List<Passenger> passengers)
    {
        HashMap<PassengerType, Integer> typeCount = new HashMap<>();
        for (Passenger passenger : passengers) {

            // Get the current count
            int currentCount;
            if (typeCount.get(passenger.getType()) == null) {
                currentCount = 0;
            } else {
                currentCount = typeCount.get(passenger.getType());
            }

            typeCount.put(passenger.getType(), currentCount+1);
        }
        int maxCount = 0;
        PassengerType modeType = null;
        for (PassengerType type : typeCount.keySet()) {
            if (typeCount.get(type) > maxCount) {
                maxCount = typeCount.get(type);
                modeType = type;
            }
        }
        return modeType;
        //throw new UnsupportedOperationException ("Return the most common passenger type among all passengers");
    }

    public int boardOrder(Passenger passenger) {
        // Based on test, the boarding order is determined by the passenger type?
        Map<PassengerType, Integer> priorityMap = new HashMap<>();
        priorityMap.put(PassengerType.ECONOMY, 3);
        priorityMap.put(PassengerType.BUSINESS_CLASS, 2);
        priorityMap.put(PassengerType.FIRST_CLASS, 1);

        return priorityMap.get(passenger.getType());

        //throw new UnsupportedOperationException ("Return the boarding order of the passenger");
    }

    public  List<Passenger> sortBySeatNumber(List<Passenger> passengers) {

        List<Passenger> sortedList = new ArrayList<>(passengers); // Use numbers first, use letters for matching numbers.

        for (Passenger passenger : sortedList) {
            passenger.setSeatNumber(passenger.getSeatNumber().replaceAll("[^0-9]", "")); // Keep only the numbers
        }

        sortedList.sort(Comparator.comparing(Passenger::getSeatNumber));

        // Can sort out collision with letters after that.
        return sortedList;

        //throw new UnsupportedOperationException ("Implement function that sorts passengers by seat number");
    }

    public UUID findPassengerIdBySeatNumber(List<Passenger> passengers, String seatNumber) {

        for (Passenger p : passengers) {
            if (p.getSeatNumber().equals(seatNumber)) {
                return p.getId();
            }
        }
        return null;
        //throw new UnsupportedOperationException ("Implement function that returns passenger id by seat number");
    }

    public UUID findPassengerIdWithLowestSeatNumber(List<Passenger> passengers) {
        ArrayList<Passenger> sameNumPassengers = new ArrayList<>(); // Keep passengers of the same lowest number here.
        int minSeat = 9999;

        for (Passenger p : passengers) {
            int seatNum = Integer.parseInt(p.getSeatNumber().replaceAll("[^0-9]", ""));
            if (seatNum < minSeat) {
                sameNumPassengers = new ArrayList<>();
                sameNumPassengers.add(p); // If it's the new lowest, refresh the list with the only smallest one
                minSeat = seatNum;

            } else if (seatNum == minSeat) {
                sameNumPassengers.add(p);   // If its joint smallest, keep it in the list, sort the letters after.
            }
        }

        sameNumPassengers.sort(Comparator.comparing(Passenger::getSeatNumber)); // Sort the letters

        return sameNumPassengers.get(0).getId();

        //throw new UnsupportedOperationException ("Implement function that returns passenger id with lowest seat number");
    }
}
