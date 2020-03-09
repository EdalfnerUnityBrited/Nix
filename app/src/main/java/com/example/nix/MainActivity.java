package com.example.nix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    EditText editTextmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit= findViewById(R.id.buttonSubmit);
        editTextmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById((R.id.editTextPassword));

        //Asignacion de evento clic
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.i("APP", "Click en login");

        String email=editTextmail.getText().toString();
        String pass=editTextPassword.getText().toString();

        if (!email.isEmpty()&&!pass.isEmpty()) {
            Intent intentLogin = new Intent(MainActivity.this, HomeActivity.class);
            intentLogin.putExtra("valorEmail", email);
            startActivity(intentLogin);
        }
        else
        {
            editTextmail.setError("Complete el email y la contraseña");
            editTextPassword.setError("Complete el email y la contraseña");
        }
    }
}
