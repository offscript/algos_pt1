public class Percolation {
    
    public int[][] grid;
    public int[] component;
    
    public Percolation(int n) {
        grid = new int[n][n];
        size = new 
        //int count = 1;
        //for (int i = 1; i < (n + 1); i++) {
          //  for (int j = 1; j < (n + 1); j++) {
            //    grid[i - 1][j - 1] = count;
              //  count++;
               // System.out.print(grid[i - 1][j - 1]);
           // }
      //  }
    }
    
    public int root(int row, int col) {
        //while (grid[row -1][col -1] != ((row - 1) * 20) + col;
    }
    
    public void open(int row, int col) {
        //the array position of the requested point is set to numerical value of
        //its position in the array. So a point at row 9 column 13, position 
        //grid[8][12], is set to 173.
        grid[row - 1][col - 1] = ((row - 1) * 20) + col;
        System.out.println(grid[row - 1][col - 1]);
    }
    
    public boolean isOpen(int row, int col) {
       return (grid[row - 1][col - 1] == 0) ? false : true;
    }
    
    public boolean isFull(int row, int col) {
        return root(row, col) == //is this point's root in the bottom (20th) row?;
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
        System.out.println(test.isOpen(1,17));
        test.open(7,13);
        test.open(9,12);
        test.open(20,19);
    }
    
}