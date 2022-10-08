package grafics;
import javax.swing.*;

import aplicacio.main;

import java.awt.*;
//import javax.imageio.ImageIO;
import dades.*;

public class FinestraDadesPlantacio extends JFrame{
	private static final long serialVersionUID=1L;
	
	
	
	public FinestraDadesPlantacio(String titol,Plantacions plantation) {
		super(titol);
		this.setBounds(100,200,500,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblAnyDeLa = new JLabel("Any de la plantacio");
		lblAnyDeLa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblAnyDeLa);
		
		JLabel lblSuperficieTotal = new JLabel("Superficie total");
		springLayout.putConstraint(SpringLayout.NORTH, lblSuperficieTotal, 52, SpringLayout.SOUTH, lblAnyDeLa);
		springLayout.putConstraint(SpringLayout.WEST, lblSuperficieTotal, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAnyDeLa, 0, SpringLayout.WEST, lblSuperficieTotal);
		lblSuperficieTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblSuperficieTotal);
		
		JLabel lblNumeroDarbres = new JLabel("Numero d'arbres");
		springLayout.putConstraint(SpringLayout.WEST, lblNumeroDarbres, 22, SpringLayout.WEST, getContentPane());
		lblNumeroDarbres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNumeroDarbres);
		
		JLabel lblNewLabel = new JLabel("Nom de la plantacio");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnyDeLa, 47, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 31, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.WEST, getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNumeroDarbustos = new JLabel("Numero d'arbustos");
		springLayout.putConstraint(SpringLayout.WEST, lblNumeroDarbustos, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNumeroDarbres, -46, SpringLayout.NORTH, lblNumeroDarbustos);
		lblNumeroDarbustos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNumeroDarbustos);
		
		JLabel lblNewLabel_5 = new JLabel("Quantitat de CO2");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNumeroDarbustos, -44, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -69, SpringLayout.SOUTH, getContentPane());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel(plantation.getName());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 72, SpringLayout.EAST, lblNewLabel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new Integer(plantation.getYear()).toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblAnyDeLa);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_2);
		//lista de plantas y su tamaño
		String[] terrainAux = main.plantationList.getPlantation(plantation.getName()).getTerrain();
		Terreny aux = new Terreny("opcio 5");
		for(int i=0; i<terrainAux.length;i++){
			 
			 String[] plantAux = main.terrainList.getTerreny(terrainAux[i]).getPlants();
			 for(int j=0; j<plantAux.length;j++){
				 double unitats = main.terrainList.getTerreny(terrainAux[i]).getHaPLantsMario(j);
				 double superficie = main.plantationList.getPlantation(plantation.getName()).getStandAreaMario(i);
				 double mult = unitats*superficie;
				 //System.out.println(plantAux[j]);
				 //System.out.println(unitats);
				 //System.out.println(superficie);
				 aux.addPlantIsmael(plantAux[j], mult);
				 //System.out.println(aux.toString());
			 }
		}
		
		//
		double suma=0;
		double rodal=0;
		String[] terrainAux2 = main.plantationList.getPlantation(plantation.getName()).getTerrain();
		int yearAux = main.any - main.plantationList.getPlantation(plantation.getName()).getYear();
		for(int i=0; i<terrainAux2.length;i++){
			 String[] plantAux = main.terrainList.getTerreny(terrainAux2[i]).getPlants();
			 for(int j=0; j<plantAux.length;j++){
				 System.out.println(plantAux[j]);
				 rodal+=main.plantList.getPlanta(plantAux[j]).getAbsortion(yearAux) * main.terrainList.getTerreny(terrainAux2[i]).getHaPLantsMario(j) * main.plantationList.getPlantation(plantation.getName()).getStandAreaMario(i);
			 }
			 suma+=rodal;
			 rodal=0;
		}

		
		
		//Calcular superficie total
		JLabel lblNewLabel_3 = new JLabel(new Double(plantation.totalArea()).toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblSuperficieTotal);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_3);
		
		//numero de arboles
		JLabel lblNewLabel_4 = new JLabel(new Double(aux.countTrees()).toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNumeroDarbres);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_4);
		//numero de arbustos
		JLabel lblNewLabel_6 = new JLabel(new Double(aux.countBush()).toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNumeroDarbustos);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_6);
		//Quantitat de CO2
		JLabel lblNewLabel_8 = new JLabel(new Double(suma).toString());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_8);
	}
	
	public void start() {
		this.setVisible(true);
	}

}
