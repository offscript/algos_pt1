import edu.princeton.cs.algs4.*;

public class QuickFind
{
    private int[] id;
    private int count;
    
    public QuickFind(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        QuickFind qf = new QuickFind(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            //if (uf.connected(p, q)) continue;
            //qf.union(p, q);
            StdOut.println(p + " " + q);
        }
        //StdOut.println(qf.count() + " components");
    }
}
            