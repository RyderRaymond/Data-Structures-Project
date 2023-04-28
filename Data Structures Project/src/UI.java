import java.util.HashMap;
import java.util.NoSuchElementException;
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
    Introduction();
    Scanner scanner = new Scanner(System.in);

    String[] options =
            {"Search", "Insert", "Delete", "Sort", "Print"};

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

      choice = DecisionHandler.handleDecisions(choice, options);

      switch(choice)
      {
        case "Search":
          currentSelection = search(scanner);
          break;
        case "Insert":
          currentSelection = insert();
          break;
        case "Delete":
          break;
        case "Sort":
          currentSelection = Sort();
          break;

        case "Print":
          break;
      }
    }
  }

  public static Product search(Scanner scanner)
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
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Your Command: ");

    choice = keyboard.nextLine();

    try{
//      choice = keyboard.nextLine();
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
    }catch (NoSuchElementException e){
      System.out.println("You have entered an invalid command(SOMETHIG WENT WRONG).");
    }

    
    return null;

  }

  public static Product searchByTitle()
  {
    Database db = new Database(); // Creating a new database object.
    Searching searching = new Searching(db); // Passing the database object to the constructor.
    DecisionHandler decisionHandler = new DecisionHandler();
    Product.ProductCategory catigory = decisionHandler.getCategory("searching");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the title of the product from the category you wish to search for: ");
    String title = scanner.nextLine();
    searching.searchByTitle(catigory,title);

    return null; //temporary
  }

  public static Product searchByRange(){
    Database db = new Database(); // Creating a new database object.
    Searching searching = new Searching(db); // Passing the database object to the constructor.
    DecisionHandler decisionHandler = new DecisionHandler();
    Scanner scanner = new Scanner(System.in);
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

  //not done need to take product catigory and convert it to "ArrayList<Product>" to properly call onto the method in sorting
  public static Product PriceSort(){
    System.out.println("You are now Sorting by Price.");
    Database db = new Database(); // Creating a new database object.
    Sorting sort = new Sorting();
    DecisionHandler decisionHandler = new DecisionHandler();
    //Scanner scanner = new Scanner(System.in);
    System.out.println("What is the product you would like to sort: ");
    Product.ProductCategory catigory = decisionHandler.getCategory("Sorting");
    //String choice = scanner.next();
    return null;

  }

      public void printOptions()
  {

  }
}