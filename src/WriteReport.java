import java.io.*;
import java.util.ArrayList;

public class WriteReport {
    ArrayList<RouteGenerator> allRouteGenerators = new ArrayList<>();
    ArrayList<Integer> allHopCounts = new ArrayList<>();
    ArrayList<Integer> allRouteCosts = new ArrayList<>();
    ArrayList<Driver> drivers = new ArrayList<>();
    int meanHopCounts, meanRouteCosts;


    public static void main(String[] args) {
        LoadRoute loadRoute = new LoadRoute ();
        ArrayList<RouteGenerator> routeGenerators = loadRoute.returnerOfRoutes("DataInputGroupWT1115.txt");
        WriteReport writeReport = new WriteReport();

        int i = 0;
        for(RouteGenerator rg : routeGenerators){
            writeReport.getAllRouteGenerators().add(rg);
        }
        System.out.println( writeReport.getDrivers().size());
        writeReport.makeDriversList();

        try {
            writeReport.writingStringToFile("report.txt","xxx");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<RouteGenerator> getAllRouteGenerators() {
        return allRouteGenerators;
    }


    public void makeDriversList(){
            for(RouteGenerator rg : allRouteGenerators){
                drivers.add(new Driver(rg.getDriverName(), 1));
            }
            for( int i = 0; i < drivers.size(); i++){
                for(int j = i + 1; j< drivers.size() - 1; j++){
                    if (drivers.get(i).getName().equals(drivers.get(j).getName())){
                        drivers.remove(i);
                    }
                }
            }
            System.out.println( getDrivers().size());
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