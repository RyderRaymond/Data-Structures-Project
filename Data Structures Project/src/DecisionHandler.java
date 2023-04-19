import java.util.Scanner;

public class DecisonHandler{
    //
    public static getCategory (String task){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a Item for" + task + ":");
        String category = scanner.nextLine();
        category = category.toLowerCase();
        return category;
    }


}