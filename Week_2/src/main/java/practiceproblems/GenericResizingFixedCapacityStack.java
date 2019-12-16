import edu.princeton.cs.algs4.*;

public class GenericResizingFixedCapacityStack<Item> {

    private int N; //n is the number of items iin the stack, so given the property of arrays it points to an empty space
    private Item[] a;

    public GenericResizingFixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public void push(Item item) {
        if (isFull()) resize(2 * a.length);
        a[N++] = item;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
        System.out.println(a.length);
        //point variable a to temp, bud
    }

    public boolean isFull() {
        if (N == a.length)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        GenericResizingFixedCapacityStack<String> s;
        s = new GenericResizingFixedCapacityStack<String>(1);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
