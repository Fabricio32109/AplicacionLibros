package com.example.aplicacionlibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import Servicios.LibroService;
import database.AppDatabase;
import entidades.Libros;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button crear,listar,sincronizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crear=findViewById(R.id.btMenuCrear);
        listar=findViewById(R.id.btListarLibros);
        sincronizar=findViewById(R.id.btSincronizar);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CrearActivity.class);
                startActivity(intent);
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListarActivity.class);
                startActivity(intent);
            }
        });
        sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                db.libroDao().delete();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://635a26bcff3d7bddb9b03cc6.mockapi.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                LibroService services = retrofit.create(LibroService.class);
                services.getListContact().enqueue(new Callback<List<Libros>>() {
                    @Override
                    public void onResponse(Call<List<Libros>> call, Response<List<Libros>> response) {
                        List<Libros> datos = response.body();
                        for(int i=0;i<datos.size();i++){
                            db.libroDao().create(datos.get(i));
                            Toast toast = Toast.makeText(MainActivity.this, "Sincronizado correctamente", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Libros>> call, Throwable t) {

                    }
                });
            }
        });

    }
}