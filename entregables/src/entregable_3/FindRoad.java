package entregable_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FindRoad {

	private Graph<?> graph;
	private HashMap<Integer, String> colors;
	private int origin;
	private int destination;

	public FindRoad(Graph<?> graph, int origin, int destination) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.origin = origin;
		this.destination = destination;
	}

	public ArrayList<Integer> findRoad() {

		Iterator<Integer> it = this.graph.getVertex();
		while (it.hasNext()) {
			int verticeId = it.next();
			colors.put(verticeId, "white");
		}

		return findRoad(this.origin);
	}

	public ArrayList<Integer> findRoad(int vertex) {

		colors.put(vertex, "yellow");

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (vertex == this.destination) {
			result.add(vertex);
		} else {
		
			Iterator<Integer> it = this.graph.getAdyacent(vertex);
			while (it.hasNext() && !result.isEmpty()) {
				int adyacent = it.next();
				if (colors.get(adyacent).equals("white")) {
					ArrayList<Integer> caminoParcial = findRoad(adyacent);
					if (!caminoParcial.isEmpty()) {
						result.add(vertex);
						result.addAll(caminoParcial);
					}
				}
					
			}
	
		}
		
		colors.put(vertex, "black");

		return result;
	}

}
