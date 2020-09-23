package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tallerlistview.Volumes.Cone;
import com.example.tallerlistview.Volumes.Cube;
import com.example.tallerlistview.Volumes.Cylinder;
import com.example.tallerlistview.Volumes.Sphere;

public class CalculateVolumes extends AppCompatActivity {
    private ListView listOptionsVolumes;
    private String[] options;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_volumenes);

        listOptionsVolumes = findViewById(R.id.lstOptionsVolumes);
        options = getResources().getStringArray(R.array.optionsVolumes);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,options);
        listOptionsVolumes.setAdapter(adapter);

        listOptionsVolumes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(CalculateVolumes.this, Cylinder.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(CalculateVolumes.this, Cone.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(CalculateVolumes.this, Sphere.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(CalculateVolumes.this, Cube.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}