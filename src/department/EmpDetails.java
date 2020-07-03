package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EmpDetails extends JFrame implements ActionListener
	{
	 int count,i=0;
	 JLabel l1;
	 JButton b1,b2,b3;
	 EmpDetails()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Employee Details");
		 Font f=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Employees Details");
		 b1=new JButton("One Employee Detail");
		 b2=new JButton("View All Employees");
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
			 EmpSearch ec=new EmpSearch();
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 EmpTable et=new EmpTable();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 Employees e1=new Employees();
			}
		}
	 public static void main(String arg[])
		{
		 EmpDetails ed=new EmpDetails();
		}
	}