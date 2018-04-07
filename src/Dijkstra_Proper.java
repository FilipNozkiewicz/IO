import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra_Proper {

    public ArrayList<Integer> distance;
    public ArrayList<Integer> visited;
    public ArrayList<Integer> path;

    Integer min , NextNode = 0;

    public void dijkstra (ArrayList<ArrayList<Integer>> matrix){

        Integer dlugosc = matrix.size();
        distance = new ArrayList<Integer> ( dlugosc );
        visited = new ArrayList<Integer> ( dlugosc );
        path = new ArrayList<Integer> ( dlugosc );

        for(int i = 0 ; i < dlugosc ; i++) {
            visited.add ( i, 0 );
            path.add ( i, 0 );
            distance.add ( i, 0 );
        }

      for(int i = 0 ; i < dlugosc ; i++){
            for(int j = 0 ; j < dlugosc ; j++){
              if(matrix.get ( i ).get ( j ) ==  (0)){
                  matrix.get ( i ).set ( j , 999);
              }
          }
      }
      for(int i = 0 ; i < dlugosc ; i++){
            distance.set ( i , matrix.get ( 0 ).get ( i ) );
      }


      distance.set ( 0 , 0 );
      visited.set ( 0,0 );

      for(int i = 0 ; i < dlugosc ; i++){
          min = 999;

          for(int j = 0 ; j < dlugosc ; j++){
              if(min > distance.get ( j ) && visited.get ( j ) != 1){
                  min = distance.get ( j );
                  NextNode = j;

              }
          }
          visited.set(NextNode , 1);

          for(int c = 0 ; c < dlugosc ; c++){
              if(visited.get ( c ) != 1){
                  Integer comp = matrix.get( NextNode ).get( c );
                  int value = (int)(comp + min);
                  if(value < distance.get ( c )){
                      distance.set(c , value);
                      path.set ( c , NextNode );
                  }
              }
          }
      }
        for(ArrayList<Integer> x  : matrix){  // dla kazeej arrraylisty w obiekcie ar
            for(int y : x){   // dla kazdego elementu tej arraylisty z poprzedniej petli
                // wypisanie za pomoaca petli for each bardzie wygodne tez zalecane :) :) :)

                System.out.print(y);
                System.out.print('\t');
            }
            System.out.println ();   // po kazdym wypisaniu wiersza nowa linia
        }
    }



    public void print_distance(){
        for(Integer x : distance){
            System.out.print ("|" + x );
        }
        System.out.print ("|");
    }
    public void print_path(){
        System.out.println ();
        for(int i = 0 ; i < path.size () ; i++){
            int j;
            System.out.println ("Path to vertex = " + i + " : ");
            j = i;

            do{
                j = path.get ( j );

                System.out.print (" ----> " + j);
            }while (j != 0);
            System.out.println ();

        }
    }



}
