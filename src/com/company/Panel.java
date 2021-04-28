package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements ActionListener, KeyListener {

    JPanel panel;
    public static JButton start, about, finish, next;
    public static JLabel win;
    Plansza plansza;
    int menu = 0;

    public Panel() {

        plansza = new Plansza();
        panel = new JPanel();
        prepareButtons();

        addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    void prepareButtons() {

        start = new JButton("Nowa gra");
        about = new JButton("O grze");
        finish = new JButton("Koniec");
        next = new JButton("Następny poziom");
        win = new JLabel("Wygrałes");

        next.setBounds(115, 160, 150, 35);
        win.setBounds(115, 160, 150, 35);
        start.setBounds(0, 0, 130, 35);
        about.setBounds(130, 0, 130, 35);
        finish.setBounds(260, 0, 130, 35);


        add(start);
        add(about);
        add(finish);
        add(next);
        add(win);


        start.setFocusable(false);
        about.setFocusable(false);
        finish.setFocusable(false);
        next.setFocusable(false);

        next.setVisible(false);
        win.setVisible(false);

        start.addActionListener(this);
        next.addActionListener(this);
        about.addActionListener(this);
        finish.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == start) {


            Levels.setLevel(1);
            plansza.UstawPlansze();
            setMenu(1);
            repaint();
            next.setVisible(false);
            win.setVisible(false);

        } else if (o == about) {

            setMenu(2);
            next.setVisible(false);
            win.setVisible(false);
            repaint();

        } else if (o == next) {

            plansza.UstawPlansze();
            next.setVisible(false);
            repaint();

        } else if (o == finish) {
            System.exit(0);
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;

        switch (menu) {

            case 1:
                if (!next.isVisible() && !win.isVisible())
                    plansza.RysujPlansze(gr);
                break;
            case 2:
                gr.drawString("Opis gry: ", 0, 150);
                gr.drawString("Polega na przejściu ludzikiem w wyznaczone miejsce", 0, 170);
                gr.drawString("Sterowanie: ", 0, 190);
                gr.drawString("Sterowanie: Strzałki lub W A S D", 0, 210);
                break;


        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {



        switch (e.getKeyCode()) {
            case 38:
            case 87:
                plansza.PrzesunLudka(3);
                break;
            case 40:
            case 83:
                plansza.PrzesunLudka(1);
                break;
            case 37:
            case 65:
                plansza.PrzesunLudka(0);
                break;
            case 39:
            case 68:
                plansza.PrzesunLudka(2);
                break;
        }
        repaint();


        //System.out.println(code);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    void setMenu(int menu) {
        this.menu = menu;
    }
}
