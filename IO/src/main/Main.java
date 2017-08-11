package main;

/**
 * @author Alpha
 * Class - Main, creating CSVReader and CompetitionManagement
 */
public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        CompetitionManagement am = new CompetitionManagement();
        String csvFile = "C:\\Users\\Alpha\\Desktop\\IO\\src\\main\\Tabel.csv";

        csvReader.readFile(csvFile);
        am.athletes=csvReader.convertFile();
        am.showResults();

    }
}
