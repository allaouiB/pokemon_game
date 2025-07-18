package pokedexapp;

import java.util.HashMap;
import java.util.Map;

public class TypeEffectiveness {
    private static final Map<String, Map<String, Double>> effectivenessMap = new HashMap<>();

    static {
        // --- Feu ---
        Map<String, Double> fireMap = new HashMap<>();
        fireMap.put("plante", 2.0);
        fireMap.put("glace", 2.0);
        fireMap.put("insecte", 2.0);
        fireMap.put("acier", 2.0);
        fireMap.put("eau", 0.5);
        fireMap.put("feu", 0.5);
        fireMap.put("roche", 0.5);
        fireMap.put("dragon", 0.5);
        effectivenessMap.put("feu", fireMap);

        // --- Eau ---
        Map<String, Double> waterMap = new HashMap<>();
        waterMap.put("feu", 2.0);
        waterMap.put("roche", 2.0);
        waterMap.put("sol", 2.0);
        waterMap.put("eau", 0.5);
        waterMap.put("plante", 0.5);
        waterMap.put("dragon", 0.5);
        effectivenessMap.put("eau", waterMap);

        // --- Plante ---
        Map<String, Double> grassMap = new HashMap<>();
        grassMap.put("eau", 2.0);
        grassMap.put("sol", 2.0);
        grassMap.put("roche", 2.0);
        grassMap.put("feu", 0.5);
        grassMap.put("plante", 0.5);
        grassMap.put("poison", 0.5);
        grassMap.put("vol", 0.5);
        grassMap.put("insecte", 0.5);
        grassMap.put("dragon", 0.5);
        effectivenessMap.put("plante", grassMap);

        // --- Électrique ---
        Map<String, Double> electricMap = new HashMap<>();
        electricMap.put("eau", 2.0);
        electricMap.put("vol", 2.0);
        electricMap.put("plante", 0.5);
        electricMap.put("electrique", 0.5);
        electricMap.put("dragon", 0.5);
        electricMap.put("sol", 0.0);
        effectivenessMap.put("electrique", electricMap);

        // --- Roche ---
        Map<String, Double> rockMap = new HashMap<>();
        rockMap.put("feu", 2.0);
        rockMap.put("glace", 2.0);
        rockMap.put("insecte", 2.0);
        rockMap.put("vol", 2.0);
        rockMap.put("combat", 0.5);
        rockMap.put("sol", 0.5);
        rockMap.put("acier", 0.5);
        effectivenessMap.put("roche", rockMap);

        // --- Sol ---
        Map<String, Double> groundMap = new HashMap<>();
        groundMap.put("feu", 2.0);
        groundMap.put("electrique", 2.0);
        groundMap.put("poison", 2.0);
        groundMap.put("roche", 2.0);
        groundMap.put("acier", 2.0);
        groundMap.put("insecte", 0.5);
        groundMap.put("plante", 0.5);
        groundMap.put("vol", 0.0);
        effectivenessMap.put("sol", groundMap);

        // --- Vol ---
        Map<String, Double> flyingMap = new HashMap<>();
        flyingMap.put("plante", 2.0);
        flyingMap.put("insecte", 2.0);
        flyingMap.put("combat", 2.0);
        flyingMap.put("electrique", 0.5);
        flyingMap.put("roche", 0.5);
        flyingMap.put("acier", 0.5);
        effectivenessMap.put("vol", flyingMap);

        // --- Insecte ---
        Map<String, Double> bugMap = new HashMap<>();
        bugMap.put("plante", 2.0);
        bugMap.put("psy", 2.0);
        bugMap.put("tenebres", 2.0); // dark
        bugMap.put("combat", 0.5);
        bugMap.put("feu", 0.5);
        bugMap.put("vol", 0.5);
        bugMap.put("spectre", 0.5);
        bugMap.put("poison", 0.5);
        effectivenessMap.put("insecte", bugMap);

        // --- Psy ---
        Map<String, Double> psychicMap = new HashMap<>();
        psychicMap.put("poison", 2.0);
        psychicMap.put("combat", 2.0);
        psychicMap.put("psy", 0.5);
        psychicMap.put("acier", 0.5);
        psychicMap.put("tenebres", 0.0);
        effectivenessMap.put("psy", psychicMap);

        // --- Spectre ---
        Map<String, Double> ghostMap = new HashMap<>();
        ghostMap.put("psy", 2.0);
        ghostMap.put("spectre", 2.0);
        ghostMap.put("normal", 0.0);
        ghostMap.put("tenebres", 0.5);
        effectivenessMap.put("spectre", ghostMap);

        // --- Normal ---
        Map<String, Double> normalMap = new HashMap<>();
        normalMap.put("roche", 0.5);
        normalMap.put("spectre", 0.0);
        effectivenessMap.put("normal", normalMap);

        // --- Combat ---
        Map<String, Double> fightMap = new HashMap<>();
        fightMap.put("roche", 2.0);
        fightMap.put("normal", 2.0);
        fightMap.put("glace", 2.0);
        fightMap.put("acier", 2.0);
        fightMap.put("tenebres", 2.0);
        fightMap.put("psy", 0.5);
        fightMap.put("vol", 0.5);
        fightMap.put("insecte", 0.5);
        effectivenessMap.put("combat", fightMap);

        // --- Poison ---
        Map<String, Double> poisonMap = new HashMap<>();
        poisonMap.put("plante", 2.0);
        poisonMap.put("insecte", 2.0);
        poisonMap.put("poison", 0.5);
        poisonMap.put("sol", 0.5);
        poisonMap.put("roche", 0.5);
        poisonMap.put("spectre", 0.5);
        effectivenessMap.put("poison", poisonMap);

        // --- Glace ---
        Map<String, Double> iceMap = new HashMap<>();
        iceMap.put("plante", 2.0);
        iceMap.put("sol", 2.0);
        iceMap.put("vol", 2.0);
        iceMap.put("dragon", 2.0);
        iceMap.put("feu", 0.5);
        iceMap.put("eau", 0.5);
        iceMap.put("glace", 0.5);
        iceMap.put("acier", 0.5);
        effectivenessMap.put("glace", iceMap);

        // --- Acier ---
        Map<String, Double> steelMap = new HashMap<>();
        steelMap.put("glace", 2.0);
        steelMap.put("roche", 2.0);
        steelMap.put("acier", 0.5);
        steelMap.put("feu", 0.5);
        steelMap.put("eau", 0.5);
        steelMap.put("electrique", 0.5);
        effectivenessMap.put("acier", steelMap);

        // --- Ténèbres (même si peu utilisé en gen1 mais utile parfois) ---
        Map<String, Double> darkMap = new HashMap<>();
        darkMap.put("psy", 2.0);
        darkMap.put("spectre", 2.0);
        darkMap.put("combat", 0.5);
        darkMap.put("tenebres", 0.5);
        darkMap.put("fee", 0.5); // fée, pour extension
        effectivenessMap.put("tenebres", darkMap);
    }

    public static double getEffectiveness(String attackingType, String defendingType) {
        attackingType = attackingType.toLowerCase();
        defendingType = defendingType.toLowerCase();
        if (effectivenessMap.containsKey(attackingType)) {
            Map<String, Double> inner = effectivenessMap.get(attackingType);
            if (inner.containsKey(defendingType)) {
                return inner.get(defendingType);
            }
        }
        return 1.0;
    }
}
