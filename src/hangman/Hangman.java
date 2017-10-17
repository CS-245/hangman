/** *************************************************************
 * file: Hangman.java
 * authors: Lenny Yang, Rachel Frodsham, Jenna Barrett
 * class: CS245 – Graphic User Interface (GUI)
 *
 * assignment: Point and Click Game – v.1.0
 * date last modified: 10/16/2017
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
import javax.swing.BorderFactory;

public class Hangman {

    public static int currentScore = 100;
    static String answer;
    static String displayedAnswer;

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
    Painter p = new Painter();

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
        JLabel answerText = new JLabel(displayedAnswer);
        final JLabel hangmanTitle = new JLabel("Hangman");

        titleText.setFont(new Font("Serif", Font.BOLD, 30));
        teamText.setFont(new Font("Curlz MT", Font.PLAIN, 30));
        titleCredit.setFont(new Font("Serif", Font.BOLD, 20));
        highScTitle.setFont(new Font("Serif", Font.BOLD, 20));
        yourScTitle.setFont(new Font("Serif", Font.BOLD, 35));
        scoreText.setFont(new Font("Serif", Font.PLAIN, 20));
        answerText.setFont(new Font("Serif", Font.BOLD, 35));
        hangmanTitle.setFont(new Font("AR DESTINE", Font.PLAIN, 35));

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
//        highScores.setBounds(250,10,300,150);
        hangmanTitle.setBounds(25,-10,500,100);        
        skipButton.setBounds(400,100,100,30);
//        scoreTitle.setBounds(200, -10, 500, 100);
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
        
        
        //Title Page uses BoxLayout
        titlePg.setBackground(new Color(255,255,200)); //rgb
        titlePg.setLayout(new BoxLayout(titlePg, BoxLayout.Y_AXIS));
        titleText.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        
        //Credits Page
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
        
        //High Score Page 
        highScorePg.setLayout(new BoxLayout(highScorePg, BoxLayout.Y_AXIS));
        highScTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButtonHS.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScorePg.add(Box.createRigidArea(new Dimension(0,25)));
        highScorePg.add(highScTitle);
        highScorePg.add(Box.createRigidArea(new Dimension(0,250)));
        highScorePg.add(backButtonHS);
        
        //Game Page
        gamePg.setLayout(null);
        gamePg.add(hangmanTitle);
        gamePg.add(time);
        gamePg.add(skipButton);
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
        p.setVisible(true);
        gamePg.add(p);
        
        //Score Page uses BoxLayout
        //with internal panels for extra formatting
        scorePg.setLayout(new BoxLayout(scorePg, BoxLayout.Y_AXIS));
        yourScTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorePg.add(Box.createRigidArea(new Dimension(0,25))); //creates padding
        scorePg.add(yourScTitle);
        scorePg.add(Box.createRigidArea(new Dimension(0,200)));
        scorePg.add(scoreText);
        scorePg.add(Box.createRigidArea(new Dimension(0,200)));
        scorePg.add(endButton);
        
        //Pages and Frame Set Up
        pages.add(titlePg, "titlePg");           //the string is the label of the page, can be anything
        pages.add(menuPg, "menuPg");             //but was set to the variable name to stay simple
        pages.add(creditsPg, "creditsPg");
        pages.add(highScorePg, "highScorePg");
        pages.add(gamePg, "gamePg");
        pages.add(scorePg, "scorePg");
        cl.show(pages, "titlePg"); //first page shown is title page
        
        mainFr.add(pages);
        mainFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFr.setSize(600, 400);
        mainFr.setLocationRelativeTo(null);
        mainFr.setVisible(true);
        

        //Listeners
        new java.util.Timer().schedule(new java.util.TimerTask() {
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
            public void actionPerformed(ActionEvent e) {
                cl.show(pages, "menuPg");
                currentScore = 100;
            }
        });


        //LETTERS
        letterA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterA.setEnabled(false);
                if (answer.contains("a")) {
                    rightAnswer('a');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 500, 200, 200);
                }
            }
        });

        letterB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterB.setEnabled(false);
                if (answer.contains("b")) {
                    rightAnswer('b');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterC.setEnabled(false);
                if (answer.contains("c")) {
                    rightAnswer('c');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterD.setEnabled(false);
                if (answer.contains("d")) {
                    rightAnswer('d');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterE.setEnabled(false);
                if (answer.contains("e")) {
                    rightAnswer('e');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });
        letterF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterF.setEnabled(false);
                if (answer.contains("f")) {
                    rightAnswer('f');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });
        letterG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterG.setEnabled(false);
                if (answer.contains("g")) {
                    rightAnswer('g');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });
        letterH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterH.setEnabled(false);
                if (answer.contains("h")) {
                    rightAnswer('h');
                }
            }
        });
        letterI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterI.setEnabled(false);
                if (answer.contains("i")) {
                    rightAnswer('i');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterJ.setEnabled(false);
                if (answer.contains("j")) {
                    rightAnswer('j');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterK.setEnabled(false);
                if (answer.contains("k")) {
                    rightAnswer('k');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterL.setEnabled(false);
                if (answer.contains("l")) {
                    rightAnswer('l');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterM.setEnabled(false);
                if (answer.contains("m")) {
                    rightAnswer('m');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterN.setEnabled(false);
                if (answer.contains("n")) {
                    rightAnswer('n');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterO.setEnabled(false);
                if (answer.contains("o")) {
                    rightAnswer('o');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterP.setEnabled(false);
                if (answer.contains("p")) {
                    rightAnswer('p');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterQ.setEnabled(false);
                if (answer.contains("q")) {
                    rightAnswer('q');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterR.setEnabled(false);
                if (answer.contains("r")) {
                    rightAnswer('r');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterS.setEnabled(false);
                if (answer.contains("s")) {
                    rightAnswer('s');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterT.setEnabled(false);
                if (answer.contains("t")) {
                    rightAnswer('t');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterU.setEnabled(false);
                if (answer.contains("u")) {
                    rightAnswer('u');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterV.setEnabled(false);
                if (answer.contains("v")) {
                    rightAnswer('v');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterW.setEnabled(false);
                if (answer.contains("w")) {
                    rightAnswer('w');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterX.setEnabled(false);
                if (answer.contains("x")) {
                    rightAnswer('x');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterY.setEnabled(false);
                if (answer.contains("y")) {
                    rightAnswer('y');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
                }
            }
        });

        letterZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letterZ.setEnabled(false);
                if (answer.contains("z")) {
                    rightAnswer('z');
                } else {
                    //p.checker = true;
                    currentScore -= 10;
                    p.repaint(0, 100, 75, 260, 135);
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

                if (withoutSpaces.equals(answer)) {
                    cl.show(pages, "scorePg");
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

    public static void main(String[] args) throws InterruptedException {
        new Hangman();
    }
}
