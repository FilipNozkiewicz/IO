import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class WriteReport {
    ArrayList<RouteGenerator> allRouteGenerators = new ArrayList<>();
    ArrayList<Integer> allHopCounts = new ArrayList<>();
    ArrayList<Integer> allRouteCosts = new ArrayList<>();
    ArrayList<Driver> drivers = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();


    public static void main(String[] args) {
        LoadRoute loadRoute = new LoadRoute();
        ArrayList<RouteGenerator> routeGenerators = loadRoute.returnerOfRoutes("DataInputGroupWT1115.txt");
        WriteReport writeReport = new WriteReport(33);

        for (RouteGenerator rg : routeGenerators) {
            writeReport.getAllRouteGenerators().add(rg);
            writeReport.getAllHopCounts().add(3);
            writeReport.getAllRouteCosts().add(3);
        }
        writeReport.makeTimeList();
        writeReport.makeDriversList();
        writeReport.writeDriversToFile(33);
        writeReport.writeHopsRoutesToFile("report.txt", "dijkstra");
    }

    public void writeHopsRoutesToFile(String fileName, String algType) {
        Integer hops = meanCreator(allHopCounts);
        Integer cost = meanCreator(allRouteCosts);

        try {
            writingStringToFile(fileName, "Sredni czas dla " + algType + ":");
            writingStringToFile(fileName, cost.toString());
            writingStringToFile(fileName, "Srednia długość dla " + algType + ":");
            writingStringToFile(fileName, hops.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RouteGenerator> getAllRouteGenerators() {
        return allRouteGenerators;
    }

    public ArrayList<Integer> getAllHopCounts() {
        return allHopCounts;
    }

    public ArrayList<Integer> getAllRouteCosts() {
        return allRouteCosts;
    }

    public void writeDriversToFile(Integer N) {
        String fileName = "Main_Report_" + N.toString() + ".txt";
        String stringDriver;
        try {
            writingStringToFile(fileName, "\nDrivers List: ");
            for (Driver driver : drivers) {
                stringDriver = "";
                stringDriver = driver.getName() + " routes number: " + driver.getHowManyTimesThereIs();
                writingStringToFile(fileName, stringDriver);
            }
            writingStringToFile(fileName, " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTimeToFile(Integer N) {
        String file_name = "Main_Report_" + N.toString() + ".txt";
        try {
            //     writingStringToFile(fileName, "Wszystkie daty: ");
            FileWrite.writefile("\nAll the dates\n", file_name);
            for (String date : dates) {
                //         writingStringToFile(fileName, date);
                FileWrite.writefile(date, file_name);
            }
            //   writingStringToFile(fileName, " ");
            FileWrite.writefile("\n", file_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTimeList() {
        Timestamp timestamp = new Timestamp(allRouteGenerators.get(1).order);
        dates.add(timestamp.toString().substring(0, 10));
        for (RouteGenerator rg : allRouteGenerators) {
            timestamp = new Timestamp(rg.getOrder());
            String date = timestamp.toString().substring(0, 10);
            for (String s : dates) {
                if (!s.equals(date)) {
                    dates.add(date);
                }

            }
        }
    }

    public void write_paths(Integer N, ArrayList<ArrayList<String>> S) {

        // String file_name = "Main_Report_" + N.toString () + ".txt";
        //  FileWrite.writefile (  , file_name );
    }


    public void makeDriversList() {
        for (RouteGenerator rg : allRouteGenerators) {
            drivers.add(new Driver(rg.getDriverName(), 1));
        }
        for (int i = 0; i < drivers.size(); i++) {
            for (int j = i + 1; j < drivers.size() - 1; j++) {
                if (drivers.get(i).getName().equals(drivers.get(j).getName())) {
                    drivers.get(i).setHowManyTimesThereIs(drivers.get(i).getHowManyTimesThereIs() + 1);
                    drivers.remove(j);
                }
            }
        }
    }

    public int meanCreator(ArrayList<Integer> temp) {
        int sum = 0;
        for (Integer i : temp) {
            sum = sum + i;
        }
        return sum / temp.size();
    }

    public void writingStringToFile(String fileName, String content)
            throws IOException {
        FileWriter fw = new FileWriter(fileName, true); //the true will append the new data
        fw.write(content + "\n");//appends the string to the file
        fw.close();
    }

    public String file_name;

    public WriteReport(Integer N) {
        this.file_name = "Main_Report_" + N.toString() + ".txt";
        try {
            CleanFile.clean(file_name);
        } catch (Exception e) {
            System.out.println("There is no such a file");
        }
        FileWrite.writefile("------------------------------------------------MAIN REPORT --------------------------------------------------------------------", file_name);
    }

    public void write_hop_dist_time(Integer counter, Integer hop_dikstra, Integer hop_bellman, Integer hop_floyyd,
                                    Integer dis_dijkstra, Integer dis_bellman, Integer dis_floyd, long time_dijkstra, long time_belllman, long time_floyd, Integer N) throws FileNotFoundException {

        String file_name = "Main_Report_" + N.toString() + ".txt";
        FileWrite.writefile("|Floyd|", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_floyd / counter + " " + "\nAverage Hop Count: " + hop_floyyd / counter, file_name);
        FileWrite.writefile("\n", file_name);
        //   FileWrite.writefile (  "Time for Alghorithm: " + time_floyd + " miliseconds" , file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

        FileWrite.writefile("Dijkstra", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_dijkstra / counter + " " + "\nAverage Hop Count: " + hop_dikstra / counter, file_name);
        FileWrite.writefile("\n", file_name);
        // FileWrite.writefile (  "Time for Alghorithm: " + time_dijkstra + " miliseconds" , file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

        FileWrite.writefile("Bellman-Ford", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_bellman / counter + " " + "\nAverage Hop Count: " + hop_bellman / counter, file_name);
        FileWrite.writefile("\n", file_name);
        //FileWrite.writefile (  "Time for Alghorithm: " + time_belllman + " miliseconds" , file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

    }

    public void write_time(long dijkstra, long bellman, long floyd, Integer N) {

        String file_name = "Main_Report_" + N.toString() + ".txt";
        FileWrite.writefile("Floyd\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + floyd + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Dijkstra\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + dijkstra + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Bellman\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + bellman + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
    }

}

