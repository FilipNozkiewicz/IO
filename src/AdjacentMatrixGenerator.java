import java.util.ArrayList;
import java.util.Random;

public class AdjacentMatrixGenerator {
    // zasada jest taka ze tworze arrayliste arraylist i daje jej jakis typ zmiennej
    public ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>(); // miasta/ vertykalne



    public void adjacentGenerator(ArrayList<ArrayList<Integer>> hor , ArrayList<ArrayList<Integer>> ver){
        int numberOfNeighbors = hor.size() * ver.size(); //kwadrat maxiery, wielkosc sasiedztwa
        int jump = hor.size();
        for(int i = 0 ; i < numberOfNeighbors; i++ ){
            adjacent.add ( i , new ArrayList<Integer>() );  // dodajemy te arraylisty
            for(int j = 0 ; j < numberOfNeighbors ; j++ ){// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                adjacent.get(i).add(j, 0); // chce wypełnić zerami macierz sąsiedztwa NxN - działa
            }
        }
        for(int i = 0 ; i < numberOfNeighbors; i++ ){
            for(int j = 0 ; j < numberOfNeighbors ; j++ ){// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                if(j == i && (j < numberOfNeighbors -2)){ // chce przesunąć j o jeden do przodu i wypełnić kolejnymi Horyzontalnymi
                    adjacent.get(i).set(j+1,2);
                }
                if(j == i && (i < numberOfNeighbors -2)){ // chce przesunąć i o jeden do przodu i wypełnić kolejnymi Vertykalnymi
                    adjacent.get(i+1).set(j,2);
                }
                if(j == i && (j < numberOfNeighbors - jump -1)){ // chce przesunąć j o skok czyli cały rząd do przodu i wypełnić kolejnymi Horyzontalnymi
                    adjacent.get(i).set(j + jump,3);
                }
                if(j == i && (i < numberOfNeighbors - jump - 1)){ // chce przesunąć i o skok czyli cały rząd jeden do przodu i wypełnić kolejnymi Vertykalnymi
                    adjacent.get(i + jump).set(j,3);
                }
            }
        }

    }
    public void print(ArrayList<ArrayList<Integer>> temp){
        for(ArrayList<Integer> x  : temp){  // dla kazeej arrraylisty w obiekcie ar
            for(int y : x){   // dla kazdego elementu tej arraylisty z poprzedniej petli
                // wypisanie za pomoaca petli for each bardzie wygodne tez zalecane :) :) :)

                System.out.print(y);
            }
            System.out.println ();   // po kazdym wypisaniu wiersza nowa linia
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjacent() {
        return adjacent;
    }

    public static void main(String[] args){

        ArraysGenerator arraysGenerator = new ArraysGenerator ();
        int placeLimit = 3; // żeby można było zmienić ilości by szybciej się zapisywał
        arraysGenerator.matrix ( placeLimit,placeLimit );
        arraysGenerator.print(arraysGenerator.getHorizonatal());
        System.out.println();
        arraysGenerator.print(arraysGenerator.getVertical());
        System.out.println();


        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator();
        adjacentMatrixGenerator.adjacentGenerator(arraysGenerator.getHorizonatal(),arraysGenerator.getVertical());
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());
    }
}
