import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class ParcelsGenerator {
    public static ArrayList<Parcel> parcels = new ArrayList<Parcel> ();//współrzędna x,y
    Random random = new Random();


    public void generateParcels(int numberOfParcels) {
        for(int i= 0; i < numberOfParcels ;i++){
            parcels.add(new Parcel());

        }
    }
        public void writeParcels(){
            for(Parcel parcel : parcels){
                System.out.println(parcel.getDescription());
            }
        }

        public static void main(String[] args) {
            ParcelsGenerator parcels = new ParcelsGenerator();
            int numberOfParcels = 5; //ustawie losowanie 5 paczek z myślą że losuje nowe w momencie gdy zjedzie
            parcels.generateParcels(numberOfParcels);
            parcels.writeParcels();
            System.out.println();
            parcels.generateParcels(numberOfParcels);
            parcels.writeParcels();

        }
    }

