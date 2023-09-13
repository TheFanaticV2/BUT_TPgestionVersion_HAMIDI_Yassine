package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur.*;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Terrain;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Acteur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Pnj;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.ennemis.Ennemi;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.ressources.Ressource;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.ImageMap;

public class TerrainVue {

    /*
    PERMET DE CHARGER LA MAP ET LES TEXTURES
     */

    private Terrain zoneActuelle;
    private Joueur joueur;
    private MapLoader mapLoader = new MapLoader();
    private ImageMap imageMap = new ImageMap();

    private Pane gamePane;

    private TilePane tilePane;
    private TilePane tilePaneDeco;
    private TilePane tilePaneSolid;
    public TerrainVue(Terrain zoneActuelle, Joueur joueur, Pane gamePane, TilePane tilePane, TilePane tilePaneDeco, TilePane tilePaneSolid){
        this.zoneActuelle = zoneActuelle;
        this.joueur = joueur;
        this.gamePane = gamePane;
        this.tilePane = tilePane;
        this.tilePaneDeco = tilePaneDeco;
        this.tilePaneSolid = tilePaneSolid;
        zoneActuelle.getProjectiles().addListener(new ObsListProjectiles(gamePane));
        for(int i = 0; i<zoneActuelle.getSaveActeurs().getSavesListesActeurs().size();i++)
            zoneActuelle.getSaveActeurs().getSavesListesActeurs().get(i).addListener(new ObsListActeurs(gamePane, joueur));
        for(int i = 0; i<zoneActuelle.getSaveRessources().getSaveListesRessources().size();i++)
            zoneActuelle.getSaveRessources().getSaveListesRessources().get(i).addListener(new ObsListRessources(gamePane, joueur));

    }
    // CHARGE L'AFFICHAGE DES ACTEURS LORS DU CHARGEMENT DE MAP
    public void updateActeurs(){
        Acteur a;
        Node b;
        for(int i = zoneActuelle.getListeActeurs().size()-1; i>=0;i--){
            a = zoneActuelle.getListeActeurs().get(i);
            if(gamePane.lookup("#"+a.getId())==null){
                if(a instanceof Ennemi){
                    ImageView sprite = new ImageView(imageMap.getImage(a.getClass().getSimpleName())); // récupère l'image de l'ennemi correspondant
                    sprite.setId(a.getId());
                    sprite.translateXProperty().bind(a.getXProperty());
                    sprite.translateYProperty().bind(a.getYProperty());
                    gamePane.getChildren().add(sprite);
                }
                else{
                    ImageView sprite = new ImageView(imageMap.getImage(((Pnj) a).getNom())); // récupère l'image de l'ennemi correspondant
                    sprite.setTranslateX(a.getX());
                    sprite.setTranslateY(a.getY());
                    sprite.setId(a.getId());
                    sprite.translateXProperty().bind(a.getXProperty());
                    sprite.translateYProperty().bind(a.getYProperty());
                    gamePane.getChildren().add(sprite);
                }
            }
        }

        for(int j = gamePane.getChildren().size()-1;j>=0;j--){
            b = gamePane.getChildren().get(j);
            if((b.getId().startsWith("a") && !zoneActuelle.findActeur(b.getId())))
                gamePane.getChildren().remove(b);
        }
    }
    // CHARGE L'AFFICHAGE DES ACTEURS LORS DU CHARGEMENT DE MAP
    public void updateRessources(){
        Ressource r;
        Node b;
        for(int i = zoneActuelle.getListeRessource().size()-1; i>=0;i--){
            r = zoneActuelle.getListeRessource().get(i);
            if(gamePane.lookup("#"+r.getId())==null){
                ImageView sprite = new ImageView(imageMap.getImage(r.getClass().getSimpleName())); // récupère l'image de la ressource correspondante
                sprite.setId(r.getId());
                sprite.setLayoutX(r.getX());
                sprite.setLayoutY(r.getY());
                zoneActuelle.getMapObstacles()[r.getY()/16][r.getX()/16] = 1880; // OBSTACLES QUI N'A PAS DE TEXTURE DANS LA TILE SET
                gamePane.getChildren().add(sprite);
            }
        }
        for(int j = gamePane.getChildren().size()-1;j>=0;j--){
            b = gamePane.getChildren().get(j);
            if((b.getId().startsWith("r") && !zoneActuelle.findRessource(b.getId()))){
                gamePane.getChildren().remove(b);
            }
        }
    }


    //charge le fichier de la premiere map.
    public void loadMap(String numero, int spawnX, int spawnY){
        try {
        	System.out.println("*** CHARGEMENT DE LA MAP "+numero+" ***");
            zoneActuelle.setNomDeCarte("zone"+numero);
            SoundPlayer.playMapMusic(numero);
            zoneActuelle.setMapObstacles(mapLoader.LoadTileMap("map"+numero+"/Map"+numero+"Obstacles"));
            zoneActuelle.setMapSpawn(mapLoader.LoadTileMap("map"+numero+"/Map"+numero+"Spawn"));
            //zoneActuelle.getListeActeurs().addListener(new ObsListActeurs(gamePane, joueur));
            //zoneActuelle.getProjectiles().addListener(new ObsListProjectiles(gamePane));
            //zoneActuelle.getListeRessource().addListener(new ObsListRessources(gamePane, joueur));
            updateActeurs();
            updateRessources();
            zoneActuelle.loadPnjHitboxes();
            joueur.setZone(zoneActuelle);
            joueur.setXProperty(spawnX);
            joueur.setYProperty(spawnY);
            affichageDeMap(numero);
            joueur.getConsole().afficherZoneActuelle(numero);
            //permet de mettre la camera au bon endroit dès le loading de map.
            setCameraOnSpawn(spawnX,spawnY);
            //joueur.updatePosition();
            //zoneActuelle.loadSaveActeurs();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public void setCameraOnSpawn(int spawnX, int spawnY){
        //verifie si, la position du spawn est sur une limite de la map,
        //ajuste la position de la camera en fonction.
        if (spawnX < 152) {
            gamePane.setLayoutX(-152+640);
        }else if (spawnX > zoneActuelle.limiteHorizMap() * 16 - 152) {
            gamePane.setLayoutX(-(joueur.getZone().limiteHorizMap()*16-152)+640);
        }if (spawnY < 115) {
            gamePane.setLayoutY(-115+360);
        }else if (spawnY > zoneActuelle.limiteVertiMap() * 16 - 115) {
            gamePane.setLayoutY(-(zoneActuelle.limiteVertiMap() * 16 - 115)+360);
        }
    }

    
    public void affichageDeMap(String numero) throws IOException {
        System.out.println("affichageDeMap");
        int floor[][] = mapLoader.LoadTileMap("map"+numero+"/Map"+numero+"Floor");
        int deco[][] = mapLoader.LoadTileMap("map"+numero+"/Map"+numero+"Décoration");
        updateTilePaneSize(tilePane, tilePaneDeco, tilePaneSolid, gamePane);
        // affiche chacune des couches
        chargerTextures(floor,tilePane);
        chargerTextures(deco,tilePaneDeco);
        chargerTextures(zoneActuelle.getMapObstacles(),tilePaneSolid);
    }

    private Image tileSet;
    
    public void chargerTextures (int [][] tab, TilePane tilepane){
        //Chargement des textures
       if(tileSet == null) {
    	   System.out.println("Premier chargement de la tileSet");
    	   try {
    		  File tsFile = new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/tilemaps/allTiles.png");
    		  tileSet = new Image(tsFile.toURI().toURL().toString());
    	   } catch (MalformedURLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.out.println("Erreur ! de chargement de la texture de terrainVue");
   			}
    	}
       else {
    	   System.out.println("TileSet existante : "+ tileSet.toString());
       }
		
        tilepane.getChildren().clear();
        for(int i = 0; i<tab.length ; i++){
            for(int j = 0; j<tab[i].length ; j++){
                if(tab[i][j]!=-1) {
                    ImageView tile = new ImageView(tileSet);
                    Rectangle2D cut = new Rectangle2D((int)(tab[i][j]%(tileSet.getWidth()/16))*16,
                            (int) (tab[i][j]/(tileSet.getWidth()/16))*16, 16, 16);
                    tile.setViewport(cut);
                    tilepane.getChildren().add(tile);
                }
                else{
                    tilepane.getChildren().add(new ImageView(imageMap.getImage("empty")));
                }
            }
        }
		
    }
    public void creerNuage(){
    	try {
        ImageView nuage = new ImageView(new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/cloud.png").toURI().toURL().toString()));
        nuage.setId("nuage"+Math.random());
        nuage.setLayoutY(100);
        nuage.setLayoutX(0);
        nuage.setScaleX(.2);
        nuage.setScaleY(.2);
        nuage.setOpacity(0.12);
        gamePane.getChildren().add(nuage);
        ImageView nuage2 = new ImageView(new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/cloud.png").toURI().toURL().toString()));
        nuage2.setId("nuage"+Math.random());
        nuage2.setLayoutY(0);
        nuage2.setLayoutX(-170);
        nuage2.setScaleX(.2);
        nuage2.setScaleY(.2);
        nuage2.setOpacity(0.17);
        gamePane.getChildren().add(nuage2);
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void bougerNuages(){
        for (int i=gamePane.getChildren().size()-1;i>=0;i--) {
            Node nuage = gamePane.getChildren().get(i);
            if(nuage.getId().startsWith("nuage")){
                if(zoneActuelle.getNumeroCarte()==0||zoneActuelle.getNumeroCarte()==6)
                    nuage.setVisible(false);
                else
                    nuage.setVisible(true);
                nuage.setLayoutX(nuage.getLayoutX()+1);
                if(Math.random()>=0.9) nuage.setLayoutY(nuage.getLayoutY()+1);
                if(nuage.getLayoutX()>=zoneActuelle.limiteHorizMap()*12 || nuage.getLayoutY()>=zoneActuelle.limiteVertiMap()*12 ) {
                    ImageView clone = (ImageView) nuage;
                    clone.setLayoutX(-350);
                    clone.setId("nuage"+Math.random());
                    clone.setLayoutY(Math.random() * zoneActuelle.limiteVertiMap()*10);
                    gamePane.getChildren().remove(nuage);
                    gamePane.getChildren().add(clone);
                }
            }
        }
    }

    // ADAPTE LA TAILLE DES TILES PANES DE LA VUE EN FONCTION DE LA MAP
    public void updateTilePaneSize(TilePane floor, TilePane deco, TilePane solid, Pane pane){
        floor.setPrefWidth(zoneActuelle.limiteHorizMap()*16);
        floor.setPrefHeight(zoneActuelle.limiteVertiMap()*16);
        deco.setPrefWidth(zoneActuelle.limiteHorizMap()*16);
        deco.setPrefHeight(zoneActuelle.limiteVertiMap()*16);
        solid.setPrefWidth(zoneActuelle.limiteHorizMap()*16);
        solid.setPrefHeight(zoneActuelle.limiteVertiMap()*16);
        pane.setPrefWidth(zoneActuelle.limiteHorizMap()*16);
        pane.setPrefHeight(zoneActuelle.limiteVertiMap()*16);
    }


    public void rainManager(ImageView rainImageView) {
        if(zoneActuelle.getNumeroCarte()==2 || zoneActuelle.getNumeroCarte()==5){
            rainImageView.setVisible(true);
            if(rainImageView.getLayoutX()==-100){ //-75y
                rainImageView.setLayoutX(-85);
                rainImageView.setLayoutY(-60);
            }
            else if (rainImageView.getLayoutX()==-85){
                rainImageView.setLayoutX(-70);
                rainImageView.setLayoutY(-45);
            }
            else {
                rainImageView.setLayoutX(-100);
                rainImageView.setLayoutY(-75);
            }
        }
        else
            rainImageView.setVisible(false);
    }
}
