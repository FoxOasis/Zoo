package com.example.zoo;

public class Kasa {
private int dniowka = 0;
    public void zliczTypa(Guest guest){
        if(guest.age > 12){
            dniowka = dniowka + 20;
        }else {
            dniowka = dniowka + 12;
        }
    }

    public int getDniowka() {
        return dniowka;
    }

    public void setDniowka(int dniowka) {
        this.dniowka = dniowka;
    }
}
