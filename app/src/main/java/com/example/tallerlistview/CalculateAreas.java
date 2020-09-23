package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tallerlistview.Areas.CalculateAreaCircle;
import com.example.tallerlistview.Areas.CalculateAreaRectangle;
import com.example.tallerlistview.Areas.CalculateAreaSquare;
import com.example.tallerlistview.Areas.CalculateAreaTriangle;

public class CalculateAreas extends AppCompatActivity {
    private ListView listOptionsAreas;
    private String[] options;
    private ArrayAdapter<String> adapter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_areas);

        listOptionsAreas = findViewById(R.id.lstOptionsAreas);
        options = getResources().getStringArray(R.array.optionsAreas);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,options);
        listOptionsAreas.setAdapter(adapter);

        listOptionsAreas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(CalculateAreas.this, CalculateAreaSquare.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(CalculateAreas.this, CalculateAreaRectangle.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(CalculateAreas.this, CalculateAreaTriangle.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(CalculateAreas.this, CalculateAreaCircle.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}