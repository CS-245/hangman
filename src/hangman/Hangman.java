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
        JFrame mainMenuFrame = new JFrame("Main Menu"); 
        JFrame creditsFrame = new JFrame("Credits"); 
        JFrame highScoreFrame = new JFrame("High Scores");
        JFrame playGame = new JFrame("Hangman");

        creditsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        highScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Labels
        final JLabel titleText = new JLabel();
        final JLabel teamText = new JLabel();  
        final JLabel jennaBarrett = new JLabel();
        final JLabel lennyYang = new JLabel();
        final JLabel rachelFrodsham = new JLabel();
        final JLabel titleCredit = new JLabel();
        final JLabel highScores = new JLabel();
        final JLabel hangmanTitle = new JLabel();


        ImageIcon pastaIcon = new ImageIcon("Images/pasta.png");
        JLabel pastaImage = new JLabel(pastaIcon); 

        titleText.setText("CS245 Quarter Project"); 
        titleCredit.setText("Credits");
        teamText.setText("By: Team Pasta");  
        jennaBarrett.setText("Jenna Barret, 010805821");
        lennyYang.setText("Lenny Yang, 010265034");
        rachelFrodsham.setText("Rachel Frodsham, 009922783");
        highScores.setText("High Scores");
        hangmanTitle.setText("Hangman");
        
        titleText.setFont(new Font("Serif", Font.BOLD, 20));
        titleCredit.setFont(new Font("Serif", Font.BOLD, 20));
        highScores.setFont(new Font("Serif", Font.BOLD, 20));
        hangmanTitle.setFont(new Font("Serif", Font.BOLD, 20));

        //Buttons
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits");
        JButton backButtonCF = new JButton("Back");
        JButton backButtonHS = new JButton("Back");

        //Positioning
        titleText.setBounds(200,50, 300,150);
<<<<<<< HEAD
        teamText.setBounds(250,300, 200,50);
=======
        teamText.setBounds(250,300, 150,50);
>>>>>>> 538c4515dafa9d3f37d6d8816bf2d65f8d1375c6
        playButton.setBounds(400,225,150,30);  
        highScoreButton.setBounds(400,275,150,30);  
        creditsButton.setBounds(400,325,150,30);
        backButtonHS.setBounds(25,300,95,30);
        backButtonCF.setBounds(25,300,95,30);
        jennaBarrett.setBounds(250,125,200,100);
        lennyYang.setBounds(250,150,200,100);
        rachelFrodsham.setBounds(250,175,200,100);
        pastaImage.setBounds(10, 0, 400, 400);
        titleCredit.setBounds(250,75,100,100);
        highScores.setBounds(250,10,300,150);
        hangmanTitle.setBounds(10,0,100,100);

        //Listeners
        new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    titleFrame.setVisible(false);
                    mainMenuFrame.setVisible(true);
                }
            },
            4500 
        );
        
        highScoreButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                mainMenuFrame.setVisible(false);
                highScoreFrame.setVisible(true);
            }  
        });
        
        playButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                mainMenuFrame.setVisible(false);
                playGame.setVisible(true);
            }
        });

        creditsButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                mainMenuFrame.setVisible(false);
                creditsFrame.setVisible(true);
            }  
        });
        
        backButtonCF.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                creditsFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
            }  
        });  
        
        backButtonHS.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                highScoreFrame.setVisible(false);
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
        mainMenuFrame.add(pastaImage);        
        mainMenuFrame.setLayout(null);
        mainMenuFrame.setLocationRelativeTo(null);
        
        //Main Frame
        playGame.setSize(600,400);  
        playGame.add(hangmanTitle); 
        playGame.setLayout(null);
        playGame.setLocationRelativeTo(null); 
    
        //Credits Frame
        creditsFrame.setSize(600,400);
        creditsFrame.add(titleCredit);
        creditsFrame.add(jennaBarrett);
        creditsFrame.add(lennyYang);
        creditsFrame.add(rachelFrodsham);
        creditsFrame.add(backButtonCF);
        creditsFrame.setLayout(null);
        creditsFrame.setLocationRelativeTo(null); 
        
        //High Scores Frame
        highScoreFrame.setSize(600,400);
        highScoreFrame.add(highScores);
        highScoreFrame.add(backButtonHS);
        highScoreFrame.setLayout(null);
        highScoreFrame.setLocationRelativeTo(null); 

    }
}
//