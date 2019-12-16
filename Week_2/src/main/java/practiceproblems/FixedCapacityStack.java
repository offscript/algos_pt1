import edu.princeton.cs.algs4.*;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[N++] = item; //postfix
    }

    public Item pop() {
        return a[--N]; //prefix
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(1);
        stack.push("Thomas");
        System.out.println(stack.isFull());

    }

}
