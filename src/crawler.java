import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Jsoup;
// Áö´Ï¹ÂÁ÷
public class crawler {
	public static void main(String[] args) {
		String url = "https://www.genie.co.kr/chart/top200";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String url2 = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20201122&hh=17&rtm=Y&pg=2";
		Document doc2 = null;
		
		try {
			doc2 = Jsoup.connect(url2).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select("tr.list");
		Elements element2 = doc2.select("tr.list");
		System.out.println("=======================================================");
		
		Iterator<Element> ie1 = element.select("td.number").iterator();
		Iterator<Element> ie2 = element.select("a.title.ellipsis").iterator();
		Iterator<Element> ie3 = element.select("a.artist.ellipsis").iterator();
		
		Iterator<Element> ie11 = element2.select("td.number").iterator();
		Iterator<Element> ie22 = element2.select("a.title.ellipsis").iterator();
		Iterator<Element> ie33 = element2.select("a.artist.ellipsis").iterator();
		
		while(ie1.hasNext()) {
			System.out.println(ie1.next().text() + "\t" + ie2.next().text() + " : " + ie3.next().text());
		}
		while(ie11.hasNext()) {
			System.out.println(ie11.next().text() + "\t" + ie22.next().text() + " : " + ie33.next().text());
		}
		System.out.println("=======================================================");
		
	}
	
}
