package com.example.tallerlistview.Volumes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cylinder extends AppCompatActivity {
    private EditText radius, high;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_volume_cylinder);

        radius = findViewById(R.id.txtRadius);
        high = findViewById(R.id.txtHigh);
        result = findViewById(R.id.lblResult);

    }

    public void calculate(View v) {

        Operation operation;
        int value_radius, value_high;
        double res;
        result.setText("");
        if (validate()) {
            value_radius = Integer.parseInt(String.valueOf(radius.getText()));
            value_high = Integer.parseInt(String.valueOf(high.getText()));

            res = Math.PI * Math.pow(value_radius, 2) * value_high;
            BigDecimal area = new BigDecimal(res);
            area = area.setScale(2, RoundingMode.DOWN);
            result.setText(getString(R.string.volume_cylinder) + " : " + area);

            operation = new Operation(
                    "" + getString(R.string.volume_cylinder_result),
                    "" + getString(R.string.value_radius) + " " + value_radius + " " + getString(R.string.value_high) + " " + value_high,
                    "" + area
            );
            operation.save();
            Toast.makeText(this, getString(R.string.operation_success), Toast.LENGTH_LONG).show();


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

        if (high.getText().toString().isEmpty()) {
            high.setError(getString(R.string.validate_high));
            high.requestFocus();
            return false;
        }

        if (Double.parseDouble(high.getText().toString()) == 0) {
            high.setError(getString(R.string.validate_high));
            high.requestFocus();
            return false;
        }

        return true;
    }
}