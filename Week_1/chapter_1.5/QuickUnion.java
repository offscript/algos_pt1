public class QuickUnion {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public QuickUnion(int N) {  // Initialize component id array.
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
        //here we are looking for the "root" of a component, i.e the
        //value that every site in the component eventually points back to.
        //The hallmark of this root is that the root has a site-value equal
        //to its site index. Hence we search for the root by starting from a given
        //site, checking its value, checking the value of the site referenced by its
        //value, until we reach a site whose index and value are equal
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {

        int pRoot = find(p); //return the component p is in
        int qRoot = find(q); //return the component q is in

        if (pRoot == qRoot) return; // no need to do more array accesses and use connected...

        //Rename everything in p's component to q's component
        id[pRoot] = qRoot;
        count--;
    }

    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
    public static void main(String[] args) {  // Solve dynamic connectivity problem on StdIn.

        int N = StdIn.readInt();
        QuickUnion uf = new QuickUnion(N);
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
