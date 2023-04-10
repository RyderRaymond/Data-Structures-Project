// Represent a single product. This is the base class for all the product types
import java.util.Date;
public class Product {
    public double price; // price of the product
    public String title; // title of the product
    public Date listingDate; // when the product first brought to the inventory

    public enum ProductCategory {
        TShirt,
        Shirt,
        Shorts,
        Jeans,
        Hat,
        Shoes,
        Jacket;
    }

    public Product(String title, double price, Date listingDate)
    {
        this.title = title;
        this.price = price;
        this.listingDate = listingDate;
    }

    public String getTitle()
    {
        return title;
    }

    public double getPrice()
    {
        return price;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public String toString()
    {
        return "Title: " + title + ", Price: " + price + ", Date: " + listingDate;
    }
}