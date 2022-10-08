package Exemple3;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe ser� responsable de tractar els esdeveniments del JTextField.
public class AccioDelTextField2 implements ActionListener {
	
	private Finestra3 finestra;
	
	public AccioDelTextField2(Finestra3 finestra) {
		this.finestra = finestra;
	}
	
	// Qu� passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la refer�ncia del control que ha provocat l'esdeveniment.
        JTextField tf = (JTextField) evt.getSource();
		// Obtenim el text del bot�.
		String s = tf.getText();
		// Enviem el text al TextArea
		finestra.afegirTextArea(s);
		tf.setText("");
	}
	
}
