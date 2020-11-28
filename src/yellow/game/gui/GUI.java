package yellow.game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import yellow.game.Main;

import static yellow.game.gui.ScreenDrawer.*;

public class GUI extends JPanel {
    Font MonoFont = new Font(Font.MONOSPACED, Font.PLAIN, 18);


    public GUI() {
        this.setFocusable(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        revalidate();

        //Background
        super.setBackground(Color.BLACK); //Window
        g.setColor(Color.BLACK); //GameScreen
        g.fillRect(0, 0, Main.windowWidth, Main.windowHeight);

        //Foreground
        g.setColor(Color.WHITE);
        g.setFont(MonoFont);

        //Draw strings to screen
        g.drawString(line01, 4, 18);  g.drawString(line02, 4, 36);  g.drawString(line03, 4, 54);
        g.drawString(line04, 4, 72);  g.drawString(line05, 4, 90);  g.drawString(line06, 4, 108);
        g.drawString(line07, 4, 126); g.drawString(line08, 4, 144); g.drawString(line09, 4, 162);
        g.drawString(line10, 4, 180); g.drawString(line11, 4, 198); g.drawString(line12, 4, 216);
        g.drawString(line13, 4, 234); g.drawString(line14, 4, 252); g.drawString(line15, 4, 270);
        g.drawString(line16, 4, 288); g.drawString(line17, 4, 306); g.drawString(line18, 4, 324);
        g.drawString(line19, 4, 342); g.drawString(line20, 4, 360); g.drawString(line21, 4, 378);
        g.drawString(line22, 4, 396); g.drawString(line23, 4, 414); g.drawString(line24, 4, 432);
        g.drawString(line25, 4, 450); g.drawString(line26, 4, 468); g.drawString(line27, 4, 486);
        g.drawString(line28, 4, 504); g.drawString(line29, 4, 522); g.drawString(line30, 4, 540);
        g.drawString(line31, 4, 558); g.drawString(line32, 4, 576); g.drawString(line33, 4, 594);
        g.drawString(line34, 4, 612); g.drawString(line35, 4, 630); g.drawString(line36, 4, 648);
        g.drawString(line37, 4, 666); g.drawString(line38, 4, 684); g.drawString(line39, 4, 702);
        g.drawString(line40, 4, 720);

        //Get layout
        LayoutPicker.browseLayout();
    }

    public void CommandLine() {
        //Create a commandline
        JTextField commandline = new JTextField(96);
        commandline.setFont(MonoFont);
        commandline.setBorder(new LineBorder(Color.BLACK,0));
        commandline.setBackground(new Color(0,0,0,0));


        //Make the input invisible (transparant)
        commandline.setForeground(new Color(0, 0, 0, 0));

        //Add it to the bottom of the screen
        this.setLayout(new BorderLayout());
        this.add(commandline, BorderLayout.SOUTH);

        //Send commands to commandlist class
        commandline.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set input to string, convert to uppercase and clear textfield
                String command = commandline.getText();
                command = command.toUpperCase();
                commandline.setText("");

                //Send command to appropriate commandlist
                if(LayoutPicker.entry == 0){
                    commandline.setForeground(Color.WHITE);
                    CommandList.pressEnter(command);
                } else if(LayoutPicker.entry == 1){
                    CommandList.commandFired(command);
                } else if(LayoutPicker.entry >= 10 && LayoutPicker.entry < 20) {
                    CommandList.createCharacter(command);
                } else if(LayoutPicker.entry >= 50 && LayoutPicker.entry < 65) {
                    CommandList.pressEnter(command);
                } else if(LayoutPicker.entry >= 65 && LayoutPicker.entry < 70) {
                    if (LayoutPicker.entry == 67 || LayoutPicker.entry == 68) {
                        CommandList.pressEnter(command);
                    } else {
                        CommandList.introScene(command);
                    }
                } else if(LayoutPicker.entry >= 9970 && LayoutPicker.entry < 9980){
                    CommandList.foundLoot(command);
                } else if(LayoutPicker.entry >= 9980 && LayoutPicker.entry < 9990){
                    CommandList.inventoryActions(command);
                } else if(LayoutPicker.entry == 9990 || LayoutPicker.entry == 9991){
                    CommandList.freeRoaming(command);
                } else if(LayoutPicker.entry > 9999998) { //TEST ENVIRONMENT
                    CommandList.TestEnvironment(command);
                }

                System.out.println(LayoutPicker.entry);
            }
        });

        //Focus on the textfield
        commandline.requestFocusInWindow();

    }
}
