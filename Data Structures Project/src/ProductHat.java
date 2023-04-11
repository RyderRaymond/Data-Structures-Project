// Represents a single Hat. This class use the existing Product class as base class
import java.util.Date;
public class ProductHat extends Product {

    ProductCategory category = ProductCategory.TShirt;

    public ProductHat(String title, double price, Date date)
    {
        super(title, price, date);
    }


}