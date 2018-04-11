package Bellman2;

public class Edge {
    public Vertex start;
    public Vertex finish;
    public Integer value;

    public Edge(Vertex start, Vertex finish , Integer value) {
        this.start = start;
        this.finish = finish;
        this.value = value;
    }
}
