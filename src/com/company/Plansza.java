package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static javax.imageio.ImageIO.*;

public class Plansza {
    private int w = 10; //wysokość planszy
    private int h = 10; //szerokość planszy
    private int[] plansza = new int[100]; //tablica pomocnicza obrazu planszy
    private String[] nazwy = {"podloga.jpg", //kod 0
            "kolumna.jpg", //kod 1
            "miejsce.jpg", //kod 2
            "gracz.jpg",//kod 3
            "graczmc.jpg",  //kod 4

    }; //tablica z nazwami obrazków
    private Image obrazy[] = new Image[nazwy.length]; //tablica z obrazami

    private int StaraPozycjaGracza;
    private int PozycjaGracza;



    public Plansza() //konstruktor klasy Plansza
    { //pobierz obrazki do tablicy:

        for (int i = 0; i < nazwy.length; i++) {
            try {
                obrazy[i] = read(new File(nazwy[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Levels.setLevel(1);
            UstawPlansze();

        }
    }

    public void UstawPlansze() //ustaw pozycje obrazków na planszy
    {
        for (int i = 0; i < (w * h); i++) // wypełnij tablice zerami
        {
            plansza[i] = 0; // 0 - kod pustego miejsca (podloga)
        }
        plansza[Levels.getMeta()] = 2; // 2 - kod mety
        plansza[Levels.getStartGracza()] = 3; // 3- kod pozycji gracza
        for (int i = 0; i < Levels.getKolumny().length; i++) { //ustaw kolumny
//ustaw kolumny na planszy, 1 - kod kolumny
            plansza[Levels.getKolumny()[i]] = 1;
        }
        PozycjaGracza = Levels.getStartGracza();
        StaraPozycjaGracza = PozycjaGracza;
    }

    private void ZmienPlansze()  //zmianie ulega tylko pozycja gracza
    {
        if (PozycjaGracza == Levels.getMeta()) {

            plansza[PozycjaGracza] = 4;
            plansza[StaraPozycjaGracza] = 0;


            //Levels.setLevel(2);
            // UstawPlansze();
            if (Levels.getLevel() != 3) {
                Panel.next.setVisible(true);
                Levels.setNext();
            } else {
                Panel.win.setVisible(true);
            }


            return;
        } else if (plansza[PozycjaGracza] == 1) {
            PozycjaGracza = StaraPozycjaGracza;
        }
        //jeśli gracz wchodzi na kolumnę - cofamy gracza do poprzedniej pozycji
        if (StaraPozycjaGracza != PozycjaGracza)
            plansza[StaraPozycjaGracza] = 0;
        //jeśli pozycja gracza różni się od starej pozycji gracza – na starej
        //pozycji rysujemy podłogę

        plansza[PozycjaGracza] = 3;


        //jeśli pozycja gracza pokrywa się z metą – w miejscu mety rysujemy
        //obrazek z graczem na mecie


    }

    public void RysujPlansze(Graphics2D g) {
        ZmienPlansze();
        //Rysowanie obrazów na planszy po zmianie pozycji gracza
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                g.drawImage(obrazy[plansza[i + w * j]], 40 + i * 30, 40 + j * 30, null);
                //obrazki .jpg mają wymiary 30x30 pikseli
                //wyznaczyć współrzędne x i y położenia kolejnych obrazów na planszy
            }
        }

    }

    public void PrzesunLudka(int i) { // i=0 do góry, i=1 w prawo, i=2 w dół, i=3 w lewo


        StaraPozycjaGracza = PozycjaGracza;
        switch (i) {


            case 0:
                if (PozycjaGracza % 10 != 0) //sprawdz czy można //lewo
                    PozycjaGracza -= 1;
                break;
            case 1:
                if (PozycjaGracza + 10 < 100) //sprawdz czy można //dół
                    PozycjaGracza += 10;
                break;
            case 2:

                if (PozycjaGracza % 10 != 9) //sprawdz czy można //prawo
                    PozycjaGracza += 1;

                break;
            case 3:
                if (PozycjaGracza - 10 >= 0) //sprawdz czy można //góra
                    PozycjaGracza -= 10;

                break;


        }

        //System.out.println(PozycjaGracza);
    }

}
