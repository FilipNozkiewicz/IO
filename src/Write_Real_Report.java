import java.io.FileNotFoundException;

public class Write_Real_Report {


    public String file_name = "Main_Report.txt";

    public void write_hop_dist_time(Integer counter, Integer hop_dikstra, Integer hop_bellman, Integer hop_floyyd,
                                    Integer dis_dijkstra, Integer dis_bellman, Integer dis_floyd, long time_dijkstra, long time_belllman, long time_floyd) throws FileNotFoundException {

        FileWrite.writefile("|Floyd|", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_floyd / counter + " " + "\nAverage Hop Count: " + hop_floyyd / counter, file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + time_floyd + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

        FileWrite.writefile("Dijkstra", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_dijkstra / counter + " " + "\nAverage Hop Count: " + hop_dikstra / counter, file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + time_dijkstra + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

        FileWrite.writefile("Bellman-Ford", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Average Distance: " + dis_bellman / counter + " " + "\nAverage Hop Count: " + hop_bellman / counter, file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("Time for Alghorithm: " + time_belllman + " miliseconds", file_name);
        FileWrite.writefile("\n", file_name);
        FileWrite.writefile("-------------------------------------------------------------------------------", file_name);
        FileWrite.writefile("\n", file_name);

    }

    public static void main(String[] args) throws FileNotFoundException {

        Write_Real_Report write_real_report = new Write_Real_Report();
        write_real_report.write_hop_dist_time(2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
    }
}

