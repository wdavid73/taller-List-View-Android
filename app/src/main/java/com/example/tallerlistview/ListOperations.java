package com.example.tallerlistview;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListOperations extends AppCompatActivity {
    private TableLayout table;
    private ArrayList<Operation> operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_operations);

        table = findViewById(R.id.tblOperations);
        operations = Datos.get();

        for (int i = 0; i < operations.size(); i++) {
            TableRow row = new TableRow(this);
            TextView columnId = new TextView(this);
            TextView columnOperation = new TextView(this);
            TextView columnData = new TextView(this);
            TextView columnResult = new TextView(this);

            columnId.setText("" + (i + 1));
            columnOperation.setText(operations.get(i).getOperation());
            columnData.setText(operations.get(i).getData());
            columnResult.setText(operations.get(i).getResult());
            columnId.setGravity(Gravity.CENTER);
            columnOperation.setGravity(Gravity.CENTER);
            columnData.setGravity(Gravity.CENTER);
            columnResult.setGravity(Gravity.CENTER);

            row.addView(columnId);
            row.addView(columnOperation);
            row.addView(columnData);
            row.addView(columnResult);
            row.setPadding(0, 0, 0, 2);

            table.addView(row);

        }
    }
}