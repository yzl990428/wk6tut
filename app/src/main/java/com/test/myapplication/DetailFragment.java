package com.test.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private TextView tvName;
    private TextView tvSymbol;
    private TextView tvValue;
    private TextView tvChange7Day;
    private TextView tvMarketCap;
    private TextView tvVolume;
    private TextView tvChange1H;
    private TextView tvChange24;

    View root;

    public static DetailFragment getInstance (Datum coin) {

        DetailFragment detailFragment =  new DetailFragment();
        Bundle argu = new Bundle();
        argu.putSerializable("coin",coin);
        detailFragment.setArguments(argu);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=  inflater.inflate(R.layout.fragment_detail,container,false);
        tvName = root.findViewById(R.id.name);
        tvChange24 =  root.findViewById(R.id.tv_change24);
        tvChange7Day =  root.findViewById(R.id.tv_change7d);
        tvMarketCap =  root.findViewById(R.id.tv_marketcap);
        tvVolume =  root.findViewById(R.id.tv_volume);
        tvSymbol = root. findViewById(R.id.tvSymbol);
        tvValue =  root.findViewById(R.id.value);
        tvChange1H =  root.findViewById(R.id.tv_change1);
        Datum coin = (Datum) getArguments().getSerializable("coin");
        changeCoin(coin);
        return  root;
    }

    public void changeCoin(Datum coin){
        tvName.setText(coin.getName());
        tvChange24.setText(coin.getPercentChange24h()+" %");
        tvChange7Day.setText(coin.getPercentChange7d()+" %");
        tvMarketCap.setText("$ "+coin.getMarketCapUsd());
        tvVolume.setText("$ "+coin.getVolume24());
        tvSymbol.setText(coin.getSymbol());
        tvValue.setText("$ "+coin.getPriceUsd());
        tvChange1H.setText(coin.getPercentChange1h()+" %");

    }

}
