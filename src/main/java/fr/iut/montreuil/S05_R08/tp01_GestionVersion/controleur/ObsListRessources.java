package fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.List;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources.Ressource;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue.RessourceVue;

public class ObsListRessources implements ListChangeListener<Ressource> {

    private RessourceVue ressourceVue;
    private Joueur joueur;

    public ObsListRessources(Pane p, Joueur j){
        joueur = j;
        ressourceVue = new RessourceVue(p);
    }

    @Override
    public void onChanged(Change<? extends Ressource> list) {
        List<? extends Ressource> listAdded;
        List<? extends Ressource> listRemoved;
        while (list.next()){
            listAdded = list.getAddedSubList();
            listRemoved = list.getRemoved();
            for (Ressource r : listAdded){
                ressourceVue.creerRessourceSprite(r);
            }
            for (Ressource r : listRemoved){
                ressourceVue.removeRessourceFromPane(r);
                joueur.getListeQuetes().ressourceTracker(r);
            }
        }
    }
}
