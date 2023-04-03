
public class Main {
    public static void main(String[] args) {
        Database products = new Database();

        double startTime = System.nanoTime();
        System.out.println(products.searchJeans("Jeans500"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println(products.searchJeans("Jeans900"));
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.println(products.getJeans(500));
        System.out.println(System.nanoTime() - startTime);
    }

}
