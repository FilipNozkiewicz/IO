import java.io.IOException;

public class Main_Dijkstra {

    public static void main(String[] args) {

        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();
        RouteGenerator routeGenerator = new RouteGenerator();


        try {
            checkInputData.read("data.txt");
        } catch (IOException e) {
            System.out.println("there is no such a file");
        }

        checkInputData.separate();
        checkInputData.print_hor();
        System.out.println();
        checkInputData.print_ver();
        System.out.println();

        adjacentMatrixGenerator.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());
        //  adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());
        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList(adjacentMatrixGenerator.getAdjacent().size());
        System.out.println("Macierz Sasiedztwa");
        //dijkstraSP_arrayList.print ( adjacentMatrixGenerator.adjacent );
        System.out.println("Macierz Sciezek");
        dijkstraSP_arrayList.print(dijkstraSP_arrayList.Fulfill_Distance_Matrix(adjacentMatrixGenerator.getAdjacent()));
        System.out.println("Hop Matrix");
        //dijkstraSP_arrayList.print( dijkstraSP_arrayList.Hop_Matrix );
        System.out.println("Matrix Sciezek");
        //try {
        // dijkstraSP_arrayList.print_paths ( dijkstraSP_arrayList.Path_Matrix );   // Moze lepiej nie bo jest jebutna :)
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace ();
        //}

        int numberOfElementsInRow = checkInputData.getVertical().get(0).size();
        routeGenerator.generateParcels(5, numberOfElementsInRow);
        routeGenerator.writeParcels();

        System.out.println(routeGenerator.getParcelsNumber());

        System.out.println();
        dijkstraSP_arrayList.choose_the_shortest(routeGenerator.getParcelsNumber(), dijkstraSP_arrayList.Fulfill_Distance_Matrix(adjacentMatrixGenerator.getAdjacent()), adjacentMatrixGenerator.getAdjacent());


    }
}
