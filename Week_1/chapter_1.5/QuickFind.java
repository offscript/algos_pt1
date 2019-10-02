public class QuickFind {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public QuickFind(int N) {  // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {

        int pID = find(p); //return the component p is in
        int qID = find(q); //return the component q is in

        if (pID == qID) return; // no need to do more array accesses and use connected...

        //Rename everything in p's component to q's component
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
    public static void main(String[] args) {  // Solve dynamic connectivity problem on StdIn.

        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;  // Ignore if connected.
            uf.union(p, q);                    // Combine components
            StdOut.println(p + " " + q);       //   and print connection.
        }
        StdOut.println(uf.count() + " components");
    }
}
