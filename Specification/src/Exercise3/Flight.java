package Exercise3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * A flight with an airline between airports. 
 */
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    
    /**
     * Constructor that creates a flight for an airline.
     * @param flightNumber the number of the flight
     * @param destination the destination of the flight
     */
    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    /**
     * Gets the destination.
     * @return the destination or null if not set
     */
    public String getDestination() {
        return destination;
    }
    /**
     * Gets the flight number.
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }
    /**
     * Gets the LocalDateTime when the flight will depart
     * @return departure date, can be null
     */
    public LocalDateTime getDepartDate() {
        return departDate;
    }

    /**
     * Sets the LocalDateTime when the flight will depart.
     * Precondition: cannot be later than the land time.
     * @param departDate
     */
    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }

    /**
     * Gets the LocalDateTime for when the flight will land.
     * @return arrival date, can be null
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the LocalDateTime for when the flight will land.
     * Precondition: cannot be before the departure time.
     * @param landDate arrival date
     */
    public void setArrivalDate(LocalDateTime landDate) {
        this.arrivalDate = landDate;
    }

    /**
     * Creates a passenger with name and age
     * Precondition: name is not empty or null and age >= 0.
     * @param name name of the passenger
     * @param age the age of the passenger
     * @return the newly created passenger object
     */
    public Passenger createPassenger(String name, int age) {
        Passenger p = new Passenger(name, age);
        passengers.add(p);
        return p;
    }
    
    /**
     * Removes the passenger.
     * Precondition: the passenger must exist on this flight.
     * @param passenger
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
    
    /**
     * Gets the current list of passengers on this flight
     * @return list of passengers
     */
    public ArrayList<Passenger> listOfPassengers() {
        return new ArrayList<>(passengers);
    }
    
    /**
     * The duration of the flight measured in hours
     * Precondition: the departure and arrival dates must have been set
     * @return how many hours
     */
    public double flightDurationInHours() {
       return ChronoUnit.HOURS.between(departDate, arrivalDate);
    }
    
    /**
     * Returns true if the flight happens during midnight of the day of departure.
     * Precondition: depart and arrival dates must have been set
     * @return true if midnight is included in the flight period, otherwise false.
     */
    public boolean midnightFlight() {
        if (ChronoUnit.DAYS.between(departDate, arrivalDate) >= 1) {
            return true;
        }
        return false;
    }
    
    /**
     * Gets the average age of all the passengers
     * Precondition: there must exist passengers on this flight
     * @return average age of passengers
     */
    public double averageAge() {
        double allAges = 0;
        for (Passenger p: passengers) {
            allAges += p.getAge();
        }
        return allAges / passengers.size();
    }
}
