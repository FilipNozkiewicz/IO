import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ArraysGenerator {
    // to jest przyklad uzycia arraylist do macierzy
    // uwazam ze to jest lepszy sposob bo maja one o wiele wiecej mozliwosci
    // do edycji i ogolnie do dostepnosci elemntow niz zwykle tabice
    public ArrayList<ArrayList<Integer>> horizonatal = new ArrayList<ArrayList<Integer>>(); // miasta/  horyzontalne
    public ArrayList<ArrayList<Integer>> vertical = new ArrayList<ArrayList<Integer>>(); // miasta/ vertykalne
    // zasada jest taka ze tworze arrayliste arraylist i daje jej jakis typ zmiennej

    public  static Random random = new Random (  );
    private int weight = 9;


    public void matrix(int a , int b){
        // macierz tworze normalnie w petli
        for(int i = 0 ; i < a; i++ ){
            horizonatal.add ( i , new ArrayList<Integer>() );  // wazme jest zeby za kazda iteracja dodac nowa arayliste
            vertical.add ( i , new ArrayList<Integer>() );
            for(int j = 0 ; j < b ; j++ ) {
                if (j == a - 1) {
                    horizonatal.get(i).add(j, 0);// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                } else{
                    horizonatal.get(i).add(j, random.nextInt(weight) + 1);// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                }
                if (i == a - 1) {
                    vertical.get(i).add(j, 0);// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                } else{
                    vertical.get(i).add(j, random.nextInt(weight)+ 1);;// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getHorizonatal() {
        return horizonatal;
    }

    public ArrayList<ArrayList<Integer>> getVertical() {
        return vertical;
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
    public void writeFile(String text) { // dopisuje i tworzy plik, działa - ale nie używamy narazie albo wcale
        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("coordinates.txt", true)); // to robi magie całą
            writer.flush();
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        ArraysGenerator arraysGenerator = new ArraysGenerator ();
        int placeLimit = 50; // żeby można było zmienić ilości by szybciej się zapisywał
        arraysGenerator.matrix ( placeLimit,placeLimit );
        arraysGenerator.print (arraysGenerator.getHorizonatal());

    }
}
