import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    
    public static void main(String[] args) {
        String numberOfInputs= args[0];
        int counter = Integer.parseInt(numberOfInputs);
        System.out.println(counter);
        RandomizedQueue<String> permutation_queue = new RandomizedQueue();
        while (counter > 0) {
            permutation_queue.enqueue(StdIn.readString());
            counter--;
        }
        for (String item : permutation_queue) {
            System.out.println(item);
        }
        
    }
}