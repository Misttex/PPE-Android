package com.example.gsbvisite.controller;

import android.content.Context;
import com.example.gsbvisite.model.Praticien;

import com.example.gsbvisite.model.PraticienDao;

import java.util.ArrayList;

/**
 * PraticienController.
 * @author : B. CHATAING.
 * created on  01/02/2021.
 * modified on .
 */
public final class PraticienController {
    private static PraticienController praticienController = null;
    private static ArrayList<Praticien> praticiens;

    private PraticienController() {
        super();
    }

    /**
     * Accesseur.
     * @return : une instance unique de PraticienController (singleton)
     */
    public static PraticienController getInstance(Context context) {
        if(PraticienController.praticienController == null) {
            PraticienController.praticienController = new PraticienController();
            praticiens = new ArrayList<>();
            PraticienDao praticienDao = new PraticienDao(context);
            praticiens = praticienDao.read();
        }
        return PraticienController.praticienController;
    }

    /**
     * Trouver un médicament par son indice dans l'arraylist.
     * @param index : indice dans l'arraylist.
     * @return le médicament
     */
    public Praticien getPraticien(int index) {
        return praticiens.get(index);
    }

    /**
     * Liste des médicaments
     * @return : l'arraylist de médicaments.
     */
    public ArrayList<Praticien> praticiens() {
        return praticiens;
    }

}
