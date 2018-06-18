import java.io.IOException;
import java.util.ArrayList;

// Klasa poczatkowa zawiera instrukcje dzialan macierzowych z uzyciem ArrayListy

public class AdjacentMatrixGenerator {
    // zasada jest taka ze tworze arrayliste arraylist i daje jej jakis typ zmiennej
    private ArrayList<ArrayList<Integer>> adjacent = new ArrayList<ArrayList<Integer>>(); // miasta/ vertykalne


    public void adjacentGenerator(ArrayList<ArrayList<Integer>> hor, ArrayList<ArrayList<Integer>> ver) {
        int numberOfNeighbors = 0;
        int matrixSize = hor.size() + ver.size() - 1;

        if (matrixSize % 2 == 0) {
            numberOfNeighbors = (matrixSize * matrixSize / 2); //kwadrat maxiery, wielkosc sasiedztwa
        } else {
            numberOfNeighbors = matrixSize * (matrixSize - (int) (matrixSize / 2));
        }

        int jump = hor.get(1).size();
        for (int i = 0; i < numberOfNeighbors; i++) {
            adjacent.add(i, new ArrayList<Integer>());  // dodajemy te arraylisty
            for (int j = 0; j < numberOfNeighbors; j++) {// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                adjacent.get(i).add(j, 0); // chce wypełnić zerami macierz sąsiedztwa NxN - działa
            }
        }
        int hx = 0;
        int ihx;
        int jhx;
        int hy = 0;
        int ihy;
        int jhy;
        int vx = 0;
        int ivx;
        int jvx;
        int vy = 0;
        int ivy;
        int jvy;

        for (int i = 0; i < numberOfNeighbors; i++) {
            for (int j = 0; j < numberOfNeighbors; j++) {// nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
                if (j == i && (j < numberOfNeighbors - 1)) { // chce przesunąć j o jeden do przodu i wypełnić kolejnymi Horyzontalnymi
                    hx++;
                    ihx = (hx - 1) % jump;
                    jhx = (int) (hx - 1) / jump;

                    adjacent.get(i).set(j + 1, hor.get(jhx).get(ihx));
                }
                if (j == i && (i < numberOfNeighbors - 1)) { // chce przesunąć i o jeden do przodu i wypełnić kolejnymi Vertykalnymi
                    hy++;
                    ihy = (hy - 1) % jump;
                    jhy = (int) (hy - 1) / jump;

                    adjacent.get(i + 1).set(j, hor.get(jhy).get(ihy));
                }
                if (j == i && (j < numberOfNeighbors - jump)) { // chce przesunąć j o skok czyli cały rząd do przodu i wypełnić kolejnymi Horyzontalnymi
                    vx++;
                    ivx = (vx - 1) % jump;
                    jvx = (int) (vx - 1) / jump;

                    adjacent.get(i).set(j + jump, ver.get(jvx).get(ivx));

                }
                if (j == i && (i < numberOfNeighbors - jump)) { // chce przesunąć i o skok czyli cały rząd jeden do przodu i wypełnić kolejnymi Vertykalnymi
                    vy++;
                    ivy = (vy - 1) % jump;
                    jvy = (int) (vy - 1) / jump;

                    adjacent.get(i + jump).set(j, ver.get(jvy).get(ivy));
                }
            }
        }
    }

    public void print(ArrayList<ArrayList<Integer>> temp) {
        for (ArrayList<Integer> x : temp) {  // dla kazeej arrraylisty w obiekcie ar
            for (int y : x) {   // dla kazdego elementu tej arraylisty z poprzedniej petli
                // wypisanie za pomoaca petli for each bardzie wygodne tez zalecane :) :) :)

                System.out.print(y);
            }
            System.out.println();   // po kazdym wypisaniu wiersza nowa linia
        }
    }


    public ArrayList<ArrayList<Integer>> getAdjacent() {
        return adjacent;
    }
}
