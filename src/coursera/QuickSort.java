package coursera;

import java.util.Arrays;

/**
 * Created by wolf on 01/10/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Quick sort. Result :" + "AEEEEGLMMOPRRSTX");
        Comparable[] strings = new Comparable[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(strings);
        for (Comparable c : strings) {
            System.out.print(c);
        }
    }

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int i = lo + 1, j = hi;
        while (i < j) {
            while (less(a[i], a[lo])) i++;
            while (less(a[lo], a[j])) j--;
            swap(a, i, j);
        }
        swap(a, lo, j);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        //todo implement 3 way partitioning (equal keys)
    }

    private static void shuffle(Comparable[] a) {

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
