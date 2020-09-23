package com.example.tallerlistview.Areas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

public class CalculateAreaSquare extends AppCompatActivity {
    private EditText side;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_area_square);

        side = findViewById(R.id.txtSideValue);
        result = findViewById(R.id.lblResult);
    }

    public void save(View v){
        Operation operation;
        double res ;
        int value_side;
        result.setText("");
        if(validate()){
            value_side = Integer.parseInt(String.valueOf(side.getText()));

            res = value_side * value_side;
            result.setText(getString(R.string.areaSquare) + res);
            operation = new Operation(
                    ""+getString(R.string.areaSquareResult),
                    ""+value_side,
                    ""+res
            );
            operation.save();
            Toast.makeText(this, R.string.operation_success,Toast.LENGTH_LONG).show();
        }
    }

    public void clear(View v){
        side.setText("");
        result.setText("");
        side.requestFocus();
    }

    public boolean validate(){
        if(side.getText().toString().isEmpty()){
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }

        if(Integer.parseInt(side.getText().toString()) == 0){
            side.setError(getString(R.string.validate_side));
            side.requestFocus();
            return false;
        }
        return true;
    }
}