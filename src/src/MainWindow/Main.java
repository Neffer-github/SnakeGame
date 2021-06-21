package MainWindow;

import GameFields.GameFiled;

import javax.swing.*;

public class Main extends JFrame {


    public Main() {
        setDefaultLookAndFeelDecorated(true);
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 395);
        setLocation(500, 240);
        add(new GameFiled());
        setVisible(true);
    }


    public static void main(String[] args) {

        Main StartGame = new Main();
    }
}
