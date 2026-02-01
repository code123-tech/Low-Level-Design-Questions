package Behavioral_Desing_pattern.TemplateMethod.wild.swing;

import javax.swing.JFrame;
import java.awt.Graphics;

/**
 * Chapter 8: paint() as a hook in JFrame's update algorithm.
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        new MyFrame("Head First Design Patterns");
    }
}

