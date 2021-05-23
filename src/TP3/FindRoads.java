package entregable_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FindRoads {

	private Graph<?> graph;
	private HashMap<Integer, String> colors;
	private int origin;
	private int destination;
	private List<Road> roads;

	public FindRoads(Graph<?> graph, int origin, int destination) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.origin = origin;
		this.destination = destination;
		this.roads = new ArrayList();
	}

	public ArrayList<ArrayList<Integer>> findRoads() {

		Iterator<Integer> it = this.graph.getVertex();
		while (it.hasNext()) {
			int verticeId = it.next();
			colors.put(verticeId, "blanco");
		}

		return findRoads(this.origin);
	}

	public ArrayList<ArrayList<Integer>> findRoads(int vertexId) {
		colors.put(vertexId, "yellow");

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if (vertexId == this.destination) {
			ArrayList<Integer> onlyRoad = new ArrayList<>();
			onlyRoad.add(vertexId);
			result.add(onlyRoad);
		} else {
		
			Iterator<Integer> it = this.graph.getAdyacent(vertexId);
			while (it.hasNext()) {
				int adjacent = it.next();
				if (colors.get(adjacent).equals("white")) {
					ArrayList<ArrayList<Integer>> partialRoads = findRoads(adjacent);

					for (ArrayList<Integer> partialRoad : partialRoads) {
						ArrayList<Integer> completeRoad = new ArrayList<>();
						completeRoad.add(vertexId);
						completeRoad.addAll(partialRoad);
						result.add(completeRoad);
					}

				}

			}
	
		}
		
		colors.put(vertexId, "white");

		return result;
	}

}
