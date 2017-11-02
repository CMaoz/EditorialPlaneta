package com.example.maoz1.editorialplaneta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maoz1 on 1/11/2017.
 */

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ContactosViewHolder>{

    Context cont;
    private ArrayList<User> userArrayList;

    public ContactosAdapter(Context context,ArrayList<User> userArrayList) {
        super();
        this.cont=context;
        this.userArrayList=userArrayList;
    }

    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);
        ContactosViewHolder contactosViewHolder = new ContactosViewHolder(itemView);

        return contactosViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactosViewHolder holder, int position) {
        User item = userArrayList.get(position);
        holder.bindContactos(item,cont);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class ContactosViewHolder extends RecyclerView.ViewHolder{

        private TextView tId,tNombredl,tNombreda,tNombreqp, tNumerotel;

        public ContactosViewHolder (View itemView){
            super(itemView);
            tId=itemView.findViewById(R.id.tID);
            tNombredl=itemView.findViewById(R.id.tNombredl);
            tNombreda=itemView.findViewById(R.id.tNombreda);
            tNombreqp=itemView.findViewById(R.id.tNombreqp);
            tNumerotel=itemView.findViewById(R.id.tNumerotel);
        }
        public void bindContactos(User user, Context context){
            tId.setText(user.getId());
            tNombredl.setText(user.getNombredl());
            tNombreda.setText(user.getNombreda());
            tNombreqp.setText(user.getNombreqp());
            tNumerotel.setText(user.getNumtel());
        }
    }
}
