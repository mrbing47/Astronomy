package garg.sarthik.fragmentpager;

import java.util.ArrayList;

public class StarDetails {

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

    public StarDetails(String name, String details, String imageURL, String moreURL) {

        this.name = name;
        this.details = details;
        this.imageURL = imageURL;
        this.moreURL = moreURL;
    }

    public static ArrayList<StarDetails> getStarDetails (){

        ArrayList<StarDetails> sd = new ArrayList<>();

        sd.add(new StarDetails(
                "Sun",
                "The Sun is the star at the center of the Solar System. " +
                        "It is a nearly perfect sphere of hot plasma, with internal convective motion that generates a magnetic field via a dynamo process.",
                "https://img.purch.com/w/660/aHR0cDovL3d3dy5zcGFjZS5jb20vaW1hZ2VzL2kvMDAwLzAxMS80NDMvb3JpZ2luYWwvbWFqb3Itc29sYXItZmxhcmUtYXVndXN0LTktLmpwZw==",
                "https://en.wikipedia.org/wiki/Sun"
        ));

        sd.add(new StarDetails(
                "Sirius",
                "Sirius is a star system and the brightest star in the Earth's night sky. " +
                        "With a visual apparent magnitude of −1.46, it is almost twice as bright as Canopus, the next brightest star." +
                        " The system has the Bayer designation Alpha Canis Majoris.",
                "http://en.es-static.us/upl/2017/02/sirius-2-19-2018-Jim-Livingston-Custer-SD-lg-e1519156718851.jpg",
                "https://en.wikipedia.org/wiki/Sirius"
        ));

        sd.add(new StarDetails(
           "Betelgeuse",
                "Betelgeuse, also designated Alpha Orionis, is the ninth-brightest star in the night sky and second-brightest in the constellation of Orion.",
                "https://upload.wikimedia.org/wikipedia/commons/5/57/Betelgeuse_captured_by_ALMA.jpg",
                "https://en.wikipedia.org/wiki/Betelgeuse"
        ));

        sd.add(new StarDetails(
                "Vega",
                "Vega, also designated Alpha Lyrae, " +
                        "is the brightest star in the constellation of Lyra, " +
                        "the fifth-brightest star in the night sky, " +
                        "and the second-brightest star in the northern celestial hemisphere, " +
                        "after Arcturus.",
                "http://en.es-static.us/upl/2015/07/Vega-espanak-e1468969973634.jpg",
                "https://en.wikipedia.org/wiki/Vega"
        ));
        return sd;
    }


}
