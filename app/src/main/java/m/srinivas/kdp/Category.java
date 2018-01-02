package m.srinivas.kdp;

/**
 * Created by srinivas on 02/01/18.
 */

public class Category {
    String Category_id, Category_name;
    int Categor_image;

    Category(String Category_id, String Category_name, int Category_image) {
        this.Category_id = Category_id;
        this.Category_name = Category_name.toUpperCase();
        this.Categor_image = Category_image;
    }

    public int getCategor_image() {
        return Categor_image;
    }

    public String getCategory_id() {
        return Category_id;
    }

    public String getCategory_name() {
        return Category_name;
    }
}
