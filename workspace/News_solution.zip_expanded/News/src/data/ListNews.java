package data;

public class ListNews {

	private String newspaper;
	private OnlineNews[] list;
	private int numNews;
	
	public ListNews(String name, int size) {
		newspaper=name;
		list=new OnlineNews[size];
		numNews=0;
	}
	
	public void add(OnlineNews n) {
		if (numNews<list.length) {
			list[numNews]=n.copy();
			numNews++;
		}
	}
	
	public ListNews popularNews () {
		ListNews popular = new ListNews(newspaper,numNews);
		for (int i=0; i<numNews; i++) {
			if (list[i].isPopular())  popular.add(list[i]);		
		}
		return popular;
	}
	
	public OnlineNews mostRead() {
		int maxRead=0;
		OnlineNews result=null;
		for (int i=0; i<numNews; i++) {
			if (list[i].secondsRead()>maxRead) {
				maxRead=list[i].secondsRead();
				result=list[i];
			}
		}
		return result;
	}
	
	
	public String toString() {
		String result="";
		for (int i=0; i<numNews; i++) {
			result=result+list[i]+"\n";
		}
		return result;
	}
	

}
