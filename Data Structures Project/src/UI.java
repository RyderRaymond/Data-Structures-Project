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

  public static boolean master()
  {
    Scanner scanner = new Scanner(System.in);

    String[] options =
            {"Search", "Insert", "Delete", "Sort", "Print"};

    Product currentSelection = null;

    do {
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
    commands.put("Range", "searches the product category for a range of products");
    commands.put("Help", "prints these options again");

    System.out.println("Possible commands are: ");
  for (String command : commands.keySet())
    {
      System.out.println(command + ": " + commands.get(command));
    }

    choice = DecisionHandler.handleDecisions("", commands.keySet())

    switch(choice)
      {
        case "Exit": 
          return null;
          break;
        case "Title":
          return searchByTitle();
      }
  }

  public static Product searchByTitle()
  {
    System.out.print("Enter the category of the product you would like to search for: ");
    String category = DecisionHandler.handleDecisions("", new String[] {"Jeans", "Hat", "Jacket", "Shirt", "TShirt", "Shorts", "Shoes"});

  }

  public void printOptions()
  {
    
  }
  
}