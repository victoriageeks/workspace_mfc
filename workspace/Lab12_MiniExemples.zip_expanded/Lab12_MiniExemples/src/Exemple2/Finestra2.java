package Exemple2;

import javax.swing.*;
import java.awt.*;

public class Finestra2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Els objectes no contenidors com atributs de la classe contenidora.
	private JButton bN = new JButton("Nord");
	private JButton bE = new JButton("Est");
	private JButton bW = new JButton("Oest");
	private JTextField texte = new JTextField();
	private JTextArea area = new JTextArea();
	
	// Constructor de la finestra
	public Finestra2(String titol) {
		super(titol); // Crida el constructor de la classe mare JFrame.
		
		// Forcem la disposició dels objectes que contindrà la finestra al tipus "BorderLayout"
		this.setLayout(new BorderLayout());
		
		// Ara ja podem afegir els objectes no contenidors en l'objecte contenidor.
		// La disposició dels objectes en el contenidor es farà en "BorderLayout".
		this.add(bN, BorderLayout.NORTH);
		this.add(bE, BorderLayout.EAST);
		this.add(bW, BorderLayout.WEST);
		this.add(texte, BorderLayout.SOUTH);
		this.add(area, BorderLayout.CENTER);
		
		// Classe de tractarà l'esdeveniment sobre el botó.
		AccioDelBoto accioBoto = new AccioDelBoto();
		AccioDelTextField accioTextField = new AccioDelTextField();
		
		// Indiquem que cada botó utilitzi la classe anterior per tractar l'esdeveniment.
		// NOTA: Cada botó pot tenir una classe diferent per tractar el seu esdeveniment.
		bN.addActionListener(accioBoto);
		bE.addActionListener(accioBoto);
		bW.addActionListener(accioBoto);
		texte.addActionListener(accioTextField);
		
		// Necessari per alliberar la memòria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300,300);
		// Fem la finestra visible.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Finestra2("Finestra2");
	}
	
}
