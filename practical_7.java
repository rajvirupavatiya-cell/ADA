public class PrimsMST {

    // Function to find vertex with minimum key value
    int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print MST
    void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim's Algorithm
    void primMST(int[][] graph, int V) {

        int[] parent = new int[V]; // stores MST
        int[] key = new int[V];    // minimum weight
        boolean[] mstSet = new boolean[V]; // included in MST

        // Initialize
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;      // Start from vertex 0
        parent[0] = -1;  // Root of MST

        // MST will have V-1 edges
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            // Update adjacent vertices
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    public static void main(String[] args) {

        int V = 5;

        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        PrimsMST obj = new PrimsMST();
        obj.primMST(graph, V);
    }
}
