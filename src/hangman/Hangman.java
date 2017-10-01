/***************************************************************
* file: Hangman.java
* author: Lenny Yang, Rachel Frodsham, Jenna Barrett
* class: CS245 – Graphic User Interface (GUI)
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/1/2017
*
* purpose: This program creates the hangman game with Java code
*
****************************************************************/ 
package hangman;

import java.awt.event.*;
import javax.swing.*;

public class Hangman{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         hangman();
    }
    
    
    // method: hangman()
    // purpose: create windows that make the Hangman game
    private static void hangman() {
        
        JFrame firstFrame = new JFrame("Title"); 
        JFrame mainMenuFrame = new JFrame("Hangman"); 

        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        final JLabel titleText=new JLabel();
        final JLabel teamText=new JLabel();  
        titleText.setText("CS245 Quarter Project"); 
        teamText.setText("By: Team Pasta");  

        
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits");  

        titleText.setBounds(250,100, 150,50);
        teamText.setBounds(250,300, 150,50);
        
        playButton.setBounds(500,275,95,30);  
        highScoreButton.setBounds(500,300,95,30);  
        creditsButton.setBounds(500,325,95,30);  
        
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    firstFrame.setVisible(false);
                    mainMenuFrame.setVisible(true); // Main Form to show after the Login Form..
                }
            }, 
            3000 
        );


        
        mainMenuFrame.add(playButton); 
        mainMenuFrame.add(highScoreButton); 
        mainMenuFrame.add(creditsButton); 
        
        firstFrame.add(titleText);  
        firstFrame.add(teamText);
                
        firstFrame.setSize(600,400);
        mainMenuFrame.setSize(600,400);  
        
        mainMenuFrame.setLayout(null);
        firstFrame.setLayout(null);
        mainMenuFrame.setLocationRelativeTo(null); 
        firstFrame.setLocationRelativeTo(null); 
        firstFrame.setVisible(true); 

    }
}
