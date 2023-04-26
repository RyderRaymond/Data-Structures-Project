import java.util.*;

public class Database {

    //The Linked List and HashMap of jeans is for representation that the two take the same runtime except for searching for an index
    LinkedList<ProductJeans> jeansLL;
    HashMap<String, ProductJeans> jeansHM;

    //Products Hash Maps and ArrayLists (for sorting purposes)
    LinkedHashMap<String, Product> jeansMap;
    ArrayList<Product> jeansPrices;
    ArrayList<Product> jeansDates;

    LinkedHashMap<String, Product> shirtMap;
    ArrayList<Product> shirtPrices;
    ArrayList<Product> shirtDates;

    LinkedHashMap<String, Product> tShirtMap;
    ArrayList<Product> tShirtPrices;
    ArrayList<Product> tShirtDates;

    LinkedHashMap<String, Product> shortsMap;
    ArrayList<Product> shortsPrices;
    ArrayList<Product> shortsDates;

    LinkedHashMap<String, Product> hatMap;
    ArrayList<Product> hatPrices;
    ArrayList<Product> hatDates;

    LinkedHashMap<String, Product> shoesMap;
    ArrayList<Product> shoesPrices;
    ArrayList<Product> shoesDates;

    LinkedHashMap<String, Product> jacketMap;
    ArrayList<Product> jacketPrices;
    ArrayList<Product> jacketDates;

    LinkedList<Product> toBeDeleted;
    LinkedList<Product> toBeAdded;


    //No-argument constructor. Initializes the database with 10000 items each
    public Database() {
        final int NUM = 10000;
        //Initialize the database with all the Products
        initializeJeans(NUM);
        initializeShirts(NUM);
        initializeTShirts(NUM);
        initializeShorts(NUM);
        initializeHats(NUM);
        initializeShoes(NUM);
        initializeJackets(NUM);

        toBeDeleted = new LinkedList<Product>();
        toBeAdded = new LinkedList<Product>();
    }

    //Constructor that allows for manual numbers of items
    public Database(int jeansNum, int shirtNum, int tShirtNum, int shortNum, int hatNum, int shoesNum, int jacketNum) {
        //Initialize the database with all the Products
        initializeJeans(jeansNum);
        initializeShirts(shirtNum);
        initializeTShirts(tShirtNum);
        initializeShorts(shortNum);
        initializeHats(hatNum);
        initializeShoes(shoesNum);
        initializeJackets(jacketNum);
    }

    //Initializes the Jeans LinkedHashMap. Initializes the linked list and normal hashmap as well for comparison of runtime
    public void initializeJeans(int numJeans) {
        Random random = new Random();

        jeansLL = new LinkedList<>();
        for (int i = 0; i < numJeans; i++) {
            jeansLL.add(new ProductJeans("Jeans" + i, random.nextDouble(15, 50), new Date()));
        }

        //Initial capacity is set to jeans * 2 to avoid collisions. Uses extra space but will be faster
        jeansHM = new HashMap<>(jeansLL.size() * 2);

        jeansMap = new LinkedHashMap<>(numJeans * 2);

        jeansPrices = new ArrayList<>(numJeans);
        jeansDates = new ArrayList<>(numJeans);

        for (ProductJeans j : jeansLL) {
            jeansHM.put(j.getTitle(), j);
            jeansMap.put(j.getTitle(), j);
            jeansPrices.add(j);
            jeansDates.add(j);
        }
    }

    public void initializeShirts(int num) {
        Random random = new Random();
        shirtMap = new LinkedHashMap<>(num * 2);
        shirtDates = new ArrayList<>(num);
        shirtPrices = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductShirt next = new ProductShirt("Shirt" + i, random.nextDouble(15, 50), new Date());
            shirtMap.put(next.getTitle(), next);
            shirtPrices.add(next);
            shirtDates.add(next);
        }
    }


    public void initializeTShirts(int num) {
        Random random = new Random();
        tShirtMap = new LinkedHashMap<>(num * 2);
        tShirtDates = new ArrayList<>(num);
        tShirtPrices = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductTShirt next = new ProductTShirt("TShirt" + i, random.nextDouble(15, 50), new Date());
            tShirtMap.put(next.getTitle(), next);
            tShirtDates.add(next);
            tShirtPrices.add(next);
        }
    }

    public void initializeShorts(int num) {
        Random random = new Random();
        shortsMap = new LinkedHashMap<>(num * 2);
        shortsPrices = new ArrayList<>(num);
        shortsDates = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductShorts next = new ProductShorts("Shorts" + i, random.nextDouble(15, 50), new Date());
            shortsMap.put(next.getTitle(), next);
            shortsPrices.add(next);
            shortsDates.add(next);
        }
    }

    public void initializeHats(int num) {
        Random random = new Random();
        hatMap = new LinkedHashMap<>(num * 2);
        hatPrices = new ArrayList<>(num);
        hatDates = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductHat next = new ProductHat("Hat" + i, random.nextDouble(15, 50), new Date());
            hatMap.put(next.getTitle(), next);
            hatPrices.add(next);
            hatDates.add(next);
        }
    }

    public void initializeShoes(int num) {
        Random random = new Random();
        shoesMap = new LinkedHashMap<>(num * 2);
        shoesPrices = new ArrayList<>(num);
        shoesDates = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductShoes next = new ProductShoes("Shoes" + i, random.nextDouble(15, 50), new Date());
            shoesMap.put(next.getTitle(), next);
            shoesPrices.add(next);
            shoesDates.add(next);
        }
    }

    public void initializeJackets(int num) {
        Random random = new Random();
        jacketMap = new LinkedHashMap<>(num * 2);
        jacketPrices = new ArrayList<>(num);
        jacketDates = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            ProductJacket next = new ProductJacket("Jacket" + i, random.nextDouble(15, 50), new Date());
            jacketMap.put(next.getTitle(), next);
            jacketDates.add(next);
            jacketPrices.add(next);
        }
    }


    //using HashMap
    public ProductJeans searchJeansHashMap(String name) {
        if (jeansMap.containsKey(name)) {
            return jeansMap.get(name);
        }

        System.out.println("This item does not exist");
        return null;
    }

    //using LinkedList
    public ProductJeans getJeansLL(int position) {
        return jeansLL.get(position);
    }

    //using Linked Hashmap - the main implementation
    public ProductJeans searchJeans(String name) {
        if (jeansMap.containsKey(name)) {
            return jeansMap.get(name);
        }

        System.out.println("This item does not exist");
        return null;
    }

    //Searching by index using linked hashMap
    public ProductJeans getJeans(int position) {
        ProductJeans[] j = jeansMap.values().toArray(new ProductJeans[0]);

        if (position < j.length)
            return j[position];
        System.out.println("The index is out of bounds");
        return null;
    }

    //Sorts this product by prices using quicksort
    public void sortPrices(String productType) {
        //Initializes as jeansPrices so java does not get mad that list may not be initialized
        ArrayList<Product> list = getPricesList(productType)

        Sorting.quickSortByPrice(list);
    }

    //sorts this product by date using quicksort
    public void sortDates(String productType) {
        ArrayList<Product> list = getDatesList(productType);

        Sorting.quickSortByDate(list);
    }

  //syncs the hashmaps to the arraylists (hashmaps are already up to date)
  public void sync()
  {
    ArrayList<Product> prices;
    ArrayList<Product> dates;

    //adding must be put first in case the user added and deleted the same item multiple times
    //putting deleting first may result in trying to delete the same item twice when it appears once
    for (Product p : toBeAdded)
      {
        prices = getPricesList(p);
        dates = getDatesList(p);
        Inserting.insertNewByPrice(p, prices);
        Inserting.insertNewByDate(p, dates);
      }
    
    for (Product p : toBeDeleted)
      {
        prices = getPricesList(p);
        dates = getDatesList(p);
        prices.remove(p);
        dates.remove(p);
      }

    //clear the lists becasue everything is up to date
    toBeAdded = new LinkedList<Product>();
    toBeDeleted = new LinkedList<Product>();
  }

  //returns the list of this product category sorted by price
  public ArrayList<Product> getPricesList(String productType)
  {        
    //Initializes as jeansPrices so java does not get mad that list may not be initialized
        ArrayList<Product> list = jeansPrices;

        switch (productType) {
            case "jeans":
                list = jeansPrices;
                break;
            case "shirt":
                list = shirtPrices;
                break;
            case "tshirt":
                list = tShirtPrices;
                break;
            case "shorts":
                list = shortsPrices;
                break;
            case "hat":
                list = hatPrices;
                break;
            case "shoes":
                list = shoesPrices;
                break;
            case "jacket":
                list = jacketPrices;
                break;
        }

      return list;
  }

  //returns the list of this product category sorted by price
    public ArrayList<Product> getPricesList(Product p)
  {        
    //Initializes as jeansPrices so java does not get mad that list may not be initialized
        ArrayList<Product> list = jeansPrices;

        switch (p.category) {
            case Jeans:
                list = jeansPrices;
                break;
            case Shirt:
                list = shirtPrices;
                break;
            case TShirt:
                list = tShirtPrices;
                break;
            case Shorts:
                list = shortsPrices;
                break;
            case Hat:
                list = hatPrices;
                break;
            case Shoes:
                list = shoesPrices;
                break;
            case Jacket:
                list = jacketPrices;
                break;
        }

      return list;
  }

  //returns the list of this product category sorted by date
      public ArrayList<Product> getDatesList(Product p)
  {        
    //Initializes as jeansPrices so java does not get mad that list may not be initialized
        ArrayList<Product> list = jeansDates;

        switch (p.category) {
            case Jeans:
                list = jeansDates;
                break;
            case Shirt:
                list = shirtDates;
                break;
            case TShirt:
                list = tShirtDates;
                break;
            case Shorts:
                list = shortsDates;
                break;
            case Hat:
                list = hatDates;
                break;
            case Shoes:
                list = shoesDates;
                break;
            case Jacket:
                list = jacketDates;
                break;
        }

      return list;
  }


  //returns the list of this product's category sorted by date
        public ArrayList<Product> getDatesList(String productType)
  {        
    //Initializes as jeansPrices so java does not get mad that list may not be initialized
        ArrayList<Product> list = jeansDates;

        switch (productType) {
            case "jeans":
                list = jeansDates;
                break;
            case "shirt":
                list = shirtDates;
                break;
            case "tshirt":
                list = tShirtDates;
                break;
            case "shorts":
                list = shortsDates;
                break;
            case "hat":
                list = hatDates;
                break;
            case "shoes":
                list = shoesDates;
                break;
            case "jacket":
                list = jacketDates;
                break;
        }

      return list;
  }

  //returns LinkedHashMap that this product's product category uses
  public LinkedHashMap<String, Product> getProductMap(Product p)
  {
    LinkedHashMap<String, Product> map;
        switch (p.category)
          {
            case p.category == Product.ProductCategory.Jeans:
              map = db.jeansMap;
              break;
            case p.category == Product.ProductCategory.Shirt:
              map = db.shirtMap;
              break;
            case p.category == Product.ProductCategory.TShirt:
              map = db.tShirtMap;
              break;
            case p.category == Product.ProductCategory.Shorts:
              map = db.shortsMap;
              break;
            case p.category == Product.ProductCategory.Hat:
              map = db.hatMap;
              break;
            case p.category == Product.ProductCategory.Shoes:
              map = db.shoesMap;
              break;
            case p.category == Product.ProductCategory.Jacket:
              map = db.shoesMap;
              break;
            default:
              throw new IllegalArgumentException("The product category was not found");
            }

    return map;
  }


    //Prints all products in this list
    public void printAll(ArrayList<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }


}