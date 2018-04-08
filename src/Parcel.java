import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class Parcel {
    public Coordinates  address = new Coordinates(); //współrzędna x,y
    int  driver; //numer kierowcy (1 do N) - po numerach będzie łatwiej niż po imionach
    Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
    int numberOfDrivers = 3; //ilość kierowców która u nas pracuje
    int coordinatesX = 50;
    int coordinatesY = 50;

    public static ArrayList<Parcel> parcels = new ArrayList<Parcel> ();//współrzędna x,y
    int numberOfParcels = 5; //ustawie losowanie 5 paczek z myślą że losuje nowe w momencie gdy zjedzie

    Random random = new Random();

    public Parcel() { // randomowo tworzymy ze wszystkim
        int x = random.nextInt(coordinatesX);
        int y = random.nextInt(coordinatesX);
        address.setX(x);
        address.setY(y);
        driver = random.nextInt(numberOfDrivers) + 1;
    }

    public Parcel(int x, int y, int driver) { // teraz dodam taką by deklarować kierowce
        address.setX(x);
        address.setY(y);
        this.driver = driver;
    }
    public Parcel(int x, int y ) { // teraz dodam taką by go losowa
        address.setX(x);
        address.setY(y);
        driver = random.nextInt(numberOfDrivers) + 1;
    }

    public int getDriver() {
        return driver;
    }

    public Timestamp getOrder() {
        return order;
    }

    public String getDescription(){
        String coordinates = new String();
        coordinates = getOrder() +
                " Coordinates: ( " +
                address.getX() + (" , ") + address.getY() + (" )") +
                " Driver number: " + getDriver();
        return coordinates;
    }

    public void generateParcels(int numberOfParcels) {
        for(int i= 0; i < numberOfParcels ;i++) {
            parcels.add(new Parcel());
        }
    }
    public void writeParcels(){
        for(Parcel parcel : parcels){
            System.out.println(parcel.getDescription());
        }
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        System.out.println(parcel.getDescription());

    }
}
