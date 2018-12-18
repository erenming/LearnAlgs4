package practice.cp4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import org.omg.CORBA.PUBLIC_MEMBER;

public class LazyPrimMST {
    private double weight;       // totel weight in MST
    private Queue<Edge> mst;     // edge int MST
    private boolean[] marked;    // marked[v] == true if v on tree
    private MinPQ<Edge> pq;   // edges with one endpoint in tree

    // compute minimum spanning forest of G
    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();

            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        // 标记顶点v并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);

    }

    public Iterable<Edge> edges() {
        return mst;
    }

//    public double weight(){
//
//    }
}
