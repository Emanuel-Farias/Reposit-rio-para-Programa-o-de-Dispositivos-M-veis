package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;

    EditText edtNumero;

    TextView tv,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        edtNumero=findViewById(R.id.edtNumero);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tv9=findViewById(R.id.tv9);

        button.setOnClickListener(v -> {
            int numero,um,dois,tres,quatro,cinco,seis,sete,oito,nove,dez;

            numero=Integer.parseInt(edtNumero.getText().toString());

            tv.setText(Integer.toString(numero*1));
            tv1.setText(Integer.toString(numero*2));
            tv2.setText(Integer.toString(numero*3));
            tv3.setText(Integer.toString(numero*4));
            tv4.setText(Integer.toString(numero*5));
            tv5.setText(Integer.toString(numero*6));
            tv6.setText(Integer.toString(numero*7));
            tv7.setText(Integer.toString(numero*8));
            tv8.setText(Integer.toString(numero*9));
            tv9.setText(Integer.toString(numero*10));


        });
    }
}