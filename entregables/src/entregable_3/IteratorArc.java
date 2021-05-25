package entregable_3;

import java.util.Iterator;

public class IteratorArc<T> implements Iterator<Integer> {

    private final Iterator<Arc<T>> itArc;

    public IteratorArc(Iterator<Arc<T>> itIntern) {
        this.itArc = itIntern;
    }

    @Override
    public boolean hasNext() {
        return this.itArc.hasNext();
    }

    @Override
    public Integer next() {
        return this.itArc.next().getDestination();
    }
}
