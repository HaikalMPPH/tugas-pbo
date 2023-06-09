package com.sugiartha.juniorandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KalkulatorActivity extends AppCompatActivity {

    EditText angka1, angka2;
    Button btnHitung;
    TextView txtHasil;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        btnHitung = (Button) findViewById(R.id.btnHitung);
        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
        btnHitung.setOnClickListener(new Button.OnClickListener() {
            @Override public void onClick(View v) {
                if (
                    angka1.getText().toString().isEmpty() &&
                    angka2.getText().toString().isEmpty()
                ) {
                    angka1.setText("0");
                    angka2.setText("0");
                }
                double angkasatu = Double.parseDouble(angka1.getText().toString());
                double angkadua = Double.parseDouble(angka2.getText().toString());
                double result = angkasatu + angkadua;
                txtHasil.setText(Double.toString(result));
            }});
    }
}
