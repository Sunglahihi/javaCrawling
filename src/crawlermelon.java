import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//¸á·Ð¹ÂÁ÷
public class crawlermelon {
	public static void main(String[] args) {
		String url = "https://www.melon.com/chart/day/index.htm";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements element = doc.select("tr.lst50");
		System.out.println("=======================================================");
		
		Iterator<Element> ie1 = element.select("span.rank").iterator();
 		Iterator<Element> ie2 = element.select("div.ellipsis.rank01").iterator();
		Iterator<Element> ie3 = element.select("div.ellipsis.rank02").select("span").iterator();
		Iterator<Element> ie4 = element.select("span.rank_wrap").iterator();
		
		while(ie1.hasNext()) {
			System.out.println(ie1.next().text() + "À§ >> " + ie4.next().text() + "\t" +ie2.next().text() + " : " + ie3.next().text());
		}
		System.out.println("=======================================================");
		
	}
	
}
