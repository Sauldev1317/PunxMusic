package dev.saul1317.punxmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.saul1317.punxmusic.Model.Instrumento;
import dev.saul1317.punxmusic.R;

public class AdapterRecyclerviewInstrumento extends
        RecyclerView.Adapter<AdapterRecyclerviewInstrumento.ViewHolder>{

    private int resource;
    List<Instrumento> instrumentoList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AdapterRecyclerviewInstrumento(int resource, List<Instrumento> instrumentoList, Context context, OnItemClickListener onItemClickListener) {
        this.resource = resource;
        this.instrumentoList = instrumentoList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Instrumento instrumento = instrumentoList.get(position);
        Picasso.get().load(instrumento.getUrl_imagen()).into(holder.img_instrumento);
        holder.txt_nombre_instrumento.setText(instrumento.getNombre());
        holder.txt_precio_instrumento.setText("Precio " + String.valueOf(instrumento.getPrecio()));
        holder.cardview_instrumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(instrumento, view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return instrumentoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout cardview_instrumento;
        ImageView img_instrumento;
        TextView txt_nombre_instrumento, txt_precio_instrumento;

        public ViewHolder(View itemView) {
            super(itemView);
            cardview_instrumento = (LinearLayout) itemView.findViewById(R.id.cardview_instrumento);
            img_instrumento = (ImageView) itemView.findViewById(R.id.img_instrumento);
            txt_nombre_instrumento = (TextView) itemView.findViewById(R.id.txt_nombre_instrumento);
            txt_precio_instrumento = (TextView) itemView.findViewById(R.id.txt_precio_instrumento);
        }
    }
}
