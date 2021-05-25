package entregable_3;

import java.util.Iterator;

public class IteratorVertex<T> implements Iterator<Integer> {

    private final Iterator<Vertex<T>> itVertex;

    public IteratorVertex(Iterator<Vertex<T>> itIntern) {
        this.itVertex = itIntern;
    }

    @Override
    public boolean hasNext() {
        return this.itVertex.hasNext();
    }

    @Override
    public Integer next() {
        return this.itVertex.next().getId();
    }
}
