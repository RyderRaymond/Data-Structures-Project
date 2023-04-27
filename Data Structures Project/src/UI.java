import java.util.HashMap;
import java.util.Scanner;

public class UI
{
  public static void runDatabase()
  {
    boolean running = true;

    while (running)
      {
        running = master();
      }
  }

  public static void Introduction(){
    System.out.println
            ("------------------------------------------\n" +
                    "Welcome to the Designer Clothing Shop!!\n" +
                    "-------Shop Created By-------\n" +
                    "------Jefferson Cajuste------\n" +
                    "-------Michael Doyle--------\n" +
                    "-------Ryder Raymond-------\n" +
                    "------------------------------------------\n");

    System.out.println("Within this clothing shop you will be able to complete several actions.");
  }

  public static boolean master()
  {
    Scanner scanner = new Scanner(System.in);

    String[] options =
            {"Search", "Insert", "Delete", "Sort", "Print"};

    Product currentSelection = null;

    while (true){
      System.out.print("Possible actions are: ");
      for(String option : options) System.out.print(option + ", ");
      System.out.println();
      System.out.print("Current product selected: ");

      if (currentSelection == null)
        System.out.println("[No product selected]");
      else
        System.out.println(currentSelection);

      System.out.print("What would you like to do?: ");

      String choice = scanner.nextLine();

      choice = DecisionHandler.handleDecisions(choice, options);

      switch(choice)
      {
        case "Search":
          currentSelection = search();
        case "Insert":
        case "Delete":
        case "Sort":
        case "Print":

      }
    }
  }

  public static Product search()
  {
    System.out.println("You are now searching.");
    String choice;
    Scanner scanner = new Scanner(System.in);

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
    System.out.println("Your Command: ");
    choice = scanner.nextLine();
    choice = DecisionHandler.handleDecisions(choice, commands.keySet());

    switch(choice) {
      case "Exit":
        return null;
//          break;
      case "Title":
        return searchByTitle();
      case "Range":
        return searchByRange();

    }
    return null;

  }

  public static Product searchByTitle()
  {
    System.out.print("Enter the category of the product you would like to search for: ");
    String category = DecisionHandler.handleDecisions("", new String[] {"Jeans", "Hat", "Jacket", "Shirt", "TShirt", "Shorts", "Shoes"});
    return null; //temporary
  }

  public static Product searchByRange(){
    Database db = new Database(); // Creating a new database object.
    Searching searching = new Searching(db); // Passing the database object to the constructor.
    DecisionHandler decisionHandler = new DecisionHandler();
    Scanner scanner = new Scanner(System.in);
    // System.out.print("Enter the product you would like to search for: ");
    // String catigory = scanner.nextLine();
    Product.ProductCategory catigory = decisionHandler.getCategory("searching");
    System.out.print("Enter the Max price range, EX $100");
    int maxR = scanner.nextInt();
    System.out.print("Enter the Min price range, EX $50");
    int minR = scanner.nextInt();

    searching.searchPriceRange(catigory,maxR,minR);
    return null;
  }

  public static Product insert(){
    System.out.println("You are now Inserting.");
    String choice;
    Scanner scanner = new Scanner(System.in);

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Exit", "returns to the selection screen");
    // commands.put("Title", "searches for a product with a specific title");
    // commands.put("Range", "searches the product category at a specific price range of products");
    commands.put("Help", "prints these options again");
    return null; ///just for now
  }

  public static Product Sort() {
    System.out.println("You are now Sorting.");
    String choice;
    Scanner scanner = new Scanner(System.in);

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Exit", "returns to the selection screen");
    commands.put("price", "searches product by Price");
    commands.put("Date", "searches product by Date");
    commands.put("Help", "prints these options again");
    return null;

  }

      public void printOptions()
  {

  }
}