package fr.ddwow.dungeonraider;

public class OffensiveEquipment {


    // Attributs -------------------------------------------------------------------------
    private String type;
    private String name;
    private int attackLevel;


    // Constructeur ---------------------------------------------------------------------
    public OffensiveEquipment (String type, String name, int attackLevel){
        this.type = type;
        this.name = name;
        this.attackLevel = attackLevel;
    }


    // Getters -----------------------------------------------------------------------------
    public String getType() {return type;}
    public String getName() {return name;}
    public int getAttackLevel() {return attackLevel;}


    // Setters -----------------------------------------------------------------------------
    public void setType(String type) { this.type = type;}
    public void setName(String name) { this.name = name;}
    public void setAttackLevel(int attackLevel) { this.attackLevel = attackLevel;}


    // toString -----------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "[" + type + "] " + name + " (Attaque : " + attackLevel + ")";
    }

}
