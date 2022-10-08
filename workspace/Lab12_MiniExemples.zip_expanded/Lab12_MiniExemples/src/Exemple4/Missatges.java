package Exemple4;

import javax.swing.JOptionPane;

public class Missatges {

	public Missatges() {
		// Demanar dades a l'usuari.
		String nom = JOptionPane.showInputDialog("Com et dius");
		while (nom == null || nom.equals("")) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Cal un nom!", "ERROR", JOptionPane.ERROR_MESSAGE);
			nom = JOptionPane.showInputDialog("Com et dius");
		}
	
		// Missatge d'informació.
		JOptionPane.showMessageDialog(null, "Hola "+nom+"!", "Benvinguda", JOptionPane.INFORMATION_MESSAGE);		
		
		// Missatge d'alerta.
		JOptionPane.showMessageDialog(null, "Vigila amb aquesta opció!", "ATENCIÓ!", JOptionPane.WARNING_MESSAGE);
		
		// Missatge de confirmació.
		String s;
		int opcio = JOptionPane.showConfirmDialog(null, "Segur que vols sortir", "CONFIRMACIÓ", JOptionPane.YES_NO_OPTION);
		if (opcio == JOptionPane.YES_OPTION) {
			s = "Has triat SI";
		} else if (opcio == JOptionPane.NO_OPTION) {
			s = "Has triat NO";
		} else {
			s = "Resposta indefinida";
		}
		JOptionPane.showMessageDialog(null, s, "INFORMACIÓ",JOptionPane.INFORMATION_MESSAGE);		
	}
	
	public static void main(String[] args) {
		new Missatges();
	}

}
