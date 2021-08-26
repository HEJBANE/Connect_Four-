public class Partie 
{

    private Joueurs[] joueurs = new Joueurs[2];
    private Jeu jeu;
    public Partie(Joueurs joueur1, Joueurs joueur2)
    {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        jeu = new Jeu();
    }
    public void joue() 
    {
        int vainqueur = -1;
        int cJoueur = 0;
        while (vainqueur==-1)
        {
        joueurs[cJoueur].joue(jeu);
        if (jeu.estPlein()) {
            vainqueur = -1;
        }
        // on a une victoire si 4 pions sont alignés, 
        if (jeu.cherche4()) {
        vainqueur = cJoueur;
        }
        // On change de joueur pour le tour suivant
        cJoueur++;
        cJoueur %= 2;
        }
        System.out.println("fin de la partie.");
        jeu.afficher();
        if (vainqueur == -1) {
        System.out.println("Match nul.");
        } else {
        System.out.println("Le vainqueur est " + joueurs[vainqueur].getNom());
        }
    }
}
