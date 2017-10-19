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

public class PaintPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Draw 
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(250, 30, 250, 150);
        g2.drawLine(250, 30, 325, 30);
        g2.drawLine(325, 30, 325, 50);
        g2.drawLine(200, 150, 350, 150);
        
            if(Hangman.currentScore == 90) { //head
            g2.drawOval(300, 50, 50, 50);
        }
	    if(Hangman.currentScore == 80) { //body
            g2.drawOval(300, 50, 50, 50);
            g2.drawLine(325, 100, 325, 120);
        }
	    if(Hangman.currentScore == 70) { //L arm
            g2.drawOval(300, 50, 50, 50);
            g2.drawLine(325, 100, 325, 120);
            g2.drawLine(325, 110, 300, 120); 
        }
	    if(Hangman.currentScore == 60) { //R arm
            g2.drawOval(300, 50, 50, 50);
            g2.drawLine(325, 100, 325, 120);
            g2.drawLine(325, 110, 300, 120);
            g2.drawLine(325, 110, 350, 120);
        }
	    if(Hangman.currentScore == 50) { //L leg
            g2.drawOval(300, 50, 50, 50);
            g2.drawLine(325, 100, 325, 120);
            g2.drawLine(325, 110, 300, 120);
            g2.drawLine(325, 110, 350, 120);
            g2.drawLine(325, 120, 300, 140);
        }
            if(Hangman.currentScore == 40) { //R leg
            g2.drawOval(300, 50, 50, 50);
            g2.drawLine(325, 100, 325, 120);
            g2.drawLine(325, 110, 300, 120);
            g2.drawLine(325, 110, 350, 120);
            g2.drawLine(325, 120, 300, 140);
            g2.drawLine(325, 120, 350, 140);
        }
    }
}
