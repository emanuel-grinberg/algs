package coursera;

/**
 * Created by wolf on 01/10/16.
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Selection sort. Result :" + "AEEEEGLMMOPRRSTX");
        Comparable[] strings = new Comparable[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(strings);
        for (Comparable c : strings) {
            System.out.print(c);
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
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
