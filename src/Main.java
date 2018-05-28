import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        AdjacentMatrixGenerator adjacentMatrixGeneratorFloyd = new AdjacentMatrixGenerator();
        AdjacentMatrixGenerator adjacentMatrixGeneratorDijkstra = new AdjacentMatrixGenerator();
        AdjacentMatrixGenerator adjacentMatrixGeneratorBellman = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();
        ArraysGenerator arraysGenerator = new ArraysGenerator();
        arraysGenerator.write_to_file(20);
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
        long startTime, stopTime, floyd_time, dijkstra_time, bellman_time;


        startTime = System.currentTimeMillis();
        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList(adjacentMatrixGeneratorDijkstra.getAdjacent().size());
        dijkstraSP_arrayList.Fulfill_Distance_Matrix(adjacentMatrixGeneratorDijkstra.getAdjacent());
        //  dijkstraSP_arrayList.print_paths ( dijkstraSP_arrayList.Path_Matrix );
        // dijkstraSP_arrayList.print ( dijkstraSP_arrayList.Hop_Matrix );
        dijkstra_time = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Floyyd floyyd = new Floyyd();
        floyyd.floyd(floyyd.conv_to_inf(adjacentMatrixGeneratorFloyd.getAdjacent()));
        //floyyd.count_paths2 ();
        // floyyd.print ( floyyd.Path_Matrix );
        floyyd.count_paths();
        floyyd.counthop();
        floyd_time = System.currentTimeMillis() - startTime;

        //    floyyd.print_paths ( floyyd.String_Path_Matrix );
        startTime = System.currentTimeMillis();
        Bellman_Arraylist bellman_arraylist = new Bellman_Arraylist();
        ArrayList<ArrayList<Integer>> bel_matrix = bellman_arraylist.aloc_main_matrix(bellman_arraylist.infinity(adjacentMatrixGeneratorBellman.getAdjacent()));

        //   bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );
        bellman_time = System.currentTimeMillis() - startTime;

        LoadRoute loadRoute = new LoadRoute();
        ArrayList<RouteGenerator> routeGenerators = loadRoute.returnerOfRoutes("routes.txt");
        Integer counter = 0;
        ArrayList<ArrayList<Integer>> matrix_adj = adjacentMatrixGeneratorDijkstra.getAdjacent();
        ArrayList<ArrayList<Integer>> matrix_dist = dijkstraSP_arrayList.Fulfill_Distance_Matrix(matrix_adj);
        dijkstraSP_arrayList.SetHops(matrix_adj);
        WriteReport writeReport;

        Integer N = 0;
        Integer divider = 0;
        writeReport = new WriteReport(N);
        for (RouteGenerator rg : routeGenerators) {
            counter++;
            divider++;

            writeReport.getAllRouteCosts();
            writeReport.getAllRouteGenerators().add(rg);

            //     writeReport.write(rg,numberOfElementsInRow , adjacentMatrixGeneratorFloyd, adjacentMatrixGeneratorDijkstra);
            rg.generateParcelsNumbers(rg.getParcels(), numberOfElementsInRow);
            //   rg.writeParcels();
            //    System.out.println(rg.getParcelsNumber());
            //     System.out.print("Dijkstra => ");
            try {
                dijkstraSP_arrayList.choose_the_shortest(numberOfElementsInRow, rg.getParcelsNumber(), matrix_dist, matrix_adj);
            } catch (Exception e) {
                System.out.println("Bad Coordinates");
                System.exit(1);
            }
            // System.out.print("Floyd => ");
            try {
                floyyd.choose_the_shortest(numberOfElementsInRow, rg.getParcelsNumber(), floyyd.Distance_Matrix);
            } catch (Exception e) {
                System.out.println("Bad Coordinates");
                System.exit(1);
            }
            //    System.out.print("Bellman => ");
            //       // bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );
            try {
                bellman_arraylist.choose_the_shortest(numberOfElementsInRow, rg.getParcelsNumber(), bel_matrix);
            } catch (Exception e) {
                System.out.println("Bad Coordinates");
                System.exit(1);
            }
            if (counter % 100 == 0) {


                //   WriteReport write_real_report = new WriteReport (N);
                writeReport.makeTimeList();
                //     writeReport.writeTimeToFile("Main_Report.txt");
                writeReport.makeDriversList();
                writeReport.writeTimeToFile(N);
                writeReport.writeDriversToFile(N);

                writeReport.write_hop_dist_time(divider, dijkstraSP_arrayList.hop_sum, bellman_arraylist.hop_sum, floyyd.hop_sum
                        , dijkstraSP_arrayList.distance_sum, bellman_arraylist.distance_sum, floyyd.distance_sum, dijkstra_time, bellman_time, floyd_time, N);
                writeReport.write_time(dijkstra_time, bellman_time, floyd_time, N);

                N++;
                dijkstraSP_arrayList.hop_sum = 0;
                floyyd.hop_sum = 0;
                bellman_arraylist.hop_sum = 0;
                dijkstraSP_arrayList.distance_sum = 0;
                floyyd.distance_sum = 0;
                bellman_arraylist.distance_sum = 0;


                writeReport = new WriteReport(N);
                divider = 0;
            }


        }


    }
}
