package com.gokwh.anastasia.gokwh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter_Elektronik extends RecyclerView.Adapter<ProductAdapter_Elektronik.ProductViewHolder> {

    private Context mCtx;
    private List<Product_Elektronik> productList_Elektronik;

    public ProductAdapter_Elektronik(Context mCtx, List<Product_Elektronik> productList_Elektronik) {
        this.mCtx = mCtx;
        this.productList_Elektronik = productList_Elektronik;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.elektronik, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product_Elektronik productElektronik = productList_Elektronik.get(position);

        holder.textViewnama.setText(productElektronik.getNama());
        holder.textViewemail.setText(productElektronik.getEmail());
    }

    @Override
    public int getItemCount() {
        return productList_Elektronik.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewnama, textViewemail;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewnama = itemView.findViewById(R.id.textViewNama);
            textViewemail = itemView.findViewById(R.id.textViewEmail);
        }
    }
}