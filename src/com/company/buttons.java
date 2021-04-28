package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class buttons extends JPanel{

    Board board;
    private JPanel Panel;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton newGameButton;
    private JButton koniecButton;
    private JButton aboutButton;
    int menu;

    public buttons(){

        menu=-1;
        board = new Board();
        Panel.add(board);
        Panel.revalidate();
        //Panel = new JPanel();



        //this.board = new Board();
       // button2.addMouseListener(new MouseAdapter() {
          //  @Override
           /// public void mouseClicked(MouseEvent e) {
             //   super.mouseClicked(e);
             //   game.board.PrzesunLudka(5);
              //  validate();
              //  repaint();
           // }
       // });


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o=e.getSource();
                if(board.getMenu()==1){
                if (o==button1) board.PrzesunLudka(2);
                else if(o==button2) board.PrzesunLudka(0);
                else if(o==button3) board.PrzesunLudka(3);
                else if(o==button4) board.PrzesunLudka(1);
                // game.board.RysujPlansze();
                //uzupełnić obsługę pozostałych przycisków
                Panel.repaint(); //przerysuj panel po zmianach
                //Panel.revalidate();
                }
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);


        aboutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                board.setMenu(0);
                repaint();
            }
        });
        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


               board.setMenu(2);
               board.repaint();
                System.out.println(board.getMenu());


            }
        });
    }

    public JPanel getPanel(){
        return this.panel1;
    }





}
