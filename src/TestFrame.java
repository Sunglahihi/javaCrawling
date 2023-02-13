import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SubFrame extends JFrame implements ActionListener{

	    public SubFrame(){
	        super("���� �ڽ�");
	        setSize(100,100);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // dispose�� ���� â�� �ݱ�
	        JButton bt = new JButton("�ݱ�");
	        add(bt);
	        bt.addActionListener(this);
	        setLocation(500, 400);
	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        dispose();
	    }
	}

public class TestFrame extends JFrame implements ActionListener{
	    SubFrame sf;

	    public TestFrame(){
	        super("������ ����");
	        setSize(200,200);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit�� ��ü â �ݱ�
	        JButton bt = new JButton("����");
	        add(bt);
	        bt.addActionListener(this);
	        setVisible(true);
	        setLocation(400, 400);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // TODO Auto-generated method stub
	        if(sf == null){
	            sf = new SubFrame();
	        }else{
	            sf.dispose();
	            sf = new SubFrame();
	        }
	    }
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new TestFrame();
	    }
	}
