import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Calculator extends JFrame implements ActionListener,KeyListener
{	
	private static final long serialVersionUID = 143L;
	JButton b[];
	JLabel l;
	String str="";
	double s=0; 
	int len=0;
	boolean flag=false;
	char op;
	
	
	public Calculator()
	{		
		setLayout(null);  int i;
		b=new JButton[22];
		l=new JLabel("0 ",JLabel.RIGHT);
		l.setBounds(15,20,215,40);				
		l.setBackground(Color.DARK_GRAY);
		l.setForeground(Color.WHITE);
		l.setOpaque(true); 		
		l.setFont(new Font("SansSerif",Font.PLAIN,18));
		Border bd=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		l.setBorder(bd);
		
		add(l);
   		
		b[0]=new JButton("\u2190");
		b[0].setMargin(new Insets(0,0,0,0));
		b[0].setBounds(15,80,80,30);
		b[0].setForeground(Color.WHITE);
		b[0].setBackground(Color.DARK_GRAY);
		Border b0=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[0].setBorder(b0);
		
		

		b[1]=new JButton("C"); 
		b[1].setMargin(new Insets(0,0,0,0));
		b[1].setBounds(105,80,35,30);
		b[1].setForeground(Color.WHITE);
		b[1].setBackground(Color.DARK_GRAY);
		Border b1=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[1].setBorder(b1);
		
		
		
		b[2]=new JButton("\u00b1");
		b[2].setMargin(new Insets(0,0,0,0));	
		b[2].setBounds(150,80,35,30);
		b[2].setForeground(Color.WHITE);
		b[2].setBackground(Color.DARK_GRAY);
		Border b2=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[2].setBorder(b2);
		
		

		b[3]=new JButton("\u221A"); 
		b[3].setMargin(new Insets(0,0,0,0));
		b[3].setBounds(195,80,35,30);
		b[3].setForeground(Color.WHITE);
		b[3].setBackground(Color.DARK_GRAY);
		Border b3=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[3].setBorder(b3);
		

		b[4]=new JButton("7");
		b[4].setMargin(new Insets(0,0,0,0));
		b[4].setBounds(15,120,35,30);	
		b[4].setForeground(Color.WHITE);
		b[4].setBackground(Color.black);
		Border b4=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[4].setBorder(b4);		


		b[5]=new JButton("8");
		b[5].setMargin(new Insets(0,0,0,0));
		b[5].setBounds(60,120,35,30);	
		b[5].setForeground(Color.WHITE);
		b[5].setBackground(Color.black);
		Border b5=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[5].setBorder(b5);


		b[6]=new JButton("9"); 
		b[6].setMargin(new Insets(0,0,0,0));
		b[6].setBounds(105,120,35,30);
		b[6].setForeground(Color.WHITE);
		b[6].setBackground(Color.black);
		Border b6=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[6].setBorder(b6);


		b[7]=new JButton("/"); 
		b[7].setMargin(new Insets(0,0,0,0));
		b[7].setBounds(150,120,35,30);
		b[7].setForeground(Color.WHITE);
		b[7].setBackground(Color.DARK_GRAY);
		Border b7=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[7].setBorder(b7);

		
		b[8]=new JButton("%"); 
		b[8].setMargin(new Insets(0,0,0,0));
		b[8].setBounds(195,120,35,30);
		b[8].setForeground(Color.WHITE);
		b[8].setBackground(Color.DARK_GRAY);
		Border b8=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[8].setBorder(b8);

		
		b[9]=new JButton("4");
		b[9].setMargin(new Insets(0,0,0,0));
		b[9].setBounds(15,160,35,30);
		b[9].setForeground(Color.WHITE);
		b[9].setBackground(Color.black);
		Border b9=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[9].setBorder(b9);
		

		b[10]=new JButton("5");
		b[10].setMargin(new Insets(0,0,0,0));
		b[10].setBounds(60,160,35,30);
		b[10].setForeground(Color.WHITE);
		b[10].setBackground(Color.black);
		Border b10=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[10].setBorder(b10);

		
		b[11]=new JButton("6"); 
		b[11].setMargin(new Insets(0,0,0,0));
		b[11].setBounds(105,160,35,30);
		b[11].setForeground(Color.WHITE);
		b[11].setBackground(Color.black);
		Border b11=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[11].setBorder(b11);
		

		b[12]=new JButton("*"); 
		b[12].setMargin(new Insets(0,0,0,0));
		b[12].setBounds(150,160,35,30);
		b[12].setForeground(Color.WHITE);
		b[12].setBackground(Color.DARK_GRAY);
		Border b12=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[12].setBorder(b12);
		

		b[13]=new JButton("1/x"); 
		b[13].setMargin(new Insets(0,0,0,0));
		b[13].setBounds(195,160,35,30);
		b[13].setForeground(Color.WHITE);
		b[13].setBackground(Color.DARK_GRAY);
		Border b13=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[13].setBorder(b13);
		

		b[14]=new JButton("1");
		b[14].setMargin(new Insets(0,0,0,0));
		b[14].setBounds(15,200,35,30);
		b[14].setForeground(Color.WHITE);
		b[14].setBackground(Color.black);
		Border b14=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[14].setBorder(b14);
		

		b[15]=new JButton("2");
		b[15].setMargin(new Insets(0,0,0,0));
		b[15].setBounds(60,200,35,30);
		b[15].setForeground(Color.WHITE);
		b[15].setBackground(Color.black);
		Border b15=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[15].setBorder(b15);
		

		b[16]=new JButton("3"); 
		b[16].setMargin(new Insets(0,0,0,0));
		b[16].setBounds(105,200,35,30);
		b[16].setForeground(Color.WHITE);
		b[16].setBackground(Color.black);
		Border b16=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[16].setBorder(b16);
		

		b[17]=new JButton("-"); 
		b[17].setMargin(new Insets(0,0,0,0));
		b[17].setBounds(150,200,35,30);
		b[17].setForeground(Color.WHITE);
		b[17].setBackground(Color.DARK_GRAY);
		Border b17=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[17].setBorder(b17);
		
	
		b[18]=new JButton("="); 
		b[18].setMargin(new Insets(0,0,0,0));
		b[18].setBounds(195,200,35,70);
		b[18].setForeground(Color.WHITE);
		b[18].setBackground(Color.DARK_GRAY);
		Border b18=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[18].setBorder(b18);
		

		b[19]=new JButton("0");
		b[19].setMargin(new Insets(0,0,0,0));
		b[19].setBounds(15,240,80,30);
		b[19].setForeground(Color.WHITE);
		b[19].setBackground(Color.black);
		Border b19=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[19].setBorder(b19);
		

		b[20]=new JButton(".");
		b[20].setMargin(new Insets(0,0,0,0));
		b[20].setBounds(105,240,35,30);
		b[20].setForeground(Color.WHITE);
		b[20].setBackground(Color.BLACK);
		Border b20=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[20].setBorder(b20);
		

		b[21]=new JButton("+"); 
		b[21].setMargin(new Insets(0,0,0,0));
		b[21].setBounds(150,240,35,30);
		b[21].setForeground(Color.WHITE);
		b[21].setBackground(Color.DARK_GRAY);
		Border b21=BorderFactory.createLineBorder(Color.DARK_GRAY,1);
		b[21].setBorder(b21);
				
		for(i=0;i<b.length;i++)
		b[i].setFocusable(false);
	
		for(i=0;i<b.length;i++)
		b[i].addActionListener(this);
	
		for(i=0;i<b.length;i++)
		add(b[i]);
	
		addKeyListener((KeyListener) this);
		setFocusable(true);

		setDefaultCloseOperation(
		JFrame.EXIT_ON_CLOSE);	
	}
	public void actionPerformed(ActionEvent a)
	{
	
	}
	public void keyTyped(KeyEvent e) 
	{		
	}	
	public void keyPressed(KeyEvent e)
	{		
	}
    public void keyReleased(KeyEvent e) 
    {    	
    }	
	
	public static void main(String[] a)
	{
		Calculator t=new Calculator(); 
		t.setSize(258,323); 
		t.setTitle("Calculator");
		t.setBackground(Color.BLACK);
		t.setVisible(true); 
		t.setResizable(false);
		t.setIconImage(new ImageIcon("calc.png").getImage());
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-t.getWidth())/2);
		int y=(int)((d.getHeight()-t.getHeight())/2);
		t.setLocation(x,y);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
