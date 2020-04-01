package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {
    private  List<Datum> coins;

    private  AdapterClickListener onClickListener;
    public void setAdapterClickListener(AdapterClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public CoinAdapter(List<Datum> coins) {
        this.coins = coins;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_coin, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Datum coin = coins.get(position);
        holder.tvName.setText(coin.getName());
        holder.tvValue.setText("$ "+coin.getPriceUsd());
        holder.tvChange.setText(coin.getPercentChange1h()+" %");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onAdapterClick(position);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return coins.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvValue;
        private TextView tvChange;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvValue = itemView.findViewById(R.id.value);
            tvChange = itemView.findViewById(R.id.change1);
        }
    }
}
