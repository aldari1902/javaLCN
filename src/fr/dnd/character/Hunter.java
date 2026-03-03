package fr.dnd.character;

public class Hunter extends Character {
    public Hunter(String name) {
        super(name, "Hunter", 80, 50);
    }

    @Override
    public String toString() {
        return "\uD83C\uDFF9";
    }
}
