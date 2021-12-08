package com.example.pizza_matias_quiroga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objeto.Pizza;

public class Arma_pizza_act extends AppCompatActivity {

    private Spinner pizzas, ingred;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        pizzas = (Spinner) findViewById(R.id.spn1);
        ingred = (Spinner) findViewById(R.id.spn2);
        resultado = (TextView) findViewById(R.id.result);

        Pizza pizz = new Pizza();
        String[] listapizza = pizz.getPizzas();
        String[] listaingre = pizz.getIngredientes();

        ArrayAdapter adapPizzas = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listapizza);
        pizzas.setAdapter(adapPizzas);
        ArrayAdapter adapIngre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaingre);
        ingred.setAdapter(adapIngre);

    }

    public void Boton_calcular(View view){

        Pizza pizz = new Pizza();
        String[] pizlista = pizz.getPizzas();
        String[] ingrelista = pizz.getIngredientes();
        String selecPizza = pizzas.getSelectedItem().toString();
        String selectIngre = ingred.getSelectedItem().toString();
        int auxp= 0;
        int auxi= 0;

        int[] valorP = pizz.getPrecios();
        int[] valorI = pizz.getPreciosi();


        for(int i = 0 ; 1 < pizlista.length; i++){
            if(pizlista[i] == selecPizza){
                auxp = i;
                break;
            }
        }
        for(int i = 0 ; 1 < ingrelista.length; i++){
            if(ingrelista[i] == selectIngre) {
                auxi = i;
                break;
            }
        }
        resultado.setText("El valor TOTAL de su pizza es: $"+ pizz.calcular(valorP[auxp],valorI[auxi]));
    }
}