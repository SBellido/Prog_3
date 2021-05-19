package entregable_3;

import java.util.Iterator;

public interface Graph<T> {
	
	// Agrega un vertice 
	public void addVertex(int verticeId);

	// Borra un vertice
	public void deleteVertex(int verticeId);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void addArc(int verticeId1, int verticeId2, T etiqueta);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void deleteArc(int verticeId1, int verticeId2);

	// Verifica si existe un vertice
	public boolean containVertex(int verticeId);

	// Verifica si existe un arco entre dos vertices
	public boolean existArc(int verticeId1, int verticeId2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arc<T> getArc(int verticeId1, int verticeId2);

	// Devuelve la cantidad total de vertices en el grafo
	public int numberVertex();

	// Devuelve la cantidad total de arcos en el grafo
	public int numberArcs();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	public Iterator<Integer> getVertex();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Integer> getAdyacent(int vertexId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arc<T>> getArcs();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arc<T>> getArcs(int vertexId);
	
	
}
