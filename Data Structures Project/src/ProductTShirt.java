// Represents a single Jeans. This class use the existing Product class as base class
import java.util.Date;
public class ProductTShirt extends Product {
    ProductCategory category = ProductCategory.TShirt;


    public ProductShirt(String title, double price, Date date)
    {
        super(title, price, date);
    }


}