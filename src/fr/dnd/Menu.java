package fr.dnd;

import java.util.Scanner;

import fr.dnd.character.Character;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int mainMenu() {
        System.out.println("""
                |==============================================|
                | Faites votre choix:                          | 
                | 1 - Nouveau personnage                       | 
                | 2 - Voir mon personnage                      |
                | 3 - Lancer la partie                         |                      
                | 4 - Quitter le jeu                           | 
                |==============================================|
                """);

        int input = scanner.nextInt();
        scanner.nextLine();

        if (input < 1 || input > 4) {
            System.out.println("Réessayez :");
            return mainMenu();
        }
        return input;
    }

    public String askType() {
        System.out.println("""
                |==============================================|
                | Choisissez une classe:                       |
                | 1 - Warrior                                  |
                | 2 - Mage                                     |
                | 3 - Rogue                                    |
                | 4 - Hunter                                   |
                |==============================================|
                """);
        String input = scanner.nextLine();
        if (input.equals("1") || input.equals("2") || input.equals("3")
                || input.equals("4") || input.equals("5")) {
            return input;
        }
        System.out.println("Choix invalide, réessayez :");
        return askType();
    }

    public String askName() {
        System.out.println("""
                |==============================================|
                | Choisissez un pseudo:                        |
                |==============================================|
                """);
        String name = scanner.nextLine();
        if (name.isBlank()) {
            System.out.println("Le nom ne peut pas être vide :");
            return askName();
        }
        return name;
    }

    public void showCharacter(Character character) {
        if (character == null) {
            System.out.println("Veuillez d'abord créer un personnage.");
        } else {
            System.out.println("""
                    
                    |========== Stats de votre personnage : =======|
                    | Name :   %-30s|
                    | Type :   %-30s|
                    | HP :     %-30d|
                    | Power :  %-30d|
                    |==============================================|
                    
                    """.formatted(
                    character.getName(),
                    character.getType(),
                    character.getHp(),
                    character.getPower()
            ));
        }
    }
}