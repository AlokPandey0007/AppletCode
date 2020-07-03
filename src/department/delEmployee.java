package department;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class delEmployee extends JFrame implements ActionListener, ItemListener
	{
	 TextField t1,t2,t3;
	 List li;
	 JLabel l1,l2;
	 JButton b1,b2,b3;
	 static Connection con;
	 delEmployee()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Delete Employee");
		 Font f1=new Font("arial",Font.BOLD,16);
		 Color c=new Color(50,200,150);
		 b1=new JButton("Delete");
		 b2=new JButton("Back");
		 b3=new JButton("Refresh");
		 t1=new TextField(20);
		 t2=new TextField(20);
		 t3=new TextField(20);
		 li=new List();
		 l1=new JLabel("Last Name:");
		 l2=new JLabel("Emp_Code:");
		 add(b1);
		 add(b2);
		 add(b3);
		 add(t1);
		 add(li);
		 add(l1);
		 add(l2);
		 add(t2);
		 add(t3);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 li.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 li.setBounds(200,100,200,250);
		 l1.setBounds(50,380,80,35);
		 t2.setBounds(140,380,100,30);
		 l2.setBounds(280,380,80,35);
		 t3.setBounds(380,380,100,30);
		 t1.setBounds(225,440,150,35);
		 b1.setBounds(250,500,100,35);
		 b2.setBounds(250,600,100,35);
		 b3.setBounds(250,550,100,35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 t1.setForeground(Color.black);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 t1.setEnabled(false);
		 li.addItemListener(this);
		 setVisible(true);
		 getContentPane().setBackground(c);
		 try
			{
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");

 //Class.forName("com.mysql.jdbc.Driver");
                     //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			  con = DBConnection.DBConnection();
			 PreparedStatement ps=con.prepareStatement("select FirstName from EmpTabel");
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
				 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
				 //Class.forName("com.mysql.jdbc.Driver");
                   //    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
                     
				PreparedStatement ps1=con.prepareStatement("select * from EmpTabel where FirstName=?");
				 ps1.setString(1,String.valueOf(li.getSelectedItem()));
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next())
					{
					 t1.setText(rs1.getString(2));
					 t2.setText(rs1.getString(3));
					 t3.setText(String.valueOf(rs1.getInt(1)));
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
			//	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//	 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
				 // Class.forName("com.mysql.jdbc.Driver");
                        
				 PreparedStatement ps2=con.prepareStatement("delete from EmpTabel where FirstName=?");
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
		 	 Employees e1=new Employees();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 delEmployee de=new delEmployee();
			}
		}
	 public static void main(String arg[])
		{
		 delEmployee de=new delEmployee();
		}
	}