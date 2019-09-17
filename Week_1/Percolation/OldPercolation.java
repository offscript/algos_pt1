import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class OldPercolation {

    private int[][] grid;
    private int numberOfOpenSites;
    WeightedQuickUnionUF uf;
    private int virtual_top = -1;
    private int virtual_bottom = -1;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new int[n][n];
        //int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
                //grid[i][j] = count;
                //count++;
                //System.out.println(grid[i][j]);
                //grid[i - 1][j - 1] = count;
                //count++;
                //System.out.print(grid[i - 1][j - 1]);
            }
        }
        uf = new WeightedQuickUnionUF(n * n);
    }

    public void open(int row, int col) {
        //the array position of the requested point is set to numerical value of
        //its position in the array. So a point at row 9 column 13, position
        //grid[8][12], is set to 173.
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = addressToNumber(row, col);
            System.out.println(grid[row - 1][col - 1]);
            setVirtualSite(row, col);
            openUnion(row, col);
            numberOfOpenSites++;
        }
    }

    //helps assign number of point if row == 1 or row == 20.
    public void setVirtualSite(int row, int col) {
        //if virtual bottom set, link item in bottom row to virtual bottom
        //otherwise, set virtual bottom to that number
        //System.out.println("Came here");
        if (row == 20 && virtual_bottom > -1) {
            //System.out.println("Came here");
            uf.union(addressToNumber(row, col), virtual_bottom);
        } else if (row == 20 && virtual_bottom == -1) {
            virtual_bottom = addressToNumber(row, col);
            //System.out.println("Came here");
        } else if (row == 1 && virtual_top > -1) {
            uf.union(addressToNumber(row, col), virtual_top);
            //System.out.println("Came here");
        } else if (row == 1 && virtual_top == -1) {
            virtual_top = addressToNumber(row, col);
            //System.out.println("Came here");
        }
    }

    public void openUnion(int row, int col) {
        //normal union commands
        if ((row + 1 < 21) && isOpen(row + 1, col)) { //union with space below
            int number_below = addressToNumber(row + 1, col);
            uf.union(addressToNumber(row, col), number_below);
            System.out.println("Union Below");
        } else if ((row - 1 > 0) && isOpen(row - 1, col)) { //union with space above
            int number_above = addressToNumber(row - 1, col);
            uf.union(addressToNumber(row, col), number_above);
            System.out.println("Union Above");
        } else if ((col - 1 > 0) && isOpen(row, col - 1)) { //union with space to the left
            int number_left = addressToNumber(row, col - 1);
            uf.union(addressToNumber(row, col), number_left);
            System.out.println("Union Left");
        } else if ((col + 1 < 21) && isOpen(row, col + 1)) { //union with space to right
            int number_right = addressToNumber(row, col + 1);
            uf.union(addressToNumber(row, col), number_right);
            System.out.println("Union Right");
        }
    }

    public boolean isOpen(int row, int col) {
        return (grid[row - 1][col - 1] < 0) ? false : true;
    }

    public boolean isFull(int row, int col) {
        return uf.connected(addressToNumber(row, col), virtual_top);
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        if (virtual_bottom != -1 && virtual_top != -1) {
            return uf.connected(virtual_top, virtual_bottom);
        } else {
            return false;
        }
    }

    public static int addressToNumber(int row, int col) {
        //System.out.println(((row - 1) * 20) + col);
        return ((row - 1) * 20) + (col - 1);
    }

    public static void test() {
        Percolation test = new Percolation(20);
        for (int i = 1; i < 21; i++) {
            test.open(i, 1);
        }
        System.out.println(test.virtual_top);
        System.out.println(test.virtual_bottom);
        System.out.println(test.percolates());
    }

    public static void main(String[] args) {
       /* Percolation test = new Percolation(20);
        test.open(2,15);
        //test.open(2,16);
        System.out.println(test.uf.connected(addressToNumber(2,15),addressToNumber(2,16)));
        test.open(1,1);
        test.open(1,20);
        test.open(20,1);
        test.open(20,20);
        System.out.println(test.numberOfOpenSites());
        System.out.println(test.grid[0][0]);
        Percolation test2 = new Percolation(0); */
        //test();
    }

}
