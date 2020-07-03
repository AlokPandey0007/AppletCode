package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Item1 extends JFrame implements ActionListener
	{
	 JLabel l1;
	 JButton b1,b2,b3,b4,b5;
	 Item1()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Items");
		 setLayout(null);
		 Font f=new Font("algerian",Font.BOLD,30);
		 Font f1=new Font("algerian",Font.BOLD,16);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Items Information");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 b1=new JButton("Add Item");
		 b2=new JButton("View Details");
		 b3=new JButton("Back");
		 b4=new JButton("Update Information");
		 b5=new JButton("Delete Item");
		 add(l1);
		 add(l11);
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
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 b4.setForeground(Color.black);
		 b5.setForeground(Color.black);
		 l1.setBounds(120,120,400,40);
		 l11.setBounds(300,10,300,40);
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
			 Items i1=new Items();
		 	}	
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 ItemTable it=new ItemTable();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 InventoryStore d1=new InventoryStore();
			}
		 if(e.getSource()==b4)
			{
			 setVisible(false);
		 	 upItem ui=new upItem();
			}
		 if(e.getSource()==b5)
			{
			 setVisible(false);
		 	 delItem di=new delItem();
			}
		}
	 public static void main(String arg[])
		{
		 Item1 i=new Item1();
		}
	}