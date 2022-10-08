package Exemple3;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe serà responsable de tractar els esdeveniments de botons.
public class AccioDelBoto2 implements ActionListener {
	
	private Finestra3 finestra;
	
	public AccioDelBoto2(Finestra3 finestra) {
		this.finestra = finestra;
	}
	
	// Què passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		// Obtenim el text del botó.
		String s = b.getText();
		// Enviem el text al TextArea
		finestra.afegirTextArea(s);
	}
	
}
