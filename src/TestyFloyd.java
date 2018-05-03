import java.io.IOException;

public class TestyFloyd {


    public static void main(String[] args){


        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator();
        CheckInputData checkInputData = new CheckInputData();
        RouteGenerator parcels = new RouteGenerator();

        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();

        try {
            checkInputData.read("data.txt");
        } catch (IOException e) {
            System.out.println("there is no such a file");
        }
        checkInputData.separate();

        adjacentMatrixGenerator.adjacentGenerator(checkInputData.getHorizontal(), checkInputData.getVertical());
        int pion = checkInputData.getVertical().get(0).size();
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());

       // floyd_arraylist.print ( floyd_arraylist.Floyd ( adjacentMatrixGenerator.getAdjacent () ) );
            floyd_arraylist.print ( floyd_arraylist.infinity (  adjacentMatrixGenerator.getAdjacent () ));
            System.out.println ();
            floyd_arraylist.print ( floyd_arraylist.Floyd ( adjacentMatrixGenerator.getAdjacent () ) );
            System.out.println ();
    }
}
