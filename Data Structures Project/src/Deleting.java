import java.util.LinkedHashMap;

public class Deleting{
    public void delete(Product p) {
        LinkedHashMap<String, Product> map;
        String title = p.getTitle();
        switch (p.category) {
            case Jeans:
                map = jeansMap;
                break;
            case Shirt:
                map = shirtMap;
                break;
            case TShirt:
                map = tShirtMap;
                break;
            case Shorts:
                map = shortsMap;
                break;
            case Hat:
                map = hatMap;
                break;
            case Shoes:
                map = shoesMap;
                break;
            case Jacket:
                map = jacketMap;
                break;
            default:
                throw new IllegalArgumentException("The product category was not found; nothing was deleted");


        }
    }
}