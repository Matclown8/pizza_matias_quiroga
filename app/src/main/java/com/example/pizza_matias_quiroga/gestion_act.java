package com.example.pizza_matias_quiroga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Model.Pizzaspedido;

public class gestion_act extends AppCompatActivity {


    private EditText name, precio, locacion;
    private Button btn;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        name = findViewById(R.id.name);
        precio = findViewById(R.id.precio);
        locacion = findViewById(R.id.locacion);
        btn = findViewById(R.id.btn);

        inicializarBase();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pizzaspedido p = new Pizzaspedido();

                p.setId(UUID.randomUUID().toString());
                p.setNombre(name.getText().toString());
                p.setPrecio(precio.getText().toString());
                p.setLocalizacion(locacion.getText().toString());

                databaseReference.child("Pedidos").child(p.getId()).setValue(p);
                Toast.makeText(getBaseContext(),"Has echo un pedido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inicializarBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getInstance().getReference();
    }
}