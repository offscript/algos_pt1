import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    
    public static void main(String[] args) {
        int k = args.length;
        RandomizedQueue permutation_queue = new RandomizedQueue();
        while (k > 0) {
            permutation_queue.enqueue(StdIn.readChar());
            k--;
        }
        for (Item item : permutation_queue) {
            System.out.println(item);
        }
    }
}