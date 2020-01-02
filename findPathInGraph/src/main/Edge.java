package main;

public class Edge {
	private Node node;
	private int duration;

	public Edge(Node node, int duration) {
		this.node = node;
		this.duration = duration;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
