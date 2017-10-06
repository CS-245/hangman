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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


class Painter extends JPanel{
    

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
        
    }
}

public class Hangman{

    static int currentScore = 100;
    
    public static void main(String[] args) throws InterruptedException{
         hangman();
    }
    
    // method: hangman()
    // purpose: create windows that make the Hangman game
    private static void hangman() {

        //Timer
        final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        int interval = 1000; // 1000 ms

        Calendar now = Calendar.getInstance();
        JLabel time = new JLabel(dateFormat.format(now.getTime()));
        time.setBounds(450, -50, 200, 125);
        
        Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                time.setText(dateFormat.format(now.getTime()));
            }
        });
        
        timer.start();
        

        
        //Frames
        JFrame titleFrame = new JFrame("Hangman"); 
        JFrame mainMenuFrame = new JFrame("Hangman"); 
        JFrame creditsFrame = new JFrame("Hangman"); 
        JFrame highScoreFrame = new JFrame("Hangman");
        JFrame playGame = new JFrame("Hangman");
        JFrame scoreFrame = new JFrame("Hangman");

        creditsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        highScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Labels
        final JLabel titleText = new JLabel();
        final JLabel teamText = new JLabel();  
        final JLabel jennaBarrett = new JLabel();
        final JLabel lennyYang = new JLabel();
        final JLabel rachelFrodsham = new JLabel();
        final JLabel titleCredit = new JLabel();
        final JLabel highScores = new JLabel();
        final JLabel hangmanTitle = new JLabel();
        final JLabel scoreTitle = new JLabel();
        final JLabel scoreText = new JLabel();
        
        ImageIcon pastaIcon = new ImageIcon("Images/pasta.png");
        JLabel pastaImage = new JLabel(pastaIcon); 

        titleText.setText("CS245 Quarter Project"); 
        titleCredit.setText("Credits");
        teamText.setText("Pasta Party");  
        jennaBarrett.setText("Jenna Barret, 010805821");
        lennyYang.setText("Lenny Yang, 010265034");
        rachelFrodsham.setText("Rachel Frodsham, 009922783");
        highScores.setText("High Scores");
        hangmanTitle.setText("Hangman");
        scoreTitle.setText("Your Score");
        scoreText.setText(Integer.toString(currentScore));
        
        titleText.setFont(new Font("Serif", Font.BOLD, 30));
        titleCredit.setFont(new Font("Serif", Font.BOLD, 20));
        teamText.setFont(new Font("Curlz MT", Font.PLAIN, 30));
        highScores.setFont(new Font("Serif", Font.BOLD, 20));
        hangmanTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
        scoreTitle.setFont(new Font("Serif", Font.BOLD, 35));
        scoreText.setFont(new Font("Serif", Font.PLAIN, 20));

        //Buttons
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits");
        JButton backButtonCF = new JButton("Back");
        JButton backButtonHS = new JButton("Back");
        JButton skipButton = new JButton("Skip");
        JButton endButton = new JButton("End");

        //Positioning
        titleText.setBounds(140,50,500,150);
        teamText.setBounds(230,300,200,50);
        playButton.setBounds(400,185,150,30);  
        highScoreButton.setBounds(400,235,150,30);  
        creditsButton.setBounds(400,285,150,30);
        backButtonHS.setBounds(25,300,95,30);   
        backButtonCF.setBounds(25,300,95,30);
        jennaBarrett.setBounds(250,125,200,100);
        lennyYang.setBounds(250,150,200,100);
        rachelFrodsham.setBounds(250,175,200,100);
        pastaImage.setBounds(10, 0, 400, 400);
        titleCredit.setBounds(250,75,100,100);
        highScores.setBounds(250,10,300,150);
        hangmanTitle.setBounds(25,-10,500,100);        
        skipButton.setBounds(400,285,100,30);
        scoreTitle.setBounds(200, -10, 500, 100);
        scoreText.setBounds(250, 100, 500, 100);
        endButton.setBounds(400,285,150,30);

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

        skipButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                playGame.setVisible(false);
                scoreFrame.setVisible(true);
            }  
        });     
        
        endButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                scoreFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
                currentScore = 100;
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
        
        //Play Frame
        playGame.setSize(600,400);  
        playGame.add(hangmanTitle); 
        playGame.add(time);
        playGame.add(skipButton);
        playGame.setLocationRelativeTo(null); 
        Painter p = new Painter();
        p.setVisible(true);
        playGame.add(p);
        
        //Score Frame
        scoreFrame.setSize(600,400);
        scoreFrame.add(scoreTitle);
        scoreFrame.add(scoreText);
        scoreFrame.setLayout(null);
        scoreFrame.setLocationRelativeTo(null);
    
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