package com.example.intentsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.intentsharedpref.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mb;
    String name;
    String email;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mb.getRoot();
        setContentView(view);

        sp = getApplicationContext().getSharedPreferences("sharedPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        mb.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new
                        Intent(MainActivity.this,
                        MainActivity2.class);

                //Bundle
//                Bundle bundle = new Bundle();

                //key-value pairs (keyname, value)
                name = mb.etName.getEditableText().toString();
                email = mb.etEmail.getEditableText().toString();
                if(!name.isEmpty()){
                    editor.putString("name", name);
//                    bundle.putString("name", name);
//                    intent.putExtra("name", name);
                }
                if(!email.isEmpty()){
                    editor.putString("email", email);
//                    bundle.putString("email", email);
//                    intent.putExtra("email", email);
                }
//                intent.putExtras(bundle);
                editor.apply();
                startActivity(intent);
            }
        });
    }
}