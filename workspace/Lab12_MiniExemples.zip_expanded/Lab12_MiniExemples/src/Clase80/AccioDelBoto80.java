package Clase80;

import java.awt.event.*;
import javax.swing.*;import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color.*;

// Aquest classe ser� responsable de tractar els esdeveniments de botons.
public class AccioDelBoto80 implements ActionListener {
	
	private Finestra80 finestra;
	
	public AccioDelBoto80(Finestra80 finestra) {
		this.finestra = finestra;
	}
	
	// Qu� passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		
		JButton b = (JButton) evt.getSource();
		
		if (b.getBackground() == Color.WHITE) {
			b.setBackground(Color.BLACK);
		}
		else {
			b.setBackground(Color.WHITE);
		}
	}
	
}
