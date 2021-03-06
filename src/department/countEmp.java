package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class countEmp extends JFrame implements ActionListener,ItemListener
	{
	 JComboBox cb1;
	 List li;
	 JLabel l1,l2,l3,l4,l6,l7,l8,l9;
	 JTextField t1,t2,t3,t4,t6,t7,t8,t9;
	 JButton b1;
	 static Connection con;
	 countEmp()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Single Employee Detail");
		 Font f=new Font("arial",Font.BOLD,30);
		 Font f1=new Font("arial",Font.BOLD,15);
		 Color c=new Color(50,200,150);
		 cb1=new JComboBox();
		 li=new List();
		 l1=new JLabel("First Name:");
		 l2=new JLabel("Last Name:");
		 l3=new JLabel("Address:");
		 l4=new JLabel("City");
		 l6=new JLabel("State");
		 l7=new JLabel("Emp_emailID");
		 l8=new JLabel("Ph No:");
		 l9=new JLabel("Position:");
		 b1=new JButton("Back");
		 t1=new JTextField(25);
		 t2=new JTextField(25);
		 t3=new JTextField(25);
		 t4=new JTextField(25);
		 t6=new JTextField(25);
		 t7=new JTextField(25);
		 t8=new JTextField(25);
		 t9=new JTextField(25);
		 l1.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 li.setForeground(Color.black);
		 l7.setForeground(Color.black);
		 l8.setForeground(Color.black);
		 l9.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 b1.setForeground(Color.black);
		 add(cb1);
		 add(li);
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l6);
		 add(l7);
		 add(l8);
		 add(l9);
		 add(t1);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(t6);
		 add(t7);
		 add(t8);
		 add(t9);
		 add(b1);
		 li.setBackground(c);
		 b1.setBackground(c);
		 cb1.addItem("Select Country");
		 cb1.setBounds(150,30,250,30);
		 li.setBounds(350,160,200,310);
		 l1.setBounds(50,160,120,30);
		 l2.setBounds(50,200,120,30);
		 l3.setBounds(50,240,120,30);
		 l4.setBounds(50,280,120,30);
		 l6.setBounds(50,320,120,30);
		 l7.setBounds(50,360,120,30);
		 l8.setBounds(50,400,120,30);
		 l9.setBounds(50,440,120,30);
		 t1.setBounds(170,160,150,30);
		 t2.setBounds(170,200,150,30);
		 t3.setBounds(170,240,150,30);
		 t4.setBounds(170,280,150,30);
		 t6.setBounds(170,320,150,30);
		 t7.setBounds(170,360,150,30);
		 t8.setBounds(170,400,150,30);
		 t9.setBounds(170,440,150,30);
		 b1.setBounds(240,500,100,40);
		 t1.setEnabled(false);
		 t2.setEnabled(false);
		 t3.setEnabled(false);
		 t4.setEnabled(false);
		 t6.setEnabled(false);
		 t7.setEnabled(false);
		 t8.setEnabled(false);
		 t9.setEnabled(false);
		 b1.addActionListener(this);
		 cb1.addActionListener(this);
		 li.addItemListener(this);
		 getContentPane().setBackground(c);
		 setVisible(true);
		 try
			{
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 
			  //Class.forName("com.mysql.jdbc.Driver");			 
             // Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
               con = DBConnection.DBConnection();
              PreparedStatement ps=con.prepareStatement("select distinct Country from EmpTabel");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
				{
				 cb1.addItem(rs.getString(1));
				}
			 PreparedStatement ps1=con.prepareStatement("select EmpID from EmpTabel where Country=?");
			 ps1.setString(1,String.valueOf(cb1.getSelectedItem()));
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 li.addItem(String.valueOf(rs1.getInt(1)));
				}
			}
	 	 catch(Exception e1)
			{
			 System.out.println(e1);
			}
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
			{
			 setVisible(false);
			 EmpSearch ec=new EmpSearch();
			}
		 try
			{
			 li.removeAll();
			 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
		 	 // Class.forName("com.mysql.jdbc.Driver");
                     //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			 PreparedStatement ps1=con.prepareStatement("select EmpID from EmpTabel where Country=?");
			 ps1.setString(1,String.valueOf(cb1.getSelectedItem()));
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 li.addItem(String.valueOf(rs1.getInt(1)));
				}
			}
	 	 catch(Exception e1)
			{
			 System.out.println(e1);
			}
		}
	 public void itemStateChanged(ItemEvent e2)
		{
		 try
			{
			 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 //Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
		 	  //Class.forName("com.mysql.jdbc.Driver");
                     //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			 
			 
			 PreparedStatement ps2=con.prepareStatement("select * from EmpTabel where EmpID=?");
			 ps2.setString(1,String.valueOf(li.getSelectedItem()));
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next())
				{
				 t1.setText(rs2.getString(2));
				 t2.setText(rs2.getString(3));
				 t3.setText(rs2.getString(4));
				 t4.setText(rs2.getString(5));
				 t6.setText(rs2.getString(7));
				 t7.setText(rs2.getString(8));
				 t8.setText(rs2.getString(9));
				 t9.setText(rs2.getString(10));
				}
			}
		 catch(Exception ee)
			{
			 
			}
				 		
		}
	 public static void main(String arg[])
		{
		 countEmp ss=new countEmp();
		}
	}
		 