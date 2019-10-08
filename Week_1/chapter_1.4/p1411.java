import java.util.Arrays;

public class p1411 {
    private int[] a;

    public p1411(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    public int howMany(int key) {
        int counter = 1;
        int middle_position = rank(key);
        counter += left_counter(middle_position);
        counter += right_counter(middle_position);
        return counter;
    }

    public int left_counter(int index) {
        int counter = 0;
        while (a[index] == a[index - counter - 1]) {
            counter++;
        }
        return counter;
    }

    public int right_counter(int index) {
        int counter = 0;
        while (a[index] == a[index + (counter + 1)]) {
            counter++;
        }
        return counter;
    }

    private int rank(int key) { // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public String toString() {
        return java.util.Arrays.toString(a);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        p1411 Set = new p1411(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int returned_index = Set.howMany(key);
            if (returned_index != -1) {
                StdOut.println(Set.toString());
                StdOut.println(returned_index);
            }
        }

    }


}
