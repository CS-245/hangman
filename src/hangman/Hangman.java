/***************************************************************
* file: Hangman.java
* authors: Lenny Yang, Rachel Frodsham, Jenna Barrett
* class: CS245 – Graphic User Interface (GUI)
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/1/2017
*
* purpose: This program creates the hangman game with Java code
*
****************************************************************/ 
package hangman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        //Frames
        JFrame titleFrame = new JFrame("Title"); 
        JFrame mainMenuFrame = new JFrame("Hangman"); 
        JFrame creditsFrame = new JFrame("Credits"); 

        creditsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        //Labels
        final JLabel titleText = new JLabel();
        final JLabel teamText = new JLabel();  
        final JLabel jennaBarrett = new JLabel();
        final JLabel lennyYang = new JLabel();
        final JLabel rachelFrodsham = new JLabel();

        titleText.setFont(new Font("Serif", Font.BOLD, 20));
        titleText.setText("CS245 Quarter Project"); 
        teamText.setText("By: Team Pasta");  
        jennaBarrett.setText("Jenna Barret, ");
        lennyYang.setText("Lenny Yang, ");
        rachelFrodsham.setText("Rachel Frodsham, ");

        //Buttons
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits"); 
        JButton backButton = new JButton("Back");  

        //Positioning
        titleText.setBounds(200,50, 300,150);
        teamText.setBounds(250,300, 150,50);
        playButton.setBounds(500,275,95,30);  
        highScoreButton.setBounds(500,300,95,30);  
        creditsButton.setBounds(500,325,95,30);
        backButton.setBounds(50,350,95,30);
        jennaBarrett.setBounds(250,125,200,100);
        lennyYang.setBounds(250,150,200,100);
        rachelFrodsham.setBounds(250,175,200,100);

        
        //Listeners
        new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    titleFrame.setVisible(false);
                    mainMenuFrame.setVisible(true); 
                }
            },
            3000 
        );
        
        creditsButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                mainMenuFrame.setVisible(false);
                creditsFrame.setVisible(true);
            }  
        });
        
        backButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                creditsFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
            }  
        });  


        
        
        //Title Frame
        titleFrame.setSize(600,400);
        titleFrame.add(titleText);  
        titleFrame.add(teamText);
        titleFrame.setLayout(null);
        titleFrame.setLocationRelativeTo(null); 
        titleFrame.setVisible(true); 


        //Main Frame
        mainMenuFrame.setSize(600,400);  
        mainMenuFrame.add(playButton); 
        mainMenuFrame.add(highScoreButton); 
        mainMenuFrame.add(creditsButton);                 
        mainMenuFrame.setLayout(null);
        mainMenuFrame.setLocationRelativeTo(null); 
        
        //Credits Frame
        creditsFrame.setSize(600,400);
        creditsFrame.add(jennaBarrett);
        creditsFrame.add(lennyYang);
        creditsFrame.add(rachelFrodsham);
        creditsFrame.add(backButton);
        creditsFrame.setLayout(null);
        creditsFrame.setLocationRelativeTo(null); 

    }
}
