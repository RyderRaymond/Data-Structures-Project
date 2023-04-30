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


import java.util.ArrayList;
import java.util.HashSet;


public class WordSuggester {
    ArrayList<String> commonWords;
    HashSet<String> wordsSet;

    public WordSuggester()
    {
        commonWords = new ArrayList<>(1000);
        wordsSet = new HashSet<>(2000);

        
    }




}
