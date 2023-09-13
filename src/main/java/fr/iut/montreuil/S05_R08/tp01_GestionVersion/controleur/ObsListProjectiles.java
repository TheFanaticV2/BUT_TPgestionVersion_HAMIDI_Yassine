package fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur;


import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.List;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Projectile;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue.ProjectilesVue;

public class ObsListProjectiles implements ListChangeListener<Projectile> {

    private ProjectilesVue projectilesVue;

    public ObsListProjectiles (Pane gamePane){
        this.projectilesVue = new ProjectilesVue(gamePane);
    }

    @Override
    public void onChanged(Change<? extends Projectile> list) {
        List<? extends Projectile> listAdded;
        List<? extends Projectile> listRemoved;
        while (list.next()){
            listAdded = list.getAddedSubList();
            listRemoved = list.getRemoved();
            for (Projectile p : listAdded){
                projectilesVue.creerBulletSprite(p);
            }
            for (Projectile p : listRemoved){
                projectilesVue.removeBulletFromPane(p);
            }
        }
    }
}
