package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Armes.ShopInventory;
import javafx.scene.control.Label;

public class ArmeDescriptionSwitcher {
    private Label armeDescription;
    public ArmeDescriptionSwitcher(Label armeDescription){
        this.armeDescription=armeDescription;
    }

    public void switchArmeDescription (String nom, ShopInventory shopInventory){
        armeDescription.setText(shopInventory.getArmeDescritpion(nom));
    }
}
