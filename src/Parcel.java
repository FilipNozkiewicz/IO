import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcel {
    public Point address = new Point(); //współrzędna x,y

    int coordinatesX = 7;
    int coordinatesY = 4;

    public static ArrayList<Parcel> parcels = new ArrayList<Parcel>();//współrzędna x,y

    Random random = new Random();

    public Point getAddress() {
        return address;
    }

    public int getX() {
        return (int) getAddress().getX();
    }

    public int getY() {
        return (int) getAddress().getY();
    }

    public Parcel() { // randomowo tworzymy ze wszystkim
        int x = random.nextInt(coordinatesX);
        int y = random.nextInt(coordinatesY);
        address.setLocation(x, y);
        ;
    }

    public Parcel(int x, int y) {
        address.setLocation(x, y);
    }

    public String getDescription() {
        String coordinates;
        coordinates = " Coordinates: ( " +    // wlasciwy zapois wspolrzednych
                address.getX() + (" , ") + address.getY() + (" )");
        return coordinates;
    }

    public void generateParcels(int numberOfParcels) {
        for (int i = 0; i < numberOfParcels; i++) {
            parcels.add(new Parcel());
        }
    }

    public void writeParcels() {
        for (Parcel parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        System.out.println(parcel.getDescription());

    }
}
