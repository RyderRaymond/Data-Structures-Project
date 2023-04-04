import java.util.*;

public class Database {
    LinkedList<ProductJeans> jeans;
//    LinkedList<ProductTShirt> shirts;

    HashMap<String, ProductJeans> jeansMap;
//    HashMap<String, ProductTShirt> shirtMap;

    LinkedHashMap<String, ProductJeans> jeansLM;

    //No-argument constructor. Initializes the database with 10000 items each
    public Database()
    {
        initializeJeans(10000);
    }

    public Database(int jeansNum)
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

        jeansLM = new LinkedHashMap<>(numJeans);

        for (ProductJeans j : jeans)
        {
            jeansMap.put(j.getTitle(), j);
            jeansLM.put(j.getTitle(), j);
        }

    }

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

    public ProductJeans searchJeansLM(String name)
    {
        if (jeansLM.containsKey(name))
        {
            return jeansLM.get(name);
        }

        System.out.println("This item does not exist");
        return null;
    }

    //Linked Map does not have a method for
    public ProductJeans getJeansLM(int position)
    {
        ProductJeans[] j = jeansLM.values().toArray(new ProductJeans[0]);

        if (position < j.length)
            return j[position];
        System.out.println("The index is out of bounds");
        return null;
    }
}
