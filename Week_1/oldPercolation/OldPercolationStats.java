import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
    public PercolationStats(int n, int trials) {
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < trials; i++) {
             Percolation p = new Percolation(n);
             int count = 0;
             int uniform_n = n + 1; //since uniform's upper limit is exclusive we must increment by one 
             while ((p.percolates() == false)) {
                 int a = StdRandom.uniform(1, uniform_n);
                 int b = StdRandom.uniform(1, uniform_n);
                 System.out.println(a);
                 System.out.println(b);
                 p.open(a, b);
                 count++;
                 System.out.println(count + " sites opened");
                 System.out.println(p.percolates());
             }
             System.out.println(count);
        }
    }
    
    public double mean() {
        // sample mean of percolation threshold
        return 1.0;
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return 1.0;
    }
    public double confidenceLo()  {
        // low  endpoint of 95% confidence interval
        return 1.0;
    }
    public double confidenceHi() {
        // high endpoint of 95% confidence interval
        return 1.0;
    }
    public static void main(String[] args) {
        int gridsize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(gridsize, trials);
    }
}