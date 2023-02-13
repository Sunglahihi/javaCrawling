import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Jsoup;
// ºôº¸µå tlqkf ¾ÈÇØ

public class Billboard {
	public static void main(String[] args) {
		String url = "https://www.billboard.com/charts/hot-100";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements element = doc.select("ol.chart-list__element.display--flex");
		System.out.println("=======================================================");
		
		Iterator<Element> ie1 = element.select("span.chart-element__rank__number").iterator();
		Iterator<Element> ie2 = element.select("span.chart-element__information__song.text--truncate.color--primary").select("span").iterator();
		Iterator<Element> ie3 = element.select("span.chart-element__information__artist.text--truncate.color--secondary").select("span").iterator();
		
		while(ie1.hasNext()) {
			System.out.println(ie1.next().text() + " \t" + ie2.next().text() + " : " + ie3.next().text());
		}
		System.out.println("=======================================================");
		
	}
	
}
