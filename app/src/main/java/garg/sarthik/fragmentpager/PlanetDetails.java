package garg.sarthik.fragmentpager;

import java.util.ArrayList;

public class PlanetDetails {

    private String name;
    private String details;
    private String imageURL;
    private String moreURL;

    public PlanetDetails(String name, String details, String imageURL, String moreURL) {
        this.name = name;
        this.details = details;
        this.imageURL = imageURL;
        this.moreURL = moreURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMoreURL() {
        return moreURL;
    }

    public String getName() {

        return name;
    }

    public String getDetails() {
        return details;
    }

    public static ArrayList<PlanetDetails> getPlanetDetails()
    {
        ArrayList<PlanetDetails> planetDetails = new ArrayList<>();

        planetDetails.add(new PlanetDetails(
                "Mercury",
                "Mercury is the smallest and innermost planet in the Solar System. " +
                "Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System. " +
                "It is named after the Roman deity Mercury, the messenger of the gods.",
                "https://upload.wikimedia.org/wikipedia/commons/d/d9/Mercury_in_color_-_Prockter07-edit1.jpg",
                "https://en.wikipedia.org/wiki/Mercury_(planet)"));
        planetDetails.add(new PlanetDetails("Venus",
                "Venus is the second planet from the Sun, orbiting it every 224.7 Earth days. " +
                "It has the longest rotation period (243 days) of any planet in the Solar System and rotates in the opposite direction to most other planets (meaning the Sun would rise in the west and set in the east).",
                "https://upload.wikimedia.org/wikipedia/commons/e/e5/Venus-real_color.jpg",
                "https://en.wikipedia.org/wiki/Venus"));
        planetDetails.add(new PlanetDetails(
                "Earth",
                "Earth is the third planet from the Sun and the only astronomical object known to harbor life." +
                        "Earth revolves around the Sun in 365.26 days, a period known as an Earth year. During this time, Earth rotates about its axis about 366.26 times.",
                "https://upload.wikimedia.org/wikipedia/commons/9/97/The_Earth_seen_from_Apollo_17.jpg",
                "https://en.wikipedia.org/wiki/Earth"));

        return planetDetails;
    }
}
