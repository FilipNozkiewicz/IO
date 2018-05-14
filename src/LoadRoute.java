import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoadRoute {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public ArrayList<RouteGenerator> returnerOfRoutes(String fileName){

        String csvFile = fileName;
        LoadRoute loadRoute = new LoadRoute ();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<RouteGenerator> routeGenerators= new ArrayList<>();

        Timestamp timestampZero = new Timestamp(0);
        while (scanner.hasNext()) {

            List<String> line = loadRoute.parseLine(scanner.nextLine());
            RouteGenerator temp = new RouteGenerator();

            String tempString = line.get(0);
            String sanitized = tempString.replaceAll("[\uFEFF-\uFFFF]", "");
            Timestamp timestamp = new Timestamp(Long.parseLong(sanitized));

            if(timestamp.after(timestampZero)) {
                temp.setOrder(sanitized);
                temp.setDriverName(line.get(1));
                for (int i = 2; i <= 10; i += 2) {
                    temp.setParcel(new Parcel(Integer.parseInt(line.get(i)), Integer.parseInt(line.get(i + 1))));
                }
                routeGenerators.add(temp);
                timestampZero.setTime(timestamp.getTime());
            }
            else {
                System.out.print("Paczki z timestamp: " + line.get(0) + " Kierowca: " + line.get(1));
                System.out.println(" - Odebrana za późno");
            }

        }
        //RouteGenerator temp = routeGenerators.get(0);
        //for (int i = 0; i < routeGenerators.size(); i++){
        //    if(temp.getOrder() <= routeGenerators.get(i).getOrder()){

        scanner.close();
        return routeGenerators;
    }
    public static void main(String[] args) throws Exception {
        String csvFile = "routes.txt";

        Scanner scanner = new Scanner(new File(csvFile));
        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine());
            RouteGenerator routeGenerator = new RouteGenerator();
            routeGenerator.setOrder(line.get(0));
            routeGenerator.setDriverName(line.get(1));
            for (int i = 2; i <= 10; i+=2){
                routeGenerator.setParcel(new Parcel(Integer.parseInt(line.get(i)), Integer.parseInt(line.get(i+1))));
            }

            routeGenerator.writeParcels();

        }

        scanner.close();

    }


    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;
                } else if ((ch == '\r') || (ch == '(') || (ch == ')'))  {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

}