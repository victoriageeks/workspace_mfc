package Exemple2;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe ser� responsable de tractar els esdeveniments del JTextField.
public class AccioDelTextField implements ActionListener {
	
	// Qu� passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la refer�ncia del control que ha provocat l'esdeveniment.
        JTextField tf = (JTextField) evt.getSource();
		// Obtenim el text del bot�.
		String s = tf.getText();
		// Enviem el text a la sortida est�ndard
		System.out.println(s);
		tf.setText("");
	}
	
}