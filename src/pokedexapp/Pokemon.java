package pokedexapp;

public class Pokemon {
    private int id;
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int special;
    private int total;

    public Pokemon(int id, String name, String type1, String type2,
                   int hp, int attack, int defense, int speed, int special, int total) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.special = special;
        this.total = total;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + type1 + (type2.isEmpty() ? "" : "/" + type2) + ")"
                + " | HP: " + hp
                + " | Attack: " + attack
                + " | Defense: " + defense
                + " | Speed: " + speed
                + " | Special: " + special
                + " | Total: " + total;
    }

    // Getters if needed later
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public int getSpecial() { return special; }
    public int getTotal() { return total; }
}
