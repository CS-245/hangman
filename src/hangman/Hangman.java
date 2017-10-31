/** *************************************************************
 * file: Hangman.java
 * authors: Lenny Yang, Rachel Frodsham, Jenna Barrett
 * class: CS245 – Graphic User Interface (GUI)
 *
 * assignment: Point and Click Game – v.1.2
 * date last modified: 10/30/2017
 *
 * purpose: This program creates the hangman game with Java code
 *
 *************************************************************** */
package hangman;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.BorderFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Hangman {

    public static int currentScore = 100;
    static int bubbleRound = 0;
    static int colorValue = 0;
    static int[] index = {0,1,2,3,4};
    static int[] xPosArray = {50,450,290,235,120};
    static int[] yPosArray = {230,190,100,250,90};
    static String answer;
    static String displayedAnswer;
    static String displayHighScores;
    static String color;
    static String color2;
    static Color purple = new Color(198, 24, 186);
    static int[][] coordinates = new int[5][10];
    static int[][] sudokuGrid = new int[9][9];

    JFrame mainFr = new JFrame("Hangman");
    //a CardLayout is like a stack of cards, where only the top card is visible at a time.
    CardLayout cl = new CardLayout();
    JPanel pages = new JPanel(cl); //will hold pages

    //panels for each page
    JPanel titlePg = new JPanel();
    JPanel menuPg = new JPanel();
    JPanel creditsPg = new JPanel();
    JPanel highScorePg = new JPanel(new BorderLayout());
    JPanel gamePg = new JPanel();
    JPanel scorePg = new JPanel();
    JPanel bubblePg = new JPanel();
    JPanel sudokuPg = new JPanel();
    
    PaintPanel pp = new PaintPanel();
    
    //Labels
    final JLabel titleText = new JLabel("CS245 Quarter Project");
    final JLabel teamText = new JLabel("PastaParty");
    final JLabel titleCredit = new JLabel("Credits");
    final JLabel jennaBarrett = new JLabel("Jenna Barret, 010805821");
    final JLabel lennyYang = new JLabel("Lenny Yang, 010265034");
    final JLabel rachelFrodsham = new JLabel("Rachel Frodsham, 009922783");
    final JLabel highScTitle = new JLabel("High Scores");
    final JLabel yourScTitle = new JLabel("Your Score");
    JLabel scoreText = new JLabel(Integer.toString(currentScore));
    static JLabel answerText = new JLabel(displayedAnswer);
    JLabel highScores = new JLabel(displayHighScores);
    JLabel bubbleText = new JLabel(color);
    final JLabel hangmanTitle = new JLabel("Hangman");
    final JLabel bubbleGameTitle = new JLabel("Bubble Game");
    final JLabel sudokuTitle = new JLabel("Sudoku");
    

    // constuctor
    // purpose: create windows that make the Hangman game
    Hangman() {
                
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
        for (int i = 0; i < answer.length(); i++) {
            displayedAnswer = displayedAnswer + "_ ";
        }

        //bubble game
        String[] colors = new String[5];
        colors[0] = "Red";
        colors[1] = "Yellow";
        colors[2] = "Green";
        colors[3] = "Blue";
        colors[4] = "Purple";
        
        Random randColor = new Random();
        colorValue = randColor.nextInt(5);
        color = colors[colorValue];
        colorValue = randColor.nextInt(5);
        color2 = colors[colorValue];
        
        
        //color button positions
        
        coordinates[0][0] = xPosArray[0];
        coordinates[0][1] = yPosArray[0];
        coordinates[0][2] = xPosArray[1];
        coordinates[0][3] = yPosArray[1];
        coordinates[0][4] = xPosArray[2];
        coordinates[0][5] = yPosArray[2];
        coordinates[0][6] = xPosArray[3];
        coordinates[0][7] = yPosArray[3];
        coordinates[0][8] = xPosArray[4];
        coordinates[0][9] = yPosArray[4];
        coordinates[1][0] = xPosArray[1];
        coordinates[1][1] = yPosArray[1];
        coordinates[1][2] = xPosArray[2];
        coordinates[1][3] = yPosArray[2];
        coordinates[1][4] = xPosArray[3];
        coordinates[1][5] = yPosArray[3];
        coordinates[1][6] = xPosArray[4];
        coordinates[1][7] = yPosArray[4];
        coordinates[1][8] = xPosArray[0];
        coordinates[1][9] = yPosArray[0];
        coordinates[2][0] = xPosArray[2];
        coordinates[2][1] = yPosArray[2];
        coordinates[2][2] = xPosArray[3];
        coordinates[2][3] = yPosArray[3];
        coordinates[2][4] = xPosArray[4];
        coordinates[2][5] = yPosArray[4];
        coordinates[2][6] = xPosArray[0];
        coordinates[2][7] = yPosArray[0];
        coordinates[2][8] = xPosArray[1];
        coordinates[2][9] = yPosArray[1];
        coordinates[3][0] = xPosArray[3];
        coordinates[3][1] = yPosArray[3];
        coordinates[3][2] = xPosArray[4];
        coordinates[3][3] = yPosArray[4];
        coordinates[3][4] = xPosArray[0];
        coordinates[3][5] = yPosArray[0];
        coordinates[3][6] = xPosArray[1];
        coordinates[3][7] = yPosArray[1];
        coordinates[3][8] = xPosArray[2];
        coordinates[3][9] = yPosArray[2];
        coordinates[4][0] = xPosArray[4];
        coordinates[4][1] = yPosArray[4];
        coordinates[4][2] = xPosArray[0];
        coordinates[4][3] = yPosArray[0];
        coordinates[4][4] = xPosArray[1];
        coordinates[4][5] = yPosArray[1];
        coordinates[4][6] = xPosArray[2];
        coordinates[4][7] = yPosArray[2];
        coordinates[4][8] = xPosArray[3];
        coordinates[4][9] = yPosArray[3];

        titleText.setFont(new Font("Serif", Font.BOLD, 30));
        teamText.setFont(new Font("Curlz MT", Font.PLAIN, 30));
        titleCredit.setFont(new Font("Serif", Font.BOLD, 20));
        highScTitle.setFont(new Font("Serif", Font.BOLD, 20));
        yourScTitle.setFont(new Font("Serif", Font.BOLD, 35));
        scoreText.setFont(new Font("Serif", Font.PLAIN, 20));
        answerText.setFont(new Font("Serif", Font.BOLD, 35));
        highScores.setFont(new Font("Serif", Font.BOLD, 20));
        hangmanTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
        bubbleGameTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
        bubbleText.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
	sudokuTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));
        
        switch(color2){
            case "Red":{
                bubbleText.setForeground(Color.red);
                break;
            }
            case "Yellow":{
                bubbleText.setForeground(Color.yellow);
                break;
            }
            case "Blue":{
                bubbleText.setForeground(Color.blue);
                break;
            }
            case "Green":{
                bubbleText.setForeground(Color.green);
                break;
            }
            case "Purple":{
                bubbleText.setForeground(purple);
                break;
            }
        }
        
        //Text Field
        JTextField highScoreName = new JTextField();
        JTextField sudoku00=new JTextField();
        JTextField sudoku01=new JTextField();
        JTextField sudoku02=new JTextField();
        JTextField sudoku03=new JTextField();
        JTextField sudoku04=new JTextField();
        JTextField sudoku05=new JTextField();
        JTextField sudoku06=new JTextField();
        JTextField sudoku07=new JTextField();
        JTextField sudoku08=new JTextField();
        JTextField sudoku10=new JTextField();
        JTextField sudoku11=new JTextField();
        JTextField sudoku12=new JTextField();
        JTextField sudoku13=new JTextField();
        JTextField sudoku14=new JTextField();
        JTextField sudoku15=new JTextField();
        JTextField sudoku16=new JTextField();
        JTextField sudoku17=new JTextField();
        JTextField sudoku18=new JTextField();
        JTextField sudoku20=new JTextField();
        JTextField sudoku21=new JTextField();
        JTextField sudoku22=new JTextField();
        JTextField sudoku23=new JTextField();
        JTextField sudoku24=new JTextField();
        JTextField sudoku25=new JTextField();
        JTextField sudoku26=new JTextField();
        JTextField sudoku27=new JTextField();
        JTextField sudoku28=new JTextField();
        JTextField sudoku30=new JTextField();
        JTextField sudoku31=new JTextField();
        JTextField sudoku32=new JTextField();
        JTextField sudoku33=new JTextField();
        JTextField sudoku34=new JTextField();
        JTextField sudoku35=new JTextField();
        JTextField sudoku36=new JTextField();
        JTextField sudoku37=new JTextField();
        JTextField sudoku38=new JTextField();
        JTextField sudoku40=new JTextField();
        JTextField sudoku41=new JTextField();
        JTextField sudoku42=new JTextField();
        JTextField sudoku43=new JTextField();
        JTextField sudoku44=new JTextField();
        JTextField sudoku45=new JTextField();
        JTextField sudoku46=new JTextField();
        JTextField sudoku47=new JTextField();
        JTextField sudoku48=new JTextField();
        JTextField sudoku50=new JTextField();
        JTextField sudoku51=new JTextField();
        JTextField sudoku52=new JTextField();
        JTextField sudoku53=new JTextField();
        JTextField sudoku54=new JTextField();
        JTextField sudoku55=new JTextField();
        JTextField sudoku56=new JTextField();
        JTextField sudoku57=new JTextField();
        JTextField sudoku58=new JTextField();
        JTextField sudoku60=new JTextField();
        JTextField sudoku61=new JTextField();
        JTextField sudoku62=new JTextField();
        JTextField sudoku63=new JTextField();
        JTextField sudoku64=new JTextField();
        JTextField sudoku65=new JTextField();
        JTextField sudoku66=new JTextField();
        JTextField sudoku67=new JTextField();
        JTextField sudoku68=new JTextField();
        JTextField sudoku70=new JTextField();
        JTextField sudoku71=new JTextField();
        JTextField sudoku72=new JTextField();
        JTextField sudoku73=new JTextField();
        JTextField sudoku74=new JTextField();
        JTextField sudoku75=new JTextField();
        JTextField sudoku76=new JTextField();
        JTextField sudoku77=new JTextField();
        JTextField sudoku78=new JTextField();
        JTextField sudoku80=new JTextField();
        JTextField sudoku81=new JTextField();
        JTextField sudoku82=new JTextField();
        JTextField sudoku83=new JTextField();
        JTextField sudoku84=new JTextField();
        JTextField sudoku85=new JTextField();
        JTextField sudoku86=new JTextField();
        JTextField sudoku87=new JTextField();
        JTextField sudoku88=new JTextField();
        
        //Pasta image
        ImageIcon pastaIcon = new ImageIcon("Images/pasta.png");
        JLabel pastaImage = new JLabel(pastaIcon);

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
        
        RoundButton redButton = new RoundButton();
        RoundButton yellowButton = new RoundButton();
        RoundButton blueButton = new RoundButton();
        RoundButton greenButton = new RoundButton();
        RoundButton purpleButton = new RoundButton();        
        redButton.setBackground(Color.red);
        yellowButton.setBackground(Color.yellow);
        blueButton.setBackground(Color.blue);
        greenButton.setBackground(Color.green);
        purpleButton.setBackground(purple);
        
        JButton submit = new JButton("Submit");
	JButton quit = new JButton("Quit");
        
                
        //setting margins
        letterA.setMargin(new Insets(0, 0, 0, 0));
        letterB.setMargin(new Insets(0, 0, 0, 0));
        letterC.setMargin(new Insets(0, 0, 0, 0));
        letterD.setMargin(new Insets(0, 0, 0, 0));
        letterE.setMargin(new Insets(0, 0, 0, 0));
        letterF.setMargin(new Insets(0, 0, 0, 0));
        letterG.setMargin(new Insets(0, 0, 0, 0));
        letterH.setMargin(new Insets(0, 0, 0, 0));
        letterI.setMargin(new Insets(0, 0, 0, 0));
        letterJ.setMargin(new Insets(0, 0, 0, 0));
        letterK.setMargin(new Insets(0, 0, 0, 0));
        letterL.setMargin(new Insets(0, 0, 0, 0));
        letterM.setMargin(new Insets(0, 0, 0, 0));
        letterN.setMargin(new Insets(0, 0, 0, 0));
        letterO.setMargin(new Insets(0, 0, 0, 0));
        letterP.setMargin(new Insets(0, 0, 0, 0));
        letterQ.setMargin(new Insets(0, 0, 0, 0));
        letterR.setMargin(new Insets(0, 0, 0, 0));
        letterS.setMargin(new Insets(0, 0, 0, 0));
        letterT.setMargin(new Insets(0, 0, 0, 0));
        letterU.setMargin(new Insets(0, 0, 0, 0));
        letterV.setMargin(new Insets(0, 0, 0, 0));
        letterW.setMargin(new Insets(0, 0, 0, 0));
        letterX.setMargin(new Insets(0, 0, 0, 0));
        letterY.setMargin(new Insets(0, 0, 0, 0));
        letterZ.setMargin(new Insets(0, 0, 0, 0));
        
        //Positioning        
        
        bubbleText.setBounds(350,-10,500,100);
        bubbleGameTitle.setBounds(25,-10,500,100); 
        skipButton.setBounds(400,100,100,30);
        answerText.setBounds(150,175,300,100);
	sudokuTitle.setBounds(25,-10,300,100);
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
	    
        redButton.setBounds(50,230,100,100); //sizes here don't matter
        yellowButton.setBounds(450,190,100,100);
        blueButton.setBounds(290,100,100,100);
        greenButton.setBounds(235,250,100,100);
        purpleButton.setBounds(120,90,100,100);
        redButton.setDiameter(100); //this sets the button size
        yellowButton.setDiameter(100);
        blueButton.setDiameter(100);
        greenButton.setDiameter(100);
        purpleButton.setDiameter(100);
	    
	submit.setBounds(35,310,100,30);
	quit.setBounds(465,310,100,30);
        sudoku00.setBounds(155,65,30,30);
        sudoku01.setBounds(185,65,30,30);
        sudoku02.setBounds(215,65,30,30);
        sudoku03.setBounds(245,65,30,30);
        sudoku04.setBounds(275,65,30,30);
        sudoku05.setBounds(305,65,30,30);
        sudoku06.setBounds(335,65,30,30);
        sudoku07.setBounds(365,65,30,30);
        sudoku08.setBounds(395,65,30,30);
        sudoku10.setBounds(155,95,30,30);
        sudoku11.setBounds(185,95,30,30);
        sudoku12.setBounds(215,95,30,30);
        sudoku13.setBounds(245,95,30,30);
        sudoku14.setBounds(275,95,30,30);
        sudoku15.setBounds(305,95,30,30);
        sudoku16.setBounds(335,95,30,30);
        sudoku17.setBounds(365,95,30,30);
        sudoku18.setBounds(395,95,30,30);
        sudoku20.setBounds(155,125,30,30);
        sudoku21.setBounds(185,125,30,30);
        sudoku22.setBounds(215,125,30,30);
        sudoku23.setBounds(245,125,30,30);
        sudoku24.setBounds(275,125,30,30);
        sudoku25.setBounds(305,125,30,30);
        sudoku26.setBounds(335,125,30,30);
        sudoku27.setBounds(365,125,30,30);
        sudoku28.setBounds(395,125,30,30);
        sudoku30.setBounds(155,155,30,30);
        sudoku31.setBounds(185,155,30,30);
        sudoku32.setBounds(215,155,30,30);
        sudoku33.setBounds(245,155,30,30);
        sudoku34.setBounds(275,155,30,30);
        sudoku35.setBounds(305,155,30,30);
        sudoku36.setBounds(335,155,30,30);
        sudoku37.setBounds(365,155,30,30);
        sudoku38.setBounds(395,155,30,30);
        sudoku40.setBounds(155,185,30,30);
        sudoku41.setBounds(185,185,30,30);
        sudoku42.setBounds(215,185,30,30);
        sudoku43.setBounds(245,185,30,30);
        sudoku44.setBounds(275,185,30,30);
        sudoku45.setBounds(305,185,30,30);
        sudoku46.setBounds(335,185,30,30);
        sudoku47.setBounds(365,185,30,30);
        sudoku48.setBounds(395,185,30,30);
        sudoku50.setBounds(155,215,30,30);
        sudoku51.setBounds(185,215,30,30);
        sudoku52.setBounds(215,215,30,30);
        sudoku53.setBounds(245,215,30,30);
        sudoku54.setBounds(275,215,30,30);
        sudoku55.setBounds(305,215,30,30);
        sudoku56.setBounds(335,215,30,30);
        sudoku57.setBounds(365,215,30,30);
        sudoku58.setBounds(395,215,30,30);
        sudoku60.setBounds(155,245,30,30);
        sudoku61.setBounds(185,245,30,30);
        sudoku62.setBounds(215,245,30,30);
        sudoku63.setBounds(245,245,30,30);
        sudoku64.setBounds(275,245,30,30);
        sudoku65.setBounds(305,245,30,30);
        sudoku66.setBounds(335,245,30,30);
        sudoku67.setBounds(365,245,30,30);
        sudoku68.setBounds(395,245,30,30);
        sudoku70.setBounds(155,275,30,30);
        sudoku71.setBounds(185,275,30,30);
        sudoku72.setBounds(215,275,30,30);
        sudoku73.setBounds(245,275,30,30);
        sudoku74.setBounds(275,275,30,30);
        sudoku75.setBounds(305,275,30,30);
        sudoku76.setBounds(335,275,30,30);
        sudoku77.setBounds(365,275,30,30);
        sudoku78.setBounds(395,275,30,30);
        sudoku80.setBounds(155,305,30,30);
        sudoku81.setBounds(185,305,30,30);
        sudoku82.setBounds(215,305,30,30);
        sudoku83.setBounds(245,305,30,30);
        sudoku84.setBounds(275,305,30,30);
        sudoku85.setBounds(305,305,30,30);
        sudoku86.setBounds(335,305,30,30);
        sudoku87.setBounds(365,305,30,30);
        sudoku88.setBounds(395,305,30,30);
         
        
        
        //Title Page uses BoxLayout
        titlePg.setBackground(new Color(255,255,200)); //rgb
        titlePg.setLayout(new BoxLayout(titlePg, BoxLayout.Y_AXIS));
        titleText.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePg.add(Box.createRigidArea(new Dimension(0,25)));
        titlePg.add(titleText);
        titlePg.add(Box.createVerticalGlue()); //sticks elements at bottom
        teamText.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); //to add padding, U L D R
        teamText.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePg.add(teamText);
        
        
        //Menu Page uses BorderLayout 
        //with internal panels for additional formatting
        menuPg.setBackground(new Color(255,200,175)); //rgb
        menuPg.setLayout(new BorderLayout());
        menuPg.add(pastaImage, BorderLayout.CENTER);
        
        JPanel menuButtons = new JPanel();
        menuButtons.setBackground(new Color(255,200,175)); //rgb
        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.Y_AXIS));
        menuButtons.add(Box.createVerticalGlue()); //sticks elements at bottom
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButtons.add(playButton);
        menuButtons.add(Box.createRigidArea(new Dimension(250,10))); //creates padding
        menuButtons.add(highScoreButton);
        menuButtons.add(Box.createRigidArea(new Dimension(25,10))); //creates padding
        menuButtons.add(creditsButton);
        menuButtons.add(Box.createRigidArea(new Dimension(25,100))); //creates padding
        menuPg.add(menuButtons, BorderLayout.EAST);
        
        //Credits Page uses boxlayout
        creditsPg.setLayout(new BoxLayout(creditsPg, BoxLayout.Y_AXIS));
        titleCredit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jennaBarrett.setAlignmentX(Component.CENTER_ALIGNMENT);
        lennyYang.setAlignmentX(Component.CENTER_ALIGNMENT);
        rachelFrodsham.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButtonCF.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsPg.add(Box.createRigidArea(new Dimension(0,25)));
        creditsPg.add(titleCredit);
        creditsPg.add(Box.createRigidArea(new Dimension(0,50)));
        creditsPg.add(jennaBarrett);
        creditsPg.add(lennyYang);
        creditsPg.add(rachelFrodsham);
        creditsPg.add(Box.createRigidArea(new Dimension(0,150)));
        creditsPg.add(backButtonCF);
        
        //High Score Page uses boxlayout
        highScorePg.setLayout(new BorderLayout());
        highScTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
//      highScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScTitle.setBorder(BorderFactory.createEmptyBorder(5, 250, 0, 0));
        highScores.setBorder(BorderFactory.createEmptyBorder(0, 260, 0, 0));
        backButtonHS.setAlignmentX(Component.CENTER_ALIGNMENT);
//      highScorePg.add(Box.createRigidArea(new Dimension(0,25)));
        highScorePg.add(highScTitle, BorderLayout.NORTH);
        highScorePg.add(highScores, BorderLayout.CENTER);
        highScorePg.add(backButtonHS, BorderLayout.SOUTH);
        
        //Game Page uses borderlayout with flowlayout for top
        gamePg.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        time.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 10)); //to add padding, U L D R
        top.add(hangmanTitle);
        top.add(time);
        gamePg.add(skipButton);
        gamePg.add(top, BorderLayout.NORTH);
        gamePg.add(answerText);
        gamePg.add(letterA);
        gamePg.add(letterB);
        gamePg.add(letterC);
        gamePg.add(letterD);
        gamePg.add(letterE);
        gamePg.add(letterF);
        gamePg.add(letterG);
        gamePg.add(letterH);
        gamePg.add(letterI);
        gamePg.add(letterJ);
        gamePg.add(letterK);
        gamePg.add(letterL);
        gamePg.add(letterM);
        gamePg.add(letterN);
        gamePg.add(letterO);
        gamePg.add(letterP);
        gamePg.add(letterQ);
        gamePg.add(letterR);
        gamePg.add(letterS);
        gamePg.add(letterT);
        gamePg.add(letterU);
        gamePg.add(letterV);
        gamePg.add(letterW);
        gamePg.add(letterX);
        gamePg.add(letterY);
        gamePg.add(letterZ);
        gamePg.add(pp);

	//Bubble Game page
        bubblePg.setLayout(null);
        bubblePg.add(bubbleGameTitle);
        bubblePg.add(bubbleText);
        bubblePg.add(redButton);
        bubblePg.add(yellowButton);
        bubblePg.add(blueButton);
        bubblePg.add(greenButton);
        bubblePg.add(purpleButton);
        //bubblePg.add(currentScore);
	    
	//Sudoku page
        sudokuPg.setLayout(null);
	sudokuPg.add(sudokuTitle);
	sudokuPg.add(submit);
	sudokuPg.add(quit);
        sudokuPg.add(sudoku00);
        sudokuPg.add(sudoku01);
        sudokuPg.add(sudoku02);
        sudokuPg.add(sudoku03);
        sudokuPg.add(sudoku04);
        sudokuPg.add(sudoku05);
        sudokuPg.add(sudoku06);
        sudokuPg.add(sudoku07);
        sudokuPg.add(sudoku08);
        sudokuPg.add(sudoku10);
        sudokuPg.add(sudoku11);
        sudokuPg.add(sudoku12);
        sudokuPg.add(sudoku13);
        sudokuPg.add(sudoku14);
        sudokuPg.add(sudoku15);
        sudokuPg.add(sudoku16);
        sudokuPg.add(sudoku17);
        sudokuPg.add(sudoku18);
        sudokuPg.add(sudoku20);
        sudokuPg.add(sudoku21);
        sudokuPg.add(sudoku22);
        sudokuPg.add(sudoku23);
        sudokuPg.add(sudoku24);
        sudokuPg.add(sudoku25);
        sudokuPg.add(sudoku26);
        sudokuPg.add(sudoku27);
        sudokuPg.add(sudoku28);
        sudokuPg.add(sudoku30);
        sudokuPg.add(sudoku31);
        sudokuPg.add(sudoku32);
        sudokuPg.add(sudoku33);
        sudokuPg.add(sudoku34);
        sudokuPg.add(sudoku35);
        sudokuPg.add(sudoku36);
        sudokuPg.add(sudoku37);
        sudokuPg.add(sudoku38);
        sudokuPg.add(sudoku40);
        sudokuPg.add(sudoku41);
        sudokuPg.add(sudoku42);
        sudokuPg.add(sudoku43);
        sudokuPg.add(sudoku44);
        sudokuPg.add(sudoku45);
        sudokuPg.add(sudoku46);
        sudokuPg.add(sudoku47);
        sudokuPg.add(sudoku48);
        sudokuPg.add(sudoku50);
        sudokuPg.add(sudoku51);
        sudokuPg.add(sudoku52);
        sudokuPg.add(sudoku53);
        sudokuPg.add(sudoku54);
        sudokuPg.add(sudoku55);
        sudokuPg.add(sudoku56);
        sudokuPg.add(sudoku57);
        sudokuPg.add(sudoku58);
        sudokuPg.add(sudoku60);
        sudokuPg.add(sudoku61);
        sudokuPg.add(sudoku62);
        sudokuPg.add(sudoku63);
        sudokuPg.add(sudoku64);
        sudokuPg.add(sudoku65);
        sudokuPg.add(sudoku66);
        sudokuPg.add(sudoku67);
        sudokuPg.add(sudoku68);
        sudokuPg.add(sudoku70);
        sudokuPg.add(sudoku71);
        sudokuPg.add(sudoku72);
        sudokuPg.add(sudoku73);
        sudokuPg.add(sudoku74);
        sudokuPg.add(sudoku75);
        sudokuPg.add(sudoku76);
        sudokuPg.add(sudoku77);
        sudokuPg.add(sudoku78);
        sudokuPg.add(sudoku80);
        sudokuPg.add(sudoku81);
        sudokuPg.add(sudoku82);
        sudokuPg.add(sudoku83);
        sudokuPg.add(sudoku84);
        sudokuPg.add(sudoku85);
        sudokuPg.add(sudoku86);
        sudokuPg.add(sudoku87);
        sudokuPg.add(sudoku88);
        
        //Score Page uses BoxLayout
        scorePg.setLayout(new BoxLayout(scorePg, BoxLayout.Y_AXIS));
        yourScTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreName.setAlignmentX(Component.CENTER_ALIGNMENT);
        endButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorePg.add(yourScTitle);
        scorePg.add(Box.createRigidArea(new Dimension(0,100))); //creates padding
        scorePg.add(highScoreName);
        scorePg.add(scoreText);
        scorePg.add(Box.createRigidArea(new Dimension(0,125))); //creates padding
        scorePg.add(endButton);
        
        
        //Pages and Frame Set Up
        pages.add(titlePg, "titlePg");           //the string is the label of the page, can be anything
        pages.add(menuPg, "menuPg");             //but was set to the variable name to stay simple
        pages.add(creditsPg, "creditsPg");
        pages.add(highScorePg, "highScorePg");
        pages.add(gamePg, "gamePg");
        pages.add(scorePg, "scorePg");
        pages.add(bubblePg, "bubblePg");
	pages.add(sudokuPg, "sudokuPg");
        cl.show(pages, "titlePg"); //first page shown is title page
        
        mainFr.add(pages);
        mainFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFr.setSize(600, 400);
        mainFr.setLocationRelativeTo(null);
        mainFr.setVisible(true);
        

        //Listeners
        new java.util.Timer().schedule(
            new java.util.TimerTask() {
            @Override
                public void run() {
                    cl.show(pages, "menuPg"); //switches to menu
                }
            },
                4500
        );

        highScoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "highScorePg");
            }
        });

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "gamePg");
            }
        });

        creditsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "creditsPg");
            }
        });

        backButtonCF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "menuPg");
            }
        });

        backButtonHS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "menuPg");
            }
        });

        skipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentScore = 0;
                cl.show(pages, "scorePg");
                
                Random rand = new Random();
                int value = rand.nextInt(5);

                //choosing a word
                answer = wordBank[value];

                displayedAnswer = "";
                for (int i = 0; i < answer.length(); i++) {
                    displayedAnswer = displayedAnswer + "_ ";
                }
                letterA.setEnabled(true);
                letterB.setEnabled(true);
                letterC.setEnabled(true);
                letterD.setEnabled(true);
                letterE.setEnabled(true);
                letterF.setEnabled(true);
                letterG.setEnabled(true);
                letterH.setEnabled(true);
                letterI.setEnabled(true);
                letterJ.setEnabled(true);
                letterK.setEnabled(true);
                letterL.setEnabled(true);
                letterM.setEnabled(true);
                letterN.setEnabled(true);
                letterO.setEnabled(true);
                letterP.setEnabled(true);
                letterQ.setEnabled(true);
                letterR.setEnabled(true);
                letterS.setEnabled(true);
                letterT.setEnabled(true);
                letterU.setEnabled(true);
                letterV.setEnabled(true);
                letterW.setEnabled(true);
                letterX.setEnabled(true);
                letterY.setEnabled(true);
                letterZ.setEnabled(true);

            }
        });

        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cl.show(pages, "menuPg");
                if (currentScore != 0){
                    String hSN = highScoreName.getText(); 
                    String combinedScore = hSN + " " + currentScore;
                    try {
                        writeHighScore("highscores.txt", combinedScore);
                    } catch (IOException ex) {
                        Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                currentScore = 100;
            }
        });
	    quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "scorePg");
            }
        });


        //LETTERS
        letterA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterA.setEnabled(false);
                if (answer.contains("a")) {
                    rightAnswer('a');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterB.setEnabled(false);
                if (answer.contains("b")) {
                    rightAnswer('b');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterC.setEnabled(false);
                if (answer.contains("c")) {
                    rightAnswer('c');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterD.setEnabled(false);
                if (answer.contains("d")) {
                    rightAnswer('d');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterE.setEnabled(false);
                if (answer.contains("e")) {
                    rightAnswer('e');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });
        letterF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterF.setEnabled(false);
                if (answer.contains("f")) {
                    rightAnswer('f');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });
        letterG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterG.setEnabled(false);
                if (answer.contains("g")) {
                    rightAnswer('g');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });
        letterH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterH.setEnabled(false);
                if (answer.contains("h")) {
                    rightAnswer('h');
                }          
                else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });
        letterI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterI.setEnabled(false);
                if (answer.contains("i")) {
                    rightAnswer('i');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterJ.setEnabled(false);
                if (answer.contains("j")) {
                    rightAnswer('j');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                    
                }
            }
        });

        letterK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterK.setEnabled(false);
                if (answer.contains("k")) {
                    rightAnswer('k');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterL.setEnabled(false);
                if (answer.contains("l")) {
                    rightAnswer('l');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterM.setEnabled(false);
                if (answer.contains("m")) {
                    rightAnswer('m');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterN.setEnabled(false);
                if (answer.contains("n")) {
                    rightAnswer('n');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterO.setEnabled(false);
                if (answer.contains("o")) {
                    rightAnswer('o');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterP.setEnabled(false);
                if (answer.contains("p")) {
                    rightAnswer('p');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterQ.setEnabled(false);
                if (answer.contains("q")) {
                    rightAnswer('q');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterR.setEnabled(false);
                if (answer.contains("r")) {
                    rightAnswer('r');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterS.setEnabled(false);
                if (answer.contains("s")) {
                    rightAnswer('s');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterT.setEnabled(false);
                if (answer.contains("t")) {
                    rightAnswer('t');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterU.setEnabled(false);
                if (answer.contains("u")) {
                    rightAnswer('u');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterV.setEnabled(false);
                if (answer.contains("v")) {
                    rightAnswer('v');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterW.setEnabled(false);
                if (answer.contains("w")) {
                    rightAnswer('w');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterX.setEnabled(false);
                if (answer.contains("x")) {
                    rightAnswer('x');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterY.setEnabled(false);
                if (answer.contains("y")) {
                    rightAnswer('y');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });

        letterZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterZ.setEnabled(false);
                if (answer.contains("z")) {
                    rightAnswer('z');
                } else {
                    currentScore -= 10;
                    pp.repaint(0, 100, 25, 260, 135);
                }
            }
        });
        
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubbleRound++;
                if (color2.equals("Red")){
                    currentScore +=100;
                }
                colorValue = randColor.nextInt(5);
                color = colors[colorValue];
                colorValue = randColor.nextInt(5);
                color2 = colors[colorValue];
                if(color.equals(color2)){
                    colorValue = randColor.nextInt(5);
                    color2 = colors[colorValue];
                }
                bubbleText.setText(color);
                switch(color2){
                    case "Red":{
                        bubbleText.setForeground(Color.red);
                        break;
                    }
                    case "Yellow":{
                     bubbleText.setForeground(Color.yellow);
                        break;
                    }
                    case "Blue":{
                        bubbleText.setForeground(Color.blue);
                        break;
                    }
                    case "Green":{
                        bubbleText.setForeground(Color.green);
                        break;
                    }
                    case "Purple":{
                        bubbleText.setForeground(purple);
                        break;
                    }
                }
                Random rand = new Random();
                int value = rand.nextInt(5);
                 
                redButton.setBounds(coordinates[value][0],coordinates[value][1],100,100);
                yellowButton.setBounds(coordinates[value][2],coordinates[value][3],100,100);
                blueButton.setBounds(coordinates[value][4],coordinates[value][5],100,100);
                greenButton.setBounds(coordinates[value][6],coordinates[value][7],100,100);
                purpleButton.setBounds(coordinates[value][8],coordinates[value][9],100,100);
                
                if (bubbleRound == 5){
                   cl.show(pages, "sudokuPg");
                }
            }
        });
        
        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubbleRound++;
                if (color2.equals("Yellow")){
                    currentScore +=100;
                }
                colorValue = randColor.nextInt(5);
                color = colors[colorValue];
                colorValue = randColor.nextInt(5);
                color2 = colors[colorValue];
                if(color.equals(color2)){
                    colorValue = randColor.nextInt(5);
                    color2 = colors[colorValue];
                }
                bubbleText.setText(color);
                switch(color2){
                    case "Red":{
                        bubbleText.setForeground(Color.red);
                        break;
                    }
                    case "Yellow":{
                     bubbleText.setForeground(Color.yellow);
                        break;
                    }
                    case "Blue":{
                        bubbleText.setForeground(Color.blue);
                        break;
                    }
                    case "Green":{
                        bubbleText.setForeground(Color.green);
                        break;
                    }
                    case "Purple":{
                        bubbleText.setForeground(purple);
                        break;
                    }
                }
                Random rand = new Random();
                int value = rand.nextInt(5);
                 
                redButton.setBounds(coordinates[value][0],coordinates[value][1],100,100);
                yellowButton.setBounds(coordinates[value][2],coordinates[value][3],100,100);
                blueButton.setBounds(coordinates[value][4],coordinates[value][5],100,100);
                greenButton.setBounds(coordinates[value][6],coordinates[value][7],100,100);
                purpleButton.setBounds(coordinates[value][8],coordinates[value][9],100,100);
                
                if (bubbleRound == 5){
                   cl.show(pages, "sudokuPg");
                }
            }
        });
        
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubbleRound++;
                if (color2.equals("Blue")){
                    currentScore +=100;
                }
                colorValue = randColor.nextInt(5);
                color = colors[colorValue];
                colorValue = randColor.nextInt(5);
                color2 = colors[colorValue];
                if(color.equals(color2)){
                    colorValue = randColor.nextInt(5);
                    color2 = colors[colorValue];
                }
                bubbleText.setText(color);
                switch(color2){
                    case "Red":{
                        bubbleText.setForeground(Color.red);
                        break;
                    }
                    case "Yellow":{
                     bubbleText.setForeground(Color.yellow);
                        break;
                    }
                    case "Blue":{
                        bubbleText.setForeground(Color.blue);
                        break;
                    }
                    case "Green":{
                        bubbleText.setForeground(Color.green);
                        break;
                    }
                    case "Purple":{
                        bubbleText.setForeground(purple);
                        break;
                    }
                }
                Random rand = new Random();
                int value = rand.nextInt(5);
                 
                redButton.setBounds(coordinates[value][0],coordinates[value][1],100,100);
                yellowButton.setBounds(coordinates[value][2],coordinates[value][3],100,100);
                blueButton.setBounds(coordinates[value][4],coordinates[value][5],100,100);
                greenButton.setBounds(coordinates[value][6],coordinates[value][7],100,100);
                purpleButton.setBounds(coordinates[value][8],coordinates[value][9],100,100);
                
                if (bubbleRound == 5){
                   cl.show(pages, "sudokuPg");
                }
            }
        });
        
        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubbleRound++;
                if (color2.equals("Green")){
                        currentScore +=100;
                }
                colorValue = randColor.nextInt(5);
                color = colors[colorValue];
                colorValue = randColor.nextInt(5);
                color2 = colors[colorValue];
                if(color.equals(color2)){
                    colorValue = randColor.nextInt(5);
                    color2 = colors[colorValue];
                }
                bubbleText.setText(color);
                switch(color2){
                    case "Red":{
                        bubbleText.setForeground(Color.red);
                        break;
                    }
                    case "Yellow":{
                     bubbleText.setForeground(Color.yellow);
                        break;
                    }
                    case "Blue":{
                        bubbleText.setForeground(Color.blue);
                        break;
                    }
                    case "Green":{
                        bubbleText.setForeground(Color.green);
                        break;
                    }
                    case "Purple":{
                        bubbleText.setForeground(purple);
                        break;
                    }
                }
                Random rand = new Random();
                int value = rand.nextInt(5);
                 
                redButton.setBounds(coordinates[value][0],coordinates[value][1],100,100);
                yellowButton.setBounds(coordinates[value][2],coordinates[value][3],100,100);
                blueButton.setBounds(coordinates[value][4],coordinates[value][5],100,100);
                greenButton.setBounds(coordinates[value][6],coordinates[value][7],100,100);
                purpleButton.setBounds(coordinates[value][8],coordinates[value][9],100,100);
                
                if (bubbleRound == 5){
                   cl.show(pages, "sudokuPg");
                }
            }
        });
        
        purpleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bubbleRound++;
                if (color2.equals("Purple")){
                    currentScore +=100;
                }
                colorValue = randColor.nextInt(5);
                color = colors[colorValue];
                colorValue = randColor.nextInt(5);
                color2 = colors[colorValue];
                if(color.equals(color2)){
                    colorValue = randColor.nextInt(5);
                    color2 = colors[colorValue];
                }
                bubbleText.setText(color);
                switch(color2){
                    case "Red":{
                        bubbleText.setForeground(Color.red);
                        break;
                    }
                    case "Yellow":{
                     bubbleText.setForeground(Color.yellow);
                        break;
                    }
                    case "Blue":{
                        bubbleText.setForeground(Color.blue);
                        break;
                    }
                    case "Green":{
                        bubbleText.setForeground(Color.green);
                        break;
                    }
                    case "Purple":{
                        bubbleText.setForeground(purple);
                        break;
                    }
                }
                Random rand = new Random();
                int value = rand.nextInt(5);
                 
                redButton.setBounds(coordinates[value][0],coordinates[value][1],100,100);
                yellowButton.setBounds(coordinates[value][2],coordinates[value][3],100,100);
                blueButton.setBounds(coordinates[value][4],coordinates[value][5],100,100);
                greenButton.setBounds(coordinates[value][6],coordinates[value][7],100,100);
                purpleButton.setBounds(coordinates[value][8],coordinates[value][9],100,100);
                
                if (bubbleRound == 5){
                   cl.show(pages, "sudokuPg");
                }
            }
        });
      

        //Hangman Set Up
        Timer updateFrames = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerText.setText(displayedAnswer);
                String numberAsString = Integer.toString(currentScore);
                scoreText.setText(numberAsString);
                String withoutSpaces = displayedAnswer.replace(" ", "");
                
                
                try {
                    printHighScores();
                } catch (IOException ex) {
                    Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
                }
                highScores.setText(displayHighScores);
                
                if (withoutSpaces.equals(answer)) {
                    cl.show(pages, "bubblePg");
                    Random rand = new Random();
                    int value = rand.nextInt(5);
                    answer = wordBank[value]; //chooses a word

                    displayedAnswer = "";
                    for (int i = 0; i < answer.length(); i++) {
                        displayedAnswer = displayedAnswer + "_ ";
                    }

                    letterA.setEnabled(true);
                    letterB.setEnabled(true);
                    letterC.setEnabled(true);
                    letterD.setEnabled(true);
                    letterE.setEnabled(true);
                    letterF.setEnabled(true);
                    letterG.setEnabled(true);
                    letterH.setEnabled(true);
                    letterI.setEnabled(true);
                    letterJ.setEnabled(true);
                    letterK.setEnabled(true);
                    letterL.setEnabled(true);
                    letterM.setEnabled(true);
                    letterN.setEnabled(true);
                    letterO.setEnabled(true);
                    letterP.setEnabled(true);
                    letterQ.setEnabled(true);
                    letterR.setEnabled(true);
                    letterS.setEnabled(true);
                    letterT.setEnabled(true);
                    letterU.setEnabled(true);
                    letterV.setEnabled(true);
                    letterW.setEnabled(true);
                    letterX.setEnabled(true);
                    letterY.setEnabled(true);
                    letterZ.setEnabled(true);
                }

                if (Hangman.currentScore == 40) {
                    cl.show(pages, "bubblePg");
                    Random rand = new Random();
                    int value = rand.nextInt(5);
                    //choosing a word
                    answer = wordBank[value];

                    displayedAnswer = "";
                    for (int i = 0; i < answer.length(); i++) {
                        displayedAnswer = displayedAnswer + "_ ";
                    }

                    letterA.setEnabled(true);
                    letterB.setEnabled(true);
                    letterC.setEnabled(true);
                    letterD.setEnabled(true);
                    letterE.setEnabled(true);
                    letterF.setEnabled(true);
                    letterG.setEnabled(true);
                    letterH.setEnabled(true);
                    letterI.setEnabled(true);
                    letterJ.setEnabled(true);
                    letterK.setEnabled(true);
                    letterL.setEnabled(true);
                    letterM.setEnabled(true);
                    letterN.setEnabled(true);
                    letterO.setEnabled(true);
                    letterP.setEnabled(true);
                    letterQ.setEnabled(true);
                    letterR.setEnabled(true);
                    letterS.setEnabled(true);
                    letterT.setEnabled(true);
                    letterU.setEnabled(true);
                    letterV.setEnabled(true);
                    letterW.setEnabled(true);
                    letterX.setEnabled(true);
                    letterY.setEnabled(true);
                    letterZ.setEnabled(true);
                }

            }
        });
        mainFr.setVisible(true);
        updateFrames.start();

    }
    
    //Method for right answer
    public static void rightAnswer(char guess) {
        rightAnswer(guess, answer, displayedAnswer);
    }
    
    public static void rightAnswer(char guess, String answer, String displayedAns) {
        String newAns = "";
        for (int i = 0; i < answer.length(); i++) {
            char a = answer.charAt(i);
            if (a == guess) {
                newAns = newAns + guess + " ";
                //newAns.charAt(i).equals(answer.charAt(i));
            } else if (displayedAns.contains(Character.toString(a))) {
                newAns = newAns + a + " ";
            } else {
                newAns = newAns + "_ ";
            }
        }
        displayedAnswer = newAns;
    }
    
    public static void printHighScores() throws IOException{
        
        int count = 0;
        FileReader fr = new FileReader("highscores.txt"); 
        ArrayList<String> list = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(fr))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
                
        String[][] tokens = new String[count][];
        
        for(int z = 0; z < tokens.length; z++){
            tokens[z] = (list.get(z)).split(" ", -1);
        }

        String newHS = "";
        for(int x = 0; x < tokens.length; x++){
            String highScores = tokens[x][0] + " " + tokens[x][1] + "<br/>";
            newHS = newHS + highScores;
        }
        String combinedString = "<html>" + newHS + "<html>";
        
        displayHighScores = combinedString;
    }
    
    public static void writeHighScore(String file, String text)throws IOException{
        
        FileWriter fw = new FileWriter(file, true);
        fw.write(text + "\n");
        fw.close();
    } 

    public static void main(String[] args) throws InterruptedException, IOException {
        
        new Hangman();
    }
}
