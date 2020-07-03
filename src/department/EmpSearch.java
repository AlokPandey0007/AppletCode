package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class EmpSearch extends JFrame implements ActionListener
	{
	 JLabel l1;
	 JButton b1,b2,b3;
	 EmpSearch()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Employee Search");
		 Font f=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Employee Search");
		 b1=new JButton("Search By Country");
		 b2=new JButton("Search By Code");
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
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l1.setBounds(125,80,400,40);
		 b1.setBounds(200,250,150,35);
		 b2.setBounds(200,300,150,35);
		 b3.setBounds(200,380,150,35);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
			 setVisible(false);
			 countEmp ss=new countEmp();
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 Empcode mp=new Empcode();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 EmpDetails ed=new EmpDetails();
			}
		}
	 public static void main(String arg[])
		{
		 EmpSearch ec=new EmpSearch();
		}
	}