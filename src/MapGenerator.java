import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {

    public static void main(String[] args) throws IOException { //wywalał mi w main więc wrzuciłem tu
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.generate();

    }

    private int placeLimit = 50; // żeby można było zmienić ilości by szybciej się zapisywał
    private int weight = 10;

    private Integer[][][] city = new Integer[placeLimit][placeLimit][2]; // miasta/ dwie wagi horyzontalne i vertykalne

    Random random = new Random();
    StringBuilder temp = new StringBuilder();

    public void generate() {
        for (int i = 0; i < placeLimit; i++) //poziom(x,/)
        {
            for (int j = 0; j < placeLimit; j++) // pionowo(/,y)
            {
                if (i == placeLimit - 1) { //chce uniknąć by kolumna 50 nie miała dalej na lewo nic
                    city[i][j][0] = 0; // brak wagi horyznotalnej na ostatniej kolumnie macierzy
                } else {
                    city[i][j][0] = 1 + random.nextInt(9);
                }
                if (j == placeLimit - 1) { //chce uniknąć by wiersz 50 nie miał dalej na dół nic
                    city[i][j][1] = 0;
                } else {
                    city[i][j][1] = 1 + random.nextInt(weight -1);
                }
                temp.append(city[i][j][0].toString()); //łącze pion z poziomem
                temp.append(city[i][j][1].toString());
                temp.append(" ");
                writeFile(temp.toString()); //zapis do pliku - możesz zmienić na czytelniejszy dla programu
            }
            writeFile("\n");
        }

    }

    public void writeFile(String text) { // dopisuje i tworzy plik
        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("coordinates.txt", true)); // to robi magie całą
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

