package com.eph.martketplace.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eph.martketplace.MainActivity2;
import com.eph.martketplace.R;
import com.eph.martketplace.dataModels.FashionData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    Context context;
    View view;
    private SharedPreferences mSharedPreferences;

    public FirebaseAdapter(View itemView) {
        super(itemView);
        view = itemView;
        context = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindRestaurant(FashionData description) {
        TextView descriptionView = (TextView) view.findViewById(R.id.Text1);

        descriptionView.setText((description.getPrice()));
    }
    @Override
    public void onClick(View view) {
        List<FashionData> myDescription = new ArrayList<>();

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String userId = mSharedPreferences.getString("User", null);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://martketplace-5cda7-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Wishlist").child(userId);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    myDescription.add((FashionData) snapshot.getValue());
                }
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("description", (Parcelable) myDescription);

                context.startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Error","Cancelled");
            }
        });
    }
}














