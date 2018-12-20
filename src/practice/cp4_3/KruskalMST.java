package practice.cp4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.Queue;

public class KruskalMST {
    private double weight;
    private Queue<Edge> mst = new Queue<Edge>();

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {  // v-w dose not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);
                weight += e.weight();
            }
        }

    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }


}
