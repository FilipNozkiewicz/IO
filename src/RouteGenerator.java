

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class  RouteGenerator {
    public  ArrayList<Parcel> parcels = new ArrayList<Parcel> ();
    public ArrayList<Integer> parcelsNumber= new ArrayList<>();
    Random random = new Random();
    Parcel parcel = new Parcel();
    long order = System.currentTimeMillis(); //obecny czas
    String driverName;

    public long getOrder() {
        return order;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setParcels(ArrayList<Parcel> parcels) {
        this.parcels = parcels;
    }


    public void setParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    public void setOrder(long order) {
        this.order = order;
    }
    public void setOrder(String order) {
        try {
            Long temp = Long.parseLong(order);
            this.order  = temp;
        }catch (NumberFormatException e){
            System.out.println("WTF BRO coś jest nie tak z setOrder w RouteGenerator krzaczy tylko przy pierwszym");
        }
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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
        for(int i= 0; i < numberOfParcels ;i++){
            parcels.add(new Parcel());
        }
    }
    public void generateParcels(int numberOfParcels) {
        driverName = "Andrzej";
        for(int i= 0; i < numberOfParcels ;i++){
            parcels.add(new Parcel());
        }
    }
    public void generateParcels(int numberOfParcels, int numberOfElementsInRow) {
        driverName = "Andrzej";
        for(int i= 0; i < numberOfParcels ;i++){
            parcel = new Parcel();
            parcels.add(parcel);
            parcelsNumber.add( numberOfElementsInRow * parcel.getY() + parcel.getX());
        }
    }
    public  void generateParcelsNumbers(ArrayList<Parcel> parcels, int numberOfElementsInRow){
        for (Parcel parcel : parcels)
            parcelsNumber.add( numberOfElementsInRow * parcel.getY() + parcel.getX());
    }

    public ArrayList<Integer> getParcelsNumber() {
        return parcelsNumber;
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

