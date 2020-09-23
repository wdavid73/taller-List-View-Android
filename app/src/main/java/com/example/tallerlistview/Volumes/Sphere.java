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

public class Sphere extends AppCompatActivity {

    private EditText radius;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_volume_sphere);

        radius = findViewById(R.id.txtRadius);
        result = findViewById(R.id.lblResult);
    }

    public void calculate(View v) {
        Operation operation;
        double res, value_radius;
        result.setText("");
        if (validate()) {
            value_radius = Double.parseDouble(String.valueOf(radius.getText()));
            res = (Math.pow(value_radius, 3) * Math.PI * 4) / 3;
            BigDecimal area = new BigDecimal(res);
            area = area.setScale(2, RoundingMode.DOWN);
            result.setText(getText(R.string.volume_sphere) + " " + area);
            operation = new Operation(
                    "" + getString(R.string.volume_sphere_result),
                    "" + getString(R.string.value_radius) + " " + value_radius,
                    "" + area
            );
            operation.save();
            Toast.makeText(this, getString(R.string.operation_success), Toast.LENGTH_LONG).show();
        }
    }

    public boolean validate() {
        if (radius.getText().toString().isEmpty()) {
            radius.setError(getString(R.string.value_radius));
            radius.requestFocus();
            return false;
        }

        if (Double.parseDouble(radius.getText().toString()) == 0) {
            radius.setError(getString(R.string.value_radius));
            radius.requestFocus();
            return false;
        }


        return true;
    }
}