package entregable_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FindRoad {

	private final int MAXBALANCES = 2;
	private Graph<?> graph;
	private HashMap<Integer, String> colors;
	private Integer origin;
	private Integer destination;
	private Road road;
	private Integer km;
	private int balances;

	public FindRoad() {}
	public FindRoad(Graph<?> graph, Integer origin, Integer destination) {
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
		this.origin = null;
		this.destination = null;
		this.road = null;
		this.km = 0;
	}

	public ArrayList<Integer> findRoad(City origin, City destination) {

		this.setOrigin(origin.getId());
		this.setDestination(destination.getId());

//
		return getRoad_visit(this.origin, this.km, this.balances);
	}



	public ArrayList<Integer> getRoad_visit(Integer origin, Integer kmActual, int countBalances) {
		colors.put(origin, "yellow");
		ArrayList<Integer> result = new ArrayList<>();

		if (origin.equals(this.destination)) {
			result.add(origin);
		} else {

			Iterator<Integer> itAdjacent = this.graph.getAdyacent(origin);
			while ((itAdjacent.hasNext() || countBalances < this.MAXBALANCES)) {
				Integer adyacent = itAdjacent.next();

				if (colors.get(adyacent).equals("white")) {
					this.road.setKms(kmActual += kmActual);
					countBalances += countBalances;
					ArrayList<Integer> partialRoad = getRoad_visit(adyacent,this.road.getKms(), countBalances);

					if (!partialRoad.isEmpty()) {
						result.add(origin);
						result.addAll(partialRoad);
					}
				}
					
			}
	
		}
		
		colors.put(origin, "black");

		return result;
	}

	public Road getRoad() {
		return road;
	}


	public void setRoad(Road road) {
		this.road = road;
	}


	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	public Integer getOrigin() {
		return this.origin;
	}

	public Integer getDestination() {
			return this.destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}


	public Integer getKm() {
		return km;
	}


	public void setKm(Integer km) {
		this.km = km;
	}
}
