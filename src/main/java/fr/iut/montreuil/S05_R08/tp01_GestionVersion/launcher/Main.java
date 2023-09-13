package fr.iut.montreuil.S05_R08.tp01_GestionVersion.launcher;

import java.io.File;
import java.net.URL;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	URL url = new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/vue/sample.fxml").toURI().toURL();
    	FXMLLoader.load(url);
    	
    	BorderPane root = FXMLLoader.load(url);
        Scene scene = new Scene(root,1280,720);
        primaryStage.getIcons().add(new Image(new File("src/main/java/fr/iut/montreuil/S05_R08/tp01_GestionVersion/ressources/logo.png").toURI().toURL().toString()));

        scene.setOnKeyPressed(Controller::keyManager);
        scene.setOnKeyReleased(Controller::keyReleaseManager);


        primaryStage.setTitle("Tales of a Blind World GOTY 2023 Edition");
        primaryStage.setScene(scene);


        primaryStage.setResizable(false);
        primaryStage.show();
    
    	
    	/*
    	 Default Launch
    	 
        var javaVersion = "1";
        var javafxVersion = "1";

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    	*/
    	
    	
    }


    public static void main(String[] args) {
        launch(args);
    }
}
