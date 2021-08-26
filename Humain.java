class Humain extends Joueurs
{

    public Humain(String nom,int couleur) 
    {
    super(nom, couleur);
    }

    public void joue(Jeu jeu)
{
    jeu.afficher();

    boolean valide;
    do
    {
        System.out.println("\n\n");
        Puissance4.espace();
        System.out.println("Joueur " + this.getNom() + ", entrez un numéro de colonne" +"  (entre 1 et " + jeu.getColonne() + ") : ");

        int col = Puissance4.scanner.nextInt(); //récuperer le numéro de la colonne et  
        col--;                                  //soustraire 1 du nombre pour l'adapter à notre numérotation

        valide = jeu.joueCoup(col, this.getCouleur());
        if (!valide )
        {
            Puissance4.espace();
        System.out.println("-> Veuillez reessayer");
        }
    } while (!valide );
    Puissance4.viderConsole();
    
}
}
