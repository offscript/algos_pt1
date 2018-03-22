public class Percolation {
    
    public int[][] grid;
    public int[] component;
    
    public Percolation(int n) {
        grid = new int[n][n];
        //int count = 1;
        //for (int i = 1; i < (n + 1); i++) {
          //  for (int j = 1; j < (n + 1); j++) {
            //    grid[i - 1][j - 1] = count;
              //  count++;
               // System.out.print(grid[i - 1][j - 1]);
           // }
      //  }
    }
    
    public void open(int row, int col) {
        grid[row - 1][col - 1] = ((row - 1) * 20) + col;
        System.out.println(grid[row - 1][col - 1]);
    }
    
    public boolean isOpen(int row, int col) {
        return true ? grid[row][col] == 1 : grid[row][col] == 0;
    }
    
    public boolean isFull(int row, int col) {
        return false;
    }
    
    public int numberofOpenSites() {
        return 0;
    }
    
    public boolean percolates() {
        return false;
    }
    
    public static void main(String[] args) {
        Percolation test = new Percolation(20);
        test.open(1,17);
        test.open(7,13);
        test.open(9,12);
        test.open(20,19);
    }
    
}