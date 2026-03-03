package fr.dnd.character;

public class God extends Character {
    public God(String name) {
        super(name, "God", 30000, 30000);
    }

    @Override
    public String toString() {
        return "\uD83C\uDFF0";
    }
}
