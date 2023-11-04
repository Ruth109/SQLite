package com.example.sqlite.UI;

import static com.example.sqlite.UI.MainActivity.personaViewModel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sqlite.Adapter.PersonaAdapter;
import com.example.sqlite.Entidades.Personas;
import com.example.sqlite.R;
import com.example.sqlite.databinding.ActivityAgregarPersonaBinding;
import com.example.sqlite.databinding.ActivityMostrarListaBinding;

import java.util.List;

public class MostrarListaActivity extends AppCompatActivity implements PersonaAdapter.OnItemClickListener, PersonaAdapter.OnItemLongClickListener {

    public static PersonaAdapter personaAdapter;
    private RecyclerView recyclerView;
    private ActivityMostrarListaBinding binding;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMostrarListaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        personaAdapter = new PersonaAdapter(MostrarListaActivity.this, MostrarListaActivity.this);
        layoutManager = new LinearLayoutManager(this);
        binding.rcvPersonas.setAdapter(personaAdapter);
        binding.rcvPersonas.setLayoutManager(layoutManager);
        binding.rcvPersonas.setHasFixedSize(true);

        LiveData<List<Personas>> liveDataPersonas = personaViewModel.getListaDePersonas();
        liveDataPersonas.observe(MostrarListaActivity.this, personas -> {
            List<Personas> lstPersonas = personas;
            personaAdapter.setDatos(lstPersonas);
        });
    }

    @Override
    public void onItemClick(Personas personas) {
        Intent intent = new Intent(MostrarListaActivity.this, AgregarPersonaActivity.class);
        intent.putExtra("id", personas.idPersona);
        intent.putExtra("nombre", personas.nombrePersona);
        intent.putExtra("apellido", personas.apellidoPersona);
        intent.putExtra("edad", personas.edadPersona);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(Personas personas) {
        AlertaDialogo(personas);
    }

    private void AlertaDialogo(Personas personas){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar Registro");
        builder.setMessage("Esta seguro de eliminar el registro?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                personaViewModel.deletePersona(personas);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}