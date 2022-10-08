package Exemple5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestDades {
  private JFrame frame;

  public TestDades() {
    frame = new JFrame("Test Dialegs");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JButton button = new JButton("Obrir dialeg");
    button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                preguntarDades();
            }
        });

	Container cont = frame.getContentPane();
	cont.add(button);

	frame.pack();
    frame.setVisible(true);
  }

  public void preguntarDades() {
    EntrarDades d = new EntrarDades(frame);
    if(d.dadesEntrades()) {
      System.out.println("Nom: "+d.getNom());
      System.out.println("Cognom: "+d.getCognom());
      System.out.println("Edat: "+d.getEdat());
      System.out.println("Sexe: "+d.getSexe());
    }
  }
  
  public static void main(String[] args) {
    new TestDades();
  }
}


