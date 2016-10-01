/**
 * Created by wolf on 01/10/16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Insertion sort. Result :" + "AEEEEGLMMOPRRSTX");
        Comparable[] strings = new Comparable[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(strings);
        for (Comparable c : strings) {
            System.out.print(c);
        }
        //todo implement convex hull
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = i;
            while (j != 0 && less(a[j], a[j - 1])) {
                swap(a, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
