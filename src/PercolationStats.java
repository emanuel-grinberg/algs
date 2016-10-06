import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation percolation;
    double[] thresholds;
    int n;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.n = n;
        thresholds = new double[trials];
        for (int k = 0; k < trials; k++) {
            percolation = new Percolation(n);
            int count = 0;
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    count++;
                }
            }
            thresholds[k] = ((double) count) / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }                      // sample mean of percolation threshold

    public double stddev() {
        return StdStats.stddev(thresholds);
    }                        // sample standard deviation of percolation threshold

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(n);
    }             // low  endpoint of 95% confidence interval

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(n);
    }           // high endpoint of 95% confidence interval

    public static void main(String[] args) {
        int n = 200;/*Integer.valueOf(args[0]);*/
        int trials = 100;/*Integer.valueOf(args[1]);*/
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println(String.format("mean                    = %f", percolationStats.mean()));
        System.out.println(String.format("stddev                  = %f", percolationStats.stddev()));
        System.out.println(String.format("95%% confidence interval = %f, %f", percolationStats.confidenceLo(), percolationStats.confidenceHi()));
    }
}
