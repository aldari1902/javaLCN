package fr.ddwow.dungeonraider;

import java.util.Scanner;

public class Menu {

    // Attribut ------------------------------------------------------
    // Un seul Scanner partagé pour toute la durée du jeu
    private Scanner scanner;

    // Constructeur ------------------------------------------------------
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // ------------------------------------------------------  AFFICHAGE  ------------------------------------------------------


    public void afficherLigne() {
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public void afficherTitre() {
        System.out.println("                                 ╔══════════════════════════════════╗");
        System.out.println("                                   ⚔️  D&D WoW - DungeonRaider   ⚔️  ");
        System.out.println("                                 ╚══════════════════════════════════╝");
    }

    public void afficherMenuPrincipal() {
        System.out.println("\n═══════════════════ MENU PRINCIPAL ═══════════════════");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Quitter le jeu");
        System.out.print("Votre choix : ");
    }

    public void afficherMenuPersonnage() {
        System.out.println("\n═══════════════════ QUE VOULEZ-VOUS FAIRE ? ═══════════════════");
        System.out.println("1. Afficher les infos du personnage");
        System.out.println("2. Modifier les infos du personnage");
        System.out.println("3. Lancer la partie");
        System.out.println("4. Quitter le jeu");
        System.out.print("Votre choix : ");
    }

    public void afficherMenuModification() {
        System.out.println("\n═══════════════════ MODIFIER LE PERSONNAGE ═══════════════════");
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier les PV");
        System.out.println("3. Modifier le niveau d'attaque");
        System.out.println("4. Retour");
        System.out.print("Votre choix : ");
    }

    public void afficherChoixClasse() {
        System.out.println("\n═══════════════════ CHOIX DE LA CLASSE ═══════════════════");
        System.out.println("1. Warrior  (Tank, dégâts modérée, bonne survie)");
        System.out.println("2. Mage     (DPS , gros dégâts, faible survie)");
        System.out.println("3. Druid    (DPS , dégâts modérée, bonne survie)");
        System.out.println("4. Hunter   (DPS , ARC, dégâts convenable et survie modérée");
        System.out.print("Votre choix : ");
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public void afficherErreur(String message) {
        System.out.println("❌ Erreur : " + message);
    }

    // ------------------------------------------------------
    //  SAISIE UTILISATEUR
    // ------------------------------------------------------

    public String lireTexte(String invite) {
        System.out.print(invite);
        return scanner.nextLine().trim();
    }

    public int lireEntier(String invite) {
        while (true) {
            System.out.print(invite);
            String saisie = scanner.nextLine().trim();
            try {
                return Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                afficherErreur("Veuillez saisir un nombre entier.");
            }
        }
    }

    public void fermer() {
        scanner.close();
    }
}