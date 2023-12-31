package fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Objets.Objet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressource {

    private final IntegerProperty x = new SimpleIntegerProperty();
    private final IntegerProperty y = new SimpleIntegerProperty();
    private final String id;
    private static int e;
    private String recompense;
    private int quantite;

    public Ressource(int posX, int posY){
        x.setValue(posX);
        y.setValue(posY);
        id = "r"+e;
        e++;
    }

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public String getRecompense() {
        return recompense;
    }

    public void setRecompense(String recompense) {
        this.recompense = recompense;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getId() {
        return id;
    }

    public int getCentreRessourceX(){
        return getX()+8;
    }
    public int getCentreRessourceY(){
        return getY()+8;
    }
}
