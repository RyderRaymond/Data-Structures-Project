
public class Main {
    public static void main(String[] args) {
        double s = System.nanoTime();
        Database products = new Database();
        System.out.println("Initializing the Database: " + (System.nanoTime() - s));

        //Testing using both a hashmap and a linked list-------------------------------------------

        //For some reason, the first search of Jeans takes longer
        /*
        double startTime = System.nanoTime();
        System.out.println("Search by name: " + products.searchJeans("Jeans500"));
        System.out.println(System.nanoTime() - startTime);
        */

        double startTime = System.nanoTime();
        System.out.println("Search by name: " + products.searchJeansHashMap("Jeans500"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println("Search by index: " + products.getJeansLL(500));
        System.out.println(System.nanoTime() - startTime);


        startTime = System.nanoTime();
        System.out.println("Search by name: " + products.searchJeansHashMap("Jeans5000"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println("Search by index: " + products.getJeansLL(5000));
        System.out.println(System.nanoTime() - startTime);


        startTime = System.nanoTime();
        System.out.println("Search by name: " + products.searchJeansHashMap("Jeans9999"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println("Search by index: " + products.getJeansLL(9999));
        System.out.println(System.nanoTime() - startTime);

        //Testing using the Linked HashMap-------------------------------------------
        System.out.println("USING LINKED HASHMAP");

        startTime = System.nanoTime();
        System.out.println("Search by name: " + products.searchJeans("Jeans9999"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println("Search by index: " + products.getJeans(9999));
        System.out.println(System.nanoTime() - startTime);

    }

}
