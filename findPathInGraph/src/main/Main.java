package main;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();

		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");
		Node node10 = new Node("10");
		Node node11 = new Node("11");
		Node node12 = new Node("12");
		Node node13 = new Node("13");

		node1.addDestination(node2, 2);
		node1.addDestination(node3, 4);
		node1.addDestination(node4, 1);

		node2.addDestination(node5, 3);
		node2.addDestination(node6, 2);
		node2.addDestination(node7, 4);

		node3.addDestination(node5, 2);
		node3.addDestination(node6, 8);
		node3.addDestination(node7, 1);

		node4.addDestination(node5, 7);
		node4.addDestination(node6, 4);
		node4.addDestination(node7, 6);

		node5.addDestination(node8, 2);
		node5.addDestination(node9, 4);

		node6.addDestination(node8, 3);
		node6.addDestination(node9, 7);

		node7.addDestination(node8, 2);
		node7.addDestination(node9, 5);

		node8.addDestination(node10, 6);
		node8.addDestination(node11, 5);
		node8.addDestination(node12, 9);

		node9.addDestination(node10, 5);
		node9.addDestination(node11, 1);
		node9.addDestination(node12, 7);

		node10.addDestination(node13, 2);

		node11.addDestination(node13, 4);

		node12.addDestination(node13, 2);

		Map<Integer, List<Node>> shortestPath = graph.findShortestPath(node1, node13, 5);
		Graph.printPath(shortestPath);
	}

}
