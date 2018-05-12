import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        AdjacentMatrixGenerator adjacentMatrixGeneratorFloyd = new AdjacentMatrixGenerator();
        AdjacentMatrixGenerator adjacentMatrixGeneratorDijkstra = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();

        try {
            checkInputData.read("data.txt");
        } catch (IOException e) {
            System.out.println("there is no such a file");
        }

        checkInputData.separate();
        int numberOfElementsInRow = checkInputData.getVertical().get(0).size();

        adjacentMatrixGeneratorFloyd.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());
        adjacentMatrixGeneratorDijkstra.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());

        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        floyd_arraylist.startPath ( adjacentMatrixGeneratorFloyd.getAdjacent());
        ArrayList<ArrayList<Integer>> proper_matrix = floyd_arraylist.infinity ( adjacentMatrixGeneratorFloyd.getAdjacent () );

        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList ( adjacentMatrixGeneratorDijkstra.getAdjacent().size () );
        dijkstraSP_arrayList.Fulfill_Distance_Matrix ( adjacentMatrixGeneratorDijkstra.getAdjacent() );

        String csvFile = "routes.txt";
        LoadRoute loadRoute = new LoadRoute ();
        Scanner scanner = new Scanner(new File (csvFile));
        ArrayList<RouteGenerator> routeGenerators= new ArrayList<>();


        while (scanner.hasNext()) {

            List<String> line = loadRoute.parseLine(scanner.nextLine());
            RouteGenerator temp = new RouteGenerator();
            temp.setOrder(line.get(0));
            temp.setDriverName(line.get(1));
            for (int i = 2; i <= 10; i+=2){
                temp.setParcel(new Parcel(Integer.parseInt(line.get(i)), Integer.parseInt(line.get(i+1))));
            }
            routeGenerators.add(temp);

        }

        scanner.close();
        for(RouteGenerator rg : routeGenerators){
            rg.generateParcelsNumbers(rg.getParcels(),numberOfElementsInRow);
            rg.writeParcels();
            System.out.println(rg.getParcelsNumber());
            System.out.print("Dijkstra => ");
            dijkstraSP_arrayList.choose_the_shortest ( rg.getParcelsNumber(), dijkstraSP_arrayList.Fulfill_Distance_Matrix ( adjacentMatrixGeneratorDijkstra.getAdjacent() ) , adjacentMatrixGeneratorDijkstra.getAdjacent() );
            System.out.print("Floyd => ");
            floyd_arraylist.choose_the_shortest ( rg.getParcelsNumber() , floyd_arraylist.floyd ( proper_matrix ) );


        }
    }
}
