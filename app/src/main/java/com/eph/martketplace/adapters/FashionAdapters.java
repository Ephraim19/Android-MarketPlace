package com.eph.martketplace.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.LocationActivity;
import com.eph.martketplace.MainActivity2;
import com.eph.martketplace.R;
import com.eph.martketplace.client.TwitterClient;
import com.eph.martketplace.dataModels.TwitterData;
import com.eph.martketplace.databinding.MyRowsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FashionAdapters extends RecyclerView.Adapter<FashionAdapters.MyViewHolder> {

    public String[] price;
    public int[] images;
    public int[] id;
    Context context;

    public FashionAdapters(Context context,String[] price, int[] images,int[] id) {
        this.context = context;
        this.price = price;
        this.images = images;
        this.id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_rows,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.MyText1.setText(price[position]);
        holder.myImage.setImageResource(images[position]);
        holder.myId.setTag(id[position]);

        //Send tweets
        holder.itemView.findViewById(R.id.tweet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "Tweet posting",Toast.LENGTH_LONG).show();
                holder.itemView.findViewById(R.id.progressBar).setVisibility(view.VISIBLE);
                MyTweetCall client = TwitterClient.getClient();
                TwitterData modal = new TwitterData("Men suits");
                Call<TwitterData> call = client.postTweet(modal);

                call.enqueue(new Callback<TwitterData>() {
                    @Override
                    public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
                        if(response.code() != 201){
                            Log.v("code", String.valueOf(response.code()));
                            Toast.makeText(context.getApplicationContext(),"Failed to post tweet",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(context.getApplicationContext(), "Tweet posted", Toast.LENGTH_LONG).show();
                        }
                        holder.itemView.findViewById(R.id.progressBar).setVisibility(view.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Call<TwitterData> call, Throwable t) {
                        holder.itemView.findViewById(R.id.progressBar).setVisibility(view.INVISIBLE);
                        Toast.makeText(context.getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        //Buy clothes
        holder.itemView.findViewById(R.id.buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(),"Clothes",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,LocationActivity.class);
                context.startActivity(intent);
            }
        });

        //Saving wishlist to firebase
        holder.itemView.findViewById(R.id.checkBox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://martketplace-5cda7-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("Wishlist");
                myRef.push().setValue(holder.getAdapterPosition());
                Toast.makeText(context.getApplicationContext(), price[holder.getAdapterPosition()] +" added",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v("count", String.valueOf(images.length));
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView MyText1;
        ImageView myImage;
        CheckBox myId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.images);
            MyText1 = itemView.findViewById(R.id.Text1);
            myId = itemView.findViewById(R.id.checkBox);
        }
    }
}














