package fr.dnd.equipment.offensive;

import fr.dnd.equipment.OffensiveEquipment;

public class Weapon extends OffensiveEquipment {

    public Weapon(String name, int damage) {
        super(name, damage);
    }

    @Override
    public String toString() {
        return "Arme : " + name + ", Dégâts : " + damage;
    }
}