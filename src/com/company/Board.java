package com.company;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{

        private int w = 10; //wysokość planszy
        private int h = 10; //szerokość planszy
        private int[] plansza = new int[100]; //tablica pomocnicza obrazu planszy
        private int PozycjaGracza = 0; //początkowa pozycja gracza
        private int StaraPozycjaGracza = 0; //poprzednia pozycja gracza
        private int Meta = 9; //pozycja mety
        private int[] Kolumny = { 3, 5, 11, 12, 13, 18, 23, 24, 25, 28, 38,
                48, 93 }; //rozmieszczenie kolumn labiryntu
        //dodaj więcej kolumn
        private String[] nazwy = {"podloga.jpg", //kod 0
                "kolumna.jpg", //kod 1
                "miejsce.jpg", //kod 2
                "gracz.jpg", //kod 3
                "graczmc.jpg" //kod 4
        }; //tablica z nazwami obrazków
        private Image obrazy[]=new Image[nazwy.length]; //tablica z
        private int menu;
        public Board() //konstruktor klasy Plansza
        { //pobierz obrazki do tablicy:
                for(int i=0;i<nazwy.length;i++) {
                        obrazy[i]=Toolkit.getDefaultToolkit().getImage(nazwy[i]);
                }
                UstawPlansze();
                menu=-1;
        }
        public int getMenu(){
                return this.menu;
        }
        public void setMenu(int menu){
                this.menu=menu;
        }

        private void UstawPlansze() //ustaw pozycje obrazków na planszy
        {
                for (int i = 0; i < (w * h); i++) // wypełnij tablice zerami
                {
                        plansza[i] = 0; // 0 - kod pustego miejsca (podloga)
                }
                plansza[Meta] = 2; // 2 - kod mety
                plansza[PozycjaGracza] = 3; // 3- kod pozycji gracza
                for (int i = 0; i < Kolumny.length; i++){ //ustaw kolumn
                        // ustaw kolumny na planszy, 1 - kod kolumny
                        plansza[Kolumny[i]] = 1;
                }
        }
        private void ZmienPlansze(Graphics2D g) //zmianie ulega tylko pozycja gracza
        {
               // Graphics2D g2 = (Graphics2D) g;
                // if()
                if (plansza[PozycjaGracza] == 1) {
                        PozycjaGracza = StaraPozycjaGracza;
                } else if (PozycjaGracza == Meta)
                {

                        plansza[Meta] = 4;
                        plansza[StaraPozycjaGracza]=0;
                        repaint();
                        setMenu(3);


                        return;
                }
                //jeśli gracz wchodzi na kolumnę - cofamy gracza do poprzedniej pozycji
                if(StaraPozycjaGracza!=PozycjaGracza)
                        plansza[StaraPozycjaGracza]=0;
                //jeśli pozycja gracza różni się od starej pozycji gracza – na starej
                //pozycji rysujemy podłogę
                plansza[PozycjaGracza]=3;

                //jeśli pozycja gracza pokrywa się z metą – w miejscu mety rysujemy
                //obrazek z graczem na mecie
                repaint();


        }
        public void RysujPlansze(Graphics2D g)
        {
                ZmienPlansze(g);
                //System.out.println(PozycjaGracza);
             //Rysowanie obrazów na planszy po zmianie pozycji gracza
                for (int i = 0; i < w; i++){
                        for (int j = 0; j < h; j++)
                        {
                                g.drawImage(obrazy[plansza[i+w*j]], j*30, i*30, null);


        //obrazki .jpg mają wymiary 30x30 pikseli
        //wyznaczyć współrzędne x i y położenia kolejnych obrazów na planszy
                        }}
        }
        public void PrzesunLudka(int i)
        { // i=0 do góry, i=1 w prawo, i=2 w dół, i=3 w lewo
                StaraPozycjaGracza = PozycjaGracza;
                switch (i)
                {


                        case 0:
                                if (PozycjaGracza - 1 >= 0) //sprawdz czy można
                                PozycjaGracza -= 1;
                                break;
                        case 1:
                                if (PozycjaGracza + 10 < 100) //sprawdz czy można
                                PozycjaGracza += 10;
                                break;
                        case 2:

                                if (PozycjaGracza + 1 < 100) //sprawdz czy można
                                      PozycjaGracza += 1;

                                break;
                        case 3:
                                 if (PozycjaGracza - 10 >= 0) //sprawdz czy można
                                PozycjaGracza -= 10;
                }
        }
        public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                switch (getMenu()) {
                        case 2:
                                plansza[PozycjaGracza]=0;
                                PozycjaGracza=0;
                                StaraPozycjaGracza=0;
                                repaint();
                                setMenu(1);

                                break; //nowa gra
                        case 1:
                                RysujPlansze(g2);
                                break; //gramy dalej
                        case 0:
                                g2.drawString("Opis gry ...", 50, 50); //opis gry
                                repaint();
                                break;
                        case 3: g2.drawString("Wygrałes",50,50); break;

                }
        }


}



