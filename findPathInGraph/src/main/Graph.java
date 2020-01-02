package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	private Set<Node> nodes;

	public Graph() {
		this.nodes = new HashSet<Node>();
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public Map<Integer, List<Node>> findShortestPath(Node source, Node dest, int attachments) {
		Map<Integer, List<Node>> shortestPath = new HashMap<Integer, List<Node>>();
		List<Node> currPathNodes = new ArrayList<Node>();
		int duration = 0;
		int currAttachments = 0;
		currPathNodes.add(source);
		findShortestPathUtil(source, dest, currPathNodes, shortestPath, duration, currAttachments, attachments);
		return shortestPath;
	}

	private void findShortestPathUtil(Node currentNode, Node dest, List<Node> currPathNodes,
			Map<Integer, List<Node>> shortestPath, int duration, int currAttachments, int attachments) {
		if (currAttachments > attachments || isCurrPathLongerOrEqualThanShortest(shortestPath, duration)) {
			return;
		}

		if (currentNode.getName().equals(dest.getName()) && currAttachments == attachments) {
			if (!shortestPath.isEmpty()) {
				if (!isCurrPathLongerOrEqualThanShortest(shortestPath, duration)) {
					shortestPath.clear();
					shortestPath.put(duration, new ArrayList<Node>(currPathNodes));
					return;
				}
			} else {
				shortestPath.put(duration, new ArrayList<Node>(currPathNodes));
				return;
			}
		}

		currentNode.setVisited(true);

		for (Edge edge : currentNode.getEdges()) {
			if (!edge.getNode().isVisited()) {
				currPathNodes.add(edge.getNode());
				duration += edge.getDuration();
				currAttachments++;
				findShortestPathUtil(edge.getNode(), dest, currPathNodes, shortestPath, duration, currAttachments,
						attachments);
				currPathNodes.remove(edge.getNode());
				duration -= edge.getDuration();
				currAttachments--;
			}
		}

		currentNode.setVisited(false);

	}

	private boolean isCurrPathLongerOrEqualThanShortest(Map<Integer, List<Node>> shortestPath, int destSum) {
		if (shortestPath.isEmpty()) {
			return false;
		}
		Map.Entry<Integer, List<Node>> entry = shortestPath.entrySet().iterator().next();
		int currMinDistance = entry.getKey();
		if (destSum >= currMinDistance) {
			return true;
		}
		return false;
	}

	public static void printPath(Map<Integer, List<Node>> allPaths) {
		StringBuilder sb = new StringBuilder();
		for (int duration : allPaths.keySet()) {
			sb.append("duration " + duration + " hours: ");
			List<Node> nodes = allPaths.get(duration);
			for (Node node : nodes) {
				sb.append(node.getName() + ";");
			}
			System.out.println(sb.toString());
		}
	}

}
