package com.jpauwels.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //declare variables
    double totalBill;
    double tipPercent;
    double calculatedTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calc = (Button)findViewById(R.id.btnCalc);
        //declare connections to interface components
        final EditText total = (EditText)findViewById(R.id.txtTotal);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        calc.setOnClickListener(new View.OnClickListener() {
            //declare connection to result TextView
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View view) {
                //perform calculations and display output in the result TextView box
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                totalBill = Double.parseDouble(total.getText().toString());
                tipPercent = Double.parseDouble(group.getSelectedItem().toString()) / 100;
                calculatedTip = tipPercent * totalBill;
                result.setText("The tip amount is " + currency.format(calculatedTip) + ".");
            }
    });
}
}