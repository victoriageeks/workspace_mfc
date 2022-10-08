package Exemple3;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe ser� responsable de tractar els esdeveniments de botons.
public class AccioDelBoto2 implements ActionListener {
	
	private Finestra3 finestra;
	
	public AccioDelBoto2(Finestra3 finestra) {
		this.finestra = finestra;
	}
	
	// Qu� passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la refer�ncia del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		// Obtenim el text del bot�.
		String s = b.getText();
		// Enviem el text al TextArea
		finestra.afegirTextArea(s);
	}
	
}
