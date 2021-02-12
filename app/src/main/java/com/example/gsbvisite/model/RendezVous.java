package com.example.gsbvisite.model;


/**
 * Classe RendezVous.
 * @author : B. CHATAING.
 * created on  31/01/2021.
 * modified on 31/01/2021.
 */
public class RendezVous {
    private int numero;
    private String dateRdv;
    private String heure;
    private Praticien praticien;

    /**
     * Constructeur.
     * @param numero
     * @param dateRdv
     * @param heure
     * @param praticien
     */
    public RendezVous(int numero, String dateRdv, String heure, Praticien praticien) {
        this.numero = numero;
        this.dateRdv = dateRdv;
        this.heure = heure;
        this.praticien = praticien;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDate() {
        return dateRdv;
    }

    public void setDate(String date) {
        this.dateRdv = dateRdv;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }
}
