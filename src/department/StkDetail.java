package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StkDetail extends JFrame implements ActionListener
	{
	 int count,i=0;
	 JLabel l1;
	 JButton b1,b2,b3,b4;
	 StkDetail()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Stock Details");
		 Font f=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Stock Details");
		 b1=new JButton("Purchase Detail");
		 b2=new JButton("Sale Detail");
		 b3=new JButton("View All Details");
		 b4=new JButton("Back");
		 add(l1);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 l1.setFont(f);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 l1.setBounds(150,120,400,40);
		 b1.setBounds(200,250,150,35);
		 b2.setBounds(200,300,150,35);
		 b3.setBounds(200,350,150,35);
		 b4.setBounds(200,400,150,35);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
			 setVisible(false);
		 	 PurchaseTable st=new PurchaseTable();
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 SaleTable st1=new SaleTable();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 StkTable st=new StkTable();
			}
		 if(e.getSource()==b4)
			{
			 setVisible(false);
		 	 StockDetails d4=new StockDetails();
			}
		}
	 public static void main(String arg[])
		{
		 StkDetail sd=new StkDetail();
		}
	}