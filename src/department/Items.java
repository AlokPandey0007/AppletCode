package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Items extends JFrame implements ActionListener
	{
	 JLabel l1,l2,l3,l4,l5,l6;
	 TextField t1,t2,t3,t4;
	 List li;
	 JButton b1,b2,b3;
	 static Connection con;
	 Items()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Items");
		 setLayout(null);
		 Font f1=new Font("algerian",Font.BOLD,30);
		 Font f2=new Font("arial",Font.BOLD,18);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Item Information");
		 l2=new JLabel("Item's Name:");
		 l3=new JLabel("Item's Category:");
		 l4=new JLabel("Maximum Stock:");
		 l5=new JLabel("Current Stock:");
		 l6=new JLabel("Minimum Stock:");
		 t1=new TextField(20);
		 t2=new TextField(20);
		 t3=new TextField(20);
		 t4=new TextField(20);
		 li=new List();
		 b1=new JButton("Save");
		 b2=new JButton("Details");
		 b3=new JButton("Back");
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(l6);
		 add(t1);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(li);
		 add(b1);
		 add(b2);
		 add(b3);
		 l1.setFont(f1);
		 l2.setFont(f2);
		 l3.setFont(f2);
		 l4.setFont(f2);
		 l5.setFont(f2);
		 l6.setFont(f2);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 l1.setBounds(120,80,400,40);
		 l2.setBounds(90,150,150,30);
		 l3.setBounds(90,200,150,30);
		 l4.setBounds(90,300,150,30);
		 l5.setBounds(90,350,150,30);
		 l6.setBounds(90,400,150,30);
		 t1.setBounds(300,150,150,30);
		 li.setBounds(300,200,150,80);
		 t2.setBounds(300,300,150,30);
		 t3.setBounds(300,350,150,30);
		 t4.setBounds(300,400,150,30);
		 b1.setBounds(90,550,100,30);
		 b2.setBounds(220,550,100,30);
		 b3.setBounds(350,550,100,30);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l5.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 try
			{
			 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 	//  Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
			 PreparedStatement ps2=con.prepareStatement("select Categories from Category");
			 ResultSet rs=ps2.executeQuery();
			 while(rs.next())
				{
				 li.addItem(rs.getString(1));
				}
			}
		 catch(Exception e)
			{
			 System.out.println(e);
			}		
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
			{
			 if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||li.getSelectedItem().equals(""))
				{
				 JOptionPane.showMessageDialog(this,"Some Fields are Empty");
				}
			 else
				{
				 int i=JOptionPane.showConfirmDialog(this,"Are you sure ?");
				 if(i==0)
					{
				 	 try
					{
	//			 	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 	 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
		         	  //Class.forName("com.mysql.jdbc.Driver");
                      // Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
	
					 PreparedStatement ps1=con.prepareStatement("insert into items values(?,?,?,?,?)");				 
					 ps1.setString(1,t1.getText());
					 ps1.setString(2,(String)li.getSelectedItem());
					 ps1.setString(3,t2.getText());
					 ps1.setString(4,t3.getText());
					 ps1.setString(5,t4.getText());
					 JOptionPane.showMessageDialog(this,"Congrets! Item_Info added");
					 ps1.executeUpdate();
					 con.close();
					}
				 catch(Exception e2)
					{
					 System.out.println("Exception is: "+e2);
					}
					}
				 if(i==1)
					{
					 t1.setText("");
					 t2.setText("");
					 t3.setText("");
					 t4.setText("");
					}
				 if(i==2)
					{
					 setVisible(true);
					}
					
				}
			 t1.setText("");
			 t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 
			}
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 ItemTable1 it=new ItemTable1();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
			 Item1 i=new Item1();
			}
		}
	 public static void main(String arg[])
		{
		 Items i1=new Items();
		}
	}