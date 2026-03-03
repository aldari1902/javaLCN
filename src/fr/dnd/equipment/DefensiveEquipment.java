package fr.dnd.equipment;

public abstract class DefensiveEquipment {
    protected String name;
    protected int defense;

    public DefensiveEquipment(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}