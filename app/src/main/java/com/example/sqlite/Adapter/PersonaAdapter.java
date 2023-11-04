package com.example.sqlite.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.Entidades.Personas;
import com.example.sqlite.R;
import com.example.sqlite.ViewHolder.ViewHolderPersona;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<ViewHolderPersona> {
    private List<Personas> listaPersona = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    public PersonaAdapter(OnItemClickListener itemClickListener, OnItemLongClickListener itemLongClickListener){
        this.onItemClickListener = itemClickListener;
        this.onItemLongClickListener = itemLongClickListener;
    }
    public void setDatos(List<Personas> nuevaPersona){
        listaPersona = nuevaPersona;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new ViewHolderPersona(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position) {
        final Personas personas = listaPersona.get(position);
        holder.getIdPersona().setText(String.valueOf(listaPersona.get(position).idPersona));
        holder.getNombrePersona().setText(listaPersona.get(position).nombrePersona);
        holder.getApellidoPersona().setText(listaPersona.get(position).apellidoPersona);
        holder.getEdadPersona().setText(String.valueOf(listaPersona.get(position).edadPersona));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(personas);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemLongClickListener != null){
                    onItemLongClickListener.onItemLongClick(personas);
                }
                return true;
            }
        });
    }
    public interface OnItemClickListener{
        void onItemClick(Personas personas);
    }
    public interface OnItemLongClickListener{
        void onItemLongClick(Personas personas);
    }

    @Override
    public int getItemCount() {
        return listaPersona.size();
    }
}
