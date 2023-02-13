import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Jsoup;
// ¹÷½º¹ÂÁ÷
public class crawlerbugs {
	public static void main(String[] args) {
		String url = "https://music.bugs.co.kr/chart";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements element = doc.select("tr");
		System.out.println("=======================================================");
		
		Iterator<Element> ie1 = element.select("div.ranking").iterator();
		Iterator<Element> ie2 = element.select("p.title").iterator();
		Iterator<Element> ie3 = element.select("p.artist").iterator();
		
		while(ie1.hasNext()) {
			System.out.println(ie1.next().text() + " \t" + ie2.next().text() + " : " + ie3.next().text());
		}
		System.out.println("=======================================================");
		
	}
	
}
