package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class StockDetails extends JFrame implements ActionListener
	{
	 JLabel l1;
	 JButton b1,b2,b3,b4;
	 StockDetails()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("StockDetails");
		 setLayout(null);
		 Font f1=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Stock Details");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 add(l11);
		 l11.setForeground(Color.black);
		 Font f2=new Font("arial",Font.BOLD,15);
		 l11.setBounds(300,10,300,40);
		 l11.setFont(f2);
		 b1=new JButton("Purchase");
		 b2=new JButton("Sale");
		 b3=new JButton("Show Details");
		 b4=new JButton("Back");
		 l1.setFont(f1);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 add(l1);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 l1.setBounds(160,120,550,30);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b1.setBounds(230,200,100,35);
		 b2.setBounds(230,250,100,35);
		 b3.setBounds(220,300,120,35);
		 b4.setBounds(230,450,100,35);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
			 setVisible(false);
			 Purchase p1=new Purchase();
			}
		 if(e.getSource()==b2)
		 	{
			 setVisible(false);
			 Sold s1=new Sold();
			}
		 if(e.getSource()==b3)
		 	{
			 setVisible(false);
			 StkDetail sd=new StkDetail();
			}
		 if(e.getSource()==b4)
		 	{
			 setVisible(false);
			 InventoryStore d1=new InventoryStore();
			}
		}
	 public static void main(String arg[])
		{
		 StockDetails d4=new StockDetails();
		
		}
	}