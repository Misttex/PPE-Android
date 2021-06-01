package com.example.gsbvisite.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.gsbvisite.R;
import com.example.gsbvisite.model.Medicament;
import com.example.gsbvisite.model.RendezVous;

import java.util.ArrayList;

public class RendezVousListAdapter extends BaseAdapter {

    private final ArrayList<RendezVous> rendezVous;
    private final LayoutInflater inflater;

    public RendezVousListAdapter(Context context, ArrayList<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
        this.inflater = LayoutInflater.from(context);
    }

    //retourne le nombre de ligne
    @Override
    public int getCount() {
        return rendezVous.size();
    }

    //retourne la l'item de la ligne actuelle
    @Override
    public Object getItem(int i) {
        return rendezVous.get(i);
    }

    //retourne un indice par rapport a la l'item actuelle
    @Override
    public long getItemId(int i) {
        return i;
    }

    //retourne la ligne formaté avec la gestion des evenements.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //déclaration d'un holder
        ViewHolder holder;
        //si la ligne n'existe pas encore
        if (view == null) {
            holder = new ViewHolder();
            //la ligne est construite avec un formatage (inflater) relier à layout_list_medicaments
            view = inflater.inflate(R.layout.layout_list_rendezvous, null);
            //chaque propriété du holder est relier a une propriété à une propriété graphique
            holder.txtDateRDV = view.findViewById(R.id.txtDateRDV);
            holder.txtHeure = view.findViewById(R.id.txtHeure);
            holder.txtPraticien = view.findViewById(R.id.txtPraticien);
            //Affecter le holder à la vue
            view.setTag(holder);
        } else {
            //Récupération du holder dans la ligne existant
            holder = (ViewHolder) view.getTag();
        }

        //valorisation du contenu du holder (de la ligne)
        holder.txtDateRDV.setText(rendezVous.get(i).getDate());
        holder.txtHeure.setText(rendezVous.get(i).getHeure());
        //holder.txtPraticien.setText((CharSequence) rendezVous.get(i).getPraticien());

        return view;
    }

    private class ViewHolder {

        TextView txtDateRDV;
        TextView txtHeure;
        TextView txtPraticien;

    }
}