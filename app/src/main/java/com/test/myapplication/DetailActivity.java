package com.test.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Datum coin = (Datum) getIntent().getSerializableExtra("detail");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(coin.getName());
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailFragment detailFragment = DetailFragment.getInstance(coin);
        fragmentTransaction.replace(R.id.detail, detailFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
