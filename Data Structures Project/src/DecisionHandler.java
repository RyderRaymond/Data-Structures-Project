import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DecisionHandler{
    //
    public static Product.ProductCategory getCategory (String task){
        Scanner scanner = new Scanner(System.in);
        categoryType();
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

        if (decision.equals("")) decision = keyboard.nextLine();

        while(!valid.contains(decision))
        {
            System.out.print("That was not a valid decision." +
                    "\nInput a valid decision: " + getArrayContents(validDecisions));
            decision = keyboard.nextLine();
        }
        return decision;
    }

    //method for handeling a question that has a decison based from an array like their backpack and ext.
    public static String handleDecisions(String decision, Set<String> validDecisions)
    {
        Scanner keyboard = new Scanner(System.in);

        if (decision.equals("")) decision = keyboard.nextLine();

        while(!validDecisions.contains(decision))
        {
            System.out.print("That was not a valid decision." +
                    "\nInput a valid decision: " + getArrayContents(validDecisions));
            decision = keyboard.nextLine();
        }
        return decision;
    }

    public static String getArrayContents(String[] valid)
    {
        String result = "";

        for (String option : valid) result += option + ", ";

        return result;
    }

    public static String getArrayContents(Set<String> valid)
    {
        String result = "";

        for (String option : valid) result += option + ", ";

        return result;
    }


}