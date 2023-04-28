import java.util.LinkedHashMap;

public class Deleting{
    public void delete(Product p, Database db) {
        LinkedHashMap<String, Product> map;
        String title = p.getTitle();
        switch (p.category) {
            case Jeans:
                map = db.jeansMap;
                break;
            case Shirt:
                map = db.shirtMap;
                break;
            case TShirt:
                map = db.tShirtMap;
                break;
            case Shorts:
                map = db.shortsMap;
                break;
            case Hat:
                map = db.hatMap;
                break;
            case Shoes:
                map = db.shoesMap;
                break;
            case Jacket:
                map = db.jacketMap;
                break;
            default:
                throw new IllegalArgumentException("The product category was not found; nothing was deleted");


        }
    }
}