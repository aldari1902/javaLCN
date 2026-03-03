package fr.dnd.equipment.offensive;

import fr.dnd.equipment.OffensiveEquipment;

public class Spell extends OffensiveEquipment {

    public Spell(String name, int damage) {
        super(name, damage);
    }

    @Override
    public String toString() {
        return "Sort : " + name + ", Dégâts : " + damage;
    }
}