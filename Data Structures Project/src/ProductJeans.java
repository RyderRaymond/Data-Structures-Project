// Represents a single Jeans. This class use the existing Product class as base class
import java.util.Date;
import java.util.Random;

public class ProductJeans extends Product {
    ProductCategory category = ProductCategory.Jeans;


    public ProductJeans(String title, double price, Date date)
    {
      //  int selectprice = 0;
      //       Random rand = new Random();
      //       selectprice=rand.nextInt(5);
      //       switch(selectprice)   {
      //       case 0:
      //           price = 31.99;
      //           break;
      //       case 1:
      //           price = 29.99;
      //           break;
      //       case 2:
      //           price = 32.50;
      //           break;
      //       case 3:
      //           price = 30;
      //           break;
      //       case 4:
      //           price = 35.99;
      //           break;
      //       case 5:
      //           price = 28.50;
      //           break;
      //   }
        
        super(title, price, date);
    }

    public static void main(String[] args) {
      jeansLL = new LinkedList<>();
        for (int i = 0; i < numJeans; i++) {
            jeansLL.add(new ProductJeans("Jeans" + i, random.nextDouble(15, 50), new Date()));
        }
        System.out.print(jeansLL);

    }
  

}