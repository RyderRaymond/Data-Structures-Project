import java.util.LinkedHashMap;

public class Searching{
  // The Searching class provides methods for searching and displaying products from the inventory database.

  // The database object used to store the inventory data.
  private Database db;

    // The constructor method that initializes the database object.
    public Searching(Database db) {
        this.db = db;
    }

    // The searchAllItems method searches and displays all items of a given category.
    public String searchAllItems(Product.ProductCategory category) {
        // LinkedHashMap is a hash table implementation with predictable iteration order.
        // Here, it is used to store products of a specific category.
        LinkedHashMap<String, ? extends Product> productMap;

        // Switch statement to determine which category of products to search.
        switch (category) {
            case jeans:
                productMap = db.jeansMap;
                break;
            case shirt:
                productMap = db.shirtMap;
                break;
            case tshirt:
                productMap = db.tShirtMap;
                break;
            case shorts:
                productMap = db.shortsMap;
                break;
            case hat:
                productMap = db.hatMap;
                break;
            case shoes:
                productMap = db.shoesMap;
                break;
            case jacket:
                productMap = db.jacketMap;
                break;
            default:
                // Use the DecisionHandler class to get a valid category input.
                category = DecisionHandler.getCategory("Searching");
                return searchAllItems(Product.ProductCategory.valueOf(category));
        }

        // Iterate through the productMap and display the product details.
        String productTitle = "";
        for (String key : productMap.keySet()) {
            Product product = productMap.get(key);
            System.out.println(product.getTitle() + " - " + product.getPrice() + " - " + product.getListingDate());
            productTitle = product.getTitle();
        }

        // Return the title of the last product in the map.
        return productTitle;
    }


    // The searchPriceRange method searches and displays products within a given price range
    // for a specific category.
    public void searchPriceRange (Product.ProductCategory category, int maxPrice, int minPrice){
        
        LinkedHashMap<String, ? extends Product> productMap;

        switch (category) {
            case jeans:
                productMap = db.jeansMap;
                break;
            case shirt:
                productMap = db.shirtMap;
                break;
            case tshirt:
                productMap = db.tShirtMap;
                break;
            case shorts:
                productMap = db.shortsMap;
                break;
            case hat:
                productMap = db.hatMap;
                break;
            case shoes:
                productMap = db.shoesMap;
                break;
            case jacket:
                productMap = db.jacketMap;
                break;
            default:
                // Use the DecisionHandler class to get a valid category input.
                category = Product.ProductCategory.valueOf(DecisionHandler.getCategory("Searching"));
                searchPriceRange(category, maxPrice, minPrice);
                return;
        }

        // Iterate through the productMap and display the product details if it falls
        // within the given price range
        for (String key : productMap.keySet()) {
            Product product = productMap.get(key);
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
              System.out.println(product.getTitle() + " - " + product.getPrice() + " - " + product.getListingDate());
            }
        }
    } 


}