package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirecterGraph<T> implements Graph<T> {
	private ArrayList<Vertex<T>> vertexs;

	public DirecterGraph(ArrayList<Vertex<T>> listVertex) {
		this.vertexs = new ArrayList<Vertex<T>>(listVertex);
		//Iterator<Vertex<T>> itVertex = this.vertexs.iterator();
	}
	public DirecterGraph(Map map) {
		ArrayList<Vertex<Integer>> listVertex = map.getGraph().copyListVertex();

		Iterator<Vertex<T>> itVertex = this.vertexs.iterator();
	}

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
		for (Vertex<T> vertex : vertexs) {
			Integer aux = vertex.getId();
			if (aux.equals(origin) && !vertex.containArc(newArc)) {
				vertex.addArc(newArc);
				break;
			}
		}
	}

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

    private Vertex<T> getVertex(Integer id) {
		for (Vertex vertex : this.vertexs)
			if (vertex.getId().equals(id))
				return vertex;
        /*Iterator<Vertex<T>> itVertex = this.vertexs.iterator();
        while (itVertex.hasNext()) {
			Integer idVertex = itVertex.next().getId();
            if (idVertex.equals(id))
                return itVertex.next();
        }
        return null;*/
		return null;
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
		Integer total = 0;
		for (Vertex<T> vertex : vertexs)
			total += vertex.countArcs();
		return total;
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
	@Override
	public Iterator<Integer> getAdyacent(Integer vertexId) {
		Vertex<T> vertex = this.getVertex(vertexId);
		if (this.containVertex(vertexId)) {
			ArrayList<Arc<T>> arcs = vertex.copyListArc();
			Iterator<Arc<T>> itInterno = arcs.iterator();
			return new IteratorArc<>(itInterno);
		}
		return null;
	}

	//	while (itInterno.hasNext()) {
	// 	if (itInterno.next().getId().equals(vertexId)) {
	//         Vertex<T> vertex = this.getVertex(itInterno.next().getId());
	//         return vertex.getArcs();
	// 	}
	// }
	// return null;


	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs() {
        List<Arc<T>> finalList = new ArrayList<Arc<T>>();
        for (Vertex<T> vertex : vertexs) {
            List<Arc<T>> arcs = vertex.copyListArc();
            finalList.addAll(arcs);
        }
        return finalList.iterator();
    }

	// Complejidad computacional: O(v*a)
	// donde v es la cantidad de vértices que componen el grafo
	// y a la cantidad de arcos que posee el vértice
	@Override
	public Iterator<Arc<T>> getArcs(Integer vertexId) {
		for (Vertex<T> vertex : vertexs) {
			if (vertex.getId().equals(vertexId)) {
				List<Arc<T>> arcs = vertex.copyListArc();
				return arcs.iterator();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder("Vértices ");
		for (Vertex<T> vertex : vertexs) {
			out.append(vertex.toString());
		}
		return out.toString();
	}

	public ArrayList<Vertex<T>> copyListVertex() {
		return new ArrayList<Vertex<T>>(this.vertexs);
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
//@Override
//public Iterator<Arc<T>> getArcs() {
//    List<Arc<T>> finalList = new ArrayList<Arc<T>>();
//    for (Vertex<T> vertex : vertexs) {
//        List<Arc<T>> arcs = vertex.copyListArc();
//        finalList.addAll(arcs);
//    }
//    return finalList.iterator();
//		Iterator<Integer> itVertex = this.getVertex();
//		List<Arc<T>> arcs = new ArrayList<Arc<T>>();
//		Iterator<Arc<T>> itArc = arcs.iterator();
//		for (Vertex vertex : this.vertexs) {
//			arcs.addAll(vertex.getArcs());
//		}
//		while (itVertex.hasNext()) {
//			itVertex.next()
//		}
//		return itArc;
//}
/*@Override
	public Iterator<Integer> getAdyacent(Integer vertexId) {
		for (Vertex<T> vertex : this.vertexs) {
			if (vertex.getId().equals(vertexId))
				return vertex.getArcs();
		}
		return null;
	}
*/