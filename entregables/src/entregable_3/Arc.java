package entregable_3;



/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */

public class Arc<T> {

	private Integer origin;
	private Integer destination;
	private T hashtag;

	public Arc(Integer origin, Integer destination, T hashtag) {
		this.origin = origin;
		this.destination = destination;
		this.hashtag = hashtag;
	}
	public Arc(Integer origin, Integer destination) {
		this.origin = origin;
		this.destination = destination;
	}
	public Arc() { }

	public void setVertexDestination(Integer destination) {
		this.destination = destination;
	}

	public void setHashtag(T hashtag) {
		this.hashtag = hashtag;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	public Integer getOrigin() {
		return origin;
	}
	
	public Integer getDestination() {
		return destination;
	}

	public T getHashtag() {
		return hashtag;
	}

	@Override
	public String toString() {
		return "\nID origen" + origin +
				"\nID destino" + destination +
				"\nEtiqueta: " + hashtag;
	}
}
