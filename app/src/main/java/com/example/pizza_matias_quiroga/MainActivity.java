
package com.example.pizza_matias_quiroga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Gestion(View view)
    {
        Intent i = new Intent(this, Gestion_act.class);
        startActivity(i);

    }
    public void Listado(View view)
    {
        Intent i = new Intent(this, Listado_act.class);
        startActivity(i);

    }
    public void Arma(View view)
    {
        Intent i = new Intent(this, Arma_pizza_act.class);
        startActivity(i);

    }

    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // ABRE SITIO WEB.
        i.setData(Uri.parse("https://www.facebook.com/")); // RECIBE LA DIRECCION WEB
        startActivity(i); // INICIA EL ACTIVITY
    }

    public void Instagram(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // ABRE SITIO WEB.
        i.setData(Uri.parse("https://www.instagram.com/")); // RECIBE LA DIRECCION WEB
        startActivity(i); // INICIA EL ACTIVITY

    }

    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // ABRE SITIO WEB.
        i.setData(Uri.parse("https://www.twitter.com/")); // RECIBE LA DIRECCION WEB
        startActivity(i); // INICIA EL ACTIVITY
    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // ABRE SITIO WEB.
        i.setData(Uri.parse("https://www.youtube.com/")); // RECIBE LA DIRECCION WEB
        startActivity(i); // INICIA EL ACTIVITY
    }
}