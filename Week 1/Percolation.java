import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    public int[][] grid;
    public int numberOfOpenSites;
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(400);
    
    public Percolation(int n) {
        grid = new int[n][n]; 
        //int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
                //grid[i - 1][j - 1] = count;
                //count++;
                //System.out.print(grid[i - 1][j - 1]);
            }
        }
    }
    
    public void open(int row, int col) {
        //the array position of the requested point is set to numerical value of
        //its position in the array. So a point at row 9 column 13, position 
        //grid[8][12], is set to 173.
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = addressToNumber(row,col);
            open_helper(row, col);
            numberOfOpenSites++;
        }
    }
    
    public void open_helper(int row, int col) {
        if ((row + 1 < 20) && isOpen(row + 1, col)) { //union with space above
           int number_above = addressToNumber(row + 1,col);
           uf.union(addressToNumber(row,col), number_above); 
        }
        if ((row - 1 > 1) && isOpen(row - 1, col)) { //union with space below
           int number_below = addressToNumber(row - 1,col);
           uf.union(addressToNumber(row,col), number_below); 
        }
        if ((col - 1 > 1) && isOpen(row, col - 1)) { //union with space to theleft
           int number_left = addressToNumber(row,col - 1);
           uf.union(addressToNumber(row,col), number_left); 
        }
        if ((col + 1 < 20) && isOpen(row, col + 1)) { //union with space to right
           int number_right = addressToNumber(row,col + 1);
           uf.union(addressToNumber(row,col), number_right); 
        } 
    }
    
    public boolean isOpen(int row, int col) {
       return (grid[row - 1][col - 1] < 0) ? false : true;
    }
    
    public boolean isFull(int row, int col) {
        return false;
        //return root(row, col) == //is this point's root in the bottom (20th) row?;
    }
    
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }
    
    public boolean percolates() {
        return false;
    }
    
    public static int addressToNumber(int row, int col) {
        //System.out.println(((row - 1) * 20) + col);
        return ((row - 1) * 20) + col;
    }
    
    public static int numberToAddress(int i) {
        return 0;
    }
    
    public static void main(String[] args) {
        Percolation test = new Percolation(20);
        test.open(2,15);
        test.open(2,16);
        System.out.println(test.uf.connected(addressToNumber(2,15),addressToNumber(2,16)));
        System.out.println(test.numberOfOpenSites());
    }
    
}