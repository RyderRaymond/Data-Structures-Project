// Represents a single TShirt. This class use the existing Product class as base class
import java.util.Date;
public class ProductTShirt extends Product {

    ProductCategory category = ProductCategory.TShirt;

    public ProductTShirt(String title, double price, Date date)
    {
        super(title, price, date);
    }


}