package data;

public class HomePageNews extends OnlineNews {

	private int daysInHomePage;
	
	public HomePageNews(String title) {
		super(title, "Home Page");
		daysInHomePage=0;
	}
	
	public void incDay() {
		daysInHomePage++;
	}
	
	public int getDaysHomePage () {
		return daysInHomePage;
	}
	
	@Override
	public boolean isPopular() {
		if (numVisits>10000*daysInHomePage && secondsRead()>60)  return true;
		else return false;	
	}
	
	public HomePageNews copy() {
		HomePageNews c = new HomePageNews(title);
		c.numVisits=super.numVisits;
		c.secTotal=super.secTotal;
		c.daysInHomePage=this.daysInHomePage;
		return c;
	}

	public String toString() {
		return (super.toString()+" days in home: "+daysInHomePage);
	}
}
