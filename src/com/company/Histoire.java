package com.company;

import java.util.Random;
import java.util.Scanner;

public class Histoire {

    // Differentes salles du jeu / Array[]
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

private Donjon mDonjon = new Donjon(new Salle[]{
        new Salle("vestibule", new Magicien()),
        new Salle( "Boudoir", new Barbare()),
        new Salle("Grand Salon", new Magicien()),
        new Salle("Bibliothèque", new Barbare()),
        new Salle("Salle du boss ! ", new Magicien())});

private Aventurier mAventurier = new Aventurier();

public void run() {
    // si le choix est different de 1 on quitte
    if (!debut())
    {return;}
    for (int i = 0; i < mDonjon.getSalles().length; i++) {
      if  (! salle(mDonjon.getSalles()[i])) {
          System.out.println("T'es mort !");
          return;
      }
    }
    System.out.println("Felicitation !! ");
    System.out.println("Vous avez gagné le tresor du Donjon Hurlant \uD83D\uDC8D\uD83D\uDCB0");
}
    // Debut du script
    public boolean debut() {

        System.out.println("Bienvenue à toi jeune Padawan");
        System.out.println("Tu viens d'arriver devant le Donjon Hurlant");
        System.out.println("Il y a devant toi une grande porte en bois et fer forgé qui ferme le donjon.");
        System.out.println("En regardant de plus près il semble que la porte n'est pas verouillée. ");
        System.out.println("Que souhaite tu faire? ");
        System.out.println(" ");

        System.out.println(" 1 - Entrer dans le Donjon ");
        System.out.println(" 2 - Partir en courant ");

        Scanner scan = new Scanner(System.in);
        int choixUtilisateur = scan.nextInt();

        // Si choix utilisateur est egal a 1 on rentre dans le jeu
        return (choixUtilisateur == 1);
    }


    private boolean salle(Salle salle) {

    // Méthode pour le jeu de role - précise la vie du joueur/ennemi + vie joueur/ennemi
    Ennemi ennemi = salle.getEnnemi();
        System.out.println("Tu entre dans la salle " + salle.getNom() +  " une ennemi te saute dessus, c'est un " + ennemi.getNom());
        while(mAventurier.getVie() > 0 && ennemi.getVie() > 0) {
            System.out.println("Que souhaite tu faire : ");
            System.out.println("Tape au clavier pour entrer la reponse ");
            System.out.println(Arme.Sword + ": Taper à l'épée");
            System.out.println(Arme.Water_Flask + " : envoyer une grenade ");

            // Combat : demande de choisir quel arme on souhaite utiliser
            // indique la vie et la force de l'attaque
            String choix = scanner.nextLine();
            if (choix.equals(Arme.Water_Flask) || choix.equals(Arme.Sword)) {
                int degat = mAventurier.taper(ennemi, choix);
                if (degat == 0 ) {
                    System.out.println("Cela ne fait rien contre ce monstre..");
                } else {
                    System.out.println("Tu viens de lui infliger " + degat + " il lui reste " + ennemi.getVie());
                }
                // L'aventurier est vulnérable a toutes les armes
                degat = ennemi.taper(mAventurier, null);
                System.out.println("Il t'a fait perdre " + degat);
                System.out.println("Il te reste " + mAventurier.getVie());

            } else {
                System.out.println("Cette arme n'est pas valide.. ");
                continue;
            }
        }
        if (mAventurier.getVie() > 0) {
            System.out.println("Felicitation vous passez dans la salle suivante !");
            return true;
        } else {
            return false;
        }
    }

}
