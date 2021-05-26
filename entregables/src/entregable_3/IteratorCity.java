package entregable_3;

import java.util.Iterator;

public class IteratorCity<Integer> implements Iterator<Integer> {

    private final Iterator<City> itCity;

    public IteratorCity(Iterator<City> itCity) {
        this.itCity = itCity;
    }

    @Override
    public boolean hasNext() {
        return this.itCity.hasNext();
    }

    @Override
    public Integer next() {
        return (Integer) this.itCity.next().getId();
    }
}