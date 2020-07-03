package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SplDetails extends JFrame implements ActionListener
	{
	 int count,i=0;
	 JLabel l1;
	 JButton b1,b2,b3;
	 SplDetails()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Supplier Details");
		 Font f=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Suppliers Details");
		 b1=new JButton("One Supplier Detail");
		 b2=new JButton("View All Suppliers");
		 b3=new JButton("Back");
		 add(l1);
		 add(b1);
		 add(b2);
		 add(b3);
		 l1.setFont(f);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 l1.setBounds(130,120,400,40);
		 b1.setBounds(210,250,160,35);
		 b2.setBounds(220,310,140,35);
		 b3.setBounds(240,400,100,35);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
			 setVisible(false);
		 	 SplSearch sc=new SplSearch();
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 SplTable st=new SplTable();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 Supplier e1=new Supplier();
			}
		}
	 public static void main(String arg[])
		{
		 SplDetails sd=new SplDetails();
		}
	}