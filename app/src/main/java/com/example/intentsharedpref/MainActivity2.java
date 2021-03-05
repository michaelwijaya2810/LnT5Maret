package com.example.intentsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.intentsharedpref.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding mb2;
    String name;
    String email;
    String food;
    Intent intent;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb2 = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = mb2.getRoot();
        setContentView(view);

//        Bundle bundle = getIntent().getExtras();

        sp = getApplicationContext().getSharedPreferences("sharedPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        //Anonymously
        name = sp.getString("name", "Not Found");
        email = sp.getString("email", "Not Found");
//        name = bundle.getString("name", "Not Found");
//        email = bundle.getString("email", "Not Found");

        //intent lagi
//        Intent intent = getIntent();
//        name = intent.getExtras().getString("name", "Not Found");

        intent = new Intent(MainActivity2.this, MainActivity3.class);



        mb2.txtName.setText("Name: "+name);
        mb2.txtEmail.setText("Email: "+email);

        mb2.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food = mb2.etFood.getEditableText().toString();
                if(!food.isEmpty()){
                    editor.putString("food", food);
                    editor.apply();
                }

//                intent.putExtra("name", name);
//                intent.putExtra("email", email);
//                intent.putExtra("food", food);
//                bundle.putString("food", food);
//                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


    }
}