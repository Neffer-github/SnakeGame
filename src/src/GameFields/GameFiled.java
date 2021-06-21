package GameFields;

import javax.swing.*;
import java.awt.*;

public class GameFiled extends JPanel {

    private final int Size = 320; // Field Size
    private final int DotSize = 16; //SnakeSize Aplle in PX
    private final int All_Dots = 400; // Max PX in GameField
    private Image dot; //ImageDot
    private Image apple; // ImageApple
    private int appleX; //Possition applex
    private int appley; //Possition appley
    private int[] x = new int[All_Dots-1];
    private int[] y = new int[All_Dots-1];
    private  int dots; //Snake Lenght
    private Timer timer;
    private boolean left;
    private boolean right = true;
    private boolean up;
    private boolean down;
    private boolean inGame = true;


    public GameFiled() {
    setBackground(Color.DARK_GRAY);
    }
}
