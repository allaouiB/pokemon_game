package pokedexapp;

public class plateau {
    private Pokemon[][] board; // 9x9 board

    public plateau() {
        board = new Pokemon[9][9];
        initialiserPlateau();
    }

    // Initialise board with some pokemons for each player
    private void initialiserPlateau() {
        // Exemple simple : juste mettre des Bulbizarre pour joueur 1 et Flagadoss pour joueur 2
        // Tu peux remplacer par d'autres pokémons selon ton CSV plus tard
        for (int col = 0; col < 9; col++) {
            // Joueur 1 sur les 3 premières lignes
            board[0][col] = new Pokemon(1, "Bulbizarre", "plante", "poison", 45, 49, 49, 45, 65, 253);
            board[1][col] = new Pokemon(1, "Bulbizarre", "plante", "poison", 45, 49, 49, 45, 65, 253);
            board[2][col] = new Pokemon(1, "Bulbizarre", "plante", "poison", 45, 49, 49, 45, 65, 253);

            // Joueur 2 sur les 3 dernières lignes
            board[6][col] = new Pokemon(80, "Flagadoss", "eau", "psy", 95, 75, 110, 30, 80, 390);
            board[7][col] = new Pokemon(80, "Flagadoss", "eau", "psy", 95, 75, 110, 30, 80, 390);
            board[8][col] = new Pokemon(80, "Flagadoss", "eau", "psy", 95, 75, 110, 30, 80, 390);
        }
    }
    public void afficherPlateau() {
        System.out.println("=== Plateau 9x9 ===");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == null) {
                    System.out.print("[  ] "); // case vide
                } else {
                    // afficher juste la première lettre du nom
                    System.out.print("[" + board[i][j].getName().charAt(0) + "] ");
                }
            }
            System.out.println();
        }
    }

    // Plus tard on ajoutera des méthodes: deplacerPokemon, attaquerPokemon, etc.
}