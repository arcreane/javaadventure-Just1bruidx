package com.company;

public class Salle {

    private Ennemi mEnnemi;
    private String mNom;

    public Salle(String nom, Ennemi ennemi) {
        mNom = nom;
        mEnnemi = ennemi;
    }

    public String getNom() {
        return mNom;
    }

    public Ennemi getEnnemi() {
        return mEnnemi;
    }
}
