package fr.ddwow.dungeonraider;

import java.util.Random;
import java.util.Scanner;

/**
 * Contient toute la logique interne du jeu :
 * création de personnage, boucle principale, menus.
 */
public class Game {

    // Attributs ---------------------------------------------------------------
    private Character player;       // le personnage du joueur
    private Menu menu;         // pour afficher et lire les saisies
    private boolean isRunning;    // true = le jeu tourne, false = on quitte

    // Constructeur ---------------------------------------------------------------
    public Game() {
        this.menu = new Menu();
        this.isRunning = true;
        this.player = null;  // pas encore de personnage créé
    }

    // Getters / Setters ---------------------------------------------------------------
    public Character getPlayer() {
        return player;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    // ══════════════════════════════════════════════════════════════
    //  MÉTHODE PRINCIPALE : démarre le jeu
    // ══════════════════════════════════════════════════════════════

    /**
     * Lance le jeu : affiche le titre puis entre dans la boucle principale.
     */
    public void start() {
        menu.afficherTitre();

        // Boucle principale du jeu
        while (isRunning) {
            menu.afficherMenuPrincipal();
            String choix = menu.lireTexte("");

            switch (choix) {
                case "1":
                    creerPersonnage();
                    // Une fois le perso créé, on entre dans son menu
                    if (player != null) {
                        menuPersonnage();
                    }
                    break;

                case "2":
                    quitter();
                    break;

                default:
                    menu.afficherErreur("Choix invalide. Tapez 1 ou 2.");
            }
        }

        menu.fermer();
    }

    // ══════════════════════════════════════════════════════════════
    //  CRÉATION DU PERSONNAGE
    // ══════════════════════════════════════════════════════════════

    /**
     * Guide l'utilisateur pour créer son personnage étape par étape.
     */
    private void creerPersonnage() {
        menu.afficherLigne();
        menu.afficherMessage("════════════════════════════════ CRÉATION DU PERSONNAGE ════════════════════════════════");

        // 1. Choix de la classe
        String type = choisirClasse();
        if (type == null) return;  // l'utilisateur a fait un choix invalide

        // 2. Saisie du nom
        String nom = menu.lireTexte("Entrez le nom de votre personnage : ");
        while (nom.isEmpty()) {
            menu.afficherErreur("Le nom ne peut pas être vide !");
            nom = menu.lireTexte("Entrez le nom de votre personnage : ");
        }

        // 3. Création de l'équipement offensif selon la classe
        OffensiveEquipment arme = creerArmeParDefaut(type);

        // 4. Création du personnage avec les stats par défaut selon la classe
        int hp = getHpParDefaut(type);
        int attackLevel = getAttaqueParDefaut(type);

        player = new Character(type, nom, hp, attackLevel, arme);

        menu.afficherLigne();
        menu.afficherMessage("✅ Personnage créé avec succès !");
        menu.afficherMessage(player.toString());
    }

    /**
     * Affiche le menu de choix de classe et retourne le type choisi.
     *
     * @return "Warrior", "Mage", "Druid", ou null si choix invalide
     */
    private String choisirClasse() {
        menu.afficherChoixClasse();
        String choix = menu.lireTexte("");

        switch (choix) {
            case "1":
                return "Warrior";
            case "2":
                return "Mage";
            case "3":
                return "Druid";
            case "4":
                return "Hunter";
            default:
                menu.afficherErreur("Classe invalide.");
                return null;
        }
    }

    /**
     * Crée l'arme / sort par défaut selon la classe.
     */
    private OffensiveEquipment creerArmeParDefaut(String type) {
        switch (type) {
            case "Warrior":
                return new OffensiveEquipment("Weapon", "Épée en fer", 9);
            case "Mage":
                return new OffensiveEquipment("Spell", "Boule de feu", 15);
            case "Druid":
                return new OffensiveEquipment("Spell", "Colère", 11);
            case "Hunter":
                return new OffensiveEquipment("Weapon", "Arc", 13);
            default:
                return new OffensiveEquipment("Weapon", "Poings", 5);
        }
    }

    /**
     * Retourne les PV de départ selon la classe.
     */
    private int getHpParDefaut(String type) {
        switch (type) {
            case "Warrior":
                return 120;
            case "Mage":
                return 70;
            case "Druid":
                return 90;
            case "Hunter":
                return 100;
            default:
                return 100;
        }
    }

    /**
     * Retourne l'attaque de base selon la classe.
     */
    private int getAttaqueParDefaut(String type) {
        switch (type) {
            case "Warrior":
                return 12;
            case "Mage":
                return 18;
            case "Druid":
                return 10;
            case "Hunter":
                return 13;
            default:
                return 10;
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  MENU PERSONNAGE (après création)
    // ══════════════════════════════════════════════════════════════

    /**
     * Menu accessible après la création du personnage.
     * Permet d'afficher ou modifier ses infos, ou de quitter.
     */
    private void menuPersonnage() {
        boolean dansMenuPerso = true;

        while (dansMenuPerso && isRunning) {
            menu.afficherMenuPersonnage();
            String choix = menu.lireTexte("");

            switch (choix) {
                case "1":
                    // Afficher les infos
                    menu.afficherLigne();
                    menu.afficherMessage(player.toString());
                    break;

                case "2":
                    // Modifier les infos
                    modifierPersonnage();
                    break;

                case "3":
                    // Quitter
                    lancerPartie();
                    dansMenuPerso = false;
                    break;

                case "4":
                    // Quitter
                    quitter();
                    dansMenuPerso = false;
                    break;

                default:
                    menu.afficherErreur("Choix invalide. Tapez 1, 2 ou 3.");
            }
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  MODIFICATION DU PERSONNAGE
    // ══════════════════════════════════════════════════════════════

    /**
     * Permet à l'utilisateur de modifier les infos de son personnage.
     */
    private void modifierPersonnage() {
        boolean dansModif = true;

        while (dansModif) {
            menu.afficherMenuModification();
            String choix = menu.lireTexte("");

            switch (choix) {
                case "1":
                    // Modifier le nom
                    String nouveauNom = menu.lireTexte("Nouveau nom : ");
                    if (!nouveauNom.isEmpty()) {
                        player.setName(nouveauNom);
                        menu.afficherMessage("✅ Nom mis à jour : " + nouveauNom);
                    } else {
                        menu.afficherErreur("Le nom ne peut pas être vide.");
                    }
                    break;

                case "2":
                    // Modifier les PV
                    int nouveauxHp = menu.lireEntier("Nouveaux PV : ");
                    player.setHp(nouveauxHp);
                    menu.afficherMessage("✅ PV mis à jour : " + nouveauxHp);
                    break;

                case "3":
                    // Modifier l'attaque
                    int nouvelleAttaque = menu.lireEntier("Nouveau niveau d'attaque : ");
                    player.setAttackLevel(nouvelleAttaque);
                    menu.afficherMessage("✅ Attaque mise à jour : " + nouvelleAttaque);
                    break;

                case "4":
                    // Retour
                    dansModif = false;
                    break;

                default:
                    menu.afficherErreur("Choix invalide. Tapez 1, 2, 3 ou 4.");
            }
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  QUITTER
    // ══════════════════════════════════════════════════════════════

    /**
     * Affiche un message d'au revoir et arrête la boucle principale.
     */
    private void quitter() {
        menu.afficherLigne();
        menu.afficherMessage("════════════════════════════════════════⚔️ À bientôt! ⚔️════════════════════════════════════════");
        menu.afficherLigne();
        isRunning = false;
    }

// ══════════════════════════════════════════════════════════════
//  LANCER LA PARTIE
// ══════════════════════════════════════════════════════════════

    private int position = 1;
    private final int DUROTAR = 64;
    private Random random = new Random();

    private void lancerDe() {

        int dice = random.nextInt(6) + 1;
        System.out.println("════════════════════════════════════════════════════\n");
        System.out.println("🎲 : " + dice);

        position += dice;

        if (position > DUROTAR) {
            position = DUROTAR;
        }

        System.out.println("Nouvelle position : " + position);

        if (position == DUROTAR) {
            System.out.println("Vous êtes arrivé.");
        }
    }

    private boolean estTerminee() {
        return position >= DUROTAR;
    }

    private void lancerPartie() {

        Scanner scanner = new Scanner(System.in);

        // reset position au cas où on relance une partie
        position = 1;

        System.out.println("═══════════════════ D&D go go ═══════════════════");
        System.out.println("Objectif : Survivre et atteindre la case 64");
        System.out.println("Position de départ : 1\n");

        while (!estTerminee()) {
            System.out.println("Appuier sur ENTRÉE pour lancer le dé...");
            scanner.nextLine();
            lancerDe();
            System.out.println();
        }

        System.out.println("Partie terminée !");
    }
}

