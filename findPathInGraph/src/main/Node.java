package main;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;

	private boolean isVisited;

	private List<Edge> edges;

	public Node(String name) {
		this.name = name;
		this.edges = new ArrayList<Edge>();
	}

	public void addDestination(Node destination, int distance) {
		edges.add(new Edge(destination, distance));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
