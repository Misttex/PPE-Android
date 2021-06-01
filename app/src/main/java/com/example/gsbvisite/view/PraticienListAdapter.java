package com.example.gsbvisite.view;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;
        import com.example.gsbvisite.R;
        import com.example.gsbvisite.model.Medicament;
        import com.example.gsbvisite.model.Praticien;
        import com.example.gsbvisite.model.PraticienDao;
        import com.example.gsbvisite.model.RendezVous;

        import java.util.ArrayList;

public class PraticienListAdapter extends BaseAdapter {

    private final ArrayList<Praticien> praticiens;
    private final LayoutInflater inflater;

    public PraticienListAdapter(Context context, ArrayList<Praticien> praticiens) {
        this.praticiens = praticiens;
        this.inflater = LayoutInflater.from(context);
    }

    //retourne le nombre de ligne
    @Override
    public int getCount() {
        return praticiens.size();
    }

    //retourne la l'item de la ligne actuelle
    @Override
    public Object getItem(int i) {
        return praticiens.get(i);
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
            view = inflater.inflate(R.layout.layout_list_praticien, null);
            //chaque propriété du holder est relier a une propriété à une propriété graphique
            holder.txtNom = view.findViewById(R.id.txtNom);
            holder.txtPrenom = view.findViewById(R.id.txtPrenom);
            holder.txtTelephone = view.findViewById(R.id.txtTelephone);
            //Affecter le holder à la vue
            view.setTag(holder);
        } else {
            //Récupération du holder dans la ligne existant
            holder = (ViewHolder) view.getTag();
        }

        //valorisation du contenu du holder (de la ligne)
        holder.txtNom.setText(praticiens.get(i).getNom());
        holder.txtPrenom.setText(praticiens.get(i).getPrenom());
        holder.txtTelephone.setText(praticiens.get(i).getTelephone());

        return view;
    }

    private class ViewHolder {

        TextView txtNom;
        TextView txtPrenom;
        TextView txtTelephone;

    }
}