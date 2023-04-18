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
            case Jeans:
                productMap = db.jeansMap;
                break;
            case Shirt:
                productMap = db.shirtMap;
                break;
            case TShirt:
                productMap = db.tShirtMap;
                break;
            case Shorts:
                productMap = db.shortsMap;
                break;
            case Hat:
                productMap = db.hatMap;
                break;
            case Shoes:
                productMap = db.shoesMap;
                break;
            case Jacket:
                productMap = db.jacketMap;
                break;
            default:
                throw new IllegalArgumentException("Invalid Item: " + category);
                category = DecisionHandler.getCategory("Searching");
                searchAllItems(category);
        }

        for (String key : productMap.keySet()) {
            Product product = productMap.get(key);
            System.out.println(product.getTitle() + " - " + product.getPrice() + " - " + product.getListingDate());
        }
    }
}