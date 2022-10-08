package aplicacio;
import dades.*;
import java.io.*;

public class Serializer {

	public static void main(String[] args) throws ObjectStreamException {
		Terreny t1 = new Terreny("ArbreSolana", "Acer pseudoplatanus", 210);
		t1.addPlant("Pinus sylvestris", 150);
		t1.addPlant("Pinus Nigra", 130);
		t1.addPlant("Fraxinus excelsior", 220);
		t1.addPlant("Populus nigra", 190);
		Terreny t2 = new Terreny("ArbustusObaga", "Corylus Avellana", 200);
		t2.addPlant("Spartium junceum", 190);
		t2.addPlant("Erica multiflora", 160);
		t2.addPlant("Genista Scorpius", 180);
		t2.addPlant("Fornite bush", 170);
		Terreny t3 = new Terreny("InclusivusTerrenus", "Quercus ilex", 200);
		t3.addPlant("Populus nigra", 185);
		t3.addPlant("Betula Alba", 170);
		t3.addPlant("Free Fire Friday", 140);
		t3.addPlant("Pubg bush", 160);
		
		LlistaTerrenys terrainList = new LlistaTerrenys();
		terrainList.addTerreny(t1);
		terrainList.addTerreny(t2);
		terrainList.addTerreny(t3);
		
		System.out.println("GUARDANT ....");
		storeData(terrainList);
	}
	
	public static void storeData (LlistaTerrenys list) {
		ObjectOutputStream outputFile;
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream("terrenys.ser"));
			for (int i=0; i<list.getnElem(); i++) {
				outputFile.writeObject(list.getTerrenys()[i]);
			}
			outputFile.close();
		}
		catch (IOException e) {
			System.out.println("Error en l'arxiu de sortida.");
		}
	}
	
	//TODO
	//5 Que pida algo, cambiar string terrenys


}
