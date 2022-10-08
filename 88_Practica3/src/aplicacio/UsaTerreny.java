package aplicacio;
import dades.*;
/**
 * @author Jordi and ismael and edgar
 */
public class UsaTerreny {

	public static void main(String[] args) {
		
		LlistaPlantes terreny = new LlistaPlantes(new Arbre("Pinus sylvestris",2018,new int[]{5,10},new int[] {180,250}));
		terreny.addPlant(new Arbre("Pinus nigra",2018,new int[]{5,10},new int[] {190,270}));
		terreny.addPlant(new Arbre("Fraxinus excelsior",2018,new int[]{5,8,15},new int[] {230,300,390}));
		terreny.addPlant(new Arbre("Acer pseudoplatanus",2018,new int[]{5,8},new int[] {245,390}));
		terreny.addPlant(new Arbre("Populus nigra",2018,new int[]{4,7,14},new int[] {190,340,430}));
		
		int[] hecta= {150,130,220,210,190};
		
		Terreny terrain= new Terreny("CalcariSolana",2.18,terreny,hecta);
		
		System.out.println(terrain.toString());

	}

}
