package entregable_3;

import java.util.HashMap;

public class Map {

	private Graph<Integer> graph;
	private HashMap<Integer, City> cities;
	private Road bestRoad;
	private FindRoads findRoads;

	public Map() {
		this.graph = new UndirecterGraph<Integer>();
		this.cities = new HashMap<>();
		this.bestRoad = new Road();

	}
	
	public void addCity(City city) {
		this.cities.put(city.getId(), city);
		this.graph.addVertex(city.getId());
	}
	
	public void deleteCity(City city) {
		this.graph.deleteVertex(city.getId());
		this.cities.remove(city.getId());
	}
	public Graph<Integer> getGraph() {
		return this.graph;
	}
	public void addRoute(City origin, City destination, int km) {
//	this.grafo.agr

		this.graph.deleteArc(origin.getId(), destination.getId());
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

	
}
