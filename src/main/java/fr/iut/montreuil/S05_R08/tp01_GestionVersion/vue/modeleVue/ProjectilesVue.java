package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue;

import java.io.File;
import java.net.MalformedURLException;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ProjectilesVue {
    private Pane gamePane;

 
    public ProjectilesVue (Pane gamePane) {
        this.gamePane = gamePane;
    }

    private Image imageBambouBullet ;
    private Image imageOeilBullet ;
    private Image imageShuriken ;

    private Image imageBossBullet;
    private Image imageBossBulletRight;
    private Image imageBossBulletLeft ;
    private Image imageBossBulletSpecial;
    
    public void creerBulletSprite(Projectile p){
    	
    	try {	
    	     if(imageBambouBullet == null) imageBambouBullet = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bambouBullet.png").toURI().toURL().toString());
				
    	     if(imageOeilBullet == null) imageOeilBullet = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/oeilBullet.png").toURI().toURL().toString());
    	     if (imageShuriken == null) imageShuriken = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken.png").toURI().toURL().toString());

    	     if( imageBossBullet == null) imageBossBullet = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bossBullet.png").toURI().toURL().toString());
    	     if(imageBossBulletRight == null) imageBossBulletRight = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bossBulletRight.png").toURI().toURL().toString());
    	     if(imageBossBulletLeft == null) imageBossBulletLeft = new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bossBulletLeft.png").toURI().toURL().toString());
    	     if(imageBossBulletSpecial == null) imageBossBulletSpecial= new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bossBulletSpecial.png").toURI().toURL().toString());

    	
        ImageView i = new ImageView();
        if (p.getOrigine().equals("Bambou"))
            i.setImage(imageBambouBullet);
        else if(p.getOrigine().equals("Oeil"))
            i.setImage(imageOeilBullet);
        else if(p.getOrigine().startsWith("EnnemiBoss")){
            if(p.getDirection().equals("RIGHT")){
                i.setImage(imageBossBulletRight);
            }
            else if(p.getDirection().equals("LEFT")){
                i.setImage(imageBossBulletLeft);
            }
            else if(p.getOrigine().equals("EnnemiBossSPE")){
                i.setImage(imageBossBulletSpecial);
            }
            else
                i.setImage(imageBossBullet);
        }
        else
            i.setImage(imageShuriken);
        i.setId(p.getId());
        i.setLayoutX(p.getX());
        i.setLayoutY(p.getY());
        i.layoutXProperty().bind(p.xProperty());
        i.layoutYProperty().bind(p.yProperty());
        gamePane.getChildren().add(i);
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void removeBulletFromPane(Projectile p){
        gamePane.getChildren().remove(gamePane.lookup("#"+p.getId()));
    }
}
