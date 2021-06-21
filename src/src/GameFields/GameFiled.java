package GameFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameFiled extends JPanel implements ActionListener {

    private final int Size = 320; // Field Size
    private final int DotSize = 16; //SnakeSize Aplle in PX
    private final int All_Dots = 400; // Max PX in GameField
    private Image dot; //ImageDot
    private Image apple; // ImageApple
    private int appleX; //Possition applex
    private int appleY; //Possition appley
    private int[] x = new int[All_Dots];
    private int[] y = new int[All_Dots];
    private int dots; //Snake Lenght
    private Timer timer;
    private boolean left;
    private boolean right = true;
    private boolean up;
    private boolean down;
    private boolean inGame = true;
    private byte Score = 0;


    public GameFiled() {
        setBackground(Color.BLACK); //change bg in window
        loadImages(); // Load img in window
        initGame(); //Start game;
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }

    public void initGame() {
        dots = 3; //set lenght of snake
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DotSize; //Init Possition of dot
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void loadImages() {
        ImageIcon iconApple = new ImageIcon("apple.png"); // Load image;
        apple = iconApple.getImage(); //Get image and insert in apple field;

        ImageIcon iconDot = new ImageIcon("dot.png"); // Load image;
        dot = iconDot.getImage(); //Get image and insert in dot field;
    }

    public void createApple() {
        appleX = new Random().nextInt(20) * DotSize;
        appleY = new Random().nextInt(20) * DotSize;
    }


    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DotSize;
        }
        if (right) {
            x[0] += DotSize;
        }
        if (up) {
            y[0] -= DotSize;
        }
        if (down) {
            y[0] += DotSize;
        }

    }

    private void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) { //x[0] and y[0] is a snake tail x[i] and y[i] is her head;
                inGame = false;
            }
        }
        if (x[0] > Size) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (y[0] > Size) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) { // check if snake eats apple;
            createApple();
            dots++;
            Score++;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) { // this method calls every 250 milsec
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint(); //this method paint snake apple in move
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            String TempForScore = String.valueOf(Score);
            g.drawString(TempForScore,Size/2,Size/2);
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        } else {
            String str = "Game Over";
            Font f = new Font("Arial", Font.BOLD, 14);
            g.setColor(Color.red);
            g.setFont(f);
            g.drawString(str, 120, Size / 2);
        }
    }


    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {       //Control key Press
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
        }
    }

}
