package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Acteur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Pnj;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class DialogueVue {
    private final Label label;
    private final Pane pane;
    private final Joueur joueur;
    public static long tempsDebutDialogue;
    public DialogueVue(Label label, Pane pane, Joueur joueur){
        this.label=label;
        this.pane=pane;
        this.joueur=joueur;
    }

    public void debutDialogueTimeSetter(long temps){
        tempsDebutDialogue = temps;
    }
    public void checkDialogueTimerOut(long tempsActuel){
        //si on reste 5 seconde la fenetre de dialogue disparait.
        if (tempsActuel == tempsDebutDialogue+2000)
           pane.setVisible(false);
    }

    public void afficherDialogue(Acteur a){
        //partie visibilité
        this.pane.setVisible(!this.pane.isVisible());
        //partie set text

        if (!joueur.getListeQuetes().getQueteActuelle().getTitre().startsWith("Felicitation")) {
            this.label.setText(((Pnj) a).getNextRepliques());
        }
        else{ this.label.setText(((Pnj) a).getRepliquesFinDuJeu().get(0)); }
    }
}

