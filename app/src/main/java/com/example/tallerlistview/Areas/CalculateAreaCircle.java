package com.example.tallerlistview.Areas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerlistview.Operation;
import com.example.tallerlistview.R;

import org.w3c.dom.Text;

public class CalculateAreaCircle extends AppCompatActivity {
private TextView result;
private EditText radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_area_circle);

        result = findViewById(R.id.lblResult);
        radius = findViewById(R.id.txtRadius);

    }

    public void calculate(View v){
        Operation operation;
        double res , value_radius;
        result.setText("");
        if(validate()){
            value_radius = Double.parseDouble(String.valueOf(radius.getText()));

            res = Math.pow(value_radius,2)*Math.PI;
            result.setText(getString(R.string.areaCircle) + res);
            operation = new Operation(
                    ""+getString(R.string.areaTriangleResult),
                    ""+ getString(R.string.circle_radius) +value_radius,
                    ""+res
            );
            operation.save();
            Toast.makeText(this, R.string.operation_success,Toast.LENGTH_LONG).show();
        }

    }

    public boolean validate(){
        if(radius.getText().toString().isEmpty()){
            radius.setError(getString(R.string.validate_radius));
            radius.requestFocus();
            return false;
        }

        if(Double.parseDouble(radius.getText().toString()) == 0){
            radius.setError(getString(R.string.validate_radius));
            radius.requestFocus();
            return false;
        }

        return true;
    }


}