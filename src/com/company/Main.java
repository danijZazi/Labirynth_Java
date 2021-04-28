package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Gra");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);

        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setVisible(true);


    }
}
