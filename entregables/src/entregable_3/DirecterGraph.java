package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirecterGraph<T> implements Graph<T> {
	private List<Vertex> vertexs;

	public DirecterGraph() {
		this.vertexs = new ArrayList<>();
	}

	//	Complejidad computacional: O(1)
	@Override
	public void addVertex(Integer vertexId) {
		Vertex vertex = new Vertex(vertexId);
		this.vertexs.add(vertex);
	}

	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteVertex(Integer vertexId) {
		for (Vertex vertex : vertexs) {
			if (vertex.getId().equals(vertexId))
				this.vertexs.remove(vertex);

		}
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void addArc(Integer origin, Integer destination, T hashtag) {
		Arc newArc = new Arc(origin, destination, hashtag);
		for (Vertex vertex : vertexs)
			if (vertex.getId().equals(origin) && !vertex.containArc(newArc))
				vertex.addArc(newArc);
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteArc(Integer origin, Integer destination) {
		for (Vertex vertex : vertexs)
			if (vertex.getId().equals(origin))
				vertex.deleteArc(destination);
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	@Override
	public boolean containVertex(Integer vertexId) {
		for (Vertex vertex : vertexs)
			if (vertex.getId().equals(vertexId))
				return true;
		return false;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public boolean existArc(Integer origin, Integer destination) {
		Arc auxArc = new Arc(origin, destination);
		for (Vertex vertex : vertexs)
			vertex.getArc(origin, destination);
			if (vertexs.contains(auxArc))
				return true;
		return false;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Arc<T> getArc(Integer origin, Integer destination) {
		for (Vertex vertex : vertexs)
			if (vertex.getId().equals(origin)) {
				return vertex.getArc(origin, destination);
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
		List<Arc> allArcs = new ArrayList<>();
		for (Vertex vertex : vertexs) {
			List<Arc> tempArcs = vertex.getArcs();
			allArcs.addAll(tempArcs);
		}
		return allArcs.size();
	}


	// Complejidad computacional: O(1)
	@Override
	public Iterator<Vertex> getVertex() {
		return this.vertexs.iterator();
	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Vertex> getAdyacent(Integer vertexId) {
		for (Vertex vertex : vertexs) {
			if (vertex.getId().equals(vertexId)) {
				List<Arc> adjacent = vertex.getArcs();
				Iterator itAdjecent = adjacent.iterator();
				return itAdjecent;
			}
		}
		return null;
	}

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs() {
		for (Vertex vertex : vertexs) {
			List<Arc> arcs = vertex.getArcs();
			Iterator itArcs = arcs.iterator();
			return itArcs;
		}
		return null;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs(Integer vertexId) {
		for (Vertex vertex : vertexs) {
			if (vertex.getId().equals(vertexId)) {
				List<Arc> arcs = vertex.getArcs();
				Iterator itArcs = arcs.iterator();
				return itArcs;
			}
		}
		return null;
	}

}
