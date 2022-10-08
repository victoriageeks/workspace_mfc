package Exemple2;

import java.awt.event.*;
import javax.swing.*;

// Aquest classe serà responsable de tractar els esdeveniments del JTextField.
public class AccioDelTextField implements ActionListener {
	
	// Què passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
        JTextField tf = (JTextField) evt.getSource();
		// Obtenim el text del botó.
		String s = tf.getText();
		// Enviem el text a la sortida estàndard
		System.out.println(s);
		tf.setText("");
	}
	
}