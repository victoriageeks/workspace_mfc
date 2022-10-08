package data;

public class OnlineNews implements NewsBehaviour {

	protected String title;
	protected String section;
	protected int numVisits;
	protected int secTotal;
	
	
	public OnlineNews(String title, String section) {
		this.title=title; this.section=section;
		numVisits=0; secTotal=0;
	}

	@Override
	public boolean isPopular() {
		if ( (section.equalsIgnoreCase("Sport")) && (numVisits>10000) )
				return true;
		if (numVisits>500 && secondsRead()>60)  
			return true;
		return false;
	}

	@Override
	public int secondsRead() {
		return secTotal/numVisits;
	}
	
	public void incVisits(int v) {
		numVisits=numVisits+v;
	}
	
	public void incSecondsVisit(int sec) {
		secTotal=secTotal+sec;
	}
	
	public OnlineNews copy() {
		OnlineNews c= new OnlineNews(title, section);
		c.secTotal=this.secTotal;
		c.numVisits=this.numVisits;
		return c;
	}
	
	public String toString() {
		return (title+" - "+section+" - num visits: "+numVisits+" total time: "+secTotal);
	}

}
