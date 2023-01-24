package InterficieGrafica;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream {
	
	JTextArea consola;
	
	public CustomOutputStream(JTextArea textoConsola) {
		consola = textoConsola;
	}

	@Override
	public void write(int b) throws IOException {
		consola.append(String.valueOf((char)b));
		consola.setCaretPosition(consola.getDocument().getLength());
	}

}
