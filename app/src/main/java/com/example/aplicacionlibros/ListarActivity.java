package com.example.aplicacionlibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import adapters.LibrosAdapter;
import database.AppDatabase;
import entidades.Libros;

public class ListarActivity extends AppCompatActivity {

    RecyclerView listaLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        listaLibros=findViewById(R.id.listaLibros);
        AppDatabase db = AppDatabase.getInstance(ListarActivity.this);
        List<Libros> datos = db.libroDao().getAll();

        listaLibros=findViewById(R.id.listaLibros);
        listaLibros.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //rvContact.setAdapter(new PokemonAdapter(datos));
        listaLibros.setAdapter(new LibrosAdapter(datos));
        Log.i("MAIN_APP", "funciona");
    }
}