package com.eph.martketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.assist.AssistStructure;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.adapters.FashionAdapters;
import com.eph.martketplace.client.TwitterClient;
import com.eph.martketplace.dataModels.TwitterData;
import com.eph.martketplace.databinding.ActivityMain2Binding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    RecyclerView recyclerView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 11;

    //recycle view data
    String[] price = {"Men tuxedo suits that fit you perfectly - Ksh 6000","Red rubber shoes perfect for workouts - Ksh 5500","Nike Airforce 1 shoes, improve your shoe game - Ksh 1700","Grey men shorts for relaxing on hot days - Ksh 1300","Yellow T-shirts, shine from far - Ksh 3200","Blue men jeans that fir perfectly - Ksh 900"};
    int[] id = {1,2,3,4,5,6};
    int[] images = {R.drawable.fashion,R.drawable.shoes,R.drawable.nikes1,R.drawable.greyshorts,R.drawable.tshirt,R.drawable.jeans1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.recyclerView;
        FashionAdapters adapter = new FashionAdapters(this,price,images,id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}






















