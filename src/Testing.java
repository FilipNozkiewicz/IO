import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Testing {


    public static void main(String[] args) {
        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();
        RouteGenerator parcels = new RouteGenerator();

        try {
            checkInputData.read("data.txt");
        } catch (IOException e) {
            System.out.println("there is no such a file");
        }
        checkInputData.separate();

        adjacentMatrixGenerator.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());
        int pion = checkInputData.getVertical().get(0).size();
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());
        Dijkstra_Proper dijkstra_proper = new Dijkstra_Proper ();
        Dijkstra_Proper dijkstra_proper2 = new Dijkstra_Proper ();

        dijkstra_proper.dijkstra ( adjacentMatrixGenerator.getAdjacent() );
        int numberOfParcels = 3;
        parcels.generateParcels(numberOfParcels);
        parcels.writeParcels();

        dijkstra_proper2.calculateDistance ( pion, parcels.getParcels().get(0), adjacentMatrixGenerator.getAdjacent() );

        dijkstra_proper.print_distance ();
        dijkstra_proper.print_path ();
        dijkstra_proper2.print_distance ();
        dijkstra_proper2.print_path ();



    }
}
