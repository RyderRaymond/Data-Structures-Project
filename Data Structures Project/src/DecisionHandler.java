import java.util.Scanner;

public class DecisonHandler{
    //
    public static getCategory (String task){
        Scanner scanner = new Scanner(System.in);
        catigoryType();
        System.out.println("Please choose a proper Item for" + task + ":");
        String category = scanner.nextLine();
        category = category.toLowerCase();
        return category;
    }

  

  //method for handeling a question that has a decison based from an array like their backpack and ext.
  public static String handleDecisions(String decision, String[] validDecisions)
  {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<String> valid = new ArrayList<String>();
    for (String s : validDecisions)
      {
        valid.add(s);
      }

    while(!valid.contains(decision))
      {
        System.out.print("That was not a valid decision." +
                          "\nInput a valid decision: " + getArrayContents(validDecisions));
        decision = keyboard.nextLine();
      }
    return decision;
  }

}