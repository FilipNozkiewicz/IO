import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
 /*   public static void main(String[] args) throws FileNotFoundException {


        AdjacentMatrixGenerator adjacentMatrixGeneratorFloyd = new AdjacentMatrixGenerator();
        AdjacentMatrixGenerator adjacentMatrixGeneratorDijkstra = new AdjacentMatrixGenerator();
        AdjacentMatrixGenerator adjacentMatrixGeneratorBellman = new AdjacentMatrixGenerator();
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
        adjacentMatrixGeneratorBellman.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());

        //    Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        //    floyd_arraylist.startPath ( adjacentMatrixGeneratorFloyd.getAdjacent());
        //   ArrayList<ArrayList<Integer>> proper_matrix = floyd_arraylist.infinity ( adjacentMatrixGeneratorFloyd.getAdjacent () );


        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList (  );
        dijkstraSP_arrayList.Fulfill_Distance_Matrix (  );
        //    dijkstraSP_arrayList.print_paths ( dijkstraSP_arrayList.Path_Matrix );

        Floyyd floyyd = new Floyyd ();
        floyyd.floyd ( floyyd.conv_to_inf (  ) );
        floyyd.count_paths ();

        //    floyyd.print_paths ( floyyd.String_Path_Matrix );

        Bellman_Arraylist bellman_arraylist = new Bellman_Arraylist ();
        bellman_arraylist.aloc_main_matrix ( bellman_arraylist.infinity (  ) ) ;
        bellman_arraylist.aloc_patch_matrix ( bellman_arraylist.infinity (  ) ) ;
        //   bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );


        LoadRoute loadRoute = new LoadRoute ();
        ArrayList<RouteGenerator> routeGenerators = loadRoute.returnerOfRoutes("routes.txt");

        for(RouteGenerator rg : routeGenerators){
            //writeReport.write(rg,numberOfElementsInRow , adjacentMatrixGeneratorFloyd, adjacentMatrixGeneratorDijkstra);
            rg.generateParcelsNumbers(rg.getParcels(),numberOfElementsInRow);
            rg.writeParcels();
            System.out.println(rg.getParcelsNumber());
            System.out.print("Dijkstra => ");
            dijkstraSP_arrayList.choose_the_shortest ( numberOfElementsInRow, rg.getParcelsNumber(), dijkstraSP_arrayList.Fulfill_Distance_Matrix ( adjacentMatrixGeneratorDijkstra.getAdjacent() ) , adjacentMatrixGeneratorDijkstra.getAdjacent() );
            System.out.print("Floyd => ");
            //   floyd_arraylist.choose_the_shortest (numberOfElementsInRow, rg.getParcelsNumber() , floyd_arraylist.floyd ( proper_matrix ) );
            floyyd.choose_the_shortest ( numberOfElementsInRow , rg.getParcelsNumber () , floyyd.Distance_Matrix );
            System.out.print("Bellman => ");
            //   bellman_arraylist.aloc_main_matrix ( bellman_arraylist.infinity ( adjacentMatrixGeneratorBellman.getAdjacent () ) );  bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );
            bellman_arraylist.choose_the_shortest (numberOfElementsInRow, rg.getParcelsNumber() , bellman_arraylist.aloc_main_matrix ( adjacentMatrixGeneratorBellman.getAdjacent () )  );


        }
    }*/
}
