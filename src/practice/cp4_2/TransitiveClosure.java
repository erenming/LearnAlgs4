package practice.cp4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 *  顶点对的可达性
 *  Preprocessing time: O(V(E + V)) time.
 *  Query time: O(1).
 *  Space: O(V^2).
 *  % java TransitiveClosure tinyDG.txt
 */
public class TransitiveClosure {
    private DirectedDFS[] tc;   // tc[v] = reachable from v

    public TransitiveClosure(Digraph G) {
        tc = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            tc[v] = new DirectedDFS(G, v);
        }
    }

    public boolean reachable(int v, int w) {
        return tc[v].marked(w);
    }

    // test client
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        TransitiveClosure tc = new TransitiveClosure(G);

        // print header
        StdOut.print("     ");
        for (int v = 0; v < G.V(); v++)
            StdOut.printf("%3d", v);
        StdOut.println();
        StdOut.println("--------------------------------------------");

        // print transitive closure
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%3d: ", v);
            for (int w = 0; w < G.V(); w++){
                if (tc.reachable(v, w)) StdOut.printf("  T");
                else                    StdOut.printf("   ");
            }
            StdOut.println();
        }
    }
}
