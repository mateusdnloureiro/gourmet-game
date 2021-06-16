package gourmet.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GourmetGameApp extends JFrame {

    private final Question firstQuestion;

    public GourmetGameApp() {
        this.setTitle("Gourmet Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        final Border padding = BorderFactory.createEmptyBorder(40, 80, 40, 80);
        panel.setBorder(padding);

        final JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonOkPressed();
            }
        });
        button.setAlignmentX(0.5F);

        final JLabel label = new JLabel("Pense em um prato que gosta");
        label.setAlignmentX(0.5F);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button);

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.firstQuestion = new Question(this, "Massa");
        this.firstQuestion.setYes(new Response(this, "Lasanha"));
        this.firstQuestion.setNo(new Response(this, "Bolo de Chocolate"));
    }

    private void buttonOkPressed() {
        this.firstQuestion.ask();
    }

    public static void main(String[] args) {
        new GourmetGameApp();
    }
}
