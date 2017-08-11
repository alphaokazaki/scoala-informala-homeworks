package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alpha
 * Class - CSVReader, methods that read athletes from csv files.
 */
public class CSVReader {
    List<String> lines=new ArrayList<>();

    public List<String> getLines() {
        return lines;
    }

    /**
     * Method fills lines with data from a csv file.
     * @param csvFile : location of the csv file
     */
    public void readFile(String csvFile) {

        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method converts csv file strings to array using "," separator
     * @param line : string - line from csv
     * @return array of strings from csv
     */
    public String[] convertLine(String line) {
        String[] variables = line.split(",");
        return variables;
    }

    /**
     * Method converts csv to list of athletes, adds athletes with parameters line by line from the csv file.
     * @return a list of athletes
     */
    public List<Athlete> convertFile() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        String[] variables = null;

        for (String line : lines) {

            variables = convertLine(line);

            athletes.add(new Athlete(Integer.parseInt(variables[0]), variables[1], variables[2],
                    Integer.parseInt(variables[3]), Integer.parseInt(variables[4]),
                    variables[5], variables[6], variables[7]));
        }
        return athletes;
    }
}
