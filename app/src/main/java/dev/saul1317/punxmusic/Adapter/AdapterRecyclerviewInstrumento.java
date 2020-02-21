package dev.saul1317.punxmusic.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import dev.saul1317.punxmusic.R;

public class AdapterRecyclerviewInstrumento extends
        RecyclerView.Adapter<AdapterRecyclerviewInstrumento.ViewHolder>{

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardview_instrumento;
        ImageView img_instrumento;
        TextView txt_nombre_instrumento, txt_precio_instrumento;

        public ViewHolder(View itemView) {
            super(itemView);
            cardview_instrumento = (CardView) itemView.findViewById(R.id.cardview_instrumento);
            img_instrumento = (ImageView) itemView.findViewById(R.id.img_instrumento);
            txt_nombre_instrumento = (TextView) itemView.findViewById(R.id.txt_nombre_instrumento);
            txt_precio_instrumento = (TextView) itemView.findViewById(R.id.txt_precio_instrumento);
        }
    }
}
