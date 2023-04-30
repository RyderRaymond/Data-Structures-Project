/*
Word Suggester for the bonus problem.

Used in UI's method to search title with word suggestion (this class's functionality is limited to that part of UI
so if this has any bugs, it does not impact the entire rest of the code.)

The text file with the list of the 1000 most common English words is from this GitHub post: https://gist.github.com/deekayen/4148741
from the user "deekayen" (David Norman)

proper MLA citation for the page:

Norman, David. "1,000 most common US English words." GitHub, https://gist.github.com/deekayen/4148741

Everything else is our own code.

 */


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.File;
import java.util.Scanner;

public class WordSuggester {
    private static ArrayList<String> commonWords;  //list of all words
    private static HashSet<String> wordSet;       //set for quick lookups
    private static final int min_diff = 1;

    private final int max_diff; //maximum difference between words for the suggester to still recommend


    public WordSuggester(int diff)
    {
        //the minimum difference must be at least 2
        max_diff = Math.max(min_diff, diff);
        commonWords = new ArrayList<>(1000);
        wordSet = new HashSet<>(2000);

        //adding words to the list from the file. Try/catch is for if the file is not found
        try {
            File words = new File("Words.txt");
            Scanner getWords = new Scanner(words);  //Scanner to read the file

            //add each line (each word)
            while (getWords.hasNext())
            {
                commonWords.add(getWords.nextLine());
            }

            getWords.close();  //remember to close
        }
        catch (FileNotFoundException f)
        {
            System.out.println("There was a problem reading the most common words.");
            System.out.println("Please do not use search with suggestion until this is fixed.");
        }

        wordSet.addAll(commonWords);

        //add the categories in case they are not in the list already
        for (Product.ProductCategory category : Product.ProductCategory.values())
        {
            String cat = category.toString();
            if (!wordSet.contains(cat))
            {
                wordSet.add(cat);
                commonWords.add(0, cat);  //add it first so in case there is an issue the categories are recommended first
            }
        }
    }

    public String suggest(String input, Scanner scanner)
    {
        input = input.toLowerCase();

        if (wordSet.contains(input))
            return input;

        ArrayList<String> possibleWords = new ArrayList<>();
        int differences = 0;
        String choice;

        for (String word : commonWords)
        {
            differences = 0;

            if (word.length() != input.length()) continue;

            for (int i = 0; i < input.length(); i++)
            {
                char inputChar = input.charAt(i);
                char secondChar = word.charAt(i);
                if (inputChar != secondChar)
                    differences++;

                if (differences > max_diff)
                    break;
            }

            if (differences <= max_diff)
                possibleWords.add(word);

        }

        System.out.println("The input \"" + input + "\" may not be a proper English word");
        System.out.println("Possible replacements: ");
        for (String word : possibleWords)
            System.out.print(word + ", ");

        System.out.println("\nEnter the original input \"" + input + "\" or one of the suggested words to continue:");

        choice = scanner.nextLine();

        if (!choice.equals(input))
            choice = DecisionHandler.handleDecisions(choice, possibleWords.toArray(String[0]), scanner);

    }

}
