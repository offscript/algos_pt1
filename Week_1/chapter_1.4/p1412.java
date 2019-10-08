import java.util.ArrayList;
import java.util.Arrays;

//what about duplicates? could remove em after, or before

public class p1412 {

    public static void main(String[] args) {
        In in = new In(args[0]);
        In in2 = new In(args[1]);

        int[] array1 = in.readAllInts();
        int[] array2 = in2.readAllInts();

        Arrays.sort(array1);
        Arrays.sort(array2);

        inBothArrays(array1, array2);

    }

    public static ArrayList<Integer> inBothArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> in_common = new ArrayList<Integer>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                in_common.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) j++;
            else i++;
        }
        for (Integer integer : in_common) {
            System.out.println(integer);
        }
        return in_common;
    }

}
