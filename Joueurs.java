public class Joueurs
{
    private String nom;
    private int couleur;

    public Joueurs(String nom, int couleur)
    {
    this.nom = nom;
    this.couleur = couleur;
    }

    public String getNom()
    {
    return nom;
    }

    public int getCouleur() 
    {
    return couleur;
    }

    
    public void joue(Jeu jeu) {} // les sous classes vont implémenter cette fonction

}
