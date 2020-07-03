package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Employees extends JFrame implements ActionListener
	{
	 JLabel l1;
	 JButton b1,b2,b3,b4,b5;
	 Employees()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Employee");
		 setLayout(null);
		 Font f=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Employees Information");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 add(l11);
		 l11.setForeground(Color.black);
		 Font f1=new Font("arial",Font.BOLD,15);
		 l11.setBounds(300,10,300,40);
		 l11.setFont(f1);
		 b1=new JButton("Add Employee");
		 b2=new JButton("View Details");
		 b3=new JButton("Back");
		 b4=new JButton("Edit Information");
		 b5=new JButton("Delete Employee");
		 add(l1);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 add(b5);
		 l1.setFont(f);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 b5.setBackground(c);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 l1.setBounds(70,80,420,40);
		 b1.setBounds(200,230,120,35);
		 b2.setBounds(190,280,140,35);
		 b4.setBounds(180,330,160,35);
		 b5.setBounds(190,380,140,35);
		 b3.setBounds(200,430,120,35);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 b4.setForeground(Color.black);
		 b5.setForeground(Color.black);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
		 	 setVisible(false);
			 AddEmployee ae=new AddEmployee( );
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 EmpDetails ed=new EmpDetails();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 InventoryStore d1=new InventoryStore();
			}
		 if(e.getSource()==b4)
			{
			 setVisible(false);
		 	 upEmployee ue=new upEmployee();
			}
		 if(e.getSource()==b5)
			{
			 setVisible(false);
		 	 delEmployee de=new delEmployee();
			}
		}
	 public static void main(String arg[])
		{
		 Employees e1=new Employees();
		}
	}