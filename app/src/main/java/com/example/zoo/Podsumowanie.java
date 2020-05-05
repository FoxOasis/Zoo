package com.example.zoo;

import java.util.List;

public class Podsumowanie implements Event{
    int kwota;
    List<Integer> odwiedziny;

    public Podsumowanie(int kwota, List<Integer> odwiedziny) {
        this.kwota = kwota;
        this.odwiedziny = odwiedziny;
    }
}
