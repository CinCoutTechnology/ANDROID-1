package com.example.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Cancion;
import com.example.recyclerview.Entidades.Album;

import com.example.recyclerview.Escuchar;
import com.example.recyclerview.R;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.NameViewHolder>
    implements View.OnClickListener{

    private int position2;
    private List<Album> data;
    private View.OnClickListener listener;
    private ToggleButton toggleButton;
    public CarAdapter(List<Album> data){
        this.data = data;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.custom_view,parent,false);

        NameViewHolder ViewHolder1 = new NameViewHolder(view);

        view.setOnClickListener(this); // para que pueda escuchar el evento de seleccion

        return ViewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        this.position2 = position;

        TextView textTitle = holder.itemView.findViewById(R.id.textTitle);
        TextView textDescripcion = holder.itemView.findViewById(R.id.textArtista);

        TextView textNum = holder.itemView.findViewById(R.id.textNunCani);

        Button bt = holder.itemView.findViewById(R.id.idbutton);
        Button bt2 = holder.itemView.findViewById(R.id.idbutton2);

        Button btf = holder.itemView.findViewById(R.id.btnFavorito);

        Album valor = data.get(position);

        textTitle.setText(valor.getNombre());
        textDescripcion.setText(valor.getArtista());
        textNum.setText(valor.getNumeroCanion());
        bt.setOnClickListener(this);
        bt2.setOnClickListener(this);
        btf.setOnClickListener(this);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent;
        int estado = 0;
        Album valor = data.get(position2);

        switch (view.getId()){
            case R.id.idbutton:

                intent = new Intent(context, Cancion.class);
                intent.putExtra("Nombre",valor.getNombre());
                intent.putExtra("Artista",valor.getArtista());
                intent.putExtra("Numero",valor.getNumeroCanion());
                context.startActivity(intent);
               // listener.onClick(view);
                break;
            case (R.id.idbutton2):
                intent = new Intent(context, Escuchar.class);
                intent.putExtra("link",valor.getNombre());
                context.startActivity(intent);
                break;
            case (R.id.btnFavorito):

                    Toast.makeText(context, "Marcado Como Favorito", Toast.LENGTH_SHORT).show();
            break;
        }
    }
    public class NameViewHolder extends RecyclerView.ViewHolder{

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
