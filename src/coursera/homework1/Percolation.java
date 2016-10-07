package coursera.homework1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by wolf on 03/10/16.
 */
public class Percolation {
    private WeightedQuickUnionUF quickUnion;
    private boolean[] openSites;
    private int N;

    public Percolation(int n) {
        this.N = n;
        this.openSites = new boolean[2 + n * n];
        openSites[0] = true;
        openSites[openSites.length - 1] = true;
        this.quickUnion = new WeightedQuickUnionUF(2 + n * n);
    }

    public void open(int i, int j) {
        openSites[arrayIndex(i, j)] = true;
        if (i == 1) {
            quickUnion.union(0, arrayIndex(i, j));
        }
        if (i == N) {
            quickUnion.union(1 + N * N, arrayIndex(i, j));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            quickUnion.union(arrayIndex(i - 1, j), arrayIndex(i, j));
        }
        if (i < N && isOpen(i + 1, j)) {
            quickUnion.union(arrayIndex(i + 1, j), arrayIndex(i, j));
        }
        if (j > 1 && isOpen(i, j - 1)) {
            quickUnion.union(arrayIndex(i, j - 1), arrayIndex(i, j));
        }
        if (j < N && isOpen(i, j + 1)) {
            quickUnion.union(arrayIndex(i, j + 1), arrayIndex(i, j));
        }
    }

    public boolean isOpen(int i, int j) {
        return openSites[arrayIndex(i, j)];
    }

    public boolean isFull(int i, int j) {
        return quickUnion.connected(0, arrayIndex(i, j));
    }

    public boolean percolates() {
        return quickUnion.connected(0, N * N + 1);
    }

    private int arrayIndex(int i, int j) {
        return (i - 1) * N + j;
    }
}
