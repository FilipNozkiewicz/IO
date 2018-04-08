import java.sql.Timestamp;
import java.util.ArrayList;

public class Parcel {
    public static ArrayList <Integer>  address = new ArrayList<Integer> (2);
    //współrzędna x,y
    int  driver; //numer kierowcy - po numerach będzie łatwiej niż po imionach?
    Timestamp order = new Timestamp(System.currentTimeMillis());


    public Parcel() {

    }

    public Parcel(int x, int y, int driver) {
        address.set(0, x);
        address.set(1, y);
        this.driver = driver;
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

    public static void setAddress(ArrayList<Integer> address) {
        Parcel.address = address;
    }
    
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        System.out.println(parcel.getX());

    }
}
