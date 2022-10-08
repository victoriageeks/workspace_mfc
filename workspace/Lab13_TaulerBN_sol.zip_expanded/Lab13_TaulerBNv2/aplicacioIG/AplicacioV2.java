package aplicacioIG;
import javax.swing.*;

import java.awt.*;

public class AplicacioV2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panellBotons, panellPregunta;
	private JButton[][] graella;
	private JTextField texte;
	private JLabel instruc;
	private JTextArea missatge;
	private int dim;
	
	public AplicacioV2(String titol, int dimensio) {	
		super(titol);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(dimensio*50,dimensio*50);
		
		dim=dimensio;
		graella=new JButton[dimensio][dimensio];
		texte = new JTextField(3);	// per definir un tamany de visualitzacio
		panellBotons=new JPanel();
		panellPregunta=new JPanel();
		
		this.setLayout(new BorderLayout());
		
		panellBotons.setLayout(new GridLayout(dimensio,dimensio));
		
		AccioBoto accioBoto=new AccioBoto();
		
		for (int i=0; i<dimensio; i++)
			for (int j=0; j<dimensio; j++) {
				graella[i][j]=new JButton("\n\n");
				graella[i][j].setBackground(Color.white);
				graella[i][j].addActionListener(accioBoto);
				panellBotons.add(graella[i][j]);
			}
		
		this.add(panellBotons, BorderLayout.NORTH);
		
		panellPregunta.setLayout(new FlowLayout());
		instruc=new JLabel("Quantes caselles tenim de color blanc?");
		panellPregunta.add(instruc);
		panellPregunta.add(texte);
		
		AccioDelTextField3 accioTextField = new AccioDelTextField3(this);
		texte.addActionListener(accioTextField);

		this.add(panellPregunta, BorderLayout.CENTER);		
		
		missatge=new JTextArea("Resultat de la consulta:\n");
		missatge.setSize(this.getWidth(), 200);
		JScrollPane scroll=new JScrollPane(missatge);
		this.add(scroll, BorderLayout.SOUTH);
		
		JButton n = new JButton("Hola");
		//n.setText(titol);
		this.add(n, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	public void hiHaNumBlancs(int numBlancs) {
		int num=0;
		for (int i=0; i<dim; i++)
			for (int j=0; j<dim; j++) {
				if (graella[i][j].getBackground().equals(Color.white)) num++;
			}
		if (num==numBlancs) {
			// l'usuari ha encertat el numero de caselles en blanc
			missatge.append("\nHAS ENCERTAT EL NUMERO DE CASELLES EN BLANC");
		} else {
			// s'ha equivocat amb el numero de caselles en blanc
			missatge.append("\nERROR no hi ha "+numBlancs+" caselles");
		}
	}

	public static void main(String[] args) {
		// Demanar dades a l'usuari.
		String num = JOptionPane.showInputDialog("Indica dimensio del tauler a crear");
		while (num == null || num.equals("")) {
			// Missatge d'error. No controlat si entren lletres enlloc de valor numeric
			JOptionPane.showMessageDialog(null, "Cal un valor enter!", "ERROR", JOptionPane.ERROR_MESSAGE);
			num = JOptionPane.showInputDialog("Indica dimensio del tauler a crear");
		}
		new AplicacioV2("Tauler B/N v2", Integer.parseInt(num));

	}

}
