package fr.dnd.equipment;

public abstract class OffensiveEquipment {
    protected String name;
    protected int damage;

    public OffensiveEquipment(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
