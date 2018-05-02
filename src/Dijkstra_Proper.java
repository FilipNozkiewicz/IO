import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra_Proper {

    public ArrayList<Integer> distance;
    public ArrayList<Integer> visited;
    public ArrayList<Integer> path;

    Integer min , NextNode = 0;

    public void dijkstra (ArrayList<ArrayList<Integer>> matrix){

        Integer size = matrix.size();
        distance = new ArrayList<Integer> ( size );
        visited = new ArrayList<Integer> ( size );
        path = new ArrayList<Integer> ( size );

        for(int i = 0 ; i < size ; i++) {
            visited.add ( i, 0 );
            path.add ( i, 0 );
            distance.add ( i, 0 );
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
              if(matrix.get ( i ).get ( j ) ==  (0)){
                  matrix.get ( i ).set ( j , 999);
              }
          }
        }
        for(int i = 0 ; i < size ; i++){
            distance.set ( i , matrix.get ( 0 ).get ( i ) );
        }

        distance.set ( 0 , 0 );
        visited.set ( 0, 0 );

         for(int i = 0 ; i < size ; i++){
             min = 999;
             for(int j = 0 ; j < size ; j++){
                 if(min > distance.get ( j ) && visited.get ( j ) != 1){
                     min = distance.get ( j );
                     NextNode = j;
                 }
             }
             visited.set(NextNode , 1);
             for(int c = 0 ; c < size ; c++){
                 if(visited.get ( c ) != 1){
                     Integer comp = matrix.get( NextNode ).get( c );
                     int value = (int)(comp + min);
                     if(value < distance.get ( c )) {
                         distance.set(c, value);
                         path.set(c, NextNode);
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
    public void calculateDistance(int x, Parcel parcel, ArrayList<ArrayList<Integer>> matrix){ //KURWA NIE WIEM CZY TO DOBRZE?!!?!?!?!

        Integer size = matrix.size();
        distance = new ArrayList<Integer> ( size );
        visited = new ArrayList<Integer> ( size );
        path = new ArrayList<Integer> ( size );

        for(int i = 0 ; i < size ; i++) {
            visited.add ( i, 0 );
            path.add ( i, 0 );
            distance.add ( i, 0 );
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(matrix.get ( i ).get ( j ) ==  (0)){
                    matrix.get ( i ).set ( j , 999);
                }
            }
        }
        for(int i = 0 ; i < size ; i++){
            distance.set ( i , matrix.get ( 0 ).get ( i ) );
        }
        int place = x * parcel.getY() + parcel.getX();
        distance.set(place, 0);
        visited.set (place , 0);

        for(int i = 0 ; i < size ; i++){
            min = 999;
            for(int j = 0 ; j < size ; j++){
                if(min > distance.get ( j ) && visited.get ( j ) != 1){
                    min = distance.get ( j );
                    NextNode = j;
                }
            }
            visited.set(NextNode , 1);
            for(int c = 0 ; c < size ; c++){
                if(visited.get ( c ) != 1){
                    Integer comp = matrix.get( NextNode ).get( c );
                    int value = (int)(comp + min);
                    if(value < distance.get ( c )) {
                        distance.set(c, value);
                        path.set(c, NextNode);
                    }
                }
            }
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
