package entidades;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

@Entity(tableName = "Libros")
public class Libros {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name ="titulo")
    public String titulo;
    @ColumnInfo(name ="autor")
    public String autor;
}
