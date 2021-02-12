package com.example.gsbvisite.controller;

import android.content.Context;
import com.example.gsbvisite.model.MedicamentDao;
import com.example.gsbvisite.model.Medicament;

import java.util.ArrayList;

/**
 * MedicamentController.
 * @author : B. CHATAING.
 * created on  26/01/2021.
 * modified on 27/01/2021.
 */
public final class MedicamentController {

    private static MedicamentController medicamentController = null;
    private static ArrayList<Medicament>medicaments;

    private MedicamentController() {
        super();
    }

    /**
     * Accesseur.
     * @return : une instance unique de MedicamentController (singleton)
     */
    public static MedicamentController getInstance(Context context) {
        if(MedicamentController.medicamentController == null) {
            MedicamentController.medicamentController = new MedicamentController();
            medicaments = new ArrayList<>();
            MedicamentDao medicamentDao = new MedicamentDao(context);
            medicaments = medicamentDao.read();
        }
        return MedicamentController.medicamentController;
    }

    /**
     * Trouver un médicament par son indice dans l'arraylist.
     * @param index : indice dans l'arraylist.
     * @return le médicament
     */
    public Medicament getMedicament(int index) {
        return medicaments.get(index);
    }

    /**
     * Liste des médicaments
     * @return : l'arraylist de médicaments.
     */
    public ArrayList<Medicament> medicaments() {
        return medicaments;
    }

}
