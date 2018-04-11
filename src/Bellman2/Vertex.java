package Bellman2;

import java.util.List;

public class Vertex {

    public int distance = 0;
    public Integer id;
    public boolean visited;
    public List<Edge> adjacenciesList;
    public double minDistance = Double.MAX_VALUE;  // beginning disatnce is infinite
    public Vertex previousVertex;

    public Vertex(Integer id) {
        this.id = id;
    }
}
