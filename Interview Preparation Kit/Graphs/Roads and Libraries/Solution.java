import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Edge {
        public int u, v;
        public long w;
        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static class UnionFind {
        private int parent[];
        private int rank[];

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findSet(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int setA = findSet(a);
            int setB = findSet(b);

            if (rank[setA] > rank[setB]) {
                parent[setB] = setA;
            } else {
                parent[setA] = setB;
                if (rank[setA] == rank[setB]) {
                    rank[setB] += 1;
                }
            }
        }

        public boolean connected(int a, int b) {
            return (findSet(a) == findSet(b));
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            long m = in.nextLong();
            long lib = in.nextLong();
            long road = in.nextLong();
            
            List<Edge> edges = new ArrayList<>();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                edges.add(new Edge(city_1, city_2, road));
            }
            
            UnionFind uf = new UnionFind((int)(n + 1));
            long minCost = n * lib;
            long roadCosts = 0;
            long libCosts = n * lib;
            
            for (Edge edge : edges) {
                if (!uf.connected(edge.u, edge.v)) {
                    uf.union(edge.u, edge.v);
                    roadCosts += road;
                    libCosts -= lib;
                    minCost = Math.min(minCost, roadCosts + libCosts);
                }
            }
            
            System.out.println(minCost);
        }
    }
}
