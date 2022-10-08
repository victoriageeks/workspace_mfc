package EstructuraDades;

public class Punt implements Comparable<Punt> {
	private int x;
	private int y;
	
	public Punt(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punt [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compareTo(Punt p) {
		// this<p => -1
		// opcio a, ordenem pel seu modul
		
		double modThis=0, modP=0;
		modThis=Math.sqrt(x*x+y*y);
		modP=Math.sqrt(p.x*p.x+p.y*p.y);
		if (modThis<modP) return(-1);
		else if (modThis==modP) return(0);
		else return(1);
		
		// opcio b, ordenem per la component x
		/*
		if (this.x<p.x) return (-1);
		else if (this.x==p.x) return(0);
		else return(1);
		*/
		// opcio c, ordenem per la component y
		/*
		if (this.y<p.y) return (-1);
		else if (this.y==p.y) return(0);
		else return(1);
		*/
	}
	
	
}
