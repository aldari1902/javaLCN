package fr.dnd.character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, "Warrior", 120, 20);
    }

    @Override
    public String toString() {
        return "🛡️";
    }
}
