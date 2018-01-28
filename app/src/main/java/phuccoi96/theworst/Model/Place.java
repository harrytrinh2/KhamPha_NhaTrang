package phuccoi96.theworst.Model;

/**
 * Created by USER on 1/14/2018.
 */


//Category
public class Place {
    private String Name;
    private String Image;

    public Place() {
    }

    public Place(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
