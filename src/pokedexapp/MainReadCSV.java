package pokedexapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainReadCSV {
    public static void main(String[] args) {
        // Path to the CSV file (put the file in the project root folder)
        String csvFile = "pokedex_gen1.csv";
        String line;
        String separator = ";"; // Use semicolon because your CSV uses ';'

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read header line
            String header = br.readLine();
            System.out.println("Header: " + header);

            // Read each data line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(separator);
                if (data.length > 1) {
                    String id = data[0];
                    String name = data[1];
                    System.out.println("ID: " + id + " | Name: " + name);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
