import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int gridSize;
    private boolean[] openSites;
    private WeightedQuickUnionUF UF;
    private int number_of_open_sites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        number_of_open_sites = 0;
        gridSize = n;
        int square = n * n;
        openSites = new boolean[square];
        System.out.println(openSites.length);
        for (int i = 0; i < square; i++) openSites[i] = false;
        UF = new WeightedQuickUnionUF(square);
    }


    public boolean[] showSites() {
        return openSites;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        System.out.println("This is the row " + row + "This is the column " + col);
        int site_to_open = gridToInt(row, col);
        System.out.println("Site to open " + site_to_open);
        if (site_to_open < 0 || site_to_open > gridSize * gridSize)
            throw new IllegalArgumentException("row index i out of bounds");
        openSites[site_to_open] = true;
        adjacent(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int site = gridToInt(row, col);
        if (site < 0 || site > gridSize * gridSize)
            throw new IllegalArgumentException("row index i out of bounds");
        return openSites[site];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        //are any of the open top sites connected to this site?

        int q = gridToInt(row, col);
        if (q < 0 || q > gridSize * gridSize) throw new IllegalArgumentException("row index i out of bounds");
        for (int i = 0; i < gridSize; i++)
            if (isOpen(1, i + 1) && UF.connected(i, q)) { //site in top layer is open and connected to q
                System.out.println("i: " + i + "q: " + q);
                return true;
            }
        return false;
    }


    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        int square = gridSize * gridSize;
        for (int i = 0; i < square; i++) {
            if (openSites[i] == true) {
                count++;
            }
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        //System.out.println("This is the number of open sites " + number_of_open_sites);
        for (int i = 1; i < gridSize + 1; i++) {
            System.out.println("isFull row: " + gridSize + " column: " + i);
            if (isFull(gridSize, i)) {
                System.out.println("percolates");
                return true;
            }
        }
        return false;
    }

    public int gridToInt(int row, int col) {
        return ((row * gridSize) + col) - gridSize - 1;
    }

    public int[] intToGrid(int index) {
        int[] returned_tuple = new int[2];
        int row = index / gridSize;
        int column = index % gridSize;
        row--; //this is for array addressing, so we decrement
        column--; //this is for array addressing, so we decrement
        returned_tuple[0] = row;
        returned_tuple[1] = column;
        return returned_tuple;
    }

    //checks to see if there are any open sites adjacent to the site being opened, if so performs
    private void adjacent(int row, int col) {
        above(row, col);
        below(row, col);
        left(row, col);
        right(row, col);
    }

    private void above(int row, int col) {
        int one_dimensional_location = gridToInt(row, col);
        int above_one_dimensional_location = one_dimensional_location - gridSize;
        //row, col location
        int row_above = row - 1;
        //System.out.println("This is the above..." + above_one_dimensional_location + " this is the gridSize " + gridSize);
        if (above_one_dimensional_location < 0) return;
        if (isOpen(row_above, col)) {
            System.out.println("union");
            UF.union(one_dimensional_location, above_one_dimensional_location);
        }
    }

    private void below(int row, int col) {
        int one_dimensional_location = gridToInt(row, col);
        int below_one_dimensional_location = one_dimensional_location + gridSize;
        //row, col location
        int row_below = row + 1;
        if (below_one_dimensional_location >= gridSize * gridSize) return;
        if (isOpen(row_below, col)) {
            System.out.println("union");
            UF.union(one_dimensional_location, below_one_dimensional_location);
        }
    }

    private void left(int row, int col) {
        int one_dimensional_location = gridToInt(row, col);
        int left_one_dimensional_location = one_dimensional_location - 1;
        //row, col location
        int column_left = col - 1;
        if (column_left < 0) return;
        if (one_dimensional_location % gridSize == 0) return;
        if (isOpen(row, column_left)) {
            System.out.println("union");
            UF.union(one_dimensional_location, left_one_dimensional_location);
        }
    }

    private void right(int row, int col) {
        int one_dimensional_location = gridToInt(row, col);
        int right_one_dimensional_location = one_dimensional_location + 1;
        //row, col location
        int column_right = col + 1;
        //checks if there is a site to the right within the grid
        if (column_right > gridSize * gridSize) return;
        //checks if there is a site to the right on the same row
        if (one_dimensional_location % gridSize == gridSize - 1) return;
        if (isOpen(row, column_right)) {
            System.out.println("union");
            UF.union(one_dimensional_location, right_one_dimensional_location);
        }
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}
