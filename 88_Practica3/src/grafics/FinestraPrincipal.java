package grafics;
import dades.*;
import aplicacio.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinestraPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action_1 = new SwingAction_1();


	/**
	 * Create the frame.
	 */
	public FinestraPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("PLANTACIONS");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 17, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 156, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -205, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -145, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 11, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 44, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -66, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -32, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Any");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 214, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 49, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		Integer inter = new Integer(main.any);
		textField = new JTextField(inter.toString());
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 46, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 93, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -1, SpringLayout.WEST, textField);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton(">5M");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -6, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -358, SpringLayout.EAST, contentPane);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.GREEN);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(">1M");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -6, SpringLayout.NORTH, lblNewLabel_1);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.ORANGE);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<1M");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, btnNewButton_2);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(Color.RED);
		contentPane.add(btnNewButton_3);
		
		JButton[] plantacions2 = new JButton[main.plantationList.getnElem()];
		AccionsBotons accioBoto = new AccionsBotons();

		for(int i =0; i<main.plantationList.getnElem(); i++){
			
			plantacions2[i]=new JButton(main.plantationList.getPlantacions()[i].getName());
			
			double suma=0;
			double rodal=0;
			String[] terrainAux2 = main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getTerrain();
			int yearAux = new Integer(textField.getText()) - main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getYear();
			for(int j=0; j<terrainAux2.length;j++){
				 String[] plantAux = main.terrainList.getTerreny(terrainAux2[j]).getPlants();
				 for(int k=0; k<plantAux.length;k++){
					 rodal+=main.plantList.getPlanta(plantAux[k]).getAbsortion(yearAux) * main.terrainList.getTerreny(terrainAux2[j]).getHaPLantsMario(k) * main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getStandAreaMario(j);
				 }
				 suma+=rodal;
				 rodal=0;
			}
			
			
			plantacions2[i].addActionListener(accioBoto);
			if(suma<1000000) {
				plantacions2[i].setBackground(Color.RED);
			}else if(suma>1000000 && suma<5000000) {
				plantacions2[i].setBackground(Color.ORANGE);
			}else if(suma>5000000) {
				plantacions2[i].setBackground(Color.GREEN);
			}
			
			panel.add(plantacions2[i]);
		}
		
		JButton btnNewButton = new JButton("Actualitzar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newAge= Integer.parseInt(textField.getText());
				main.setAny(newAge);
				for (int i = 0; i < plantacions2.length; i++) {
					
					double suma=0;
					double rodal=0;
					String[] terrainAux2 = main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getTerrain();
					int yearAux =  Integer.parseInt(textField.getText()) - main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getYear();
					for(int j=0; j<terrainAux2.length;j++){
						 String[] plantAux = main.terrainList.getTerreny(terrainAux2[j]).getPlants();
						 for(int k=0; k<plantAux.length;k++){
							 rodal+=main.plantList.getPlanta(plantAux[k]).getAbsortion(yearAux) * main.terrainList.getTerreny(terrainAux2[j]).getHaPLantsMario(k) * main.plantationList.getPlantation(main.plantationList.getPlantacions()[i].getName()).getStandAreaMario(j);
						 }
						 suma+=rodal;
						 rodal=0;
					}
					
					if(suma<1000000) {
						plantacions2[i].setBackground(Color.RED);
					}else if(suma>1000000 && suma<5000000) {
						plantacions2[i].setBackground(Color.ORANGE);
					}else if(suma>5000000) {
						plantacions2[i].setBackground(Color.GREEN);
					}
					panel.add(plantacions2[i]);
				}
				
			}
		});
		btnNewButton.setAction(action_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -37, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -111, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -1, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
	}
	

	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Actualitzar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
