package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.eph.martketplace.adapters.FashionAdapters;


public class MainActivity2 extends AppCompatActivity {
    private MainActivity2 binding;
    RecyclerView recyclerView;
    //recycle view data
    String[] price = {"Men suits - Ksh 6000","Red shoes - Ksh 5500","Nike Airforce shoes - Ksh 1700","Grey men shorts - Ksh 1300","Yellow T-shirts - Ksh 3200","Blue men jeans - Ksh 900"};
    String[] description = {"Men suits","Red shoes","Nike Airforce shoes","Grey men shorts","Yellow T-shirts","Blue men jeans"};
    int[] images = {R.drawable.fashion,R.drawable.shoes,R.drawable.nikes1,R.drawable.shoes,R.drawable.tshirt,R.drawable.jeans1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);
        FashionAdapters adapter = new FashionAdapters(this,price,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}