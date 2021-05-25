package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirecterGraph<T> implements Graph<T> {
	private List<Vertex<T>> vertexs;

	public DirecterGraph() {
		this.vertexs = new ArrayList<>();
	}

	//	Complejidad computacional: O(1)
	@Override
	public void addVertex(Integer vertexId) {
		Vertex<T> vertex = new Vertex<T>(vertexId);
		this.vertexs.add(vertex);
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteVertex(Integer vertexId) {
		boolean vertexRemove = false;
		Iterator<Vertex<T>> itVertex = this.vertexs.iterator();
		while (itVertex.hasNext() && !vertexRemove)
			if (vertexId.equals(itVertex.next().getId())) {
				vertexs.remove(itVertex.next());
				vertexRemove = true;
			}
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void addArc(Integer origin, Integer destination, T hashtag) {

		Arc<T> newArc = new Arc<T>(origin, destination, hashtag);
		//IteratorVertex<T> itVertex = new IteratorVertex<T>();
		for (Vertex<T> vertex : vertexs) {
			Integer aux = vertex.getId();
			if (aux.equals(origin) && !vertex.containArc(newArc)) {
				System.out.println("\nide vertice " + vertex.getId() + "\norigen: " + origin);
				vertex.addArc(newArc);
				break;
			}
		}
	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
//	@Override
//	public void addArc(Integer origin, Integer destination, T hashtag) {
//		boolean isAdded = false;
//		Arc<T> newArc = new Arc<T>(origin, destination, hashtag);
//		Iterator<Integer> intIteratorVertex = this.getVertex();
//
//		while (intIteratorVertex.hasNext() && !isAdded) {
//			Integer idOrigin = intIteratorVertex.next();
//			if (idOrigin.equals(origin)) {
//				isAdded = true;
//				Vertex<T> vertex = this.vertexs.get(idOrigin);
//				this.vertexs.add(idOrigin, vertex);
//			}
//		}
//	}
	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteArc(Integer origin, Integer destination) {
		for (Vertex<T> vertex : vertexs)
			if (vertex.getId().equals(origin))
				vertex.deleteArc(destination);
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	@Override
	public boolean containVertex(Integer vertexId) {
		for (Vertex<T> vertex : vertexs)
			if (vertex.getId().equals(vertexId))
				return true;
		return false;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public boolean existArc(Integer origin, Integer destination) {

		Arc<T> auxArc = new Arc<T>(origin, destination);
		for (Vertex<T> vertex : vertexs) {
			vertex.getArc(destination);
			if (vertex.containArc(auxArc))
				return true;
		}
		return false;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Arc<T> getArc(Integer origin, Integer destination) {
		for (Vertex<T> vertex : vertexs)
			if (vertex.getId().equals(origin)) {
				return vertex.getArc(destination);
			}
		return null;
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	@Override
	public Integer numberVertex() {
		return vertexs.size();
	}


	// Complejidad computacional: O(a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Integer numberArcs() {
		List<Arc<T>> allArcs = new ArrayList<Arc<T>>();
		for (Vertex<T> vertex : vertexs) {
			List<Arc<T>> tempArcs = vertex.getArcs();
			allArcs.addAll(tempArcs);
		}
		return allArcs.size();
	}


	// Complejidad computacional: O(1)
	@Override
	public Iterator<Integer> getVertex() {
		Iterator<Vertex<T>> itInterno = this.vertexs.iterator();
		return new IteratorVertex<T>(itInterno);
	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
//	@Override
//	public Iterator<Integer> getAdyacent(Integer vertexId) {
//		for (Vertex vertex : vertexs) {
//			if (vertex.getId().equals(vertexId)) {
//				List<Arc> adjacent = vertex.getArcs();
//				Iterator itAdjecent = adjacent.iterator();
//				return itAdjecent;
//			}
//		}
//		return null;
//	}
	@Override
	public Iterator<Integer> getAdyacent(Integer vertexId) {
		Iterator<Vertex<T>> itInterno = this.vertexs.iterator();
		while (itInterno.hasNext()) {
			if (itInterno.next().getId().equals(vertexId))
			itInterno.next();

		}
		return new IteratorVertex<T>(itInterno);

	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Integer> getArcs() {
		ArrayList<Arc<T>> arcs = new ArrayList<>();
		Iterator<Arc<T>> itInterno = arcs.iterator();

		return new IteratorArc<T>(itInterno);
//		for (Vertex<T> vertex : vertexs) {
//			List<Arc<T>> arcs = vertex.getArcs();
//			Iterator itArcs = arcs.iterator();
//			return itArcs;
//		}
//		return null;
	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs(Integer vertexId) {
		for (Vertex<T> vertex : vertexs) {
			if (vertex.getId().equals(vertexId)) {
				List<Arc<T>> arcs = vertex.getArcs();
				Iterator<Arc<T>> itArcs = arcs.iterator();
				return itArcs;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (Vertex<T> vertex : vertexs) {
			out.append(vertex.toString());
		}
		return out.toString();
	}

}
