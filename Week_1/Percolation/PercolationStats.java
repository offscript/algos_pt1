public class PercolationStats {
    int[] mean;

    //perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        for (int i = 0; i < trials; i++) {
            simulate(n);
        }

    }


    // sample mean of percolation threshold
    public double mean() {
        return 0.0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0.0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0.0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0.0;
    }

    public int simulate(int n) {
        Percolation test = new Percolation(n);
        int count = 0;
        int openings = 0;
        int row;
        int column;
        while (test.percolates() != true && openings < n * n) {
            row = StdRandom.uniform(1, n + 1);
            column = StdRandom.uniform(1, n + 1);
            test.open(row, column);
            openings++;
        }
        System.out.println(openings);
        /*boolean[] sites = test.showSites();
        for (int i = 0; i < sites.length; i++) {
            System.out.println(sites[i]);
        }*/
        return count;
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats p = new PercolationStats(20, 1);
    }
}
