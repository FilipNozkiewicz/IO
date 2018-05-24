import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class WriteReport {
    ArrayList<RouteGenerator> allRouteGenerators = new ArrayList<>();
    ArrayList<Integer> allHopCounts = new ArrayList<>();
    ArrayList<Integer> allRouteCosts = new ArrayList<>();
    ArrayList<Driver> drivers = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();


    public static void main(String[] args) {
        LoadRoute loadRoute = new LoadRoute ();
        ArrayList<RouteGenerator> routeGenerators = loadRoute.returnerOfRoutes("DataInputGroupWT1115.txt");
        WriteReport writeReport = new WriteReport();

        for(RouteGenerator rg : routeGenerators){
            writeReport.getAllRouteGenerators().add(rg);
        }
        writeReport.makeTimeList();
        writeReport.writeTimeToFile("report.txt");
        writeReport.makeDriversList();
        writeReport.writeDriversToFile("report.txt");
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<RouteGenerator> getAllRouteGenerators() {
        return allRouteGenerators;
    }
    public void writeDriversToFile(String fileName){
        String stringDriver;
        try {
            writingStringToFile(fileName, "Wykaz kierowców: ");
            for (Driver driver : drivers){
                stringDriver = "";
                stringDriver = driver.getName() + " ilość tras: " + driver.getHowManyTimesThereIs();
                writingStringToFile(fileName, stringDriver);
            }
            writingStringToFile(fileName, " ");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTimeToFile(String fileName){
        try {
            writingStringToFile(fileName, "Wszystkie daty: ");
            for(String date : dates) {
                    writingStringToFile(fileName, date);
            }
            writingStringToFile(fileName, " ");
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void makeTimeList(){
        Timestamp timestamp = new Timestamp(allRouteGenerators.get(1).order);
        dates.add(timestamp.toString().substring(0,10));
        for(RouteGenerator rg : allRouteGenerators) {
            timestamp = new Timestamp(rg.getOrder());
            String date = timestamp.toString().substring(0, 10);
            for (String s : dates) {
                if (!s.equals(date)) {
                    dates.add(date);
                }

            }
        }
    }


    public void makeDriversList(){
        for(RouteGenerator rg : allRouteGenerators){
            drivers.add(new Driver(rg.getDriverName(), 1));
        }
        for( int i = 0; i < drivers.size(); i++){
            for(int j = i + 1; j< drivers.size() - 1; j++){
                if (drivers.get(i).getName().equals(drivers.get(j).getName())) {
                    drivers.get(i).setHowManyTimesThereIs(drivers.get(i).getHowManyTimesThereIs()+1);
                    drivers.remove(j);
                }
            }
        }
    }

    public  int meanCreator(ArrayList<Integer> temp){
        int sum = 0;
        for (Integer i : temp){
            sum = sum + i;
        }
        return  sum/temp.size();
    }
    public void writingStringToFile(String fileName, String content)
            throws IOException {
        FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
        fw.write(content + "\n");//appends the string to the file
        fw.close();
    }

}