package Exercise3;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);

        System.out.println("Average age of Passengers");
        System.out.println(flight.averageAge());
        System.out.println();

        flight.setDepartDate(LocalDateTime.now());
        flight.setArrivalDate(LocalDateTime.now().plusDays(2));
        System.out.println("Length of the flight in hours");
        System.out.println(flight.flightDurationInHours());
        System.out.println();

        System.out.println("Is the flight doing midnight");
        System.out.println(flight.midnightFlight());
    }

}
