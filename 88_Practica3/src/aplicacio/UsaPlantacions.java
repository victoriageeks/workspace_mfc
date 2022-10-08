package aplicacio;
import dades.*;
/**
 * @author Jordi and Ismael
 */
public class UsaPlantacions {

	public static void main(String[] args) {
		LlistaPlantacions llistaPlantacions = new LlistaPlantacions(plantaciones2(2018,"Finca les pedres"));
		llistaPlantacions.addPlantacion(plantaciones(2015,"Els trossos"));
		System.out.println(llistaPlantacions.toString());
	}
	
	public static Plantacions plantaciones(int year,String name) {
		LlistaTerrenys plantacion = new LlistaTerrenys(CalcariSolana(year,5.4));
		plantacion.addTerreny(CalcariObaga(year,8.5));
		plantacion.addTerreny(CalcariSolana(year,13));
		plantacion.addTerreny(CalcariObaga(year,8.75));
		plantacion.addTerreny(CalcariSolana(year,24));
		return new Plantacions(name,year,plantacion);
	}
	
	public static Plantacions plantaciones2(int year,String name) {
		LlistaTerrenys plantacion = new LlistaTerrenys(CalcariSolana(year,2.18));
		plantacion.addTerreny(CalcariObaga(year,0.97));
		plantacion.addTerreny(CalcariSolana(year,1.5));
		plantacion.addTerreny(CalcariSolana(year,12.5));
		return new Plantacions(name,year,plantacion);
	}
	
	public static Terreny CalcariSolana(int year, double S) {
		LlistaPlantes terreny = new LlistaPlantes(new Arbre("Pinus sylvestris",year,new int[]{5,10},new int[] {180,250}));
		terreny.addPlant(new Arbre("Pinus nigra",year,new int[]{5,10},new int[] {190,270}));
		terreny.addPlant(new Arbre("Fraxinus excelsior",year,new int[]{5,8,15},new int[] {230,300,390}));
		terreny.addPlant(new Arbre("Acer pseudoplatanus",year,new int[]{5,8},new int[] {245,390}));
		terreny.addPlant(new Arbre("Populus nigra",year,new int[]{4,7,14},new int[] {190,340,430}));
		
		int[] hecta= {150,130,220,210,190};
		
		Terreny terrain= new Terreny("CalcariSolana",S,terreny,hecta);
		return terrain;
	}
	
	public static Terreny CalcariObaga(int year, double S) {
		LlistaPlantes terreny = new LlistaPlantes(new Arbre("Pinus sylvestris",year,new int[]{5,10},new int[] {180,250}));
		terreny.addPlant(new Arbust("Colirus abegalla",year,110));
		terreny.addPlant(new Arbust("Spartium junceum",year,85));
		terreny.addPlant(new Arbre("Quercus ilex",year,new int[]{4,6,10},new int[] {210,374,402}));
		terreny.addPlant(new Arbre("Betula alba",year,new int[]{4,7,12},new int[] {190,324,420}));
		
		int[] hecta= {190,200,150,200,160};
		
		Terreny terrain= new Terreny("CalcariObaga",S,terreny,hecta);
		return  terrain;
	}
}
