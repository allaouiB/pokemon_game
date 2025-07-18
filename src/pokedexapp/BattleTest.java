package pokedexapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleTest {
    public static void main(String[] args) {
        // Load pokedex from CSV
        List<Pokemon> pokedex = loadPokedex("pokedex_gen1.csv");

        // Show some pokemons to choose
        System.out.println("=== Liste des Pokémon (ID et Nom) ===");
        for (Pokemon p : pokedex) {
            System.out.println(p.getId() + " - " + p.getName());
        }

        Scanner scanner = new Scanner(System.in);

        // Player 1 choice
        System.out.print("\nJoueur 1, choisissez l'ID de votre Pokémon: ");
        int id1 = scanner.nextInt();
        Pokemon p1 = findById(pokedex, id1);

        // Player 2 choice
        System.out.print("Joueur 2, choisissez l'ID de votre Pokémon: ");
        int id2 = scanner.nextInt();
        Pokemon p2 = findById(pokedex, id2);

        if (p1 == null || p2 == null) {
            System.out.println("Pokémon invalide choisi !");
            return;
        }

        System.out.println("\n=== Combat ===");
        System.out.println("Joueur 1: " + p1);
        System.out.println("Joueur 2: " + p2);

        // Determine who attacks first
        Pokemon attacker = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
        Pokemon defender = (attacker == p1) ? p2 : p1;

        System.out.println(attacker.getName() + " attaque en premier !");

        // Calculate damage
        double typeEffect = TypeEffectiveness.getEffectiveness(attacker.getType1(), defender.getType1());
        // If defender has a second type, multiply again
        if (!defender.getType2().isEmpty()) {
            typeEffect *= TypeEffectiveness.getEffectiveness(attacker.getType1(), defender.getType2());
        }

        int rawDamage = attacker.getAttack() - defender.getDefense() / 2;
        if (rawDamage < 1) rawDamage = 1; // minimum damage
        int finalDamage = (int)(rawDamage * typeEffect);

        System.out.println(attacker.getName() + " inflige " + finalDamage + " dégâts à " + defender.getName());

        // Simple outcome
        if (finalDamage >= defender.getHp()) {
            System.out.println(defender.getName() + " est K.O. ! Victoire de " + attacker.getName() + " !");
        } else {
            System.out.println(defender.getName() + " survit avec " + (defender.getHp() - finalDamage) + " PV.");
        }

        scanner.close();
    }

    private static List<Pokemon> loadPokedex(String csvFile) {
        List<Pokemon> pokedex = new ArrayList<>();
        String line;
        String separator = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); // skip header
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
                    pokedex.add(new Pokemon(id, name, type1, type2, hp, attack, defense, speed, special, total));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokedex;
    }

    private static Pokemon findById(List<Pokemon> pokedex, int id) {
        for (Pokemon p : pokedex) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
