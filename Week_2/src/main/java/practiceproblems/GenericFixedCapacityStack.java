import edu.princeton.cs.algs4.*;

public class GenericFixedCapacityStack<Item> {

    private int N;
    private Item[] a;

    public GenericFixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        return a[--N];
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        GenericFixedCapacityStack<String> s;
        s = new GenericFixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
