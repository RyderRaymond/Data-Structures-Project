import java.util.ArrayList;
import java.util.Comparator;

/*
Class that handles all sorting
 */
public class Sorting {
    public static void quickSortByPrice(ArrayList<Product> list)
    {
        quickSort(list, 0, list.size(), new ProductComparator("price"));
    }

    //quickSort to sort all of this list of items
    //Basically generic: comparator determines if we are sorting by price or date
    private static void quickSort(ArrayList<Product> list, int start, int end, ProductComparator comparator){
        if (start >= end) return;

        int left = start;
        int right = end - 1;
        Product pivot = list.get(right);

        while (left <= right)
        {
            while (left <= right && comparator.compare(list.get(left), pivot) <= 0) left++;

            while (left <= right && comparator.compare(list.get(right), pivot) >= 0) right++;

            if (left <= right){
                Product temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
        }

        Product temp = list.get(left);
        list.set(left, pivot);
        list.set(end, temp);  //sets the pivot to the left product

        quickSort(list, start, left - 1, comparator);
        quickSort(list, left + 1, end, comparator);
    }

    public static class ProductComparator implements Comparator<Product>
    {
        private String type;
        public ProductComparator(String type)
        {
            //either date or price
            this.type = type;
        }
        @Override
        public int compare(Product o1, Product o2) {
            if (type.equals("price"))
            {
                double difference = o1.getPrice() - o2.getPrice();
                if (difference > 0) return 1;
                else if (difference < 0) return -1;
                else return 0;
            }
            else{
                return o1.getListingDate().compareTo(o2.getListingDate());
            }
        }
    }
}
