import java.io.*;

public class WriteReport {
    public static void main(String[] args) {
        WriteReport writeReport = new WriteReport();
        try {
            writeReport.writingStringToFile("report.txt","line1");
            writeReport.writingStringToFile("report.txt","line2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writingStringToFile(String fileName, String content)
            throws IOException {
        FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
        fw.write(content + "\n");//appends the string to the file
        fw.close();
    }
}