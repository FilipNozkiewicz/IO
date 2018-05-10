import java.io.IOException;

public class TestyFloyd {


    public static void main(String[] args){


        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();
        RouteGenerator routeGenerator = new RouteGenerator();

        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();

        try {
            checkInputData.read("data.txt");
        } catch (IOException e) {
            System.out.println("there is no such a file");
        }
        checkInputData.separate();
        checkInputData.print_hor();
        System.out.println ();
        checkInputData.print_ver();
        System.out.println ();

        adjacentMatrixGenerator.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());

       // floyd_arraylist.print ( floyd_arraylist.Floyd ( adjacentMatrixGenerator.getAdjacent () ) );
        floyd_arraylist.startPath ( adjacentMatrixGenerator.getAdjacent().size());
        System.out.println ();
        System.out.println ("Macierz Sasiedztwa");
        floyd_arraylist.print ( floyd_arraylist.infinity (  adjacentMatrixGenerator.getAdjacent () ));
        System.out.println ("Macierz Odleglosci");
        floyd_arraylist.print ( floyd_arraylist.floyd ( adjacentMatrixGenerator.getAdjacent () ) );
        System.out.println ();
        System.out.println ("Macierz sciezek");
        floyd_arraylist.print ( floyd_arraylist.P );
        //floyd_arraylist.choose_the_shortest ( 6,12,8, floyd_arraylist.floyd ( adjacentMatrixGenerator.getAdjacent () ) );

        int numberOfElementsInRow = checkInputData.getVertical().get(0).size();
        routeGenerator.generateParcels(5, numberOfElementsInRow);
        routeGenerator.writeParcels();
        //routeGenerator.generateParcelsNumbers(routeGenerator.getParcels(), numberOfElementsInRow);
        System.out.println(routeGenerator.getParcelsNumber());
        floyd_arraylist.choose_the_shortest ( routeGenerator.getParcelsNumber(), floyd_arraylist.floyd ( adjacentMatrixGenerator.getAdjacent () ) );
    }
}
