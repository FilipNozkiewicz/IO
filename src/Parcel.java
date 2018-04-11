import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class Parcel {
    public Coordinates  address = new Coordinates(); //współrzędna x,y

    Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
    int coordinatesX = 50;
    int coordinatesY = 50;

    public static ArrayList<Parcel> parcels = new ArrayList<Parcel> ();//współrzędna x,y

    Random random = new Random();

    public Parcel() { // randomowo tworzymy ze wszystkim
        int x = random.nextInt(coordinatesX);
        int y = random.nextInt(coordinatesX);
        address.setX(x);
        address.setY(y);
    }

    public Parcel(int x, int y) {
        address.setX(x);
        address.setY(y);
    }


    public Timestamp getOrder() {
        return order;
    }

    public String getDescription(){
        String coordinates = new String();
        coordinates = getOrder() +
                " Coordinates: ( " +
                address.getX() + (" , ") + address.getY() + (" )") ;
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
