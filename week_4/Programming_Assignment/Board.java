import java.util.Iterator;

public class Board {
    private int totalMoves;
    private Board predecessor;
    private int[][] gameBoard;
    private int hamming_priority;
    private int manhattan_priority;
    
    public Board(int[][] blocks) {
        totalMoves = 0;
        predecessor = null;
        int length = blocks[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; i++) {
                gameBoard[i][j] = blocks[i][j];
            }
        }
    }
    
    public int dimension() //not sure what this means
    { return gameBoard[0].length; }
    
    public int hamming() 
    {
        int hamming_distance = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (i+j+1 != gameBoard[i][j]) hamming_priority++;
            }
        }
        hamming_priority = hamming_distance + totalMoves;
        return hamming_priority;
    }
    
    public int manhattan()
    {
        int manhattan_distance = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                manhattan_distance = manhattan_distance + 
                    Math.abs(((gameBoard[i][j] - 1)/ 3)) + 
                    Math.abs((gameBoard[i][j] - (i + j + 1)));
            }
        }
        manhattan_priority = manhattan_distance + totalMoves;
        return manhattan_priority;
    }
    
    public boolean isGoal()
    {
       for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (gameBoard[i][j] != (i+j+1)) return false;
            }
       }
       return true;
    }
    
    public Board twin() {
        int[] hold_this = new int[]{-1, 0, 0};
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension() - 1; j++) {
                if (hold_this[0] < 0) {
                    hold_this[0] = gameBoard[i][j];
                    hold_this[1] = i;
                    hold_this[2] = j;
                }
                if (hold_this[0] > 1) {
                    break;
                }
            }
       }
       int [][] new_array = gameBoard.clone();
       new_array[hold_this[1]][hold_this[2]] = hold_this[0];
       Board twin = new Board(new_array);
       return twin;
    }
    
    public boolean equals(Object y) {
        return true;
    }
    
    public Iterable<Board> neighbors() {
        return new BoardIterator();
    }
    
    private class BoardIterator implements Iterator<Board> {
        
    }
    
    public String toString() {
        
    }
}