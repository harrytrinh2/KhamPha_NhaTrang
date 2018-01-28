package phuccoi96.theworst.Model;

/**
 * Created by USER on 1/24/2018.
 */

public class Food_In_Detail {

    private String Name,Image,Description,Price,Discount,FoodId;

    public Food_In_Detail() {
    }

    public Food_In_Detail(String name, String image, String description, String price, String discount, String foodId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        FoodId = foodId;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getFoodId() {
        return FoodId;
    }

    public void setFoodId(String foodId) {
        FoodId = foodId;
    }
}
