// Represents a single pair of Shorts. This class use the existing Product class as base class
import java.util.Date;
public class ProductShorts extends Product {

    ProductCategory category = ProductCategory.TShirt;

    public ProductShorts(String title, double price, Date date)
    {
        super(title, price, date);
    }


}