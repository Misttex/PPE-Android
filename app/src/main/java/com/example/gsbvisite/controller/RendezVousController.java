package com.example.gsbvisite.controller;


import android.content.Context;
import com.example.gsbvisite.model.RendezVous;

import com.example.gsbvisite.model.RendezVousDao;

import java.util.ArrayList;

/**
 * PraticienController.
 * @author : B. CHATAING.
 * created on  01/02/2021.
 * modified on .
 */
public final class RendezVousController {
    private static RendezVousController rendezVousController = null;
    private static ArrayList<RendezVous> rendezVous;

    private RendezVousController() {
        super();
    }

    /**
     * Accesseur.
     * @return : une instance unique de RendezVousController (singleton)
     */
    public static RendezVousController getInstance(Context context) {
        if(RendezVousController.rendezVousController == null) {
            RendezVousController.rendezVousController = new RendezVousController();
            rendezVous = new ArrayList<>();
            RendezVousDao rendezVousDAO = new RendezVousDao(context);
            rendezVous = rendezVousDAO.read();
        }
        return RendezVousController.rendezVousController;
    }

    /**
     * Trouver un médicament par son indice dans l'arraylist.
     * @param index : indice dans l'arraylist.
     * @return le médicament
     */
    public RendezVous getRendezVous(int index) {
        return rendezVous.get(index);
    }

    /**
     * Liste des médicaments
     * @return : l'arraylist de médicaments.
     */
    public ArrayList<RendezVous> rendezVous() {
        return rendezVous;
    }
}
