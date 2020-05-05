package com.example.zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand;
    Button open;
    Button close;
    Button guest;
    TextView summary;
    ZooModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open = findViewById(R.id.open);
        close = findViewById(R.id.close);
        guest = findViewById(R.id.guest);
        summary = findViewById(R.id.sumarry);
        model = new ViewModelProvider(this).get(ZooModel.class);
        model.passer.observe(this, new Observer<Event>() {
            @Override
            public void onChanged(Event event) {
                if (event instanceof Podsumowanie) {
                    summary.setText(((Podsumowanie) event).kwota+""+"\n");
                    for (Integer lista: ((Podsumowanie) event).odwiedziny) {
                        summary.append(lista.toString()+"\n");
                    }
                }
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createZoo();
            }

        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.newGuest();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.podsumowanie();

            }
        });
    }


}
