package com.example.sqlite.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.sqlite.Entidades.Personas;
import com.example.sqlite.R;
import com.example.sqlite.ViewModel.PersonasViewModel;
import com.example.sqlite.databinding.ActivityMainBinding;

import java.util.List;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static PersonasViewModel personaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personaViewModel = new ViewModelProvider(this).get(PersonasViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AgregarPersonaActivity.class));
            }
        });

        binding.btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
