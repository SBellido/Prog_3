package entregable_3;

import java.util.ArrayList;

public class Vertex {
    private Integer id;
    public ArrayList<Arc> arcs;

    public Vertex(Integer id) {
        this.id = id;
        this.arcs = new ArrayList<>();
    }

    public Vertex() {}

    // Complejidad computacional: O(1)
    public void addArc(Arc arc) {
        this.arcs.add(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public void deleteArc(Integer destination) {
        for (Arc arc: arcs)
            if (arc.getDestination() == destination)
                arcs.remove(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public boolean containArc(Arc arc) {
        return this.arcs.contains(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public Arc getArc(Integer origin, Integer destination) {
        if (this.getId().equals(origin)) {
            for (Arc arc : arcs)
                if (arc.getDestination().equals(destination))
                    return arc;
        }
        return null;
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public ArrayList<Arc> getArcs() {
        ArrayList<Arc> arcsCopy = new ArrayList<Arc>(this.arcs);
        return arcsCopy;
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


}
