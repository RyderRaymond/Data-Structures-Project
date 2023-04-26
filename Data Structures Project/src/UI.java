import java.util.Scanner;

public class UI
{
  public static void runDatabase()
  {
    boolean running = true;

    while (running)
      {
        running = getInput();
      }
  }

  public static boolean master()
  {
    Scanner scanner = new Scanner(System.in);
    String[] options = 
    {"Search", "Insert", "Delete", "Sort", "Print"};

    System.out.print("Possible actions are: ");
    for(String option : options) System.out.print(option + ", ");
    System.out.println();
    System.out.print("What would you like to do?: ");

    String choice = scanner.nextLine();

    choice = DecisionHandler.handleDecisions(choice, options);

    switch(choice)
    {
      case "Search":
      case "Insert":
      case "Delete":
      case "Sort":
      case "Print":
          
    }

  }

  public void search()
  {
    System.out.println("You are now searching.");
    String choice;
    Scanner scanner = new Scanner();

    HashMap<String, String> commands = new HashMap<String, String>();
    commands.put("Exit", "returns to the selection screen");
    commands.put("Title", "searches for a product with a specific title");
    commands.put("Range", "searches the product category for a range of products");
    commands.put("Help", "prints these options again");

    System.out.println("Possible commands are: ")
  for (String command : commands.keySet())
    {
      System.out.println(command + ": " + commands.get(command));
    }

    choice = DecisionHandler.handleDecisions("", commands.keySet())

    switch(choice)
      {
        case "Exit": 
          return;
          break;
        case "Title":
          
      }
  }

  public void printOptions()
  {
    
  }
  
}