import java.util.Scanner;

public class UI
{
  public static void runDatabase()
  {
    boolean running = true;

    while (running)
      {
        running = getInput;
      }
  }

  public static boolean getInput()
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
    
  }

  public void printOptions()
  {
    
  }
  
}