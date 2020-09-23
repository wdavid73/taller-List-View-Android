package com.example.tallerlistview.Areas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

public class Circle extends AppCompatActivity {
    private TextView result;
    private EditText radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_area_circle);

        result = findViewById(R.id.lblResult);
        radius = findViewById(R.id.txtRadius);

    }

    public void calculate(View v) {
        Operation operation;
        int res, value_radius;
        result.setText("");
        if (validate()) {
            value_radius = Integer.parseInt(String.valueOf(radius.getText()));

            res = (int) Math.pow(value_radius, 2) * (int) Math.PI;
            result.setText(getString(R.string.area_circle) + res);
            operation = new Operation(
                    "" + getString(R.string.area_circle_result),
                    "" + getString(R.string.circle_radius) + " " + value_radius,
                    "" + res
            );
            operation.save();
            Toast.makeText(this, R.string.operation_success, Toast.LENGTH_LONG).show();
        }

    }

    public boolean validate() {
        if (radius.getText().toString().isEmpty()) {
            radius.setError(getString(R.string.validate_radius));
            radius.requestFocus();
            return false;
        }

        if (Double.parseDouble(radius.getText().toString()) == 0) {
            radius.setError(getString(R.string.validate_radius));
            radius.requestFocus();
            return false;
        }

        return true;
    }


}