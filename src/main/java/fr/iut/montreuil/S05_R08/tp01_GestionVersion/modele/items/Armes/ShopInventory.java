package fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.items.Armes;

import java.util.ArrayList;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Projectile;

public class ShopInventory {
    ArrayList<Arme> inventoryShop;

    public ShopInventory(){
        this.inventoryShop=new ArrayList<Arme>();
        inventoryShop.add(new Epee());
        inventoryShop.add(new EpeeLongue());
        inventoryShop.add(new Gourdin());
        inventoryShop.add(new Hache());
        inventoryShop.add(new Katana());
        inventoryShop.add(new Lance());
        inventoryShop.add(new Marteau());
    }

    public String getArmeDescritpion(String nom){
        for(Arme a : inventoryShop) {
            if (nom.endsWith(a.getClass().getSimpleName()))
                return a.getShopDescription();
        }
        return "";
    }
    public Arme chercherArme(String nom){
        for (Arme a : inventoryShop){
            if (a.getNom().equals(nom))
                return a;
        }
        return null;
    }
}
