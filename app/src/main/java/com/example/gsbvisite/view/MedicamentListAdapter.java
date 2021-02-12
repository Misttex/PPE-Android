package com.example.gsbvisite.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.gsbvisite.R;
import com.example.gsbvisite.model.Medicament;

import java.util.ArrayList;

public class MedicamentListAdapter extends BaseAdapter {

    private final ArrayList<Medicament> medicaments;
    private final LayoutInflater inflater;

    public MedicamentListAdapter(Context context, ArrayList<Medicament> medicaments) {
        this.medicaments = medicaments;
        this.inflater = LayoutInflater.from(context);
    }

    //retourne le nombre de ligne
    @Override
    public int getCount() {
        return medicaments.size();
    }

    //retourne la l'item de la ligne actuelle
    @Override
    public Object getItem(int i) {
        return medicaments.get(i);
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
            view = inflater.inflate(R.layout.layout_list_medicament, null);
            //chaque propriété du holder est relier a une propriété à une propriété graphique
            holder.txtNomCommercial = view.findViewById(R.id.txtNomCommercial);
            holder.txtEffet = view.findViewById(R.id.txtEffet);
            holder.txtPrix = view.findViewById(R.id.txtPrix);
            //Affecter le holder à la vue
            view.setTag(holder);
        } else {
            //Récupération du holder dans la ligne existant
            holder = (ViewHolder) view.getTag();
        }

        //valorisation du contenu du holder (de la ligne)
        holder.txtNomCommercial.setText(medicaments.get(i).getMNomCommercial());
        holder.txtEffet.setText(medicaments.get(i).getMEffet());
        holder.txtPrix.setText(Double.toString(medicaments.get(i).getMPrixEchant()));

        return view;
    }

    private class ViewHolder {

        TextView txtNomCommercial;
        TextView txtEffet;
        TextView txtPrix;

    }
}