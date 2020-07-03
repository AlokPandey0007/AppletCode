package department;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class delCategory extends JFrame implements ActionListener, ItemListener
	{
	 TextField t1;
	 List li;
	 JButton b1,b2,b3;
	 static Connection con;
	 delCategory()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Delete Category");
		 Font f1=new Font("arial",Font.BOLD,16);
		 Color c=new Color(50,200,150);
		 b1=new JButton("Delete");
		 b2=new JButton("Back");
		 b3=new JButton("Refresh");
		 t1=new TextField(20);
		 li=new List();
		 add(b1);
		 add(b2);
		 add(t1);
		 add(li);
		 add(b3);
		 li.setBounds(200,100,200,250);
		 t1.setBounds(225,400,150,35);
		 b1.setBounds(250,500,100,35);
		 b2.setBounds(250,600,100,35);
		 b3.setBounds(250,550,100,35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 li.setForeground(Color.black);
		 li.addItemListener(this);
		 setVisible(true);
		 getContentPane().setBackground(c);
		 try
			{
			 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  con = DBConnection.DBConnection();
			 PreparedStatement ps=con.prepareStatement("select Categories from Category");
			 ResultSet rs=ps.executeQuery();			 
			 
			 while(rs.next())
				{
				 li.addItem(rs.getString(1));
				}
			}
		 catch(Exception e)
			{
			 System.out.println(e);
			}		
		}
	 public void itemStateChanged(ItemEvent e1)
		{
		 if(e1.getSource()==li)
			{
			 try
				{
				// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				// Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
                       //Class.forName("com.mysql.jdbc.Driver");
                     //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");			
				 con = DBConnection.DBConnection();
				 PreparedStatement ps1=con.prepareStatement("select Categories from Category where CONVERT(varchar,Categories)=?");
				 ps1.setString(1,String.valueOf(li.getSelectedItem()));
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next())
					{
					 t1.setText(rs1.getString(1));
					}
				}
			 catch(Exception e5)
				{
				 System.out.println(e5);
				}
			}
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
			{
			 try
				{
				 
				 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
				  //Class.forName("com.mysql.jdbc.Driver");
                       //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
				 con = DBConnection.DBConnection();
				 PreparedStatement ps2=con.prepareStatement("delete from Category where CONVERT(varchar,Categories)=?");
				 ps2.setString(1,String.valueOf(t1.getText()));
				 ps2.executeUpdate();
				}
			 catch(Exception e6)
				{
				 System.out.println(e6);
				}
			}
		 if(e.getSource()==b2)
			{
			 setVisible(false);
		 	 Category c1=new Category();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 
			 delCategory dc=new delCategory();
			}
		}
	 public static void main(String arg[])
		{
		 delCategory dc=new delCategory();
		}
	}