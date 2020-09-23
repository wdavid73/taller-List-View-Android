package com.example.tallerlistview.Areas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

public class Triangle extends AppCompatActivity {
    private EditText side, base;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_area_triangle);

        side = findViewById(R.id.txtSide);
        base = findViewById(R.id.txtBase);
        result = findViewById(R.id.lblResult);
    }

    public void calculate(View v) {
        Operation operation;
        double res;
        int value_side, value_base;
        result.setText("");
        if (validate()) {
            value_side = Integer.parseInt(String.valueOf(side.getText()));
            value_base = Integer.parseInt(String.valueOf(base.getText()));

            res = (value_side * value_base) / 2;
            result.setText(getString(R.string.area_triangle) + res);
            operation = new Operation(
                    "" + getString(R.string.area_triangle_result),
                    "" + getString(R.string.value_side) + " " + value_side + " " + getString(R.string.value_base) + " " + value_base,
                    "" + res
            );
            operation.save();
            Toast.makeText(this, R.string.operation_success, Toast.LENGTH_LONG).show();
        }

    }

    public boolean validate() {
        if (base.getText().toString().isEmpty()) {
            base.setError(getString(R.string.validate_base));
            base.requestFocus();
            return false;
        }

        if (Integer.parseInt(base.getText().toString()) == 0) {
            base.setError(getString(R.string.validate_base));
            base.requestFocus();
            return false;
        }

        if (side.getText().toString().isEmpty()) {
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }

        if (Integer.parseInt(side.getText().toString()) == 0) {
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }

        return true;
    }
}