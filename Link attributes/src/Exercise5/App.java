package Exercise5;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Jens Jensen");
        cast.add("Susan Lastname");
        cast.add("Den store Michael");
        Series s = new Series("Great Batsy", cast);

        ArrayList<String> guestCast = new ArrayList<>();
        guestCast.add("Johnny");
        guestCast.add("Mikala");
        s.createEpisode(1, guestCast, 60);

        guestCast = new ArrayList<>();
        guestCast.add("Louise");
        guestCast.add("Helge");
        s.createEpisode(2, guestCast, 60);

        System.out.println("Total length in minutes: " + s.totalLength());
        System.out.println("All guest actors: " + s.getGuestActors());
    }
}
