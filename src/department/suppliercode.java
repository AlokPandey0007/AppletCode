package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class suppliercode extends JFrame implements ActionListener
	{
	 JComboBox cb1;
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	 JButton b1;
	 static Connection con;
	 suppliercode()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Single Supplier Detail");
		 Font f=new Font("arial",Font.BOLD,30);
		 Font f1=new Font("arial",Font.BOLD,15);
		 Color c=new Color(50,200,150);
		 cb1=new JComboBox();
		 l1=new JLabel("Supplier's Name:");
		 l2=new JLabel("Address:");
		 l3=new JLabel("City:");
		 l4=new JLabel("State:");
		 l5=new JLabel("Country");
		 l6=new JLabel("Spl_email ID:");
		 l7=new JLabel("PH No:");
		 l8=new JLabel("VAT No:");
		 l9=new JLabel("PAN No:");
		 b1=new JButton("Back");
		 t1=new JTextField(25);
		 t2=new JTextField(25);
		 t3=new JTextField(25);
		 t4=new JTextField(25);
		 t5=new JTextField(25);
		 t6=new JTextField(25);
		 t7=new JTextField(25);
		 t8=new JTextField(25);
		 t9=new JTextField(25);
		 add(cb1);
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(l6);
		 add(l7);
		 add(l8);
		 add(l9);
		 add(t1);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(t5);
		 add(t6);
		 add(t7);
		 add(t8);
		 add(t9);
		 add(b1);
		 l1.setFont(f1);
		 l2.setFont(f1);
		 l3.setFont(f1);
		 l4.setFont(f1);
		 l5.setFont(f1);
		 l6.setFont(f1);
		 l7.setFont(f1);
		 l8.setFont(f1);
		 l9.setFont(f1);
		 b1.setBackground(c);
		 cb1.addItem("Select Code");
		 cb1.setBounds(150,30,250,30);
		 l1.setBounds(80,100,200,35);
		 l2.setBounds(80,150,200,35);
		 l3.setBounds(80,200,200,35);
		 l4.setBounds(80,250,200,35);
		 l5.setBounds(80,300,200,35);
		 l6.setBounds(80,350,200,35);
		 l7.setBounds(80,400,200,35);
		 l8.setBounds(80,450,200,35);
		 l9.setBounds(80,500,200,35);
		 t1.setBounds(250,100,150,30);
		 t2.setBounds(250,150,150,30);
		 t3.setBounds(250,200,150,30);
		 t4.setBounds(250,250,150,30);
		 t5.setBounds(250,300,150,30);
		 t6.setBounds(250,350,150,30);
		 t7.setBounds(250,400,150,30);
		 t8.setBounds(250,450,150,30);
		 t9.setBounds(250,500,150,30);
		 b1.setBounds(240,570,100,40);
		 t1.setEnabled(false);
		 t2.setEnabled(false);
		 t3.setEnabled(false);
		 t4.setEnabled(false);
		 t5.setEnabled(false);
		 t6.setEnabled(false);
		 t7.setEnabled(false);
		 t8.setEnabled(false);
		 t9.setEnabled(false);
		 b1.addActionListener(this);
		 cb1.addActionListener(this);
		 getContentPane().setBackground(c);
		 setVisible(true);
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  //Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
			
		PreparedStatement ps=con.prepareStatement("select supplierID from SplTabel");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
				{
				 cb1.addItem(rs.getString(1));
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
			 SplSearch sc=new SplSearch();
			}
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  //Class.forName("com.mysql.jdbc.Driver");
                //       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
	
			 PreparedStatement ps1=con.prepareStatement("select * from SplTabel where supplierID=?");
			 ps1.setString(1,String.valueOf(cb1.getSelectedItem()));
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 t1.setText(rs1.getString(2));
				 t2.setText(rs1.getString(3));
				 t3.setText(rs1.getString(4));
				 t4.setText(rs1.getString(5));
				 t5.setText(rs1.getString(6));
				 t6.setText(rs1.getString(7));
				 t7.setText(rs1.getString(8));
				 t8.setText(rs1.getString(9));
				 t9.setText(rs1.getString(10));
				 
				}
			}
	 	 catch(Exception e1)
			{
			 System.out.println(e1);
			}
		}
	 public static void main(String arg[])
		{
		 suppliercode ss1=new suppliercode();
		}
	}
		 