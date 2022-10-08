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
		
		// Forcem la disposici� dels objectes que contindr� la finestra al tipus "BorderLayout"
		this.setLayout(new BorderLayout());
		
		// Ara ja podem afegir els objectes no contenidors en l'objecte contenidor.
		// La disposici� dels objectes en el contenidor es far� en "BorderLayout".
		this.add(bN, BorderLayout.NORTH);
		this.add(bE, BorderLayout.EAST);
		this.add(bW, BorderLayout.WEST);
		this.add(texte, BorderLayout.SOUTH);
		this.add(area, BorderLayout.CENTER);
		
		// Classe de tractar� l'esdeveniment sobre el bot�.
		AccioDelBoto accioBoto = new AccioDelBoto();
		AccioDelTextField accioTextField = new AccioDelTextField();
		
		// Indiquem que cada bot� utilitzi la classe anterior per tractar l'esdeveniment.
		// NOTA: Cada bot� pot tenir una classe diferent per tractar el seu esdeveniment.
		bN.addActionListener(accioBoto);
		bE.addActionListener(accioBoto);
		bW.addActionListener(accioBoto);
		texte.addActionListener(accioTextField);
		
		// Necessari per alliberar la mem�ria quan tanquem la finestra.
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
