package pokedexapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainReadCSV {
    public static void main(String[] args) {
        String csvFile = "pokedex_gen1.csv";
        String line;
        String separator = ";";

        List<Pokemon> pokedex = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            // Lire le CSV
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

            // Afficher la liste
            System.out.println("=== Liste des Pokémon disponibles ===");
            for (Pokemon p : pokedex) {
                System.out.println(p.getId() + " - " + p.getName());
            }

            // Choisir deux Pokémon pour tester un combat
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEntrez l'ID du Pokémon du Joueur 1 : ");
            int id1 = sc.nextInt();
            System.out.print("Entrez l'ID du Pokémon du Joueur 2 : ");
            int id2 = sc.nextInt();

            Pokemon p1 = findById(pokedex, id1);
            Pokemon p2 = findById(pokedex, id2);

            if (p1 == null || p2 == null) {
                System.out.println("ID invalide !");
                return;
            }

            // Afficher les choix
            System.out.println("\nJoueur 1 : " + p1);
            System.out.println("Joueur 2 : " + p2);

            // Déterminer qui attaque en premier
            Pokemon attacker = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
            Pokemon defender = (attacker == p1) ? p2 : p1;

            System.out.println("\n" + attacker.getName() + " attaque en premier !");

            // Calcul des dégâts
            double typeEffect = TypeEffectiveness.getEffectiveness(attacker.getType1(), defender.getType1());
            if (!defender.getType2().isEmpty()) {
                typeEffect *= TypeEffectiveness.getEffectiveness(attacker.getType1(), defender.getType2());
            }

            int rawDamage = attacker.getAttack() - defender.getDefense() / 2;
            if (rawDamage < 1) rawDamage = 1;
            int finalDamage = (int)(rawDamage * typeEffect);

            System.out.println(attacker.getName() + " inflige " + finalDamage + " dégâts à " + defender.getName());

            if (finalDamage >= defender.getHp()) {
                System.out.println(defender.getName() + " est K.O. ! Victoire de " + attacker.getName() + " !");
            } else {
                System.out.println(defender.getName() + " survit avec " + (defender.getHp() - finalDamage) + " PV.");
            }

            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour trouver un Pokémon par ID
    private static Pokemon findById(List<Pokemon> pokedex, int id) {
        for (Pokemon p : pokedex) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
