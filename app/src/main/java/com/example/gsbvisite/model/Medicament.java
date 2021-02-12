package com.example.gsbvisite.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Medicament implements Parcelable {
    private String MDepotLegal;
    private String MNomCommercial;
    private String MComposition;
    private String MEffet;
    private String MContreIndic;
    private Double MPrixEchant;

    public Medicament(String MDepotLegal, String MNomCommercial, String MComposition, String MEffet, String MContreIndic, Double MPrixEchant) {
        this.MDepotLegal = MDepotLegal;
        this.MNomCommercial = MNomCommercial;
        this.MComposition = MComposition;
        this.MEffet = MEffet;
        this.MContreIndic = MContreIndic;
        this.MPrixEchant = MPrixEchant;
    }
    private Medicament(Parcel in){
        MDepotLegal = in.readString();
        MNomCommercial = in.readString();
        MComposition = in.readString();
        MEffet = in.readString();
        MContreIndic = in.readString();
        MPrixEchant = in.readDouble();
    }
    public static final Parcelable.Creator<Medicament> CREATOR = new Parcelable.Creator<Medicament>(){
       public Medicament createFromParcel(Parcel in){
           return new Medicament(in);
       }

        @Override
        public Medicament[] newArray(int size) {
            return new Medicament[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
   }
    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(getMDepotLegal());
        dest.writeString(getMNomCommercial());
        dest.writeString(getMComposition());
        dest.writeString(getMEffet());
        dest.writeString(getMContreIndic());
        dest.writeDouble(getMPrixEchant());
    }
    public String getMDepotLegal() {
        return MDepotLegal;
    }

    public void setMDepotLegal(String MDepotLegal) {
        this.MDepotLegal = MDepotLegal;
    }

    public String getMNomCommercial() {
        return MNomCommercial;
    }

    public void setMNomCommercial(String MNomCommercial) {
        this.MNomCommercial = MNomCommercial;
    }

    public String getMComposition() {
        return MComposition;
    }

    public void setMComposition(String MComposition) {
        this.MComposition = MComposition;
    }

    public String getMEffet() {
        return MEffet;
    }

    public void setMEffet(String MEffet) {
        this.MEffet = MEffet;
    }

    public String getMContreIndic() {
        return MContreIndic;
    }

    public void setMContreIndic(String MContreIndic) {
        this.MContreIndic = MContreIndic;
    }

    public Double getMPrixEchant() {
        return MPrixEchant;
    }
}
