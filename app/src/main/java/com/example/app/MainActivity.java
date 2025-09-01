package com.example.app;

import android.os.Bundle;
import android.util.Log;
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

   EditText editTextMin,editTextMax;

   TextView tvResultado,tvIntroducao;

   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       button=findViewById(R.id.button);
       editTextMin=findViewById(R.id.edMin);
       editTextMax=findViewById(R.id.edMax);
       tvResultado=findViewById(R.id.tvResultado);
       tvIntroducao=findViewById(R.id.tvIntroducao);

       button.setOnClickListener(v -> {
           Random random=new Random();
           int min,max;
           min=Integer.parseInt(editTextMin.getText().toString());
           max=Integer.parseInt(editTextMax.getText().toString());
           int delta=max-min;
           int sorteado= random.nextInt(delta)+min;
           tvResultado.setText(Integer.toString(sorteado));
       });

   }


}