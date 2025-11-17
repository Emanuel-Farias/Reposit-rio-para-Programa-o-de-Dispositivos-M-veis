package com.example.app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button b;

    ListView listagem;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        b = findViewById(R.id.b);
        listagem=findViewById(R.id.lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("app_databse",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " titulo VARCHAR,texto TEXT)");

        carregarListagem();

        b=findViewById(R.id.b);
        b.setOnClickListener(v -> {

            String texto=editText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo",texto);
            cv.put("texto", "Este é o texto da nota de exemplo");
            db.insert("notas", null,cv);
            Toast.makeText(this,"Nota salva com sucesso!", Toast.LENGTH_SHORT).show();
            carregarListagem();
        });
        listagem.setOnItemClickListener((parent,view,position,id)-> {
            String titulo = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ExibeItem.class);
            intent.putExtra("titulo",titulo);
            startActivity(intent);

        });


    }

        public void carregarListagem(){
            ArrayList<String> titulos = new ArrayList<String>();
            Cursor cursor = db.rawQuery("SELECT * FROM notas",null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                titulos.add(titulo);
                cursor.moveToNext();
            }

            ArrayAdapter<String> titulosAdapter = new ArrayAdapter<>(
                    getApplication(),
                    android.R.layout.simple_list_item_1,
                    titulos
            );
            listagem.setAdapter(titulosAdapter);
        }





}