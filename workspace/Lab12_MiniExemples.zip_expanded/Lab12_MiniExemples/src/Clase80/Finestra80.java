package Clase80;

import javax.swing.*;
import java.awt.*;

public class Finestra80 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel panellBotons = new JPanel();
	private JButton b1 = new JButton("");
	private JButton b2 = new JButton("");
	private JButton b3 = new JButton("");
	private JButton b4 = new JButton("");
	private JTextField texte = new JTextField("Marca caselles per canviar de color");
	
	// Constructor de la finestra, es a dir, la classe contenidora.
	public Finestra80(String titol) {
		super(titol); // Crida el constructor de la classe mare JFrame.
		iniComponents();
	}
	
	private void iniComponents() {
		// Forcem la disposici� dels objectes que tindr�
		// la finestra principal al tipus "BorderLayout"
		this.setLayout(new BorderLayout());
		
		// Forcem la disposici� dels objectes continguts en el panell.
		panellBotons.setLayout(new FlowLayout());
		// Afegim els botons al panell.
		
		// Afegim el panell a la finestra.
		int n = 2;
		this.setLayout(new GridLayout(n-1, n-1, 10, 1));
		for (int i = 0; i<n*n; i++) {
			this.add(new JButton(""), BorderLayout.EAST);
			if (i == 0) {
				
			}
		}
		this.add(texte, BorderLayout.SOUTH);
		
		// Classe de tractar� l'esdeveniment sobre el bot�.
		AccioDelBoto80 accioBoto = new AccioDelBoto80(this);
		
		// Indiquem que cada bot� utilitzi la classe anterior per tractar l'esdeveniment.
		// NOTA: Cada bot� pot tenir una classe diferent per tractar el seu esdeveniment.
		b1.addActionListener(accioBoto);
		b2.addActionListener(accioBoto);
		b3.addActionListener(accioBoto);
		b4.addActionListener(accioBoto);
		
		// Necessari per alliberar la mem�ria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300,300);
		// Fem la finestra visible.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Finestra80("Finestra3");
	}
	
}
