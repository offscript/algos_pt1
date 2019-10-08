import java.util.ArrayList;
import java.util.Collections;


public class core_p148 {

    public static void main(String[] args) {
        In in = new In(args[0]);
        ArrayList<Integer> readInts = new ArrayList<>();
        System.out.println(in.isEmpty());
        while (!in.isEmpty()) {
            System.out.println("reading");
            readInts.add(in.readInt());
        }

        System.out.println(readInts.toString());
        Collections.sort(readInts);
        System.out.println(readInts.toString());

        int counter = 0;
        for (int i = 0; i < readInts.size() - 1; i++) {
            if (readInts.get(i).equals(readInts.get(i + 1))) {
                counter++;
            }
        }
        System.out.println(counter);

    }


}
