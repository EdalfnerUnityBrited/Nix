package com.example.nix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

ListView lista;
List<String> androidVersionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras=getIntent().getExtras();
        String emailUsuario=extras.getString("valorEmail");
        setTitle(emailUsuario);

        lista=findViewById(R.id.listView);

        androidVersionList= new ArrayList<>();
        androidVersionList.add("Pie");
        androidVersionList.add("Oreo");
        androidVersionList.add("Nougat");
        androidVersionList.add("Marshmallow");
        androidVersionList.add("Lollipop");
        androidVersionList.add("...");

        ArrayAdapter adaptadorVersionesAndroid=new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                androidVersionList
        );

        lista.setAdapter(adaptadorVersionesAndroid);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String androidVersion=androidVersionList.get(position);
        Log.i("APP","Version clic: "+androidVersion);
    }
}
