package org.example.model;

import java.util.*;

public class Aeroplane {

    private final List<Passenger> passengers = new ArrayList<>();

    public String enter(Passenger passenger)
    {
        if (passenger == null) return null;

        passengers.add(passenger);
        System.out.println(passenger.getDescription());

        if (passenger.getType() == PassengerType.ECONOMY) {
            return "Welcome Economy Passenger " + passenger.getName();
        } else if (passenger.getType() == PassengerType.BUSINESS_CLASS) {
            return "Welcome Business Class Passenger " + passenger.getName();
        }
        //throw new UnsupportedOperationException ("Add passenger to passengers list");
        // throw new UnsupportedOperationException ("Print passenger description if it is not null");
        // throw new UnsupportedOperationException ("Print a welcome message for each passenger type, see unit test shouldAddPassengerOnEnter for expected message");
        return null;
    }

    public List<Passenger> bulkEnter(Passenger... passenger)
    {
        for (Passenger p : passenger) {
            enter(p); // Enters the passenger
        }
        return passengers;
        //throw new UnsupportedOperationException ("Implement method that executes enter(passenger) for each passenger and return all as list");
    }

    public boolean exit(UUID passengerId)
    {
        for (int i=0; i < passengers.size(); i++) {
            if (passengers.get(i).getId().equals(passengerId)) {
                passengers.remove(i);
                return true;
            }
        }
        return false;

        //throw new UnsupportedOperationException ("Should remove passenger from passenger list returning true on success otherwise false");
    }

    public int countPassengers()
    {
        return passengers.size();
        //throw new UnsupportedOperationException ("count passengers in passenger list");
    }

    public int countPassengersByType(PassengerType passengerType)
    {
        int count = 0;
        for (int i=0; i < passengers.size(); i++) {
            if (passengers.get(i).getType().equals(passengerType)) {
                count+=1;
            }
        }
        return count;
        //throw new UnsupportedOperationException ("count passengers of given passenger type in passenger list");
    }

    public Map<PassengerType, Passenger> mapPassengersByType()
    {
        Map<PassengerType, Passenger> typeMap = new HashMap<>();
        for (Passenger p : passengers) {
            typeMap.put(p.getType(), p);    // Should replace the old value
        }
        return typeMap;
        //throw new UnsupportedOperationException ("Convert passenger list to a map keyed by passenger type. If any two elements would have the same key, then the last one gets added to the map");
    }

    public List<Passenger> orderPassengersByFare()
    {
        List<Passenger> sortedList = new ArrayList<>(passengers); // copy of original
        sortedList.sort(Comparator.comparingDouble(Passenger::getFarePrice));

        return sortedList;

        //throw new UnsupportedOperationException ("Return a list of all passengers (from passengers list) sorted in ascending order of fare price");
    }

    public double totalFare()
    {
        Double total = 0.0;

        for (int i=0; i < passengers.size(); i++) {
            total += passengers.get(i).getFarePrice();
        }
        return total;
        //throw new UnsupportedOperationException ("Return the sum of all passenger fare prices");
    }
}
