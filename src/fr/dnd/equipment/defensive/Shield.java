package fr.dnd.equipment.defensive;

import fr.dnd.equipment.DefensiveEquipment;

public class Shield extends DefensiveEquipment {

    public Shield(String name, int defense) {
        super(name, defense);
    }

    @Override
    public String toString() {
        return "Bouclier : " + name + ", Défense : " + defense;
    }
}