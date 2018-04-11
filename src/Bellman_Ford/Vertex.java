package Bellman_Ford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Edge> adjacenciesList;
    private double minDistance = Double.MAX_VALUE;  // beginning disatnce is infinite
    private Vertex previousVertex;

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<> ();
    }
    public void addNeighbour(Edge edge){
        this.adjacenciesList.add ( edge );
    }

    public void addEdge(Edge edge) {
        this.adjacenciesList.add ( edge );   // add new edge to adjacentList
    }
////////////////////////// GETTERS ////////////////////////////////////
    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public List<Edge> getAdjacenciesList() {

        return adjacenciesList;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }
    //////////////////////////////////////SETTERS ////////////////////////////////////////////

    @Override
    public String toString() {
        return this.name;
    }
}
//// auto format crtl + alt + l