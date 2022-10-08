package Exemple2;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe ser� responsable de tractar els esdeveniments de botons.
public class AccioDelBoto implements ActionListener {
	
	// Qu� passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la refer�ncia del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		// Obtenim el text del bot�.
		String s = b.getText();
		// Imprimim el text per la consola de text
		System.out.println(s);
	}
	
}
