package garg.sarthik.fragmentpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GalaxyDetails {

    private String name;
    private String details;
    private String imageURL;
    private String moreURL;

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMoreURL() {
        return moreURL;
    }

    public GalaxyDetails(String name, String details, String imageURL, String moreURL) {

        this.name = name;
        this.details = details;
        this.imageURL = imageURL;
        this.moreURL = moreURL;
    }

    public static ArrayList<GalaxyDetails> getGalaxyDetails(){

        ArrayList<GalaxyDetails> gd = new ArrayList<>();

        gd.add(new GalaxyDetails(
                "Milky Way",
                "The Milky Way is the galaxy that contains our Solar System. The descriptive \"milky\" is derived from the appearance from Earth of the galaxy – a band of light seen in the night sky formed from stars that cannot be individually distinguished by the naked eye.",
                "https://upload.wikimedia.org/wikipedia/commons/c/c6/Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg",
                "https://en.wikipedia.org/wiki/Milky_Way"
        ));

        gd.add(new GalaxyDetails(
                "Andromeda Galaxy",
                "The Andromeda Galaxy, also known as Messier 31, M31, or NGC 224, is a spiral galaxy approximately 780 kiloparsecs from Earth, and the nearest major galaxy to the Milky Way.",
                "https://upload.wikimedia.org/wikipedia/commons/9/98/Andromeda_Galaxy_%28with_h-alpha%29.jpg",
                "https://en.wikipedia.org/wiki/Andromeda_Galaxy"

        ));

        gd.add(new GalaxyDetails(
                "Whirlpool Galaxy",
                "The Whirlpool Galaxy, also known as Messier 51a, M51a, and NGC 5194, is an interacting grand-design spiral galaxy with a Seyfert 2 active galactic nucleus.",
                "https://upload.wikimedia.org/wikipedia/commons/d/db/Messier51_sRGB.jpg",
                "https://en.wikipedia.org/wiki/Whirlpool_Galaxy"
        ));

        gd.add(new GalaxyDetails(
                "Triangulum Galaxy",
                "The Triangulum Galaxy is a spiral galaxy approximately 3 million light-years from Earth in the constellation Triangulum. It is catalogued as Messier 33 or NGC 598.",
                "https://upload.wikimedia.org/wikipedia/commons/e/ea/M33_-_Triangulum_Galaxy.jpg",
                "https://en.wikipedia.org/wiki/Triangulum_Galaxy"
        ));

        return gd;
    }

}
