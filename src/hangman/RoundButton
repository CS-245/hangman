package hangman;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundButton extends JButton {

  public void setDiameter(int diameter) {
    Dimension size = new Dimension();
    size.width = diameter;
    size.height = diameter;
    setPreferredSize(size);

    setContentAreaFilled(false); // This allows us to paint a round background.
  }
  
// Paint the round background and label.
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(Color.lightGray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);
    
    super.paintComponent(g);
  }

// So that there isn't a square border around the button
  protected void paintBorder(Graphics g) {
    g.setColor(getBackground());
    g.drawOval(0, 0, getSize().width-1, 
      getSize().height-1);
  }

}
