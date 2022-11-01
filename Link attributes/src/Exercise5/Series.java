package Exercise5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;
    private ArrayList<Episode> episodes;

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
        this.episodes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode e = new Episode(number, guestActors, lengthMinutes);
        episodes.add(e);
        return e;
    }

    public int totalLength() {
        int totalTimeInMinutes = 0;
        for (Episode e : episodes) {
            totalTimeInMinutes += e.getLengthMinutes();
        }
        return totalTimeInMinutes;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (Episode e :episodes) {
            allGuestActors.addAll(e.getGuestActors());
        }
        return new ArrayList<>(allGuestActors);
    }
}
