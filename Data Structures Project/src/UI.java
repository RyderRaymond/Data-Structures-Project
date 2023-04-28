import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class UI
{
  private Database db;
  private Scanner scanner;

  public UI(Database database)
  {
    db = database;
    scanner = new Scanner(System.in);
  }

  public void runDatabase()
  {
    boolean running = true;

    while (running)
      {
        running = master();
      }
  }

  public void Introduction(){
    System.out.println
            ("""
                    ------------------------------------------
                    Welcome to the Designer Clothing Shop!!
                    -------Shop Created By-------
                    ------Jefferson Cajuste------
                    -------Michael Doyle--------
                    -------Ryder Raymond-------
                    ------------------------------------------
                    """);

    System.out.println("Within this clothing shop you will be able to complete several actions.");
  }

  public boolean master()
  {
    Introduction();
//    Scanner scanner = new Scanner(System.in);

    String[] options =
            {"Search", "Insert", "Delete", "Sort", "Print", "Exit"};

    Product currentSelection = null;
    String choice;

    while (true){
      System.out.print("Possible actions are: ");
      for(String option : options) System.out.print(option + ", ");
      System.out.println();
      System.out.print("Current product selected: ");

      if (currentSelection == null)
        System.out.println("[No product selected]");
      else
        System.out.println(currentSelection);

      System.out.println("What would you like to do?: ");

      choice = scanner.nextLine();

      choice = DecisionHandler.handleDecisions(choice, options, scanner);

      switch(choice)
      {
        case "Search":
          currentSelection = search();
          break;
        case "Insert":
          currentSelection = insert();
          break;
        case "Delete":
          currentSelection = delete(currentSelection);
          break;
        case "Sort":
          sort();
          break;
        case "Print":
          break;
        case "Exit":
          return false;
      }
    }
  }

  public Product search()
  {
    System.out.println("You are now searching.");
    String choice = "";

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Exit", "returns to the selection screen");
    commands.put("Title", "searches for a product with a specific title");
    commands.put("Range", "searches the product category at a specific price range of products");
    commands.put("Help", "prints these options again");

    System.out.println("----------------------------------------------------------");
    System.out.println("Possible commands are: ");
    for (String command : commands.keySet())
      {
        System.out.println(command + ": " + commands.get(command));
      }

      System.out.println("----------------------------------------------------------");
    //    Scanner keyboard = new Scanner(System.in);
      System.out.print("Your Command: ");

      choice = scanner.nextLine();

//      choice = keyboard.nextLine();
      choice = DecisionHandler.handleDecisions(choice, commands.keySet(), scanner);

      switch(choice) {
        case "Exit":
          return null;
        case "Title":
          return searchByTitle();
        case "Range":
          return searchByRange();
        case "Help":
          return search();
      }

    return null;  //choice somehow was not an option
  }

  public Product searchByTitle()
  {
    Searching searching = new Searching(db); // Passing the database object to the constructor.
    Product.ProductCategory catigory = DecisionHandler.getCategory("searching", scanner);
//    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the title of the product from the category you wish to search for: ");
    String title = scanner.nextLine();
    Product result = searching.searchByTitle(catigory,title);

    if (result != null)
      System.out.println("Product " + result.getTitle() + " was found");
    else
      System.out.println("No product with title " + title + " was found");

    return result;
  }

  public Product searchByRange(){
    Database db = new Database(); // Creating a new database object.
    Searching searching = new Searching(db); // Passing the database object to the constructor.
//    DecisionHandler decisionHandler = new DecisionHandler();
//    Scanner scanner = new Scanner(System.in);
    Product.ProductCategory catigory = DecisionHandler.getCategory("searching", scanner);
    System.out.print("Enter the Max price range, EX $100");
    int maxR = scanner.nextInt();
    System.out.print("Enter the Min price range, EX $50");
    int minR = scanner.nextInt();

    searching.searchPriceRange(catigory,maxR,minR);
    return null;
  }

  public Product insert(){
    System.out.println("You are now Inserting.");
    String choice;

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Enter", "enters a new product into the database");
    commands.put("Exit", "returns to the selection screen");
    commands.put("Help", "prints these options again");

    System.out.println("Possible commands:");
    for (String command : commands.keySet())
    {
      System.out.println(command + ": " + commands.get(command));
    }

    System.out.print("\nYour command: ");
    choice = scanner.nextLine();

    choice = DecisionHandler.handleDecisions(choice, commands.keySet(), scanner);

    switch(choice)
    {
      case ("Enter"):
        return createNewProduct();
      case ("Exit"):
        return null;
      case ("Help"):
        return insert();

    }
    return null; ///just for now
  }

  private Product createNewProduct()
  {
    Product.ProductCategory category;
    String title;
    double price;

    System.out.print("Enter the category of the new product: ");
    category = DecisionHandler.getCategory("Inserting", scanner);

    System.out.print("Enter the tile of the new product: " );
    title = scanner.nextLine();

    //they need to enter a product with a title at least 1 character long
    while (title.length() < 1)
    {
      System.out.println("The title must have a length greater than 0");
      System.out.print("New title: " );
      title = scanner.nextLine();
    }

    System.out.println("\nEnter the price of the new product: " );

    price = scanner.nextDouble();
    scanner.next();

    Product p;

    switch(category)
    {
      case Jeans:
         p = new ProductJeans(title, price, new Date());
         break;
      case Shirt:
        p = new ProductShirt(title, price, new Date());
        break;
      case TShirt:
        p = new ProductTShirt(title, price, new Date());
        break;
      case Hat:
        p = new ProductHat(title, price, new Date());
        break;
      case Jacket:
        p = new ProductJacket(title, price, new Date());
        break;
      case Shoes:
        p = new ProductShoes(title, price, new Date());
        break;
      case Shorts:
        p = new ProductShorts(title, price, new Date());
        break;
      default:
        System.out.println("Incorrect category selection");
        return null;
    }

    //return the product if insertion was successful, null otherwise
    return Inserting.insert(p, db) ? p : null;

  }

  public Product sort() {
    System.out.println("You are now Sorting.");
    String choice;
//    Scanner scanner = new Scanner(System.in);

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Exit", "returns to the selection screen");
    commands.put("price", "searches product by Price");
    commands.put("Date", "searches product by Date");
    commands.put("Help", "prints these options again");
    return null;

  }

  //not done need to take product catigory and convert it to "ArrayList<Product>" to properly call onto the method in sorting
  public Product PriceSort(){
    System.out.println("You are now Sorting by Price.");
//    Database db = new Database(); // Creating a new database object.
//    Sorting sort = new Sorting();
    DecisionHandler decisionHandler = new DecisionHandler();
    //Scanner scanner = new Scanner(System.in);
    System.out.println("What is the product you would like to sort: ");
    Product.ProductCategory catigory = decisionHandler.getCategory("Sorting", scanner);
    //String choice = scanner.next();
    return null;

  }

  public Product delete(Product selected)
  {
    System.out.println("You are now deleting");

    String choice;

    HashMap<String, String> commands = new HashMap<>();
    commands.put("Title", "deletes the product with the matching title");
    commands.put("Selected", "deletes the currently selected product, if one is selected");
    commands.put("Help", "prints the options again");
    commands.put("Exit", "returns to the selection menu");

    System.out.println("Possible commands:");

    for (String command : commands.keySet()){
      System.out.println(command + ": " + commands.get(command));
    }

    System.out.print("Your command: ");
    choice = scanner.nextLine();
    choice = DecisionHandler.handleDecisions(choice, commands.keySet(), scanner);

    switch (choice)
    {
      case "Title":
        return deleteByTitle();
      case "Selected":
        return deleteBySelected(selected);
      case "Help":
        return delete(selected);
      case "Exit":
        return null;
      default:
        System.out.println("That was not an option");
        return null;
    }
  }

  public Product deleteByTitle()
  {
    Product.ProductCategory category;
    String title;

    category = DecisionHandler.getCategory("deleting", scanner);

    System.out.print("Enter the tile of the product you want to delete:");
    title = scanner.nextLine();

    Searching searching = new Searching(db);
    Deleting deleting = new Deleting(db);
    Product p = searching.searchByTitle(category, title);

    if (p == null)
    {
      System.out.println("Cannot delete nonexistent product");
      return null;
    }

    deleting.delete(p);
    return null;
  }

  public Product deleteBySelected(Product selected)
  {
    if (selected == null)
    {
      System.out.println("You have no product selected");
      return null;
    }

    Deleting deleting = new Deleting(db);
    deleting.delete(selected);

    return null;
  }

}