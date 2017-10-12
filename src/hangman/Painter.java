/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author lennyyang
 */
public class Painter extends JPanel{
    static boolean checker = false;
    public Painter(){
    }
    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //hangmans noose
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(250, 80, 250, 200);
        g2.drawLine(250, 80, 325, 80);
        g2.drawLine(325, 80, 325, 100);
        g2.drawLine(200, 200, 350, 200);
        
        if(Hangman.currentScore == 90) { //head
            g2.drawOval(300, 100, 50, 50);
        }
	    if(Hangman.currentScore == 80) { //body
            g2.drawOval(300, 100, 50, 50);
            g2.drawLine(325, 150, 325, 170);
        }
	    if(Hangman.currentScore == 70) { //L arm
            g2.drawOval(300, 100, 50, 50);
            g2.drawLine(325, 150, 325, 170);
            g2.drawLine(325, 160, 300, 170);
        }
	    if(Hangman.currentScore == 60) { //R arm
            g2.drawOval(300, 100, 50, 50);
            g2.drawLine(325, 150, 325, 170);
            g2.drawLine(325, 160, 300, 170);
            g2.drawLine(325, 160, 350, 170);
        }
	    if(Hangman.currentScore == 50) { //L leg
            g2.drawOval(300, 100, 50, 50);
            g2.drawLine(325, 150, 325, 170);
            g2.drawLine(325, 160, 300, 170);
            g2.drawLine(325, 160, 350, 170);
            g2.drawLine(325, 170, 300, 190);
        }
            if(Hangman.currentScore == 40) { //R leg
            g2.drawOval(300, 100, 50, 50);
            g2.drawLine(325, 150, 325, 170);
            g2.drawLine(325, 160, 300, 170);
            g2.drawLine(325, 160, 350, 170);
            g2.drawLine(325, 170, 300, 190);
            g2.drawLine(325, 170, 350, 190);
        }
        
    }
}
