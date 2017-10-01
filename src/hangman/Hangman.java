/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author lennyyang
 */
public class Hangman{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Hangman();
    }
    
    

    private static void Hangman() {
        
        JFrame firstFrame = new JFrame("Title"); 
        JFrame mainMenuFrame = new JFrame("Hangman"); 

        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        final JLabel titleText=new JLabel();
        final JLabel teamText=new JLabel();  
        titleText.setText("CS245 Quarter Project"); 
        teamText.setText("By: Team Pasta");  

        
        JButton btnPC = new JButton("Place Holder Button");  
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits");  

        titleText.setBounds(250,100, 150,50);
        btnPC.setBounds(250,150, 150,50);
        teamText.setBounds(250,300, 150,50);
        
        playButton.setBounds(500,275,95,30);  
        highScoreButton.setBounds(500,300,95,30);  
        creditsButton.setBounds(500,325,95,30);  


        btnPC.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                firstFrame.setVisible(false);
                mainMenuFrame.setVisible(true); // Main Form to show after the Login Form..
            }
        });

        
        mainMenuFrame.add(playButton); 
        mainMenuFrame.add(highScoreButton); 
        mainMenuFrame.add(creditsButton); 
        
        firstFrame.add(titleText);  
        firstFrame.add(btnPC);
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
