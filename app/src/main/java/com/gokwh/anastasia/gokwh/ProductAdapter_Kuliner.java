package com.gokwh.anastasia.gokwh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter_Kuliner extends RecyclerView.Adapter<ProductAdapter_Kuliner.ProductViewHolder> {

    private Context mCtx;
    private List<Product_Kuliner> productList_Kuliner;

    public ProductAdapter_Kuliner(Context mCtx, List<Product_Kuliner> productList_Kuliner) {
        this.mCtx = mCtx;
        this.productList_Kuliner = productList_Kuliner;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kuliner, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product_Kuliner productKuliner = productList_Kuliner.get(position);

        holder.textViewnama.setText(productKuliner.getNama());
        holder.textViewemail.setText(productKuliner.getEmail());
    }

    @Override
    public int getItemCount() {
        return productList_Kuliner.size();
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