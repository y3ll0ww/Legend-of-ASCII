package yellow.game;

import javax.swing.*;
import yellow.game.gui.GUI;

public class Main {


    private static JFrame window;
    private static GUI gameScreen;
    public static final int windowWidth = 1080;
    public static final int windowHeight = 770;

    public static void main(String[] args) {
        createWindow();
        startGame();
    }

    private static void createWindow() {
        window = new JFrame("Legend of ASCII");
        ImageIcon icon = new ImageIcon("./src/yellow/assets/european-dragon.png");
        window.setIconImage(icon.getImage());

        window.setVisible(true);
        window.setResizable(true);
        window.setBounds(200, 80, windowWidth, windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void startGame() {
        gameScreen = new GUI();
        window.add(gameScreen);
        gameScreen.CommandLine();
    }
}

