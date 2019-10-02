import edu.princeton.cs.algs4.Interval1D;


public class p122 {
    private Interval1D[] intervalList;
    private int position;

    public p122(int list_length) {
        intervalList = new Interval1D[list_length];
    }

    public void printList() {
        for (Interval1D interval :
                intervalList) {
            System.out.println(interval.toString());
        }
    }

    public void addIntervalToList(Interval1D interval) {
        intervalList[position] = interval;
        position++;
    }

    public int howManyIntersect() {
        int number_intersecting = 0;
        for (int i = 0; i < intervalList.length - 1; i++) {
            for (int j = i + 1; j < intervalList.length; j++) {
                if (intervalList[i].intersects(intervalList[j])) {
                    number_intersecting++;
                }
            }
        }
        return number_intersecting;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int i = 0;
        int list_length = in.readInt();
        p122 test = new p122(list_length);
        while (in.isEmpty() != true) {
            double x = in.readDouble();
            double y = in.readDouble();
            Interval1D interval = new Interval1D(x, y);
            test.addIntervalToList(interval);
            i++;
        }
        test.printList();
        System.out.println(test.howManyIntersect());
    }


}
