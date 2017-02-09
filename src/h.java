import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Admin on 07-02-2017.
 */
public class h {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
    }
}

class Graph {
    boolean[] visited;
    List<List<Integer>> adjList;

    Graph(int n) {
        visited = new boolean[n];
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = false;
        }
    }

    void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
    }

    void dfs(int source) {
        visited[source] = true;
        System.out.println(source);
        List<Integer> children = adjList.get(source);
        for (int c: children){
            if (!visited[c]) {
                dfs(c);
            }
        }
    }

    void bfs(int source) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (queue.size() != 0) {
            int s = queue.remove();
            visited[source] = true;
            System.out.println(s);
            List<Integer> neighbors = adjList.get(s);
            for (int n: neighbors) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}
