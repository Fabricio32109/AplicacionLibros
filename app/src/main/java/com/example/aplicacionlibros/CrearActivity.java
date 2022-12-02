package com.example.aplicacionlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Servicios.LibroService;
import entidades.Libros;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearActivity extends AppCompatActivity {

    EditText autor,titulo;
    Button volver,crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        volver=findViewById(R.id.btVolver);
        crear=findViewById(R.id.btMenuCrear);
        autor=findViewById(R.id.etAutor);
        titulo=findViewById(R.id.etTitulo);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Libros libro=new Libros();
                libro.autor=autor.getText().toString();
                libro.titulo=titulo.getText().toString();
                postRetrofit(libro);
            }
        });
    }
    public void postRetrofit(Libros libro){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635a26bcff3d7bddb9b03cc6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LibroService service = retrofit.create(LibroService.class);
        service.create(libro).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast toast = Toast.makeText(CrearActivity.this, "Libro ingresado correctamente", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast toast = Toast.makeText(CrearActivity.this, "Error al ingresar libro", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}