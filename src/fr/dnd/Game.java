package fr.dnd;

import fr.dnd.character.*;
import fr.dnd.character.Character;

import java.util.Scanner;

public class Game {

    private Menu menu;
    private Dice dice;
    private Board board;
    private Character character;
    private Scanner scanner;

    public Game(Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice = dice;
        this.scanner = scanner;
    }

    public void startGame() {
        boolean quit = false;

        while (!quit) {
            int choice = menu.mainMenu();

            switch (choice) {
                case 1:
                    String type = menu.askType();
                    String name = menu.askName();
                    initGame(type, name);
                    break;
                case 2:
                    menu.showCharacter(character);
                    break;
                case 3:
                    if (character == null) {
                        System.out.println("Veuillez d'abord créer un personnage.");
                        break;
                    }
                    while (!checkWin()) {
                        loop();
                    }
                    board.print();
                    System.out.println("""
                            |============================================|
                            |                                            |
                            |      WINNER WINNER CHICKEN DINNER !!!      |
                            |                                            |
                            |============================================|
                            """);
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    public void initGame(String type, String name) {
        board = new Board(64);
        switch (type) {
            case "1":
                character = new Warrior(name);
                break;
            case "2":
                character = new Mage(name);
                break;
            case "3":
                character = new Rogue(name);
                break;
            case "4":
                character = new Hunter(name);
                break;
            case "5":
                character = new God(name);
                break;
            default:
                System.out.println("Réessayez :");
                String newType = scanner.nextLine();
                initGame(newType, name);
                return;
        }
        board.setTile(0, character);
        System.out.println("Personnage créé : " + character.getName() + " (" + character.getType() + ")");
    }

    public void loop() {
        board.print();
        int roll = dice.roll(6);
        System.out.println("Lancé de dé : " + roll);
        board.moveCharacter(roll);
        System.out.println("Press enter.");
        this.scanner.nextLine();
    }

    public boolean checkWin() {
        return board.getTile(63) == character;
    }
}