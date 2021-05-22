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
	public void addVertex(int vertexId) {
		Vertex vertex = new Vertex(vertexId);
		this.vertexs.add(vertex);
	}

	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteVertex(int vertexId) {
		for (Vertex vertex : vertexs)
			if (vertex.getId() == vertexId) ;
			this.vertexs.remove(this.getVertex().next());
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void addArc(int origin, int destination, T hashtag) {
		Arc newArc = new Arc(origin, destination, hashtag);
		for (Vertex vertex : vertexs)
			if (vertex.getId() == origin && !vertex.containArc(newArc))
				vertex.addArc(newArc);
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public void deleteArc(int origin, int destination) {
		for (Vertex vertex : vertexs)
			if (vertex.getId() == origin)
				vertex.deleteArc(destination);
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	@Override
	public boolean containVertex(int vertexId) {
		for (Vertex vertex : vertexs)
			if (vertex.getId() == vertexId)
				return true;
		return false;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public boolean existArc(int origin, int destination) {
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
	public Arc<T> getArc(int origin, int destination) {
		for (Vertex vertex : vertexs)
			if (vertex.getId() == origin) {
				Arc foundArc = vertex.getArc(origin, destination);
				return foundArc;
			}
		return null;
	}


	// Complejidad computacional: O(v)
	// donde v es la cantidad de vértices que componen el grafo
	@Override
	public int numberVertex() {
		return vertexs.size();
	}


	// Complejidad computacional: O(a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public int numberArcs() {
		List<Arc> allArcs = new ArrayList<>();
		for (Vertex vertex : vertexs) {
			List<Arc> tempArcs = vertex.getArcs();
			allArcs.addAll(tempArcs);
		}
		return allArcs.size();
	}


	// Complejidad computacional: O(1)
	@Override
	public Iterator<Integer> getVertex() {
		Iterator it = this.vertexs.iterator();
		return it;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Integer> getAdyacent(int vertexId) {
		List<Arc> adjacent = new ArrayList<>();
		for (Vertex vertex : vertexs) {
			if (vertex.getId() == vertexId) {
				adjacent = vertex.getArcs();
				Iterator itAdjacent = adjacent.iterator();
				return itAdjacent;
			}
		}
		return null;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs() {
		List<Arc> arcs = new ArrayList<>();
		for (Vertex vertex : vertexs) {
			arcs = vertex.getArcs();
			Iterator itArcs = arcs.iterator();
			return itArcs;
		}
		return null;
	}


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs(int vertexId) {
		for (Vertex vertex : vertexs) {
			if (vertex.getId() == vertexId) {
				List<Arc> arcs = vertex.getArcs();
				Iterator it = arcs.iterator();
				return it;
			}
		}
		return null;
	}

}
