package com.example.intentsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.intentsharedpref.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
    ActivityMain3Binding mb3;
    String name;
    String email;
    String food;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb3 = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = mb3.getRoot();
        setContentView(view);
        sp = getApplicationContext().getSharedPreferences("sharedPref", 0);

        name = sp.getString("name", "Not Found");
        email = sp.getString("email", "Not Found");
        food = sp.getString("food", "Nothing");

//        name = getIntent().getExtras().getString("name", "Not Found");
//        email = getIntent().getExtras().getString("email", "Not Found");
//        food = getIntent().getExtras().getString("food", "Not Found");

        mb3.txtName.setText("Name: " + name);
        mb3.txtEmail.setText("Email: " + email);
        mb3.txtFood.setText("Favorite food: " + food);


    }
}