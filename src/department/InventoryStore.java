package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class InventoryStore extends JFrame implements ActionListener
	{
	 JLabel l1;
	 JButton b1,b2,b3,b4,b5,b6;
	 InventoryStore()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Inventory Store");
		 setLayout(null);
		 Font f1=new Font("algerian",Font.BOLD,30);
		 Font f2=new Font("algerian",Font.BOLD,15);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Details Of Inventory Store");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 b1=new JButton("Category ");
		 b2=new JButton("Items");
		 b3=new JButton("Suppliers");
		 b4=new JButton("Employees");
		 b5=new JButton("Stock");
		 b6=new JButton("Log Out");
		 add(l1);
		 add(l11);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 add(b5);
		 add(b6);
		 l1.setFont(f1);
		 l11.setFont(f2);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 b5.setBackground(c);
		 b6.setBackground(c);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 b4.setForeground(Color.black);
		 b5.setForeground(Color.black);
		 b6.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 l1.setBounds(50,100,550,30);
		 l11.setBounds(300,10,300,40);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 b6.addActionListener(this);
		 b1.setBounds(200,200,120,30);
		 b2.setBounds(200,250,120,30);
		 b3.setBounds(200,300,120,30);
		 b4.setBounds(200,350,120,30);
		 b5.setBounds(200,400,120,30);
		 b6.setBounds(200,520,120,30);
 		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
		 	 setVisible(false);
		 	 Category c1=new Category();
			}
		 if(e.getSource()==b2)
		 	{
		 	 setVisible(false);
		 	 Item1 i=new Item1();
			}
		 if(e.getSource()==b3)
		 	{
		 	 setVisible(false);
		 	 Supplier s1=new Supplier();
			}
		 if(e.getSource()==b4)
		 	{
		 	 setVisible(false);
		 	 Employees e1=new Employees();
			}
		 if(e.getSource()==b5)
		 	{
		 	 setVisible(false);
		 	 StockDetails d4=new StockDetails();
			}	
		 if(e.getSource()==b6)
			{
			 setVisible(true);
		 	 int i=JOptionPane.showConfirmDialog(this," Do u want to LogOut ");
			 if(i==0)
				{
				 setVisible(false);
				 login d2=new login();
				}
			 else if(i==1)
				{
				 setVisible(true);
				}
			 else
				{
				 setVisible(true);
				}
			}
		}
	 public static void main(String arg[])
		{
		 InventoryStore d1=new InventoryStore();
		}
	}