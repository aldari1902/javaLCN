package fr.ddwow.dungeonraider;


public class Character {

    // Attributs --------------------------------------------------------------------------------------------------
    private String type;          // Warrior, Mage, Druid ou Hunter
    private String name;          // nom joueur
    private int hp;            // HP
    private int attackLevel;   // AD / AP
    private OffensiveEquipment weapon; // Stuff


    // Constructeur --------------------------------------------------------------------------------------------------
    public Character(String type, String name, int hp, int attackLevel,
                     OffensiveEquipment weapon) {
        this.type = type;
        this.name = name;
        this.hp = hp;
        this.attackLevel = attackLevel;
        this.weapon = weapon;
    }


    // Getters --------------------------------------------------------------------------------------------------
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public OffensiveEquipment getWeapon() {
        return weapon;
    }


    // Setters --------------------------------------------------------------------------------------------------
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public void setWeapon(OffensiveEquipment weapon) {
        this.weapon = weapon;
    }


    // toString --------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "═════════════════════════════════════════════════════════\n"
                + "═══════════════════ Votre Personnage ═══════════════════\n"
                + "|  Nom       : " + name + "\n"
                + "|  Classe    : " + type + "\n"
                + "|  PV        : " + hp + "\n"
                + "|  Attaque   : " + attackLevel + "\n"
                + "|  Arme      : " + (weapon != null ? weapon.toString() : "aucune") + "\n"
                + "═════════════════════════════════════════════════════════";
    }
}