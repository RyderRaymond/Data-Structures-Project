import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Date;

public class Database {
    LinkedList<ProductJeans> jeans;
//    LinkedList<ProductTShirt> shirts;

    HashMap<String, ProductJeans> jeansMap;
//    HashMap<String, ProductTShirt> shirtMap;

    //No-args constructor. Initializes the database with 10000 items each
    public Database()
    {
        initializeJeans(10000);
    }

    public Database(int jeansNum, int shirtNum)
    {
        initializeJeans(jeansNum);
        //initializeShirts(shirtNum)
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
        jeansMap = new HashMap<>(jeans.size() * 2);

        for (ProductJeans j : jeans)
        {
            jeansMap.put(j.getTitle(), j);
        }
    }

//    public void initializeShirts()


    public ProductJeans searchJeans(String name)
    {
        if (jeansMap.containsKey(name))
        {
            return jeansMap.get(name);
        }

        System.out.println("This item does not exist");
        return null;
    }

    public ProductJeans getJeans(int position)
    {
        return jeans.get(position);
    }
}
