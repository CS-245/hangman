import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PaintSudoku extends JPanel {


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Draw 
        g2.drawLine(244, 64, 244, 126); // first verticle line
        g2.drawLine(334, 64, 334, 126); // second verticle line
        g2.drawLine(154, 124, 396, 124); // first horizontal line
        g2.drawLine(154, 244, 396, 244); // second horizontal line
    }
}
