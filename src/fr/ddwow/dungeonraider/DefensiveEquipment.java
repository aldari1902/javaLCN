package fr.ddwow.dungeonraider;

public class DefensiveEquipment {


    // Attributs -------------------------------------------------------------------------
    private String type;
    private String name;
    private int defenseLevel;


    // Constructeur ---------------------------------------------------------------------
    public DefensiveEquipment (String type, String name, int defenseLevel){
        this.type = type;
        this.name = name;
        this.defenseLevel = defenseLevel;
    }


    // Getters -----------------------------------------------------------------------------
    public String getType() {return type;}
    public String getName() {return name;}
    public int getDefenseLevel() {return defenseLevel;}


    // Setters -----------------------------------------------------------------------------
    public void setType(String type) { this.type = type;}
    public void setName(String name) { this.name = name;}
    public void setDefenseLevel(int defenseLevel) { this.defenseLevel = defenseLevel;}


    // toString -----------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "[" + type + "] " + name + " (Defense : " + defenseLevel + ")";
    }

}
