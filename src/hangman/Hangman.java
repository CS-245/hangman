/***************************************************************
* file: Hangman.java
* authors: Lenny Yang, Rachel Frodsham, Jenna Barrett
* class: CS245 – Graphic User Interface (GUI)
*
* assignment: Point and Click Game – v.1.0
* date last modified: 10/8/2017
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
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


class Painter extends JPanel{
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
        
        if(currentScore == 90) { //head
            g2.Oval(80, 100, 50, 50);
        }
	    if(currentScore == 80) { //body
            g2.drawLine(80, 150, 80, 225);
        }
	    if(currentScore == 70) { //L arm
            g2.drawLine(80, 200, 50, 150);
        }
	    if(currentScore == 60) { //R arm
            g2.drawLine(80, 200, 110, 150);
        }
	    if(currentScore == 50) { //L leg
            g2.drawLine(80, 250, 50, 250);
        }
	    if(currentScore == 40) { //R leg
            g2.drawLine(80, 250, 1100, 250);
        }
        
    }
}

public class Hangman{

    static int currentScore = 100;
    static String answer;
    static String displayedAnswer;
    
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
        

        //Word bank array
        String[] wordBank = new String[5];
        wordBank[0] = "abstract";
        wordBank[1] = "cemetery";
        wordBank[2] = "nurse";
        wordBank[3] = "pharmacy";
        wordBank[4] = "climbing";
    
        //random number generator
        Random rand = new Random(); 
        int value = rand.nextInt(5);    
        //choosing a word
        answer = wordBank[value];
        
        displayedAnswer = "";
        for (int i=0;i<answer.length();i++){
            displayedAnswer = displayedAnswer + "_ ";
        }
        
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
        JLabel answerText = new JLabel();

        titleText.setText("CS245 Quarter Project"); 
        titleCredit.setText("Credits");
        teamText.setText("Pasta Party");  
        jennaBarrett.setText("Jenna Barret, 010805821");
        lennyYang.setText("Lenny Yang, 010265034");
        rachelFrodsham.setText("Rachel Frodsham, 009922783");
        highScores.setText("High Scores");
        hangmanTitle.setText("Hangman");
	answerText.setText(displayedAnswer);
        scoreTitle.setText("Your Score");
        scoreText.setText(Integer.toString(currentScore));
        
        titleText.setFont(new Font("Serif", Font.BOLD, 30));
        titleCredit.setFont(new Font("Serif", Font.BOLD, 20));
        teamText.setFont(new Font("Curlz MT", Font.PLAIN, 30));
        highScores.setFont(new Font("Serif", Font.BOLD, 20));
        hangmanTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
        scoreTitle.setFont(new Font("Serif", Font.BOLD, 35));
        scoreText.setFont(new Font("Serif", Font.PLAIN, 20));
	answerText.setFont(new Font("Serif", Font.BOLD, 35));

        //Buttons
        JButton playButton = new JButton("Play");  
        JButton highScoreButton = new JButton("High Score");  
        JButton creditsButton = new JButton("Credits");
        JButton backButtonCF = new JButton("Back");
        JButton backButtonHS = new JButton("Back");
        JButton skipButton = new JButton("Skip");
        JButton endButton = new JButton("End");
        JButton letterA = new JButton("A");
        JButton letterB = new JButton("B");
        JButton letterC = new JButton("C");
        JButton letterD = new JButton("D");
        JButton letterE = new JButton("E");
        JButton letterF = new JButton("F");
        JButton letterG = new JButton("G");
        JButton letterH = new JButton("H");
        JButton letterI = new JButton("I");
        JButton letterJ = new JButton("J");
        JButton letterK = new JButton("K");
        JButton letterL = new JButton("L");
        JButton letterM = new JButton("M");
        JButton letterN = new JButton("N");
        JButton letterO = new JButton("O");
        JButton letterP = new JButton("P");
        JButton letterQ = new JButton("Q");
        JButton letterR = new JButton("R");
        JButton letterS = new JButton("S");
        JButton letterT = new JButton("T");
        JButton letterU = new JButton("U");
        JButton letterV = new JButton("V");
        JButton letterW = new JButton("W");
        JButton letterX = new JButton("X");
        JButton letterY = new JButton("Y");
        JButton letterZ = new JButton("Z");
        

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
        skipButton.setBounds(400,100,100,30);
        scoreTitle.setBounds(200, -10, 500, 100);
        scoreText.setBounds(250, 100, 500, 100);
        endButton.setBounds(400,285,150,30);
	answerText.setBounds(150,175,300,100);
        letterA.setBounds(40,275,30,30);
        letterB.setBounds(80,275,30,30);
        letterC.setBounds(120,275,30,30);
        letterD.setBounds(160,275,30,30);
        letterE.setBounds(200,275,30,30);
        letterF.setBounds(240,275,30,30);
        letterG.setBounds(280,275,30,30);
        letterH.setBounds(320,275,30,30);
        letterI.setBounds(360,275,30,30);
        letterJ.setBounds(400,275,30,30);
        letterK.setBounds(440,275,30,30);
        letterL.setBounds(480,275,30,30);
        letterM.setBounds(520,275,30,30);
        letterN.setBounds(40,310,30,30);
        letterO.setBounds(80,310,30,30);
        letterP.setBounds(120,310,30,30);
        letterQ.setBounds(160,310,30,30);
        letterR.setBounds(200,310,30,30);
        letterS.setBounds(240,310,30,30);
        letterT.setBounds(280,310,30,30);
        letterU.setBounds(320,310,30,30);
        letterV.setBounds(360,310,30,30);
        letterW.setBounds(400,310,30,30);
        letterX.setBounds(440,310,30,30);
        letterY.setBounds(480,310,30,30);
        letterZ.setBounds(520,310,30,30);
        
        //setting margins
        letterA.setMargin(new Insets(0,0,0,0));
        letterB.setMargin(new Insets(0,0,0,0));
        letterC.setMargin(new Insets(0,0,0,0));
        letterD.setMargin(new Insets(0,0,0,0));
        letterE.setMargin(new Insets(0,0,0,0));
        letterF.setMargin(new Insets(0,0,0,0));
        letterG.setMargin(new Insets(0,0,0,0));
        letterH.setMargin(new Insets(0,0,0,0));
        letterI.setMargin(new Insets(0,0,0,0));
        letterJ.setMargin(new Insets(0,0,0,0));
        letterK.setMargin(new Insets(0,0,0,0));
        letterL.setMargin(new Insets(0,0,0,0));
        letterM.setMargin(new Insets(0,0,0,0));
        letterN.setMargin(new Insets(0,0,0,0));
        letterO.setMargin(new Insets(0,0,0,0));
        letterP.setMargin(new Insets(0,0,0,0));
        letterQ.setMargin(new Insets(0,0,0,0));
        letterR.setMargin(new Insets(0,0,0,0));
        letterS.setMargin(new Insets(0,0,0,0));
        letterT.setMargin(new Insets(0,0,0,0));
        letterU.setMargin(new Insets(0,0,0,0));
        letterV.setMargin(new Insets(0,0,0,0));
        letterW.setMargin(new Insets(0,0,0,0));
        letterX.setMargin(new Insets(0,0,0,0));
        letterY.setMargin(new Insets(0,0,0,0));
        letterZ.setMargin(new Insets(0,0,0,0));
        
        
        

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

        Painter p = new Painter();
	    
        //LETTERS
         letterA.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterA.setEnabled(false);
                if(answer.contains("a"))
                    rightAnswer('a');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 100, 500, 200, 200);
                }
            }  
        }); 
        
        letterB.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
                letterB.setEnabled(false);
                if(answer.contains("b"))
                    rightAnswer('b');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        
        letterC.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterC.setEnabled(false);
                if(answer.contains("c"))
                    rightAnswer('c');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        
        letterD.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterD.setEnabled(false);
                if(answer.contains("d"))
                    rightAnswer('d');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        
        letterE.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterE.setEnabled(false);
                if(answer.contains("e"))
                    rightAnswer('e');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        letterF.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterF.setEnabled(false);
                if(answer.contains("f"))
                    rightAnswer('f');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        letterG.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterG.setEnabled(false);
                if(answer.contains("g"))
                    rightAnswer('g');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        letterH.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterH.setEnabled(false);
                if(answer.contains("h"))
                    rightAnswer('h');
            }  
        }); 
        letterI.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterI.setEnabled(false);
                if(answer.contains("i"))
                    rightAnswer('i');
		     else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
                                                                        
        letterJ.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterJ.setEnabled(false);
                if(answer.contains("j"))
                    rightAnswer('j');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        }); 
        
        letterK.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterK.setEnabled(false);
                if(answer.contains("k"))
                    rightAnswer('k');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterL.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterL.setEnabled(false);
                if(answer.contains("l"))
                    rightAnswer('l');
		     else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterM.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterM.setEnabled(false);
                if(answer.contains("m"))
                    rightAnswer('m');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterN.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterN.setEnabled(false);
                if(answer.contains("n"))
                    rightAnswer('n');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterO.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterO.setEnabled(false);
                if(answer.contains("o"))
                    rightAnswer('o');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterP.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterP.setEnabled(false);
                if(answer.contains("p"))
                    rightAnswer('p');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterQ.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterQ.setEnabled(false);
                if(answer.contains("q"))
                    rightAnswer('q');
		     else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterR.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterR.setEnabled(false);
                if(answer.contains("r"))
                    rightAnswer('r');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterS.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterS.setEnabled(false);
                if(answer.contains("s"))
                    rightAnswer('s');
		     else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterT.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterT.setEnabled(false);
                if(answer.contains("t"))
                    rightAnswer('t');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterU.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterU.setEnabled(false);
                if(answer.contains("u"))
                    rightAnswer('u');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterV.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterV.setEnabled(false);
                if(answer.contains("v"))
                    rightAnswer('v');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterW.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterW.setEnabled(false);
                if(answer.contains("w"))
                    rightAnswer('w');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterX.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterX.setEnabled(false);
                if(answer.contains("x"))
                    rightAnswer('x');
		    else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterY.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterY.setEnabled(false);
                if(answer.contains("y"))
                    rightAnswer('y');
		     else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 79, 201, 247, 122);
                }
            }  
        });
        
        letterZ.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                letterZ.setEnabled(false);
                if(answer.contains("z")) {
                    rightAnswer('z');
                }
                else {
                    //p.checker = true;
		    currentScore -= 10;
                    p.repaint(0, 100, 500, 200, 200);
                }
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
        playGame.add(answerText);
        playGame.add(letterA);
        playGame.add(letterB);
        playGame.add(letterC);
        playGame.add(letterD);
        playGame.add(letterE);
        playGame.add(letterF);
        playGame.add(letterG);
        playGame.add(letterH);
        playGame.add(letterI);
        playGame.add(letterJ);
        playGame.add(letterK);
        playGame.add(letterL);
        playGame.add(letterM);
        playGame.add(letterN);
        playGame.add(letterO);
        playGame.add(letterP);
        playGame.add(letterQ);
        playGame.add(letterR);
        playGame.add(letterS);
        playGame.add(letterT);
        playGame.add(letterU);
        playGame.add(letterV);
        playGame.add(letterW);
        playGame.add(letterX);
        playGame.add(letterY);
        playGame.add(letterZ);
        //Painter p = new Painter();
        p.setVisible(true);
        playGame.add(p);


        //Score Frame
        scoreFrame.setSize(600,400);
        scoreFrame.add(scoreTitle);
        scoreFrame.add(scoreText);
        scoreFrame.add(endButton);
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
        //Method for right answer
    public static void rightAnswer(char guess){
        rightAnswer(guess,answer,displayedAnswer);
    }
    
    public static void rightAnswer(char guess, String answer, String displayedAns){
        char[] ch=displayedAns.toCharArray();
        int ansIndex = 0;
        for(int i=0;i<answer.length();i++){
            if (answer.charAt(i) == guess)
                ch[ansIndex] = guess;
           ansIndex +=2;      
        }
        displayedAnswer = String.valueOf(ch);
    }
        
    //Method for wrong answer
    
    
}
//
