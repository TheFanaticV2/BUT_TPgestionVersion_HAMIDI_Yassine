package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Inventaire;
import javafx.scene.control.Label;

public class ItemDescriptionSwitcher {
    private Label description;
    public ItemDescriptionSwitcher(Label description){ this.description=description; }
    public void switchDescription(String clicSource, Inventaire inventaire){
            description.setText(inventaire.getListObjet().get(inventaire.trouverObjet(clicSource)).getDescription());
    }
}
