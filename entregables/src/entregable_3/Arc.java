package entregable_3;


/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arc<T> {

	private int origin;
	private int destination;
	private T hashtag;

	public Arc(int origin, int destination, T hashtag) {
		this.origin = origin;
		this.destination = destination;
		this.hashtag = hashtag;
	}
	public Arc(int origin, int destination) {
		this.origin = origin;
		this.destination = destination;
	}
	public Arc() { }

	public void setVertexDestination(int destination) {
		this.destination = destination;
	}

	public void setHashtag(T hashtag) {
		this.hashtag = hashtag;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getOrigin() {
		return origin;
	}
	
	public int getDestination() {
		return destination;
	}

	public T getHashtag() {
		return hashtag;
	}

}
