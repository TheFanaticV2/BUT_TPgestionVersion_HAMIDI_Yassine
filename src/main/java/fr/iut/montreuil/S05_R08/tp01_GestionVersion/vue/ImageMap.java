package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class ImageMap {

    private Map<String, Image> map = new HashMap<>();

    public ImageMap(){
    	
    	
        try {
			map.put("empty", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/empty.png").toURI().toURL().toString()));
		
	        map.put("Slime", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/slime.png").toURI().toURL().toString()));
	        map.put("Bambou", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/Bambou.png").toURI().toURL().toString()));
	        map.put("Bete", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/bete.png").toURI().toURL().toString()));
	        map.put("Oeil", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/Oeil.png").toURI().toURL().toString()));
	        map.put("Hibou", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/Hibou.png").toURI().toURL().toString()));
	        map.put("Reptile", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/reptile.png").toURI().toURL().toString()));
	        map.put("EnnemiBoss", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ennemis/boss.png").toURI().toURL().toString()));
	
	        map.put("kid", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/kid.png").toURI().toURL().toString()));
	        map.put("cavegirl", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/cavegirl.png").toURI().toURL().toString()));
	        map.put("goldninja", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/goldninja.png").toURI().toURL().toString()));
	        map.put("master", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/master.png").toURI().toURL().toString()));
	        map.put("moine", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/moine.png").toURI().toURL().toString()));
	        map.put("spectre", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/spectre.png").toURI().toURL().toString()));
	        map.put("upgrader", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/upgrader.png").toURI().toURL().toString()));
	        map.put("vendeur", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/vendeur.png").toURI().toURL().toString()));
	        map.put("vieux", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/vieux.png").toURI().toURL().toString()));
	        map.put("villageois1", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/villageois1.png").toURI().toURL().toString()));
	        map.put("villageois2", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/villageois2.png").toURI().toURL().toString()));
	        map.put("villageois3", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/villageois3.png").toURI().toURL().toString()));
	        map.put("villageois4", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/villageois4.png").toURI().toURL().toString()));
	        map.put("villageois5", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/villageois5.png").toURI().toURL().toString()));
	        map.put("chocobo",new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/chocobo.png").toURI().toURL().toString()));
	        map.put("luigi",new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/luigi.png").toURI().toURL().toString()));
	        map.put("panneau",new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/panneau.png").toURI().toURL().toString()));
	        map.put("cloud",new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/cloud.png").toURI().toURL().toString()));
	        map.put("épouvantail",new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/pnj/epouvantail.png").toURI().toURL().toString()));
	
	        map.put("playerDOWN", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/player/playerDOWN.png").toURI().toURL().toString()));
	        map.put("playerUP", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/player/playerUP.png").toURI().toURL().toString()));
	        map.put("playerRIGHT", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/player/playerRIGHT.png").toURI().toURL().toString()));
	        map.put("playerLEFT", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/player/playerLEFT.png").toURI().toURL().toString()));
	
	        map.put("SourceBois", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/bois.png").toURI().toURL().toString()));
	        map.put("SourceTresor", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/coffre.png").toURI().toURL().toString()));
	        map.put("SourceMinerai", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/ressourcesImg/minerai.png").toURI().toURL().toString()));
	
	        map.put("shuriken", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken.png").toURI().toURL().toString()));
	        map.put("shuriken2", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken2.png").toURI().toURL().toString()));
	        map.put("shuriken3", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken3.png").toURI().toURL().toString()));
	        map.put("shuriken4", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken4.png").toURI().toURL().toString()));
	        map.put("shuriken5", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken5.png").toURI().toURL().toString()));
	        map.put("shuriken6", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken6.png").toURI().toURL().toString()));
	        map.put("shuriken7", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken7.png").toURI().toURL().toString()));
	        map.put("shuriken8", new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/armes/shuriken8.png").toURI().toURL().toString()));
        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Map<String, Image> getMap() {
        return map;
    }

    public Image getImage(String name){
        return map.get(name);
    }
}
