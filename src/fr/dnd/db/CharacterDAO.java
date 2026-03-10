package fr.dnd.db;

import fr.dnd.character.*;
import fr.dnd.character.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO {

    // ---------------------------------------------------
    // Transforme une ligne SQL en objet Java
    // ---------------------------------------------------
    private Character buildCharacter(ResultSet rs) throws SQLException {
        String type = rs.getString("char_type");
        String name = rs.getString("char_name");
        int hp = rs.getInt("hp");

        // On recrée le bon type de personnage
        Character c = switch (type) {
            case "Warrior" -> new Warrior(name);
            case "Mage" -> new Mage(name);
            case "Rogue" -> new Rogue(name);
            case "Hunter" -> new Hunter(name);
            case "God" -> new God(name);
            default -> throw new IllegalArgumentException("Type inconnu : " + type);
        };

        c.setId(rs.getInt("id"));
        c.setHp(hp);
        return c;
    }

    // ---------------------------------------------------
    // getHeroes() : affiche tous les personnages
    // ---------------------------------------------------
    public List<Character> getHeroes() throws SQLException {
        List<Character> liste = new ArrayList<>();

        // La requête SQL pour récupérer tout le monde
        String sql = "SELECT * FROM game_character";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("--- Liste des personnages ---");

            while (rs.next()) {
                Character c = buildCharacter(rs);
                liste.add(c);

                // Affichage simple en console
                System.out.println(
                        "ID: " + c.getId() +
                                " | Nom: " + c.getName() +
                                " | Classe: " + c.getType() +
                                " | HP: " + c.getHp() +
                                " | Power: " + c.getPower()
                );
            }

            System.out.println("-----------------------------");
        }

        return liste;
    }

    // ---------------------------------------------------
    // createHero() : enregistre un nouveau personnage
    // ---------------------------------------------------
    public void createHero(Character character) throws SQLException {

        String sql = "INSERT INTO game_character (char_name, char_type, hp, char_power) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // On remplit les ? dans l'ordre
            stmt.setString(1, character.getName());
            stmt.setString(2, character.getType());
            stmt.setInt(3, character.getHp());
            stmt.setInt(4, character.getPower());
            stmt.executeUpdate();

            // On récupère l'id généré par la base et on le met dans l'objet
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                character.setId(keys.getInt(1));
            }

            System.out.println("Personnage sauvegardé ! ID = " + character.getId());
        }
    }

    // ---------------------------------------------------
    // editHero() : modifie le nom et la classe
    // ---------------------------------------------------
    public void editHero(Character character) throws SQLException {

        String sql = "UPDATE game_character SET char_name = ?, char_type = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, character.getName());
            stmt.setString(2, character.getType());
            stmt.setInt(3, character.getId());
            stmt.executeUpdate();

            System.out.println("Personnage modifié !");
        }
    }

    // ---------------------------------------------------
    // changeLifePoints() : met à jour uniquement les HP
    // ---------------------------------------------------
    public void changeLifePoints(Character character) throws SQLException {

        String sql = "UPDATE game_character SET hp = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, character.getHp());
            stmt.setInt(2, character.getId());
            stmt.executeUpdate();

            System.out.println("HP mis à jour : " + character.getHp());
        }
    }
}