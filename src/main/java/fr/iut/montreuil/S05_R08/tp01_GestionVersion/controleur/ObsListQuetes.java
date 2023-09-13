package fr.iut.montreuil.S05_R08.tp01_GestionVersion.controleur;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.quetes.Quete;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue.QueteVue;
import javafx.collections.ListChangeListener;

public class ObsListQuetes implements ListChangeListener<Quete> {

    private QueteVue queteVue;

    public ObsListQuetes(QueteVue queteVue){
        this.queteVue = queteVue;
    }

    @Override
    public void onChanged(Change<? extends Quete> c) {

        queteVue.displayQuest(c.getList().get(0));
    }
}
