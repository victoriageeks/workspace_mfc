package Exemple3;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe serà responsable de tractar els esdeveniments del JTextField.
public class AccioDelTextField2 implements ActionListener {
	
	private Finestra3 finestra;
	
	public AccioDelTextField2(Finestra3 finestra) {
		this.finestra = finestra;
	}
	
	// Què passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
        JTextField tf = (JTextField) evt.getSource();
		// Obtenim el text del botó.
		String s = tf.getText();
		// Enviem el text al TextArea
		finestra.afegirTextArea(s);
		tf.setText("");
	}
	
}
