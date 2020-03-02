package dev.saul1317.punxmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.saul1317.punxmusic.Model.Instrumento;
import dev.saul1317.punxmusic.R;

public class AdapterRecyclerviewShoppingCart extends
        RecyclerView.Adapter<AdapterRecyclerviewShoppingCart.ShoppingCartViewHolder>{

    private int resource;
    List<Instrumento> instrumentoList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AdapterRecyclerviewShoppingCart(int resource, List<Instrumento> instrumentoList, Context context, OnItemClickListener onItemClickListener) {
        this.resource = resource;
        this.instrumentoList = instrumentoList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ShoppingCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent,false);
        return new AdapterRecyclerviewShoppingCart.ShoppingCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartViewHolder holder, int position) {
        final Instrumento instrumento = instrumentoList.get(position);
        Picasso.get().load(instrumento.getUrl_imagen()).into(holder.img_instrument_shopping_cart);
        holder.txt_name_instrument_shopping_cart.setText(instrumento.getNombre());
        holder.txt_model_instrument_shopping_cart.setText("N.º de modelo:" + instrumento.getNumero_modelo());
        holder.txt_precio_instrument_shopping_cart.setText("$" + String.valueOf(instrumento.getPrecio()));
        holder.button_ver_instrumento_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(instrumento, view);
                }
            }
        });
        holder.button_remover_instrumento_cart.setOnClickListener(new View.OnClickListener() {
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

    public class ShoppingCartViewHolder extends RecyclerView.ViewHolder{
        LinearLayout cardview_shopping_cart;
        ImageView img_instrument_shopping_cart;
        TextView txt_name_instrument_shopping_cart, txt_model_instrument_shopping_cart, txt_precio_instrument_shopping_cart;
        Button button_ver_instrumento_cart, button_remover_instrumento_cart;

        public ShoppingCartViewHolder(View itemView) {
            super(itemView);
            cardview_shopping_cart = (LinearLayout) itemView.findViewById(R.id.cardview_shopping_cart);
            img_instrument_shopping_cart = (ImageView) itemView.findViewById(R.id.img_instrument_shopping_cart);
            txt_name_instrument_shopping_cart = (TextView) itemView.findViewById(R.id.txt_name_instrument_shopping_cart);
            txt_model_instrument_shopping_cart = (TextView) itemView.findViewById(R.id.txt_model_instrument_shopping_cart);
            txt_precio_instrument_shopping_cart = (TextView) itemView.findViewById(R.id.txt_precio_instrument_shopping_cart);
            button_ver_instrumento_cart = (Button) itemView.findViewById(R.id.button_ver_instrumento_cart);
            button_remover_instrumento_cart = (Button) itemView.findViewById(R.id.button_remover_instrumento_cart);
        }
    }
}
