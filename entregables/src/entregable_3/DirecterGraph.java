package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirecterGraph<T> implements Graph<T> {
	private List<Vertex> vertexs;

	public DirecterGraph() {
		this.vertexs = new ArrayList<>();
	}

	@Override
	public void addVertex(int vertexId) {
		Vertex vertex = new Vertex(vertexId);
		this.vertexs.add(vertex);
	}

	@Override
	public void deleteVertex(int vertexId) {
		//  Auto-generated method stub

	}

	@Override
	public void addArc(int vertexId1, int vertexId2, T hashtag) {
		Arc newArc = new Arc(vertexId1, vertexId2, hashtag);
		for (Vertex vertex : vertexs) {
			if (vertex.getId() == vertexId1) {
				vertex.addArc(newArc);
			}
		}
	}

	@Override
	public void deleteArc(int vertexId1, int vertexId2) {
		//  Auto-generated method stub

	}

	@Override
	public boolean containVertex(int vertexId) {
		for (Vertex vertex : vertexs)
			if (vertex.getId() == vertexId)
				return true;
		return false;
	}

	@Override
	public boolean existArc(int vertexId1, int vertexId2) {
		//  Auto-generated method stub
		return false;
	}

	@Override
	public Arc<T> getArc(int vertexId1, int vertexId2) {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public int numberVertex() {
		//  Auto-generated method stub
		return 0;
	}

	@Override
	public int numberArcs() {
		//  Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> getVertex() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> getAdyacent(int vertexId) {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arc<T>> getArcs() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arc<T>> getArcs(int vertexId) {
		//  Auto-generated method stub
		return null;
	}

}
