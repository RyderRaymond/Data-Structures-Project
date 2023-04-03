
public class Main {
    public static void main(String[] args) {
        Database products = new Database();

        //For some reason, the first search of Jeans takes longer
        double startTime = System.currentTimeMillis();
        System.out.println(products.searchJeans("Jeans500"));
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(products.searchJeans("Jeans900"));
        System.out.println(System.currentTimeMillis() - startTime);

         startTime = System.currentTimeMillis();
        System.out.println(products.searchJeans("Jeans500"));
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(products.getJeans(500));
        System.out.println(System.currentTimeMillis() - startTime);


        startTime = System.currentTimeMillis();
        System.out.println(products.searchJeans("Jeans5000"));
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(products.getJeans(5000));
        System.out.println(System.currentTimeMillis() - startTime);


        startTime = System.currentTimeMillis();
        System.out.println(products.searchJeans("Jeans9999"));
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(products.getJeans(9999));
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
