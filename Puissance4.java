import java.util.Scanner;

import java.util.concurrent.TimeUnit;

class Puissance4 {
  protected static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    ligne();
    espace();
    System.out.println("                     EILCO-ING1");
    espace();
    System.out.println("-----------------------------------------------------");
    espace();
    System.out.println("     ");
    espace();
    System.out.println("           ---------------------------                             ");
    espace();
    System.out.println("          |       Puissance4          |                ");
    espace();
    System.out.println("           ---------------------------                                            ");
    espace();
    System.out.println("                                                       ");
    espace();
    System.out.println("-----------------------------------------------------");
    espace();
    System.out.println("Realise par:  HEJBANE Mohamed et SABOUNI Ahmed");
    espace();
    System.out.println("--------------------------------------------------- ");
    delay(5);
    viderConsole();
    ligne();
    espace();
    System.out.println("Entrez votre nom(Joueur1): ");
    String nom1 = scanner.nextLine();
    viderConsole();
    ligne();
    espace();
    System.out.println("Entrez votre nom(Joueur2): ");
    String nom2 = scanner.nextLine();
    viderConsole();

    Partie p = new Partie(new Humain(nom1, Jeu.BLEU), new Humain(nom2, Jeu.ROUGE));
    p.joue();// debut de la partie
  }

  public static void ligne() {
    for (int i = 0; i < 5; i++) {
      System.out.print("\n");
    }
  }

  public static void espace() {
    for (int i = 0; i < 40; i++) {
      System.out.print(" ");

    }
  }

  public static void delay(int t) {
    try {
      TimeUnit.SECONDS.sleep(t);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void viderConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}
