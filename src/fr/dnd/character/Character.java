package fr.dnd.character;

import fr.dnd.equipment.OffensiveEquipment;

public abstract class Character {

    private String name;
    private String type;
    private int hp;
    private int power;
    private OffensiveEquipment offensiveEquipment;

    public Character(String name, String type, int hp, int power) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return " 🦖 ";
    }
}