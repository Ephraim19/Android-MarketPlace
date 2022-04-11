package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.eph.martketplace.constant.Constants;
import com.eph.martketplace.databinding.ActivityLocationBinding;

import java.util.ArrayList;
import java.util.Locale;


public class LocationActivity extends AppCompatActivity {
    private ActivityLocationBinding binding;
    private static final String TAG = "MyActivity";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    // Define List for List View data
     String[] myLocations = {"thika","kiambu","kahawa","ngong","kitengela","kikuyu","rongai","embakasi","roysambu"};
     ArrayAdapter<String> arrayAdapter;
     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        listView = binding.lists;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myLocations);
        listView.setAdapter(arrayAdapter);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = sharedPreferences.edit();


        binding.LocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userLocation = (String) binding.textView4.getText();
                //adding to shared preference
                addToSharedPreferences(userLocation);

                Toast.makeText(getApplicationContext(),"Submitting Location",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LocationActivity.this,DeliveryActivity.class);
                intent.putExtra("location",userLocation);
                startActivity(intent);
            }
        });
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.LOCATION_KEY, location).apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.searchBar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search your location");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                binding.lists.setVisibility(View.VISIBLE);
                arrayAdapter.getFilter().filter(s.toLowerCase(Locale.ROOT));
                binding.textView4.setText(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}



















