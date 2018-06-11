package com.gokwh.anastasia.gokwh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.anggota, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textViewid.setText(product.getId());
        holder.textViewnama.setText(product.getNama());
        holder.textViewjabatan.setText(product.getJabatan());
        holder.textViewemail.setText(product.getEmail());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewid, textViewnama, textViewjabatan, textViewemail;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewid = itemView.findViewById(R.id.textViewID);
            textViewnama = itemView.findViewById(R.id.textViewNama);
            textViewjabatan = itemView.findViewById(R.id.textViewJabatan);
            textViewemail = itemView.findViewById(R.id.textViewEmail);
        }
    }
}