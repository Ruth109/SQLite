package com.example.sqlite.UI;

import static com.example.sqlite.UI.MainActivity.personaViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.sqlite.Entidades.Personas;
import com.example.sqlite.R;
import com.example.sqlite.databinding.ActivityAgregarPersonaBinding;

public class AgregarPersonaActivity extends AppCompatActivity {

    private ActivityAgregarPersonaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        binding = ActivityAgregarPersonaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if(getIntent().getExtras() != null){
            binding.edtId.setText(String.valueOf(getIntent().getIntExtra("id", 0)));
            binding.edtNombre.setText(getIntent().getStringExtra("nombre").toString());
            binding.edtApellido.setText(getIntent().getStringExtra("apellido").toString());
            binding.edtEdad.setText(String.valueOf(getIntent().getIntExtra("edad", 0)));
        }

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personas persona = new Personas();
                persona.nombrePersona = binding.edtNombre.getText().toString();
                persona.apellidoPersona = binding.edtApellido.getText().toString();
                persona.edadPersona = Integer.parseInt(binding.edtEdad.getText().toString());

                if(binding.edtId.getText().toString().equals("")){
                    personaViewModel.insertPersona(persona);
                }else{
                    persona.idPersona = Integer.parseInt(binding.edtId.getText().toString());
                    personaViewModel.updatePersona(persona);
                }
                finish();
            }
        });
    }
}