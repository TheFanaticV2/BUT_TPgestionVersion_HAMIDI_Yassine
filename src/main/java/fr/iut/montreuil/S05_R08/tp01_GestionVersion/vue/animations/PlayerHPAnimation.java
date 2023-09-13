package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.animations;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.ImageMap;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PlayerHPAnimation {
    public static void initAnimation(Joueur joueur, ImageView hpBar, ImageMap imageMap, Label pourcentage) {
        joueur.getHp().addListener(e -> {
            //hpBar.setImage(imageMap.getImage((int)((double)(joueur.getHp().getValue())/(double)(joueur.getMaxHP())*10)+"HP"));
            hpBar.setScaleX(((double)joueur.getHp().getValue())/(double)(joueur.getMaxHP()));
            pourcentage.setText(((double)joueur.getHp().getValue()/(double)(joueur.getMaxHP())*100)+"%");
        });
    }
}
