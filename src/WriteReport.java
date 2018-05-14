import java.io.*;
import java.util.ArrayList;

public class WriteReport {
/*    public static void main(String[] args) {
        WriteReport writeReport = new WriteReport();
        try {
            writeReport.writingStringToFile("report.txt","line1");
            writeReport.writingStringToFile("report.txt","line2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(RouteGenerator routeGenerator, int numberOfElementsInRow, AdjacentMatrixGenerator adjacentMatrixGeneratorFloyd, AdjacentMatrixGenerator adjacentMatrixGeneratorDijkstra ){
        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        floyd_arraylist.startPath ( adjacentMatrixGeneratorFloyd.getAdjacent());
        ArrayList<ArrayList<Integer>> proper_matrix = floyd_arraylist.infinity ( adjacentMatrixGeneratorFloyd.getAdjacent () );

        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList ( adjacentMatrixGeneratorDijkstra.getAdjacent().size () );
        dijkstraSP_arrayList.Fulfill_Distance_Matrix ( adjacentMatrixGeneratorDijkstra.getAdjacent() );

        routeGenerator.generateParcelsNumbers(routeGenerator.getParcels(),numberOfElementsInRow);
        routeGenerator.writeParcels();

        System.out.println(routeGenerator.getParcelsNumber());
        System.out.print("Dijkstra => ");
        dijkstraSP_arrayList.choose_the_shortest ( routeGenerator.getParcelsNumber(), dijkstraSP_arrayList.Fulfill_Distance_Matrix ( adjacentMatrixGeneratorDijkstra.getAdjacent() ) , adjacentMatrixGeneratorDijkstra.getAdjacent() );
        System.out.print("Floyd => ");
        System.out.println(proper_matrix);
        floyd_arraylist.choose_the_shortest ( routeGenerator.getParcelsNumber() , floyd_arraylist.floyd ( proper_matrix ) );

    }
    public void writingStringToFile(String fileName, String content)
            throws IOException {
        FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
        fw.write(content + "\n");//appends the string to the file
        fw.close();
    }*/
}