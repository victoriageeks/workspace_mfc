package application;
import data.*;

public class NewsAnalysis {

	public static void main(String[] args) {
	    ListNews tarracoNews = new ListNews("tarraco",10);
	    
	    OnlineNews n1 = new OnlineNews("Puja atur","Economia");
	    n1.incVisits(200); n1.incSecondsVisit(80*200);
	    
	    HomePageNews n2 = new HomePageNews("Arriben els reis mags");
	    n2.incVisits(25000); n2.incSecondsVisit(65*25000); n2.incDay();
	    
	    OnlineNews n3 = new OnlineNews("El Nastic guanya","Sport");
	    n3.incVisits(16000); n3.incSecondsVisit(30*16000);

	    OnlineNews n4 = new OnlineNews("Nou museu","Cultura");
	    n4.incVisits(5000); n4.incSecondsVisit(70*5000);

	    OnlineNews n5 = new OnlineNews("Bany de Sant Silvestre","Sport");
	    n5.incVisits(8000); n5.incSecondsVisit(70*8000);

	    HomePageNews n6 = new HomePageNews("Les rebaixes a punt");
	    n6.incVisits(11000); n6.incSecondsVisit(75*11000); n6.incDay();
	    
	    tarracoNews.add(n1); tarracoNews.add(n2); tarracoNews.add(n3);
	    tarracoNews.add(n4); tarracoNews.add(n5);

	    ListNews populars = tarracoNews.popularNews();
	    System.out.println(populars);
	    
	    System.out.println("Noticia mes llegida: "+tarracoNews.mostRead());
	    
	    
	    
	    
	}

}
