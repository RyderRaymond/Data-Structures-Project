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
    String[] options = 
    {"Search", "Insert", "Delete", "Sort", "Print"};

    System.out.print("Possible actions are: ");
    for(String option : options) System.out.print(option + ", ");
    System.out.println();
    System.out.print("What would you like to do?: ");

    String choice = Scanner.nextLine();

    choice = DecisionHandler.handleDecisions(choice, options);

    switch(choice)
    {
      case "Search":
          
    }

  }

  public void search()
  {
    
  }

  public void printOptions()
  {
    
  }
  
}