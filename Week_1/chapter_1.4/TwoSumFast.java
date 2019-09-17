import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class TwoSumFast {

    public static int count(int[] a) {
        int count = 0;
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i < N; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
                count++;
        return count;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int matches = count(a);
        System.out.println(matches);
    }

}
