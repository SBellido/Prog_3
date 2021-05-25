package entregable_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {

	private Graph<Integer> graph;
	private HashMap<Integer, City> cities;
	private FindRoad findRoad;

	public Map() {
		this.graph = new UndirecterGraph<Integer>();
		this.cities = new HashMap<>();
		this.findRoad = new FindRoad(this.graph);
	}

	public void addCity(City city) {
		this.cities.put(city.getId(), city);
		this.graph.addVertex(city.getId());
	}

	public void deleteCity(City city) {
		this.graph.deleteVertex(city.getId());
		this.cities.remove(city.getId());
	}

	public void addRoad(City origin, City destination, Integer hashtag) {
		this.graph.addArc(origin.getId(), destination.getId(), hashtag);
	}

	public Graph<Integer> getGraph() {
		return this.graph;
	}

	public ArrayList<Integer> getBestRoad(City origin, City destination) {
//		Road road = new Road();
		ArrayList<Integer> vertexs = this.findRoad.findRoad(origin, destination);
		return vertexs;
	}

	@Override
	public String toString() {
		return "\nMAPA: " + graph.toString() +
				"\nDetalle Ciudades: " + cities.toString();
	}
}



