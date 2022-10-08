package aplicacio;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;
import dades.*;
import grafics.*;
import java.util.InputMismatchException;

public class main {
	public static LlistaPlantes plantList = new LlistaPlantes();
	public static LlistaPlantacions plantationList = new LlistaPlantacions();
	public static LlistaTerrenys terrainList = new LlistaTerrenys();
	public static int any = 0;
	static File plants, terrains;

	public static void main(String[] args) throws FileNotFoundException{		
		
		File f;
		boolean exit = false;
		int option = 0;
		Scanner leer=new Scanner(System.in);
		Scanner keyboard=new Scanner(System.in);
		

		 do{ 
			try{
			System.out.println("Introdueix l'any actual");
			any = leer.nextInt();
			if(any<1)
				 throw new ExceptionOption("Error: Valor invalid"); 
			}catch(ExceptionOption ea){
				System.out.println(ea.getMessage());
			}
		 }while(any<1);

		 
		 while(!exit){
			menu();
			try{
				System.out.println("Introdueix que vols fer");
				option = leer.nextInt();
				if(option<0 || option>14)
					throw new ExceptionOption("Error: no existeix aquesta opcio."); 
				switch(option){
					case 1:
						opcio1();
						FinestraPrincipal ventana1 = new FinestraPrincipal();
						ventana1.setVisible(true);
						break;
					case 2:
						opcio2();
						break;
					case 3:
						opcio3();
						break;
					case 4:
						System.out.println("Introdueix: el nom del terreny");
						opcio4(keyboard.nextLine());
						break;
					case 5:
						System.out.println("Introdueix: el nom de la plantaci�");
						opcio5(keyboard.nextLine());
						break;
					case 6:
						opcio6();
						break;
					case 7:
						System.out.println("Introdueix: nom de la especie i una edat");
						opcio7(keyboard.nextLine(),keyboard.nextInt());
						break;
					case 8:
						opcio8();
						break;
					case 9:
						keyboard.nextLine();
						System.out.println("Introdueix: nom de la Plantacio a esborrar");
						opcio9(keyboard.nextLine());
						break;
					case 10:
						System.out.println("Introdueix: nom de la Plantacio i any nou de la Plantacio");
						opcio10(keyboard.nextLine(),keyboard.nextInt());
						break;
					case 11:
						keyboard.nextLine();
						System.out.println("Introdueix: nom de la Plantacio, numero del Rodal i Superficie nova del rodal");
						opcio11(keyboard.nextLine(),keyboard.nextInt(),keyboard.nextDouble());
						break;
					case 12:
						System.out.println("Introdueix: el nou any");
						opcio12(keyboard.nextInt());
						break;
					case 13:
						keyboard.nextLine();
						System.out.println("Introdueix: nom de la Plantacio");
						opcio13(keyboard.nextLine());
						break;
					case 14:
						keyboard.nextLine();
						System.out.println("Introdueix: el nom de l'especie");
						opcio14(keyboard.nextLine());
						break;
					case 0:
						exit();
						exit=true;
						break;
				}
			}catch(InputMismatchException e){
				System.out.println("Has d'escollir una opci�");
				leer.next();
			}catch(ExceptionOption ea){
				System.out.println(ea.getMessage());	
			}

			}
			 
		 }
	
		 

	private static void menu(){
		System.out.println("1: Carregar dades dels fitxers.");
		System.out.println("2: Llistar les dades de tots els tipus de terreny.");
		System.out.println("3: Llistar les dades de totes les plantacions");
		System.out.println("4: Llistar les dades de les plantacions que tenen algun rodal d'un tipus de terreny.");
		System.out.println("5: Mostrar quantes de cada especie s'hi ha plantat en una plantacio.");
		System.out.println("6: Llistar les dades de totes les esp�cies.");
		System.out.println("7: Mostrar la quantitat de CO2 que permet absorbir una especies a una edat.");
		System.out.println("8: Afegir una nova especie de planta.");
		System.out.println("9: Esborrar les dades d'una plantacio.");
		System.out.println("10: Modificar l'any de plantacio d'una plantacio.");
		System.out.println("11: Modificar les dades d'un rodal d'una plantacio.");
		System.out.println("12: Modificar any en que ens trobem.");
		System.out.println("13: Mostrar la quantitat de CO2 que permet absorbir cada rodal d'una plantacio.");
		System.out.println("14: Mostrar la quantitat de CO2 que permet absorbir el conjunt d'unitats plantades d'una especie.");
		System.out.println("0: Sortir");					
	}
	

	private static void opcio1(){
		System.out.println("... CARREGANT FITXER DE PLANTACIONS ...");
		getPlantationFile(selectFile(), plantList, plantationList);
		System.out.println(plantList+"\n"+plantationList);
		System.out.println("... CARREGANT FITXER DE TERRENYS ...");
		getTerrainFile(selectFile(), terrainList);
		System.out.println("\n"+terrainList);

	}
	
	private static void opcio2(){
		System.out.println(terrainList.toString());
	}
	
	private static void opcio3() {
		System.out.println(plantationList.toString());
	}
	
	private static void opcio4(String terrain) {
		System.out.println(plantationList.LlistTypesTerrains(terrain).toString());
	}
	
	private static void opcio5(String plantation) {
		String[] terrainAux = plantationList.getPlantation(plantation).getTerrain();
		Terreny aux = new Terreny("opcio 5");
		for(int i=0; i<terrainAux.length;i++){
			 
			 String[] plantAux = terrainList.getTerreny(terrainAux[i]).getPlants();
			 for(int j=0; j<plantAux.length;j++){
				 double unitats = terrainList.getTerreny(terrainAux[i]).getHaPLantsMario(j);
				 double superficie = plantationList.getPlantation(plantation).getStandAreaMario(i);
				 double mult = unitats*superficie;
				 //System.out.println(plantAux[j]);
				 //System.out.println(unitats);
				 //System.out.println(superficie);
				 aux.addPlantIsmael(plantAux[j], mult);
				 //System.out.println(aux.toString());
			 }
		}
		System.out.println(aux.toString());
		
		
		/*Terreny terrain = plantationList.UnitasXespecie(plantation,terrainList, plantList); 
		System.out.println(terrain.toString());*/
	}
	
	public static int getAny() {
		return any;
	}



	public static void setAny(int any) {
		main.any = any;
	}



	private static void opcio6() {
		System.out.println(plantList.toString());

	}
	
	private static void opcio7(String type, int age) {
		System.out.println(plantList.getPlanta(type).getAbsortion(age));
	}

	private static void opcio8() {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Vols afegir un arbust (b) o un arbre (t)\n--> b            --> t");
		String name;
		String type;
		String type2;

		do{
			type=keyboard.nextLine();

			if(type.equals("b")){
				System.out.println("Introdueix el nom de la espècie: \n");	
				name = keyboard.nextLine();
				System.out.println("Quin és el valor d'absorció de l'arbust:\n");
				int absortion = keyboard.nextInt();
				System.out.println("Quina és la edat de finaliztació d'absorció de Co2 de l'arbust:\n");
				int useless = keyboard.nextInt();
				Planta newP = new Arbust(name, absortion, useless);
				plantList.addPlant(newP);
			}
			else if(type.equals("t")){
				System.out.println("Introdueix el nom de la espècie: \n");	
				name = keyboard.nextLine();
				System.out.println("Quina és la edat mínima en que l'arbre comença a absprbir Co2?:\n");
				int minAge = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Quin és aquest valor d'absorció?:\n");
				int absortion = keyboard.nextInt();
				Planta newP = new Arbre(name, minAge, absortion);
				keyboard.nextLine();
				do{
					System.out.println("Vols afegir un altre interval d'absorció?:\n--> s (Si)            --> n(no)");
					type2=keyboard.nextLine();
					if(type2.equals("s")){
						System.out.println("Quina és la edat mínima d'aquest interval?:\n");
						minAge = keyboard.nextInt();
						keyboard.nextLine();
						System.out.println("Quin és aquest valor d'absorció?:\n");
						absortion = keyboard.nextInt();
						((Arbre)newP).addAbsortion(minAge, absortion);
						keyboard.nextLine();
					}
					else if(type2.equals("n")){
						plantList.addPlant(newP);
					}
					else{
						System.out.println("Introdueix un caràcter acceptat!:\n");
					}	
				}while(!(type2.equals("n")));
			}
			else{
				System.out.println("Introdueix un caràcter acceptat!:\n");	
			}
		}while(!(type.equals("b")) && !(type.equals("t")) );	
	}
		
	private static void opcio9(String plantation) {
		System.out.println("Eliminant la plantacio: "+plantation);
		plantationList.removePlantation(plantation);
		System.out.println(plantationList);
	}
		
	private static void opcio10(String plantation, int age) {
		System.out.println("Modificant any de plantacio");
		plantationList.setPlantationYear(plantation, age);
		System.out.println(plantationList.getPlantation(plantation).getYear());
	}
		
	private static void opcio11(String plantation, int num, double area) {
		System.out.println(plantationList.getPlantation(plantation).getTerrain(num));
		System.out.println("Modificant les dades");
		plantationList.getPlantation(plantation).setStandArea(num, area);
		System.out.println(plantationList.getPlantation(plantation).getTerrain(num));
	}
		
	private static void opcio12(int year) {
		any=year;
	}
	
	private static void opcio13(String plantation) {
		double suma=0;
		double rodal=0;
		String[] terrainAux = plantationList.getPlantation(plantation).getTerrain();
		int yearAux = any - plantationList.getPlantation(plantation).getYear();
		for(int i=0; i<terrainAux.length;i++){
			 String[] plantAux = terrainList.getTerreny(terrainAux[i]).getPlants();
			 for(int j=0; j<plantAux.length;j++){
				 System.out.println(plantAux[j]);
				 rodal+=plantList.getPlanta(plantAux[j]).getAbsortion(yearAux) * terrainList.getTerreny(terrainAux[i]).getHaPLantsMario(j) * plantationList.getPlantation(plantation).getStandAreaMario(i);
			 }
			 System.out.println("la quantitat del rodal ["+i+"] es: "+rodal);
			 suma+=rodal;
			 rodal=0;
		}
		System.out.println("La quantitat total dels rodals es: "+suma);
	}
	
	private static void opcio14(String species) {
		double resultado=0;
		for(int x=0; x<plantationList.getnElem();x++){
			String[] terrainAux2 = plantationList.getPlantacionsFromIndex(x).getTerrain();
			int yearAux2 = any - plantationList.getPlantacionsFromIndex(x).getYear();
			for(int i=0; i<terrainAux2.length;i++){
				String[] plantAux2 = terrainList.getTerreny(terrainAux2[i]).getPlants();
				for(int j=0; j<plantAux2.length;j++){
					if(plantAux2[j].equalsIgnoreCase(species)){
						double unitats = terrainList.getTerreny(terrainAux2[i]).getHaPLantsMario(j);
				 		double superficie = plantationList.getPlantacionsFromIndex(x).getStandAreaMario(i);
				 		int getAbs = plantList.getPlanta(species).getAbsortion(yearAux2);
				 		double mult = unitats*superficie*getAbs;
				 		resultado+=mult;
					}
				}
			}
		}
		System.out.println("La quantitat de CO2 que absorbeix ["+ species+"] es de: "+resultado);
	}
	
	
	private static void opcio0(File f) {
	
	}

	private static void exit(){
		Scanner leer=new Scanner(System.in);
		String type;
		do{
			try{
				System.out.println("Vols guardar la nova informacio als fitxers?\n--> s (Si)            --> n (no)");
				type = leer.nextLine();
				if(type.equals("s")){
					storeObj();
				}

				
			}catch(InputMismatchException e){
				leer.next();
				System.out.println("Deus (JISUS CRAIS) escollir una opcio");
			}
		}while(!(type.equals("s")) && !(type.equals("n")));

	}

	
	private static File selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		return (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) ? fileChooser.getSelectedFile() : null;
	}
	
	private static void getPlantationFile(File f, LlistaPlantes plantList, LlistaPlantacions plantationList ){
		try {
			/**	Estructura Fitxer
			* 0- t=(arbre) o b=(arbust)	o p=(plantacio)	
			* 1- Nom
			* 2- Edad Naixement
			* 3- minThresholdArbre o absorcioArbust
			* 4- absorcioArbre o edadUselessArbust
			* 5- etc
			* 6- 
			**/
			String[] aux;
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				aux=sc.nextLine().split(";");
				switch(aux[0]){
					case "b":
						Arbust bush = new Arbust(aux[1],Integer.parseInt(aux[2]),Integer.parseInt(aux[3]));
						plantList.addPlant(bush);
						break;
					
					case "t":	
						Arbre tree = new Arbre(aux[1],Integer.parseInt(aux[2]),Integer.parseInt(aux[3]));
						int x=4;
						do{
							tree.addAbsortion(Integer.parseInt(aux[x]),Integer.parseInt(aux[x+1]));
							x+=2;
						}while(x+2<=aux.length);
						plantList.addPlant(tree);
						break;
				
					case "p": 
						Plantacions plantation = new Plantacions(aux[1],Integer.parseInt(aux[2]), aux[3], Double.parseDouble(aux[4]));
						int p=5;
						do{
							plantation.add(aux[p], Double.parseDouble(aux[p+1]));
							p+=2;
						}while(p+2<=aux.length);
						plantationList.addPlantation(plantation);
						break;
					
					default:
						break;
					
				}
				
			}
			sc.close();
			plants = f;
			
		} catch (FileNotFoundException error) {
			System.out.println("Hi ha hagut un error");
            error.getMessage();
		}
	}
	
	private static void getTerrainFile(File f, LlistaTerrenys terrainList){
		ObjectInputStream inputFile;
		try {
			inputFile = new ObjectInputStream(new FileInputStream(f.getName()));
			for (int i=0; i<3; i++) {
				terrainList.addTerreny((Terreny)inputFile.readObject());
			}
			inputFile.close();
			terrains=f;
		}
		catch (IOException e) {
			System.out.println("Error en l'arxiu d'entrada.");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error, no es troba la classe Terreny."+e);
		}
		catch (ClassCastException e){
		System.out.println("Error, el format de l'arxiu no �s correcte per la definici� actual de la classe Terreny."+e);
		}
	}
	
	private static void storeObj () {
		ObjectOutputStream outputFile;
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream(terrains.getName()));
			for (int i=0; i<terrainList.getnElem(); i++) {
				outputFile.writeObject(terrainList.getTerrenys()[i]);
			}
			outputFile.close();
		}
		catch (IOException e) {
			System.out.println("Error en l'arxiu de sortida.");
		}
	}
	
	
	private static void storeInfo() {
		try {
			FileWriter writer = new FileWriter(plants.getName());
		    for (int i = 0; i < plantList.getnElem(); i++) {
				if(plantList.getPlants()[i] instanceof Arbust) {
					writer.write("b;"+plantList.getPlants()[i].getName()+";"+plantList.getPlants()[i].getAbsortion()+";"+((Arbust)plantList.getPlants()[i]).getUseless());
				
				}else{
					String auxFile = ("t;"+plantList.getPlants()[i].getName());
					for(int x=0; x<((Arbre)plantList.getPlants()[i]).getminimThreshold().length; x++){
						auxFile+= (";"+((Arbre)plantList.getPlants()[i]).getminimThreshold()[x]+";"+((Arbre)plantList.getPlants()[i]).getAbsortionList()[x]);	
					}
					writer.write(auxFile);
				}
			}    
		    
		    for (int j = 0; j < plantationList.getnElem(); j++) {
			    String auxFile=("p;"+plantationList.getPlantacions()[j].getName()+";"+plantationList.getPlantacions()[j].getYear());
			    for (int i = 0; i < plantationList.getPlantacions()[j].getTerrain().length; i++) {
					auxFile+=(";"+plantationList.getPlantacions()[j].getTerrain()[i]+";"+plantationList.getPlantacions()[j].getStandArea()[j]);
				}
		    	writer.write(auxFile);
			}
		}catch (IOException e) {
		    System.out.println("Oh man");
		    e.printStackTrace();
		}
	}


}
