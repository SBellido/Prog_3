package entregable_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FindRoad {

	private final int MAXBALANCES = 2;
	private Graph<?> graph;
	private HashMap<Integer, String> colors;
	private Vertex origin;
	private Vertex destination;
	private Road road;
	private Integer km;
	private int balances;

	public FindRoad() {}
	public FindRoad(Graph<?> graph, Vertex origin, Vertex destination) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.origin = origin;
		this.destination = destination;
		this.road = null;
		this.km = 0;
		this.balances = 0;
	}


	public FindRoad(Graph<?> graph) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.origin = new Vertex();
		this.destination = new Vertex();
		this.road = null;
		this.km = 0;
	}

	public ArrayList<Vertex> findRoad(City origin, City destination) {

		this.origin.setId(origin.getId());
		this.destination.setId(destination.getId());

		Iterator<Vertex> itVertex = this.graph.getVertex();
		while (itVertex.hasNext()) {
			Vertex vertexIdActual = itVertex.next();
			colors.put(vertexIdActual.getId(), "white");
		}

		return getRoad_visit(this.origin, this.km, this.balances);
	}



	public ArrayList<Vertex> getRoad_visit(Vertex origin, Integer kmActual, int countBalances) {

		colors.put(origin.getId(), "yellow");
		ArrayList<Vertex> result = new ArrayList<Vertex>();


		if (origin.equals(this.destination)) {
			result.add(origin);
		} else {

			Iterator<Vertex> itAdjacent = this.graph.getAdyacent(origin.getId());
			while ((itAdjacent.hasNext() || countBalances < this.MAXBALANCES)) {
				Vertex adyacent = itAdjacent.next();

				if (colors.get(adyacent).equals("white")) {
					kmActual += kmActual;
					countBalances += countBalances;
					ArrayList<Vertex> partialRoad = getRoad_visit(adyacent,kmActual, countBalances);

					if (!partialRoad.isEmpty()) {
						result.add(origin);
						result.addAll(partialRoad);
					}
				}
					
			}
	
		}
		
		colors.put(origin.getId(), "black");

		return result;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public void setOrigin(Vertex origin) {
		this.origin = origin;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}
}
