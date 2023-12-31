package fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.ennemis.EnnemiBoss;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Acteur {

    private final IntegerProperty x;
    private final IntegerProperty y;
    private final String id;
    private static int a = 0;

    public Acteur(int x, int y) {
        if(this instanceof EnnemiBoss)
            id = "aBoss";
        else{
            id="a"+a;
            a++;
        }
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }



    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public String getId() {
        return id;
    }

    public int getX() {return this.x.getValue();}
    public int getY() {return this.y.getValue();}
    public IntegerProperty getXProperty() {return this.x;}
    public IntegerProperty getYProperty() {return this.y;}

    public int getCentreActeurX(){
        return getX()+8;
    }
    public int getCentreActeurY(){
        return getY()+8;
    }


}




