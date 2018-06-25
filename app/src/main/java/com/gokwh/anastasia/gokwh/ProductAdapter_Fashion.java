package com.gokwh.anastasia.gokwh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter_Fashion extends RecyclerView.Adapter<ProductAdapter_Fashion.ProductViewHolder> {

    private Context mCtx;
    private List<Product_Fashion> productList_Fashion;

    public ProductAdapter_Fashion(Context mCtx, List<Product_Fashion> productList_Fashion) {
        this.mCtx = mCtx;
        this.productList_Fashion= productList_Fashion;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.fashion, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product_Fashion productFashion = productList_Fashion.get(position);

        holder.textViewnama.setText(productFashion.getNama());
        holder.textViewemail.setText(productFashion.getEmail());
    }

    @Override
    public int getItemCount() {
        return productList_Fashion.size();
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