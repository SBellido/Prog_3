package entregable_3;

import java.util.HashMap;
import java.util.Iterator;

public class ThereIsRoad {

	private Graph<?> graph;
	private HashMap<Integer, String> colors;
	private int origin;
	private int destination;

	public ThereIsRoad(Graph<?> graph, int origin, int destino) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.origin = origin;
		this.destination = destino;
	}

	public boolean existeCamino() {

		Iterator<Integer> it = this.graph.getVertex();
		while (it.hasNext()) {
			int verticeId = it.next();
			colors.put(verticeId, "blanco");
		}

		return existeCamino(this.origin);
	return true;
	}

	public boolean existeCamino(int vertice) {

		colors.put(vertice, "amarillo");

		boolean resultado = false;
		
		if (vertice == this.destination) {
			resultado = true;
//		} else {
//
//			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
//			while (it.hasNext() && !resultado) {
//				int adyacente = it.next();
//				if (colores.get(adyacente).equals("blanco")) {
//					resultado = existeCamino(adyacente);
//				}
//			}
	
		}
		
		colors.put(vertice, "negro");

		return resultado;
	}

}
