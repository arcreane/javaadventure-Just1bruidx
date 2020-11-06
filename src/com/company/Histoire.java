package com.company;

import java.util.Scanner;

public class Histoire {
    Scanner scanner = new Scanner(System.in);
private Donjon mDonjon = new Donjon(new Salle[]{
        new Salle ("vestibule", new Magicien()),
        new Salle( "Salle 2", new Barbare()),
        new Salle("salle 3", new Magicien()),
        new Salle("Salle 4", new Barbare())});

private Aventurier mAventurier = new Aventurier();

public void run() {
    if (!debut())
    {return;}
    for (int i = 0; i < mDonjon.getSalles().length; i++) {
      if  (! salle(mDonjon.getSalles()[i])) {
          System.out.println("T'es mort !");
          return;
      }
    }
    System.out.println("Felicitation !! ");
}

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
        return (choixUtilisateur == 1);
    }

    private boolean salle(Salle salle) {

    Ennemi ennemi = salle.getEnnemi();
        System.out.println("Tu entre dans la salle " + salle.getNom() +  " une ennemi te saute dessus, c'est un " + ennemi.getNom());
        while(mAventurier.getVie() > 0 && ennemi.getVie() > 0) {
            System.out.println("Que souhaite tu faire : ");
            System.out.println("Tape au clavier pour entrer la reponse ");
            System.out.println(Arme.Sword + ": Taper à l'épée");
            System.out.println(Arme.Water_Flask + " : envoyer une grenade ");

            String choix = scanner.nextLine();
            if (choix.equals(Arme.Water_Flask) || choix.equals(Arme.Sword)) {
                int degat = mAventurier.taper(ennemi, choix);
                if (degat == 0 ) {
                    System.out.println("Cela ne fait rien contre ce monstre..");
                } else {
                    System.out.println("Tu viens de lui infliger " + degat + " il lui reste " + ennemi.getVie());
                }
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
