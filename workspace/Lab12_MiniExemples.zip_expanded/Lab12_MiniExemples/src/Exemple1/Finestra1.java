package Exemple1;

import javax.swing.*;
import java.awt.*;

public class Finestra1 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	// Constructor sense par�metres,
	// crida a un altre constructor on cal el t�tol de la finestra com a par�metre.
	public Finestra1() {
		this("Finestra sense nom");
	}
	
	// Constructor per crear un objecte Finestra amb el t�tol com a par�metre.
	public Finestra1(String titol) {
		super(titol); // Crida el constructor de la classe mare JFrame.
		// Creaci� de tres botons.
		JButton bN = new JButton("Nord");
		JButton bE = new JButton("Est");
		JButton bW = new JButton("Oest");
		// Creaci� d'un quadre de text d'una linia.
		JTextField texte = new JTextField();
		// Creaci� d'un quadre de text de m�ltiples linies.
		JTextArea area = new JTextArea();
		
		
		// Forcem la disposici� dels objectes que contindr� la finestra al tipus "BorderLayout"
		this.setLayout(new BorderLayout());
		
		// Ara ja podem afegir els objectes no contenidors en l'objecte contenidor.
		// La disposici� dels objectes en el contenidor es far� en "BorderLayout".
		this.add(bN, BorderLayout.NORTH);
		this.add(bE, BorderLayout.EAST);
		this.add(bW, BorderLayout.WEST);
		this.add(texte, BorderLayout.SOUTH);
		this.add(area, BorderLayout.CENTER);
		
		// Necessari per alliberar la mem�ria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, �s a dir, la finestra.
		setSize(300,300);
		// Fem la finestra visible.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Finestra1();
	}
	
}
