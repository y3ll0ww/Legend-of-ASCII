package yellow.game;

import javax.swing.*;
import yellow.game.gui.GUI;

import java.awt.*;

import static yellow.game.gui.ScreenDrawer.*;
import static yellow.game.gui.ScreenDrawer.line40;

public class Main {


    private static JFrame window;
    private static GUI gameScreen;
    public static final int windowWidth = 1080;
    public static final int windowHeight = 980;

    public static void main(String[] args) {
        createWindow();
        startGame();
    }

    private static void createWindow() {
        window = new JFrame("Legend of ASCII");
        ImageIcon icon = new ImageIcon("./src/yellow/assets/european-dragon.png");
        window.setIconImage(icon.getImage());

        window.setLayout(new GridLayout(0, 1));

        window.setVisible(true);
        window.setSize(windowWidth, windowHeight);
        window.setResizable(true);
      //  window.setBounds(200, 80, windowWidth, windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void startGame() {
        gameScreen = new GUI();

        window.add(gameScreen, BorderLayout.CENTER);
        gameScreen.CommandLine();
     //   JLabel l1 = new JLabel(line01), l2 = new JLabel(line02), l3 = new JLabel(line03), l4 = new JLabel(line04),
     //          l5 = new JLabel(line05), l6 = new JLabel(line06), l7 = new JLabel(line07), l8 = new JLabel(line08),
     //          l9 = new JLabel(line09), l10 = new JLabel(line10), l11 = new JLabel(line11), l12 = new JLabel(line12),
     //          l13 = new JLabel(line13), l14 = new JLabel(line14), l15 = new JLabel(line15), l16 = new JLabel(line16),
     //          l17 = new JLabel(line17), l18 = new JLabel(line18), l19 = new JLabel(line19), l20 = new JLabel(line20),
     //          l21 = new JLabel(line21), l22 = new JLabel(line22), l23 = new JLabel(line23), l24 = new JLabel(line24),
     //          l25 = new JLabel(line25), l26 = new JLabel(line26), l27 = new JLabel(line27), l28 = new JLabel(line28),
     //          l29 = new JLabel(line29), l30 = new JLabel(line30), l31 = new JLabel(line31), l32 = new JLabel(line32),
     //          l33 = new JLabel(line33), l34 = new JLabel(line34), l35 = new JLabel(line35), l36 = new JLabel(line36),
     //          l37 = new JLabel(line37), l38 = new JLabel(line38), l39 = new JLabel(line39), l40 = new JLabel(line40);
     //   window.add(l1); window.add(l2); window.add(l3); window.add(l4); window.add(l5); window.add(l6); window.add(l7);
     //   window.add(l8); window.add(l9); window.add(l10); window.add(l1); window.add(l12); window.add(l13); window.add(l14);
     //   window.add(l15); window.add(l16); window.add(l17); window.add(l18); window.add(l19); window.add(l20); window.add(l21);
     //   window.add(l22); window.add(l23); window.add(l24); window.add(l25); window.add(l26); window.add(l27); window.add(l28);
     //   window.add(l29); window.add(l30); window.add(l31); window.add(l32); window.add(l33); window.add(l34); window.add(l35);
     //   window.add(l36); window.add(l37); window.add(l38); window.add(l39); window.add(l40);
    }
}

