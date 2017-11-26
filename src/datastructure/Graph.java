package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

	public HashMap<String, Node> nodes = new HashMap<>();
	int numEdges = 0;

	public void addEdge(String nodeId1, String nodeId2, int weight) {
		Node node1;
		if (nodes.containsKey(nodeId1)) {
			node1 = nodes.get(nodeId1);
		} else {
			node1 = new Node(nodeId1);
			nodes.put(nodeId1, node1);
		}

		Node node2;
		if (nodes.containsKey(nodeId2)) {
			node2 = nodes.get(nodeId2);
		} else {
			node2 = new Node(nodeId2);
			nodes.put(nodeId2, node2);
		}

		Edge edge = new Edge(node1, node2, weight);
		node1.edges.put(nodeId2, edge);
		node2.edges.put(nodeId1, edge);

		numEdges++;
	}

	public void removeEdge(String nodeId1, String nodeId2) {
		Node node1 = nodes.get(nodeId1);
		Node node2 = nodes.get(nodeId2);

		if (node1 != null && node2 != null) {
			node1.edges.remove(nodeId2);
			node2.edges.remove(nodeId1);
			numEdges--;
		}
	}

	public String shortestPath(String source, String target, boolean weighted) {
		if (weighted) {
			return dijsktra(source, target);
		} else {
			return shortestPath(source, target);
		}
	}

	private String dijsktra(String source, String target) {
		if (nodes.containsKey(source) && nodes.containsKey(target)) {
			Set<String> notVisited = new HashSet<>(nodes.size()); // not visited / colored nodes
			PriorityQueue<NodeHelper> nodesMinPath = new PriorityQueue<>(); // heap of shortest path to each node
			HashMap<String, String> pathBacktrack = new HashMap<>(); // used only for backtracking the path

			// Add all nodes to notVisited list
			for (String key : nodes.keySet()) {
				notVisited.add(key);
			}

			nodesMinPath.add(new NodeHelper(source, 0, null));

			NodeHelper node = null;
			do {
				node = nodesMinPath.poll();

				if (node != null && notVisited.contains(node.nodeId)) {
					pathBacktrack.put(node.nodeId, node.previousNodeId);
					notVisited.remove(node.nodeId);

					for (Entry<String, Edge> edgeEntry : nodes.get(node.nodeId).edges.entrySet()) {
						if (notVisited.contains(edgeEntry.getKey())) {
							/*
							 * Add a new NodeHelper to the priority queue which gives preference for the
							 * nodes with lowest weight
							 * 
							 * NodeHelper(String nodeId, Integer weight, String previousNodeId)
							 * 
							 * weight = node.weight + edgeEntry.getValue().weight
							 */
							if (notVisited.contains(edgeEntry.getKey())) {
								nodesMinPath.add(new NodeHelper(edgeEntry.getKey(),
										node.weight + edgeEntry.getValue().weight, node.nodeId));
							}
						}
					}
				}
			} while (!notVisited.isEmpty() && !node.nodeId.equals(target));

			// found target node
			if (node != null && node.nodeId.equals(target)) {
				String pathString = target + " (size: " + node.weight + ")";
				String nodeId = target;

				// backtrack in order to print path
				do {
					nodeId = pathBacktrack.get(nodeId);

					if (nodeId != null) {
						pathString = nodeId + " -> " + pathString;
					}
				} while (nodeId != null);

				return pathString;
			}
		}

		return null;
	}

	private String shortestPath(String source, String target) {
		return null;
	}

	public class Node {
		String id;
		HashMap<String, Edge> edges = new HashMap<>();

		public Node(String id) {
			this.id = id;
		}
	}

	private class NodeHelper implements Comparable<NodeHelper> {
		String nodeId;
		Integer weight;
		String previousNodeId;

		public NodeHelper(String nodeId, Integer weight, String previousNodeId) {
			this.nodeId = nodeId;
			this.weight = weight;
			this.previousNodeId = previousNodeId;
		}

		@Override
		public int compareTo(NodeHelper o) {
			return weight.compareTo(o.weight);
		}
	}

	public class Edge {
		public Node start;
		public Node end;
		public int weight;

		public Edge(Node node1, Node node2, int weight) {
			start = node1;
			end = node2;
			this.weight = weight;
		}
	}
}
