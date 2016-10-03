package coursera;

/**
 * Created by wolf on 30/09/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Hello, pidr");
        Comparable[] strings = new Comparable[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(strings);
        for (Comparable c : strings) {
            System.out.print(c);
        }
    }

    private static void merge(Comparable[] items, Comparable[] aux, int lo, int mid, int hi) {
        //precondition a[lo..mid] sorted
        //precondition a[mid+1..hi] sorted
        for (int k = lo; k <= hi; k++) {
            aux[k] = items[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) items[k] = aux[j++];
            else if (j > hi) items[k] = aux[i++];
            else if (less(aux[j], aux[i])) items[k] = aux[j++];
            else items[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        sort(a, new Comparable[a.length], 0, a.length - 1);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        //improvement: use insertion sort for tiny arrays instead of mergesort (1,2,3 items etc.)
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) return; //improvement
        merge(a, aux, lo, mid, hi);
    }
    //todo implement bottom-line mergesort without recursion
    //todo implement insertion and selection sort
    //insertion sort and mergesort are stable
    //selection sort and shell sort are not stable
}
