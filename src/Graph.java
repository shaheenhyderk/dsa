import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public void addVertex(Integer s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(Integer source,
                        Integer destination,
                        boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }


    public void display() {

        for (Integer v : map.keySet()) {
            System.out.print(v + ": ");
            for (Integer w : map.get(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Graph g = new Graph();

        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // print the graph.
        g.display();

    }

}
