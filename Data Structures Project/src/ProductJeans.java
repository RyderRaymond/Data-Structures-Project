// Represents a single Jeans. This class use the existing Product class as base class
import java.util.Date;
public class ProductJeans extends Product {
    ProductCategory category = ProductCategory.Jeans;


    public ProductJeans(String title, double price, Date date)
    {
        super(title, price, date);
    }


}