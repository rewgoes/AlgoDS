
import datastructure.Graph;
import datastructure.Graph.Node;

public class Main {

	public static void main(String[] args) {
		 Graph graph = new Graph();
		 graph.addEdge("s", "a", 18);
		 graph.addEdge("s", "c", 15);
		 graph.addEdge("a", "b", 9);
		 graph.addEdge("a", "c", 6);
		 graph.addEdge("c", "b", 14);
		 graph.addEdge("c", "d", 7);
		 graph.addEdge("b", "d", 10);
		 graph.addEdge("b", "t", 28);
		 graph.addEdge("d", "t", 36);
		 
		 Node node = graph.nodes.get("s");
		 
		 boolean weighted = true;
		 System.out.println(graph.shortestPath("s", "t", weighted));
	}

}
