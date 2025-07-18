package pokedexapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainReadCSV {
    public static void main(String[] args) {
        String csvFile = "pokedex_gen1.csv";
        String line;
        String separator = ";";

        List<Pokemon> pokedex = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(separator);
                if (data.length >= 10) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String type1 = data[2];
                    String type2 = data[3];
                    int hp = Integer.parseInt(data[4]);
                    int attack = Integer.parseInt(data[5]);
                    int defense = Integer.parseInt(data[6]);
                    int speed = Integer.parseInt(data[7]);
                    int special = Integer.parseInt(data[8]);
                    int total = Integer.parseInt(data[9]);

                    Pokemon p = new Pokemon(id, name, type1, type2, hp, attack, defense, speed, special, total);
                    pokedex.add(p);
                }
            }

            // Print all Pokémon
            for (Pokemon p : pokedex) {
                System.out.println(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
