package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<T> {
    private Integer id;
    public ArrayList<Arc<T>> arcs;

    public Vertex(Integer id) {
        this.id = id;
        this.arcs = new ArrayList<>();
    }

    public Vertex() {}

    // Complejidad computacional: O(1)
    public void addArc(Arc<T> arc) {
        this.arcs.add(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public void deleteArc(Integer destination) {
        for (Arc<T> arc: arcs) {
            if (arc.getDestination().equals(destination))
                arcs.remove(arc);
        }
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public boolean containArc(Arc<T> arc) {
        return this.arcs.contains(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public Arc<T> getArc(Integer destination) {
        for (Arc<T> arc : arcs)
            if (arc.getDestination().equals(destination))
                return arc;
        return null;
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public Iterator<Integer> getArcs() {
        Iterator<Arc<T>> itInterno = this.arcs.iterator();
        return new IteratorArc<T>(itInterno);
    }

    public List<Arc<T>> copyListArc() {
        return new ArrayList<Arc<T>>(this.arcs);
    }
    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public Integer countArcs() {
       return arcs.size();
    }

    // Complejidad computacional: O(1)
    public void setId(Integer id) {
        this.id = id;
    }

    // Complejidad computacional: O(1)
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("\n---------------------\n" +
                "ID origen:" + this.getId() + "\n---------------------\n");
        for (Arc<T> arc : this.arcs) {
            out.append("\nID destino: ").append(arc.getDestination());
            out.append("\nKm: ").append(arc.getHashtag());
        }
        return String.valueOf(out);
    }
}
