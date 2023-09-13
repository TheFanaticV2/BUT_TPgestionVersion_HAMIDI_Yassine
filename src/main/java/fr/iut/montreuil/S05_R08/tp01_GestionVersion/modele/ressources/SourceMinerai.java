package fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Objets.MineraiBrut;

public class SourceMinerai extends Ressource{

    public SourceMinerai(int posX, int posY) {
        super(posX, posY);
        super.setQuantite((int)(Math.random()*5)+1);
        super.setRecompense("MineraiBrut");
    }
}
