package Exemple3;

import javax.swing.*;
import java.awt.*;

public class Finestra3 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel panellBotons = new JPanel();
	private JButton b1 = new JButton("Boto1");
	private JButton b2 = new JButton("Boto2");
	private JButton b3 = new JButton("Boto3");
	private JTextField texte = new JTextField();
	private JTextArea area = new JTextArea();
	
	// Constructor de la finestra, es a dir, la classe contenidora.
	public Finestra3(String titol) {
		super(titol); // Crida el constructor de la classe mare JFrame.
		iniComponents();
	}
	
	public void afegirTextArea(String s) {
		this.area.append(s+"\n");
	}
	
	private void iniComponents() {
		// Forcem la disposició dels objectes que tindrà
		// la finestra principal al tipus "BorderLayout"
		this.setLayout(new BorderLayout());
		// Afegim els dos control al contenidor principal.
		this.add(area, BorderLayout.CENTER);
		this.add(texte, BorderLayout.SOUTH);
		
		// Forcem la disposició dels objectes continguts en el panell.
		panellBotons.setLayout(new FlowLayout());
		// Afegim els botons al panell.
		panellBotons.add(b1);
		panellBotons.add(b2);
		panellBotons.add(b3);
		
		// Afegim el panell a la finestra.
		this.add(panellBotons, BorderLayout.NORTH);
		
		// Classe de tractarà l'esdeveniment sobre el botó.
		AccioDelBoto2 accioBoto = new AccioDelBoto2(this);
		AccioDelTextField2 accioTextField = new AccioDelTextField2(this);
		// Indiquem que cada botó utilitzi la classe anterior per tractar l'esdeveniment.
		// NOTA: Cada botó pot tenir una classe diferent per tractar el seu esdeveniment.
		b1.addActionListener(accioBoto);
		b2.addActionListener(accioBoto);
		b3.addActionListener(accioBoto);
		texte.addActionListener(accioTextField);
		
		// Necessari per alliberar la memòria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300,300);
		// Fem la finestra visible.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Finestra3("Finestra3");
	}
	
}
