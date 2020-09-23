package com.example.tallerlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listOptions;
    private String[] options;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOptions = findViewById(R.id.lstOptions);
        options = getResources().getStringArray(R.array.options);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        listOptions.setAdapter(adapter);

        listOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent = new Intent(MainActivity.this, CalculateAreas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, CalculateVolumes.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ListOperations.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}