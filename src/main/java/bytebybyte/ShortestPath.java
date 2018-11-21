package bytebybyte;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a directed graph, find the shotest path between two nodes if one exists
//https://www.youtube.com/watch?v=c0OMPDLef08&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj
//https://www.youtube.com/watch?v=SmnUqWmWvz0
//https://www.youtube.com/watch?v=us0qySiUsGU&list=PLrmLmBdmIlps7GJJWW9I7N0P0rB0C3eY2&index=4
public class ShortestPath {

	private class Node {

		List<Node> next;
	}

	public List<Node> shortestpath(Node a, Node b) {

		if (a == null || b == null)
			return null;

		Queue<Node> toVisit = new LinkedList<Node>();

		HashMap<Node, Node> parents = new HashMap<Node, Node>();

		toVisit.add(a);
		parents.put(a, null);

		while (!toVisit.isEmpty()) {
			Node curr = toVisit.remove();
			if (curr == b)
				break;
			Iterable<Node> curr1 = null; //curr.getListIterable();
			for (Node n : curr1) {
				if (!parents.containsKey(n)) {
					toVisit.add(n);
					parents.put(n, curr);
				}
			}

			if (parents.get(b) == null)
				return null;

			List<Node> out = new LinkedList<Node>();
			curr = b;
			while (curr != null) {
				out.add(0, curr);
				curr = parents.get(curr);
			}
		}

		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
