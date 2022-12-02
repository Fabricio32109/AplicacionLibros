package database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import entidades.Libros;

@Database(entities = {Libros.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LibroDao libroDao();

    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "DBLibros")
                .allowMainThreadQueries()
                .build();
    }

}
