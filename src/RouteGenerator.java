import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class  RouteGenerator {
    public  ArrayList<Parcel> parcels = new ArrayList<Parcel> ();
    Random random = new Random();
    Parcel parcel = new Parcel();
    Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
    String driverName;

    public Timestamp getOrder() {
        return order;
    }

    public String getDriverName() {
        return driverName;
    }

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public Parcel getParcel(ArrayList<Parcel> parcels) {
        for (Parcel parcel: parcels){
            return parcel;

        }
        return parcels.get(0);
    }

    public void generateParcels(int numberOfParcels, String name) {
        driverName = name;
        Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
        for(int i= 0; i < numberOfParcels ;i++){
            parcels.add(new Parcel());
        }
    }
    public void generateParcels(int numberOfParcels) {
        driverName = "Andrzej";
        Timestamp order = new Timestamp(System.currentTimeMillis()); //obecny czas
        for(int i= 0; i < numberOfParcels ;i++){
            parcels.add(new Parcel());
        }
    }
    public void writeParcels(){
       System.out.println(getOrder() + " " + getDriverName());
       for(Parcel parcel : parcels){
            System.out.println(parcel.getDescription());
       }
    }

        public static void main(String[] args) {
            RouteGenerator parcels = new RouteGenerator();
            int numberOfParcels = 3; //ustawie losowanie 5 paczek z myślą że losuje nowe w momencie gdy zjedzie
            parcels.generateParcels(numberOfParcels);
            parcels.writeParcels();
        }
    }

