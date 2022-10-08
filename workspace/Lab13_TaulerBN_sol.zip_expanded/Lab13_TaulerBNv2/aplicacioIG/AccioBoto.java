package aplicacioIG;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccioBoto implements ActionListener {
  
  public void actionPerformed(ActionEvent e) {
	  JButton boto=(JButton) e.getSource();
	  Color c=boto.getBackground();
	  
	  if (c.equals(Color.white)) boto.setBackground(Color.BLACK);
	  else boto.setBackground(Color.white);
  }
}
