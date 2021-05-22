package entregable_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex {
    private Integer id;
    private List<Integer> vertexs;
    private List<Arc> arcs;

    public Vertex(Integer id) {
        this.id = id;
        this.vertexs = new ArrayList<>();
        this.arcs = new ArrayList<>();
    }

    // Complejidad computacional: O(1)
    public void addArc(Arc arc) {
        this.arcs.add(arc);
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public void deleteArc(int destination) {
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
    public Arc getArc(int origin, int destination) {
        if (this.getId() == origin) {
            for (Arc arc : arcs)
                if (arc.getDestination() == destination)
                    return arc;
        }
        return null;
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public List<Arc> getArcs() {
        List<Arc> arcsCopy = new ArrayList<>();
        arcsCopy.addAll(this.arcs);
        return arcsCopy;
    }

    // Complejidad computacional: O(a)
    // donde a es la cantidad de arcos que posee el vértice
    public int countArcs() {
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
