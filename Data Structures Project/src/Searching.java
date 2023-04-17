import java.util.LinkedHashMap;

public class Searching{
  //searching thought all items and be able to show what is being asked 
  //display all available items prior to selecting for search
  //linked hashmap needed for searching 
  //

  private Database db;

    public Searching(Database db) {
        this.db = db;
    }

    public void searchAllItems(Product.ProductCategory category) {
        LinkedHashMap<String, ? extends Product> productMap;

        switch (category) {
            case JEANS:
                productMap = db.jeansMap;
                break;
            case SHIRT:
                productMap = db.shirtMap;
                break;
            case TSHIRT:
                productMap = db.tShirtMap;
                break;
            case SHORTS:
                productMap = db.shortsMap;
                break;
            case HAT:
                productMap = db.hatMap;
                break;
            case SHOES:
                productMap = db.shoesMap;
                break;
            case JACKET:
                productMap = db.jacketMap;
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }

        for (String key : productMap.keySet()) {
            Product product = productMap.get(key);
            System.out.println(product.getTitle() + " - " + product.getPrice() + " - " + product.getDateAdded());
        }
    }
}