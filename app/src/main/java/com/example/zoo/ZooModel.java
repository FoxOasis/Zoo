package com.example.zoo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZooModel extends ViewModel {
    Random rand = new Random();
    Kasa kasa = new Kasa();

    List<Integer> listaKlatki = new ArrayList<>();
    MutableLiveData<Event> passer = new MutableLiveData<>();

    public void createZoo() {
        listaKlatki.clear();
        kasa.setDniowka(0);
        for (int klatki = 0; klatki < 18; klatki++) {
            listaKlatki.add(0);
        }
    }

    public void newGuest() {

        Guest gosc = new Guest(rand.nextInt(80));
        kasa.zliczTypa(gosc);
        wizyta();
    }

    public void wizyta() {
        int przejscia = rand.nextInt(listaKlatki.size());

        for (int i = przejscia; i < listaKlatki.size(); i++) {
            int wizyta = rand.nextInt(listaKlatki.size());
                listaKlatki.set(wizyta, listaKlatki.get(wizyta) + 1);
            }



        }


    public void podsumowanie() {
        passer.postValue(new Podsumowanie(kasa.getDniowka(), listaKlatki));

    }
}
