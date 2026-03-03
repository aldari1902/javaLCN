package fr.dnd;

public class OutOfBoardException extends Exception {
    public OutOfBoardException() {
        super("Erreur");
    }
}

// Tu dois l'appeler (la lancer) dans la méthode qui gère les déplacements ou le positionnement sur le plateau, par exemple quand tu vérifies si une position est valide.
//Typiquement, dans une méthode comme move() ou setPosition() de ta classe Board ou Character :
//javapublic void move(int x, int y) throws OutOfBoardException {
//    if (x < 0 || x >= width || y < 0 || y >= height) {
//        throw new OutOfBoardException(x, y);
//    }
//    // logique de déplacement...
//}
//Et tu la catches là où tu appelles cette méthode, par exemple dans ta boucle de jeu :
//javatry {
//    board.move(newX, newY);
//} catch (OutOfBoardException e) {
//    System.out.println("Mouvement invalide : " + e.getMessage());
//}
//Est-ce que tu as déjà une classe Board ou une méthode de déplacement dans ton projet ?