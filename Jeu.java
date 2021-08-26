public class Jeu {
    public final static char VIDE = '.';
    public final static int BLEU = 1;
    public final static int ROUGE = 2;

    private int colonne;
    private int ligne;
    private int[][] grille; // 0 = vide, B : joueur bleu, R : joueur rouge

    public Jeu(int colonne)

    {
        initJeu(colonne);
    }

    public Jeu() {
        initJeu(7);
    }

    private void initJeu(int colonne) {
        this.colonne = colonne;

        grille = new int[colonne][colonne];
        for (int col = 0; col < colonne; col++) {
            for (int row = 0; row < colonne; row++) {
                grille[col][row] = VIDE;
            }
        }
    }

    public boolean joueCoup(int col, int joueur) {
        if ((col < 0) || (col >= colonne)) {
            return false;
        }

        // chercher la première place disponible dans la colonne
        for (int ligne = 0; ligne < colonne - 1; ligne++) {
            if (grille[col][ligne] == VIDE) {
                grille[col][ligne] = joueur;
                return true;
            }
        }

        // toute les cases de la colonnes sont remplies
        return false;
    }

    /**
     * la méthode cherche et verifie si l'un des deux joueurs est parvenue à
     * alligner 4 jetons consécutifs sans retourner de quelle jetons s'agit il
     * puisque c'est celui du joueur qui vient de jouer
     */
    public boolean cherche4() {
        // Vérifier une victoire horizontale
        for (int ligne = 0; ligne < colonne; ligne++) {
            if (cherche4alignes(0, ligne, 1, 0)) {
                return true;
            }
        }
        // Vérifier une victoire verticale
        for (int col = 0; col < colonne; col++) {
            if (cherche4alignes(col, 0, 0, 1)) {
                return true;
            }
        }

        // chercher depuis le bas
        for (int col = 0; col < colonne; col++) {
            // Première diagonale
            if (cherche4alignes(col, 0, 1, 1)) {
                return true;
            }
            // Deuxième diagonale
            if (cherche4alignes(col, 0, -1, 1)) {
                return true;
            }
        }

        // chercher depuis les colonnes gauches et droites
        for (int ligne = 0; ligne < colonne; ligne++) {
            // Première diagonale
            if (cherche4alignes(0, ligne, 1, 1)) {
                return true;
            }
            // Deuxième diagonale
            if (cherche4alignes(colonne - 1, ligne, -1, 1)) {
                return true;
            }
        }
        // aucun allignement de quatre
        return false;
    }

    private boolean cherche4alignes(int verifcol, int verifLigne, int dCol, int dLigne) {
        int couleur = VIDE;
        int compteur = 0;
        int curCol = verifcol;
        int curRow = verifLigne;

        while ((curCol >= 0) && (curCol < colonne) && (curRow >= 0) && (curRow < colonne)) {
            if (grille[curRow][curCol] != couleur) {
                // Si la couleur change, on réinitialise le compteur
                couleur = grille[curRow][curCol];
                compteur = 1;
            } else {
                // Sinon on l'incrémente
                compteur++;
            }

            // On sort lorsque le compteur atteint 4
            if ((couleur != VIDE) && (compteur == 4)) {
                return true;
            }

            // On passe à l'itération suivante
            curCol += dCol;
            curRow += dLigne;
        }

        // Aucun alignement n'a été trouvé
        return false;
    }

    public boolean estPlein() {
        // on cherche si il y'a encore des cases vides dans la grille
        for (int col = 0; col < colonne; col++) {
            for (int ligne = 0; ligne < colonne; ligne++) {
                if (grille[col][ligne] == VIDE) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getColonne(

    ) {
        return colonne;

    }

    public void afficher() {
        Puissance4.ligne();

        for (int ligne = colonne - 2; ligne >= 0; --ligne) {
            Puissance4.espace();
            for (int col = 0; col < colonne; col++) {
                switch (grille[col][ligne]) {
                    case VIDE:
                        System.out.print(" . ");
                        break;
                    case ROUGE:
                        System.out.print(" R ");
                        break;
                    case BLEU:
                        System.out.print(" B ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println("\n");
        Puissance4.espace();
        for (int i = 0; i < colonne; ++i) {
            System.out.print(" - ");
        }
        System.out.println();
        Puissance4.espace();
        for (int i = 1; i <= colonne; ++i) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
}