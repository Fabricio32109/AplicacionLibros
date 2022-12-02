package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionlibros.R;

import java.util.List;

import entidades.Libros;

public class LibrosAdapter extends RecyclerView.Adapter{
    List<Libros> datos;

    public LibrosAdapter(List<Libros> datos) {
        this.datos=datos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_libro,parent,false);
        return new LibrosAdapter.LibrosAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final LibrosAdapter.LibrosAdapterViewHolder viewHolder = (LibrosAdapterViewHolder) holder;
        TextView tvautor = holder.itemView.findViewById(R.id.idAutor);
        TextView tvtitulo = holder.itemView.findViewById(R.id.idTitulo);
        tvautor.setText(datos.get(position).autor);
        tvtitulo.setText(datos.get(position).titulo);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }



    static class LibrosAdapterViewHolder extends RecyclerView.ViewHolder{

        public LibrosAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
