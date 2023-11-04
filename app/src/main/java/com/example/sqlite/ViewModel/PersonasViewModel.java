package com.example.sqlite.ViewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.sqlite.DAO.PersonaDAO;
import com.example.sqlite.Database.PersonasDatabase;
import com.example.sqlite.Entidades.Personas;
import java.util.List;
public class PersonasViewModel extends AndroidViewModel {
    private PersonaDAO personaDAO;
    private LiveData<List<Personas>> listaDePersonas;
    public PersonasViewModel(Application application) {
        super(application);
        PersonasDatabase database = PersonasDatabase.getInstance(application);
        personaDAO = database.personaDAO();
        listaDePersonas = personaDAO.obtenerTodasLasPersonas();
    }
    public LiveData<List<Personas>> getListaDePersonas() {
        return listaDePersonas;
    }
    public void insertPersona(Personas persona) {
        // Insertar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Insert(persona);
            }
        }).start();
    }
    public void updatePersona(Personas persona) {
        // Actualizar una persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Update(persona);
            }
        }).start();
    }
    public void deletePersona(Personas persona) {
        // Eliminar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Delete(persona);
            }
        }).start();
    }

}
