import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class Parcel {
    public static ArrayList <Integer>  address = new ArrayList<Integer> (2); //współrzędna x,y
    int  driver; //numer kierowcy (1 do N) - po numerach będzie łatwiej niż po imionach
    Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
    int numberOfDrivers = 5; //ilość kierowców która u nas pracuje
    int coordinatesX = 50;
    int coordinatesY = 50;

    Random random = new Random();

    public Parcel() { // randomowo tworzymy ze wszystkim
        int x = random.nextInt(coordinatesX);
        int y = random.nextInt(coordinatesX);
        address.add(0, x);
        address.add(1, y);
        driver = random.nextInt(5) + 1;
    }

    public Parcel(int x, int y, int driver) { // teraz dodam taką by deklarować kierowce
        address.add(0, x);
        address.add(1, y);
        this.driver = driver;
    }
    public Parcel(int x, int y ) { // teraz dodam taką by go losowa
        address.add(0, x);
        address.add(1, y);
        driver = random.nextInt(numberOfDrivers) + 1;
    }

    public int getDriver() {
        return driver;
    }

    public Timestamp getOrder() {
        return order;
    }

    public static int getX() { // zwraca X
        try {
            return address.get(0);
        }catch (Exception e){
            System.out.println("Bład z współrzędnymi - zwracam X = 0");
            return 0;
        }
    }
    public static int getY() { //zwraca Y
        try {
            return address.get(1);
        }catch (Exception e){
            System.out.println("Bład z współrzędnymi - zwracam Y = 0");
            return 0;
        }
    }

    public String getDescription(){
        String coordinates = new String();
        coordinates = getOrder() +
                " Coordinates: ( " +
                getX() + (" , ") + getY() + (" )") +
                " Driver number: " + getDriver();
        return coordinates;
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        System.out.println(parcel.getDescription());

    }
}
