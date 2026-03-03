package fr.dnd.equipment.defensive;

import fr.dnd.equipment.DefensiveEquipment;

public class Potion extends DefensiveEquipment {

    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name, healAmount);
        this.healAmount = healAmount;
    }

    @Override
    public String toString() {
        return "Potion : " + name + ", Soin : " + healAmount;
    }
}