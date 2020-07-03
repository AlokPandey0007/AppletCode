package department;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
class Category extends JFrame implements ActionListener
	{
	 TextField t1;
	 JLabel l1,l2;
	 JButton b1,b2,b3,b4,b5,b6;
	 static Connection con;
	 Category()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Category");
		 Font f=new Font("algerian",Font.BOLD,30);
		 Font f1=new Font("arial",Font.BOLD,16);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Categories Information");
		 l2=new JLabel("Category Name: ");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 b1=new JButton("Add Category");
		 b2=new JButton("Show All Categories");
		 b3=new JButton("Back");
		 b4=new JButton("Add");
		 b5=new JButton("Delete Category");
		 t1=new TextField(50);
		 l1.setFont(f);
		 l2.setFont(f1);
		 l11.setFont(f1);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 b5.setBackground(c);
		 l11.setForeground(Color.black);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 b4.setForeground(Color.black);
		 b5.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 add(l1);
		 add(l2);
		 add(l11);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(t1);
		 add(b4);
		 add(b5);
		 t1.setVisible(false);
		 b4.setVisible(false);
		 l2.setVisible(false);
		 l1.setBounds(80,100,500,40);
		 l11.setBounds(300,10,300,40);
		 l2.setBounds(100,220,150,35);
		 b1.setBounds(200,170,150,35);
		 t1.setBounds(250,220,150,35);
		 b4.setBounds(200,270,150,35);
		 b2.setBounds(200,320,150,35);
		 b5.setBounds(200,370,150,35);
		 b3.setBounds(200,420,150,35);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
		 	{
			 t1.setVisible(true);
			 b4.setVisible(true);
			 l2.setVisible(true);
			}
		 if(e.getSource()==b2)
		 	{
			 setVisible(false);
			 showCategory sc=new showCategory();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
			 InventoryStore d1=new InventoryStore();
			}
		 if(e.getSource()==b4)
		 	{
			 if(t1.getText().equals(""))
				{
				 JOptionPane.showMessageDialog(this,"Field is Empty");
				}
			 else
				{
				 try
					{
				 	 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 	 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
					 // Class.forName("com.mysql.jdbc.Driver");
                      Connection con = DBConnection.DBConnection();
					 PreparedStatement ps1=con.prepareStatement("insert into Category values(?)");				 
					 ps1.setString(1,t1.getText());
					 JOptionPane.showMessageDialog(this,"Congrets! Category is added");
					 ps1.executeUpdate();
					 con.close();
					 t1.setText("");
					}
				 catch(Exception e2)
					{
					 System.out.println("Exception is: "+e2);
					}
				}
			 
			 t1.setVisible(false);
			 b4.setVisible(false);
			 l2.setVisible(false);
			}
		 if(e.getSource()==b5)
			{
			 setVisible(false);
			 delCategory dc=new delCategory();
			}
		}
	 public static void main(String arg[])
		{
		 Category c1=new Category();
		}
	}

