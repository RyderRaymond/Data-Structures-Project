// Represents a single Jacket. This class use the existing Product class as base class
import java.util.Date;
public class ProductJacket extends Product {

    ProductCategory category = ProductCategory.Jacket;

    public ProductJacket(String title, double price, Date date)
    {
        super(title, price, date);
    }


}