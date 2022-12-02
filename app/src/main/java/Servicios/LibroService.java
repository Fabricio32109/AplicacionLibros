package Servicios;

import java.util.List;

import entidades.Libros;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LibroService {
    @GET("libros")
    Call<List<Libros>> getListContact();
    @POST("libros")
    Call<Void> create(@Body Libros poke);//guardar datos
    /*@PUT("contacts/{id}")
    Call<Void> update (@Body ContactApi contactApi, @Path("id")int id);*/
    @PUT("libros/{id}")
    Call<Libros> update(@Body Libros poke, @Path("id")int id);
    @DELETE("libros/{id}")
    Call<Libros> delete (@Path("id")int id);
}
