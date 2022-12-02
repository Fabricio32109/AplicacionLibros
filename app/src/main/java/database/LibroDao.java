package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entidades.Libros;

@Dao
public interface LibroDao {
    @Query("SELECT * FROM libros")
    List<Libros> getAll();

    @Query("SELECT * FROM libros where id = :abc")
    Libros find(int abc); //1,2,3,4,5

    @Insert
    void create(Libros lbs);

    @Update
    void update(Libros lbs);

    @Query("DELETE FROM libros")
    void delete();
}
