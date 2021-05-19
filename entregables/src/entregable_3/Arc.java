package entregable_3;


/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arc<T> {

	private int vertexOrigin;
	private int vertexDestination;
	private T hashtag;

	public Arc(int vertexOrigin, int vertexDestination, T hashtag) {
		this.vertexOrigin = vertexOrigin;
		this.vertexDestination = vertexDestination;
		this.hashtag = hashtag;
	}
	public Arc() { }


	public void setVertexDestination(int vertexDestination) {
		this.vertexDestination = vertexDestination;
	}

	public void setHashtag(T hashtag) {
		this.hashtag = hashtag;
	}

	public void setVertexOrigin(int vertexOrigin) {
		this.vertexOrigin = vertexOrigin;
	}

	public int getVertexOrigin() {
		return vertexOrigin;
	}
	
	public int getVertexDestination() {
		return vertexDestination;
	}

	public T getHashtag() {
		return hashtag;
	}

}
