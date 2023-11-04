package com.example.sqlite.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqlite.R;

public class ViewHolderPersona extends RecyclerView.ViewHolder {
    private TextView idPersona, nombrePersona, apellidoPersona, edadPersona;

    public ViewHolderPersona(@NonNull View itemView) {
        super(itemView);
        this.idPersona = itemView.findViewById(R.id.txvId);
        this.nombrePersona = itemView.findViewById(R.id.txvNombre);
        this.apellidoPersona = itemView.findViewById(R.id.txvApellido);
        this.edadPersona = itemView.findViewById(R.id.txvEdad);
    }

    public TextView getIdPersona(){
        return idPersona;
    }

    public TextView getNombrePersona(){
        return nombrePersona;
    }

    public TextView getApellidoPersona(){
        return apellidoPersona;
    }

    public TextView getEdadPersona(){
        return edadPersona;
    }
}
