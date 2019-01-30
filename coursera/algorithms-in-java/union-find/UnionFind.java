/**
 *
 */
import java.util.Scanner;


public class UnionFind {
    private int[] id;
    private int[] sz;
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = n;
            sz[i] = 1;
        }
    }

    // current number of components
    public int count() {
        return count;
    }

    // they are connected if their roots are same.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // find the root of the point, with path compression
    public int find(int p) {
        int op = p;
        // find root
        while (id[p] != p) p = id[p];
        // compress path
        if (id[op] != p) id[op] = p;
        return p;
    }

    // weighted union two points
    public void union(int p, int q) {
        int j = find(p);
        int k = find(q);
        // already union
        if (j == k) return;
        if (sz[j] < sz[k]) {
            id[j] = k;
            sz[k] += sz[j];
        } else {
            id[k] = j;
            sz[j] += sz[k];
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        UnionFind uf = new UnionFind(N);
        while (s.hasNext()) {
            int p = s.nextInt();
            int q = s.nextInt();
            if (uf.connected(p, q)) continue;  // Ignore if connected.
            uf.union(p, q);                    // Combine components
            System.out.println(p + " " + q);       // and print connection.
        }
        System.out.println(uf.count() + " components");
    }
}
