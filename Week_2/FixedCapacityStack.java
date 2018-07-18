public class FixedCapacityStack<Item>
{
    private Item[] a;
    private int N;
    
    public FixedCapacityStack(int cap) 
    { a = (Item[]) new Object[cap]; }
    
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
    
   
}