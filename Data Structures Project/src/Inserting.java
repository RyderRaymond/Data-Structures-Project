import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class Inserting
  {
    public void insert(Product p, Database db)
    {
      LinkedHashMap<String, Product> map = db.getProductMap(p);
      String title = p.getTitle();
      if (!map.containsKey(p.getTitle())) {
        map.put(title, p);
        db.toBeAdded.add(p);
      }
      else {
        System.out.println("Two products cannot have the same title");
        System.out.println("The title of the new product matches with another product");
      }
    }

      //inserts a new product into the given list based on price. 
  public static void insertNewByPrice(Product p, ArrayList<Product> list)
  {
    double price = p.getPrice();

    for (int i = 0; i < list.size(); i++)
      {
        Product next = list.get(i);
        if (next.getPrice() >= price) list.add(i, p);
        return;
      }

    //if the product was not added (it is the highest price to date), just add it at the end
    list.add(p);
  }

  public static void insertNewByDate(Product p, ArrayList<Product> list)
  {
    Date date = p.getListingDate();

    for (int i = 0; i < list.size(); i++)
      {
        Product next = list.get(i);
        if (next.getListingDate().compareTo(date) >= 0) list.add(i, p);
        return;
      }

    //if the product was not added (it is the newest product), just add it at the end
    list.add(p);
  }
  }