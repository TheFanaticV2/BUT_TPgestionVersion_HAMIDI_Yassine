package fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.List;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Acteur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.ennemis.Ennemi;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.ennemis.EnnemiBoss;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.ImageMap;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue.ActeurVue;

public class ObsListActeurs implements ListChangeListener<Acteur> {

    private Pane pane;
    private ImageMap imageMap = new ImageMap();
    private ActeurVue acteurVue;
    private Joueur joueur;

    public ObsListActeurs(Pane p, Joueur j){
        joueur = j;
        pane = p;
        acteurVue = new ActeurVue(p);
    }

    @Override
    public void onChanged(Change<? extends Acteur> c) {
        List<? extends Acteur> listAjoutes ;
        List<? extends Acteur> listEnleves ;
        while (c.next()){
            listAjoutes = c.getAddedSubList();
            listEnleves = c.getRemoved();
            for(Acteur a : listAjoutes){
                acteurVue.createSprite(a);
            }
            for(Acteur a : listEnleves){
                if(a instanceof Ennemi){
                    acteurVue.removeSprite(a);
                    joueur.getListeQuetes().killTracker(a);
                    if(a instanceof EnnemiBoss)
                        SoundPlayer.playMusiqueDeFond("goodTime.wav");
                }
            }
        }
    }

}
