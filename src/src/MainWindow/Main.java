package MainWindow;

import GameFields.GameFiled;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    public Main() {
        SetOptionWindow();
        add(new GameFiled());
        setVisible(true);
    }

    public void SetOptionWindow() {

        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 240, 350, 370);
        ImageIcon imageIcon = new ImageIcon("apple.png");
        setIconImage(imageIcon.getImage());
    }

    public static void main(String[] args) {
        Main StartGame = new Main();
    }
}
