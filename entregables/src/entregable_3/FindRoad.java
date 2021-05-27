package entregable_3;

import java.awt.*;
import java.util.*;

public class FindRoad implements Comparator<Road> {

	private final int MAXBALANCES = 2;
	private Graph<Integer> graph;
	private HashMap<Integer, City> cities;
	private HashMap<Integer, String> colors;
	private Road partialRoad;
	private Road bestRoad;
	private Integer countKm;
	private int countBalances;

	public FindRoad() {}
	public FindRoad(Graph<Integer> graph, Integer origin, Integer destination) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.partialRoad = new Road();
		this.bestRoad = new Road();
		this.countKm = 0;
		this.countBalances = 0;
	}


	public FindRoad(Graph<Integer> graph, HashMap<Integer, City> cities) {
		this.cities = cities;
		this.graph = graph;
		this.colors = new HashMap<>();
		this.partialRoad = new Road();
		this.bestRoad = new Road();
		this.countKm = 0;
		this.countBalances = 0;
	}

	@Override
	public int compare(Road road1, Road road2) {
		if (road1.getKms() > road2.getKms()) {
			return road1.getKms();
		} else {
			return road2.getKms();
		}
	}

	private void updateCountBalance(City origin) {
		if (isWeighsInOrigin(origin))
			this.countBalances++;
	}

	private boolean isWeighsInOrigin(City origin) {
		return origin.isThereBalance();
	}

	public void findRoad(City origin, City destination) {

		Iterator<Integer> itVertex = this.graph.getVertex();
		while (itVertex.hasNext()) {
			Integer vertexIdActual = itVertex.next();
			colors.put(vertexIdActual, "white");
		}
		getRoad_visit(origin, destination, this.countKm, this.countBalances);
	}

	public void getRoad_visit(City origin, City destination, Integer kmActual, Integer countBalances) {
		Integer originId = origin.getId();
		Integer detinationId = destination.getId();
		colors.put(originId, "yellow");
		this.partialRoad.addCity(origin);
		this.updateCountBalance(origin);

		if (this.countBalances < MAXBALANCES) {
			if (originId.equals(detinationId)) {
				//SI LLEGÓ A DESTINO COMPARA EL LARGO DEL CAMINO PARCIAL
				//CON EL ACTUAL Y SETEA EL ACTUAL CON AL MAYOR
				if (this.bestRoad.getKms() < this.partialRoad.getKms()) {
					this.setBestRoad(this.partialRoad);
				}
			} else {
				Iterator<Integer> itIdDestination = this.graph.getAdyacent(originId);
				while (itIdDestination.hasNext()) {
					Integer nextId = itIdDestination.next();
					String actualDestiantion = colors.get(nextId);
					if (actualDestiantion.equals("white")) {
						Arc<Integer> arc = this.graph.getArc(originId, nextId);
						kmActual = arc.getHashtag();
						this.partialRoad.setKms(kmActual += arc.getHashtag());
						origin = this.cities.get(nextId);
						getRoad_visit(origin, destination, kmActual, countBalances);
						//this.bestRoad.setKms(this.bestRoad.compare(this.partialRoad, this.bestRoad));
					}
				}

			}

//			terator<Vertex<T>> itInterno = this.vertexs.iterator();
//			return new IteratorVertex<T>(itInterno);
		}
	}


	public Road getBestRoad() {
		return this.bestRoad;
	}


	public void setBestRoad(Road bestRoad) {
		this.bestRoad = bestRoad;
	}

	public Integer getKm() {
		return this.countKm;
	}


	public void setKm(Integer countKm) {
		this.countKm = countKm;
	}

	public Integer getCountKm() {
		return countKm;
	}

	public void setCountKm(Integer countKm) {
		this.countKm = countKm;
	}

	public int getCountBalances() {
		return countBalances;
	}

	public void setCountBalances(Integer countBalances) {
		this.countBalances = countBalances;
	}
}


//List<City> citiesVisit = new ArrayList<>();
//Iterator<City> itCity = citiesVisit.iterator();
//IteratorCity<Integer> itIdCity = new IteratorCity<>(itCity);
//grafo dame todos los arcos

