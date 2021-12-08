package com.example.pizza_matias_quiroga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Model.Pizzaspedido;

public class listado_pact extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Pizzaspedido> listaPizzapedido = new ArrayList();

    Pizzaspedido pizzaselected;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pact);

        lista = findViewById(R.id.lv);

        inicializarBase();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                pizzaselected = (Pizzaspedido)parent.getItemAtPosition(i);
            }
        });


        databaseReference.child("Pedidos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot op: snapshot.getChildren()){
                    Pizzaspedido p = op.getValue(Pizzaspedido.class);

                    listaPizzapedido.add(p);
                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaPizzapedido);
                    lista.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void eliminarpedido(View view){

        Pizzaspedido p = new Pizzaspedido();
        p.setId(pizzaselected.getId());

        databaseReference.child("Pedidos").child(p.getId()).removeValue();
        Toast.makeText(getBaseContext(),"Has eliminado un pedido", Toast.LENGTH_SHORT).show();


    }



    public void inicializarBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getInstance().getReference();
    }
}