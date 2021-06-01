package com.example.gsbvisite.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe RendezVous.
 * @author : B. CHATAING.
 * created on  31/01/2021.
 * modified on 31/01/2021.
 */
public class RendezVous implements Parcelable {
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
    private RendezVous(Parcel in){
        dateRdv = in.readString();
        heure = in.readString();
    }
    public static final Parcelable.Creator<RendezVous> CREATOR = new Parcelable.Creator<RendezVous>(){
        public RendezVous createFromParcel(Parcel in){
            return new RendezVous(in);
        }

        @Override
        public RendezVous[] newArray(int size) {
            return new RendezVous[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getHeure());
        dest.writeString(getDate());
    }
}
