package fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Objets.Bois;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Objets.Objet;

public class SourceBois extends Ressource{
    public SourceBois(int posX, int posY) {
        super(posX, posY);
        super.setQuantite((int)(Math.random()*9)+1);
        super.setRecompense("Bois");
    }
}
