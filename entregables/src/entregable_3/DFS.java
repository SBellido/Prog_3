package entregable_3;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	
	private Graph<?> graph;
	private HashMap<Integer,String> colors;
	private int time;
	private HashMap<Integer,Integer> discovery;
	private HashMap<Integer,Integer> ending;

	public DFS(Graph<?> graph) {
		this.graph = graph;
		this.colors = new HashMap<>();
		this.discovery = new HashMap<>();
		this.ending = new HashMap<>();
		this.time = 0;
	}
	
	public void dfs() {
		
		Iterator<Integer> it = this.graph.getVertex();
		while (it.hasNext()) {
			int vertexId = it.next();
			colors.put(vertexId, "white");
		}
		this.time = 0;
		
		it = this.graph.getVertex();
		while (it.hasNext()) {
			int vertexId = it.next();
			if (colors.get(vertexId).equals("white"))
				dfs_visit(vertexId);
		}
		
	}
	
	public void dfs_visit(int vertex) {
		
		colors.put(vertex, "amarillo");
		time += 1;
		discovery.put(vertex, time);
		
		Iterator<Integer> it = this.graph.getAdyacent(vertex);
		while(it.hasNext()) {
			int adyacent = it.next();
			if (colors.get(adyacent).equals("white"))
				dfs_visit(adyacent);
		}
		
		colors.put(vertex, "black");
		time += 1;
		ending.put(vertex, time);
		
	}
	

}
