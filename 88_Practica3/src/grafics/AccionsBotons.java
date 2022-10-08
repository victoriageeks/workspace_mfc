package grafics;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import aplicacio.main;

public class AccionsBotons implements ActionListener {
	
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
			JButton flashButton = (JButton)evt.getSource();
			
			System.out.println(flashButton.getText());
			
			FinestraDadesPlantacio v3 = new FinestraDadesPlantacio(flashButton.getText(), main.plantationList.getPlantation(flashButton.getText()));
			v3.start();

	}
	
}
