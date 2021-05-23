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

	public ArrayList<Vertex> getBestRoad(City origin, City destination) {
//		Road road = new Road();

		ArrayList<Vertex> vertexs = this.findRoad.findRoad(origin, destination);
//		for (Vertex vertex : vertexs) {
//			for (City city : this.cities.values()) {
//				if (city.getId().equals(vertex.getId())) {
//					road.addCity(city);
//				}
//			}


//		road.addCity();
		return vertexs;
	}

//	private Road makeRoad() {
//		for (:
//			 ) {
//
//		}
//	}


	/*public Road getBestRoad(City origin, City destination) {
		List<Integer> idCities = this.findRoad.findRoad();
		Road road = new Road();
		for (City city : this.cities) {
			if (city.getId() == origin) {
				road.addCity(city);
			}
		}

		return
	}*/



}




	/*egarArco(origen.getId(), destino.getId(), kilometros);
	}
	 * Esto es un solo un código de ejemplo de como se usarían las estructuras
	 * La interfaz (retorno o parametros) de este método se puede cambiar,
	 * y por supuesto se pueden crear mas métodos en esta clase en caso de ser necesario
	 */
//	 public ¿Solucion? encontrarCamino(Town origen, Town destino) {

/* Aca hacer la logica que corresponda*/

// Obtengo todas las rutas salientes de mi ciudad origen
//		Iterator<Arc<Integer>> iterador = this.grafo.obtenerArcos(origen.getId());
//
//		while (iterador.hasNext()) {
//			Arc<Integer> arco = iterador.next(); // Arco que representa la ruta
//			int kilometros = arco.getEtiqueta(); // Kilometros de la ruta
//			int idDestino = arco.getVerticeDestino(); // ID de ciudad destino
//			Town ciudadAdyacente = this.ciudades.get(idDestino); // Objeto de ciudad destino
//		}
//
//		return null;
//	}



