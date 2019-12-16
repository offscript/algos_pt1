public class GenericStack<Item> {

    private int N;
    private Item[] a;

    public GenericStack(int cap) {
        a = (Item[]) new Object[cap];
        N = 0;
    }

    public static void main(String[] args) {
        GenericStack<String> part;
        //type variable name
        part = new GenericStack<String>(10);

    }
}
