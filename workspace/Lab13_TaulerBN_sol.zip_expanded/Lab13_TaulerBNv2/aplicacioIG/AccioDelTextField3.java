package aplicacioIG;
import java.awt.event.*;
import javax.swing.*;

// Aquest classe serà responsable de tractar els esdeveniments del JTextField.
public class AccioDelTextField3 implements ActionListener {
	
	private AplicacioV2 finestra;
	
	public AccioDelTextField3(AplicacioV2 finestra) {
		this.finestra = finestra;
	}
	
	// Què passa quan es fa "click"?
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
        JTextField tf = (JTextField) evt.getSource();
		String s = tf.getText();
	    //System.out.println(s);
		
		finestra.hiHaNumBlancs(Integer.parseInt(s));
	}
	
}