import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
class SubFrameMelon extends JFrame {
	public class Addmelon extends JPanel{
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("C:\\Users\\parksm\\eclipse-workingspace\\Scrapping\\src\\image\\meloning.PNG");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);}
	}
	public SubFrameMelon() {
		setTitle("멜론차트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel jp = new Addmelon();
		setContentPane(jp);
		JTextArea txtA = new JTextArea(50,60);
		JScrollPane scroll = new JScrollPane(txtA);
		jp.add(scroll);
		txtA.setEditable(false);
		setSize(800,1000);
		
		String url = "https://www.melon.com/chart/day/index.htm";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Elements element = doc.select("tr.lst50");
		Elements element2 = doc.select("tr.lst100");
		
		Iterator<Element> ie1 = element.select("span.rank").iterator();
		Iterator<Element> ie2 = element.select("div.ellipsis.rank01").iterator();
		Iterator<Element> ie3 = element.select("div.ellipsis.rank02").select("span").iterator();
		Iterator<Element> ie4 = element.select("span.rank_wrap").iterator();
		
		Iterator<Element> ie11 = element2.select("span.rank").iterator();
		Iterator<Element> ie22 = element2.select("div.ellipsis.rank01").iterator();
		Iterator<Element> ie33 = element2.select("div.ellipsis.rank02").select("span").iterator();
		Iterator<Element> ie44 = element2.select("span.rank_wrap").iterator();
	
		while(ie1.hasNext()) {	
			txtA.append("\n"+ie1.next().text() + "  " + ie4.next().text() + "   " +ie2.next().text() + " ~ " + ie3.next().text()+"\n"+"-----------------");
		}
		while(ie11.hasNext()) {	
			txtA.append("\n"+ie11.next().text() + "  " + ie44.next().text() + "   " +ie22.next().text() + " ~ " + ie33.next().text()+"\n"+"-----------------");
		}
		txtA.setCaretPosition(txtA.getDocument().getLength());
		setLocation(300,0);
		setVisible(true);
	}
	
}
class SubFrameBugs extends JFrame {
	public class AddBugs extends JPanel{
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("C:\\Users\\parksm\\eclipse-workingspace\\Scrapping\\src\\image\\bugss.PNG");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);}
	}
	public SubFrameBugs() {
		setTitle("벅스차트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel jp = new AddBugs();
		setContentPane(jp);
		JTextArea txtA = new JTextArea(50,60);
		JScrollPane scroll = new JScrollPane(txtA);
		jp.add(scroll);
		txtA.setEditable(false);
		setSize(800,1000);
		String url = "https://music.bugs.co.kr/chart/track/day/total";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements element = doc.select("tr");
		
		Iterator<Element> ie1 = element.select("div.ranking").iterator();
		Iterator<Element> ie2 = element.select("p.title").iterator();
		Iterator<Element> ie3 = element.select("p.artist").iterator();
		
		while(ie1.hasNext()) {
			txtA.append("\n"+ie1.next().text() + "     " + ie2.next().text() + " ~ " + ie3.next().text()+"\n"+"-----------------");
		}
		setLocation(1100,0);
		setVisible(true);
	}
	
}
class SubFrameGenie extends JFrame {
	public class Addgenie extends JPanel{
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("C:\\Users\\parksm\\eclipse-workingspace\\Scrapping\\src\\image\\geniene.PNG");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);}
	}
	public SubFrameGenie() {
		setTitle("지니차트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel jp = new Addgenie();
		setContentPane(jp);
		JTextArea txtA = new JTextArea(50,60);
		JScrollPane scroll = new JScrollPane(txtA);
		jp.add(scroll);
		txtA.setEditable(false);
		setSize(800,1000);
		String url = "https://www.genie.co.kr/chart/top200?ditc=D&rtm=N";
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
		
		Iterator<Element> ie1 = element.select("td.number").iterator();
		Iterator<Element> ie2 = element.select("a.title.ellipsis").iterator();
		Iterator<Element> ie3 = element.select("a.artist.ellipsis").iterator();
		
		Iterator<Element> ie11 = element2.select("td.number").iterator();
		Iterator<Element> ie22 = element2.select("a.title.ellipsis").iterator();
		Iterator<Element> ie33 = element2.select("a.artist.ellipsis").iterator();
		
		while(ie1.hasNext()) {
			txtA.append("\n"+ie1.next().text() + "\t" + ie2.next().text() + " ~ " + ie3.next().text()+"\n"+"-----------------");
		}
		while(ie11.hasNext()) {
			txtA.append("\n"+ie11.next().text() + "\t" + ie22.next().text() + " ~ " + ie33.next().text()+"\n"+"-----------------");
		}
		
		setLocation(700,0);
		setVisible(true);
	}
}
public class newMelon extends JFrame{
	SubFrameMelon sfm;
	SubFrameBugs sfb;
	SubFrameGenie sfg;
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(100,200,100); //배경색 결정
	         Color o=new Color(100,250,100); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 15, 15); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	public class HButton extends JButton {
	      public HButton() { super(); decorate(); } 
	      public HButton(String text) { super(text); decorate(); } 
	      public HButton(Action action) { super(action); decorate(); } 
	      public HButton(Icon icon) { super(icon); decorate(); } 
	      public HButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(0,230,250); //배경색 결정
	         Color o=new Color(0,200,250); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 15, 15); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	public class GButton extends JButton {
	      public GButton() { super(); decorate(); } 
	      public GButton(String text) { super(text); decorate(); } 
	      public GButton(Action action) { super(action); decorate(); } 
	      public GButton(Icon icon) { super(icon); decorate(); } 
	      public GButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(250,10,10); //배경색 결정
	         Color o=new Color(247,109,12); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 15, 15); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	public class AddInfoPanel extends JPanel{
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("C:\\Users\\parksm\\eclipse-workingspace\\Scrapping\\src\\image\\jordi.jpg");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);}
	}
	public newMelon() {
		setTitle("음악차트 보여줄게(일간)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new AddInfoPanel();
		setContentPane(jp);
		jp.setLayout(new FlowLayout());
		JButton jb = new RoundedButton("멜론");
		JButton jb1 = new HButton("지니");
		JButton jb2 = new GButton("벅스");
		jp.add(jb);
		jp.add(jb1);
		jp.add(jb2);
		
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(e.getSource().equals(jb))
					sfm = new SubFrameMelon();
				}
			}
		);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(e.getSource().equals(jb1))
					sfg = new SubFrameGenie();
				}
			});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(e.getSource().equals(jb2))
					sfb = new SubFrameBugs();
				}
			});
		
				
		setLocation(10, 0);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new newMelon();
	}
}
