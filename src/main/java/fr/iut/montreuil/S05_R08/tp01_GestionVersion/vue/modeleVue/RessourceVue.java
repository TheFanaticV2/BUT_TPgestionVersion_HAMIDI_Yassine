package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue;

import java.io.File;
import java.net.MalformedURLException;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources.Ressource;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources.SourceBois;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources.SourceMinerai;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RessourceVue {
    private Pane gamePane;

  

    public RessourceVue (Pane gamePane) {
        this.gamePane = gamePane;
    }

    
    private Image coffre;
    private Image bois ;
    private Image minerai;
    
    public void creerRessourceSprite(Ressource ressource){
    	
    	try {
    	if(coffre == null) coffre = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/coffre.png").toURI().toURL().toString());
    	if (bois == null) bois = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/bois.png").toURI().toURL().toString());
    	if (minerai ==null) minerai = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/minerai.png").toURI().toURL().toString());
    	
        ImageView img;
        if(ressource instanceof SourceBois)
             img = new ImageView(bois);
        else if(ressource instanceof SourceMinerai)
            img = new ImageView(minerai);
        else
            img = new ImageView(coffre);
        img.setId(ressource.getId());
        img.setLayoutX(ressource.getX());
        img.setLayoutY(ressource.getY());
        gamePane.getChildren().add(img);
    	 } catch (MalformedURLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    public void removeRessourceFromPane(Ressource ressource){
        gamePane.getChildren().remove(gamePane.lookup("#"+ressource.getId()));
    }

}
