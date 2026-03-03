package fr.dnd.character;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name, "Rogue", 60, 60);
    }

    @Override
    public String toString() {
        return "\uD83D\uDDE1\uFE0F";
    }
}
