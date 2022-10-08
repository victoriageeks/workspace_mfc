package aplicacio;
import java.io.*;
import dades.Densitat;

public class LlegirBinari {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream fitxer = new ObjectInputStream(new FileInputStream("Densitats.bin"));
		Densitat instancia;
		boolean llegit = false;

		while (!llegit) {
			try {
				instancia = (Densitat) fitxer.readObject();
				System.out.println(instancia);
			} catch (EOFException e) {
				llegit = true;
			}
		}
		fitxer.close();
	}
}
