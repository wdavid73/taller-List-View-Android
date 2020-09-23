package com.example.tallerlistview.Volumes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

public class Cube extends AppCompatActivity {
    private EditText side;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_volume_cube);

        side = findViewById(R.id.txtSide);
        result = findViewById(R.id.lblResult);

    }

    public void calculate(View v) {
        Operation operation;
        double res, value_side;
        result.setText("");
        if (validate()) {
            value_side = Double.parseDouble(String.valueOf(side.getText()));
            res = Math.pow(value_side, 3);
            result.setText(getText(R.string.volume_cube) + " " + res);
            operation = new Operation(
                    "" + getString(R.string.volume_cube_result),
                    "" + getString(R.string.value_side) + " " + value_side,
                    "" + res
            );
            operation.save();
            Toast.makeText(this, getString(R.string.operation_success), Toast.LENGTH_LONG).show();
        }
    }

    public boolean validate() {
        if (side.getText().toString().isEmpty()) {
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }

        if (Double.parseDouble(side.getText().toString()) == 0) {
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }


        return true;
    }


}