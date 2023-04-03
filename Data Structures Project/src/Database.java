import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Date;

public class Database {
    LinkedList<ProductJeans> jeans;
//    LinkedList<ProductTShirt> shirts;

    HashMap<String, ProductJeans> jeansMap;
//    HashMap<String, ProductTShirt> shirtMap;

    //Constructor. Can implement either using internal methods to instantiate lists and maps or take in arrays
    public Database()
    {
        initializeJeans(10000);
    }

    public void initializeJeans(int numJeans)
    {
        Random random = new Random();

        jeans = new LinkedList<>();
        for (int i = 0; i < numJeans; i++)
        {
            jeans.add(new ProductJeans("Jeans" + i, random.nextDouble(), new Date()));
        }

        //Initial capacity is set to jeans * 2 to avoid collisions. Uses extra space but will be faster
        jeansMap = new HashMap<>(jeans.size());

        for (ProductJeans j : jeans)
        {
            jeansMap.put(j.getTitle(), j);
        }
    }

//    public void initializeShirts()


    public ProductJeans searchJeans(String name)
    {
        ProductJeans temp = jeansMap.getOrDefault(name, null);
        if (temp != null)
            return temp;
        System.out.println("This item does not exist");
        return null;
    }

    public ProductJeans getJeans(int position)
    {
        return jeans.get(position);
    }
}
