package entregable_3;

import java.util.ArrayList;
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

    public void addArc(Arc arc) {
        this.arcs.add(arc);
    }
    public Vertex() {
        this.vertexs = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }


}
