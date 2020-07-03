package department;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class upSupplier extends JFrame implements ActionListener
	{
	 TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	 JTextArea t;
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	 JButton b1,b2,b3,b4;
	 JComboBox cb1;
	 JScrollPane s;
	 static Connection con;
	 upSupplier()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Update Employee Information");
		 Font f1=new Font("arial",Font.BOLD,16);
		 Color c=new Color(50,200,150);
		 b1=new JButton("Update");
		 b2=new JButton("Back");
		 b3=new JButton("Refresh");
		 b4=new JButton("OK");
		 t1=new TextField(20);
		 t2=new TextField(20);
		 t3=new TextField(20);
		 t4=new TextField(20);
		 t5=new TextField(20);
		 t6=new TextField(20);
		 t7=new TextField(20);
		 t8=new TextField(20);
		 t9=new TextField(20);
		 l1=new JLabel("Supplier Name:");
		 l2=new JLabel("Spl_Code:");
		 l3=new JLabel("Address :");
		 l4=new JLabel("City:");
		 l5=new JLabel("State:");
		 l6=new JLabel("Country:");
		 l7=new JLabel("Emp_emailID:");
		 l8=new JLabel("PH No.:");
		 l9=new JLabel("VAT No:");
		 l10=new JLabel("PAN No:");
		 t=new JTextArea(25,25);
		 cb1=new JComboBox();
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 add(t1);
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(l6);
		 add(l7);
		 add(l8);
		 add(l9);
		 add(l10);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(t);
		 add(cb1);
		 add(t9);
		 add(t5);
		 add(t6);
		 add(t7);
		 add(t8);
		 cb1.addItem("Select Name");
		 cb1.setBounds(200,200,200,30);
		 l1.setBounds(30,320,100,30);
		 t2.setBounds(135,320,150,30);
		 l2.setBounds(295,320,80,35);
		 t3.setBounds(370,320,150,30);
		 l3.setBounds(140,100,80,30);
		 t.setBounds(240,100,150,80);
		 l4.setBounds(140,200,80,30);
		 t1.setBounds(240,200,150,30);
		 l5.setBounds(140,250,80,30);
		 t4.setBounds(240,250,150,30);
		 l6.setBounds(140,300,80,30);
		 t5.setBounds(240,300,150,30);
		 l7.setBounds(140,350,80,30);
		 t6.setBounds(240,350,150,30);
		 l8.setBounds(140,400,80,30);
		 t7.setBounds(240,400,150,30);
		 l9.setBounds(140,450,80,30);
		 t8.setBounds(240,450,150,30);
		 l10.setBounds(140,500,80,30);
		 t9.setBounds(240,500,150,30);
		 b4.setBounds(240,400,100,35);
		 b1.setBounds(100,580,100,35);
		 b2.setBounds(240,500,100,35);
		 b3.setBounds(400,580,100,35);
		 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		 s=new JScrollPane(t,v,h);
		 s.setBounds(240,100,150,80);
		 add(s);
		 s.setVisible(false);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 b4.setForeground(Color.black);
		 t1.setForeground(Color.black);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 b4.setBackground(c);
		 l4.setVisible(false);
		 t.setVisible(false);
		 l3.setVisible(false);
		 t1.setVisible(false);
		 l1.setVisible(false);
		 l2.setVisible(false);
		 t2.setVisible(false);
		 t3.setVisible(false);
		 b4.setVisible(false);
		 l5.setVisible(false);
		 t4.setVisible(false);
		 l6.setVisible(false);
		 l7.setVisible(false);
		 l8.setVisible(false);
		 l9.setVisible(false);
		 l10.setVisible(false);
		 t5.setVisible(false);
		 t6.setVisible(false);
		 t7.setVisible(false);
		 t8.setVisible(false);
		 t9.setVisible(false);
		 b1.setVisible(false);
		 b3.setVisible(false);
		 cb1.addActionListener(this);
		 setVisible(true);
		 getContentPane().setBackground(c);
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  //Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
	
			 PreparedStatement ps=con.prepareStatement("select SplName from SplTabel");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
				{
				 cb1.addItem(rs.getString(1));
				}
			}
		 catch(Exception e)
			{
			 System.out.println(e);
			}
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==cb1)
			{
			 try
				{
				 l1.setVisible(true);
				 l2.setVisible(true);
				 t2.setVisible(true);
				 t3.setVisible(true);
				 b4.setVisible(true);
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
               //        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps1=con.prepareStatement("select * from SplTabel where CONVERT(varchar,SplName)=?");
				 ps1.setString(1,String.valueOf(cb1.getSelectedItem()));
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next())
					{
					 t1.setText(rs1.getString(4));
					 t2.setText(rs1.getString(2));
					 t3.setText(String.valueOf(rs1.getInt(1)));
					 t.setText(rs1.getString(3));
					 t4.setText(rs1.getString(5));
					 t5.setText(rs1.getString(6));
					 t6.setText(rs1.getString(7));
					 t7.setText(rs1.getString(8));
					 t8.setText(rs1.getString(9));
					 t9.setText(rs1.getString(10));
					}

				}
			 catch(Exception e5)
				{
				 System.out.println(e5);
				}
			}
		 if(e.getSource()==b1)
			{
			 try
				{
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			//  Class.forName("com.mysql.jdbc.Driver");
                   //    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
	
				 
				 PreparedStatement ps2=con.prepareStatement("update SplTabel set SplName=?,Address=?,City=?,State=?,Country=?,Spl_emailID=?,PH_No=?,VAT_No=?,PAN_No=? where SplName=?");
//PreparedStatement ps2=con.prepareStatement("update SplTabel set Address=?,City=?,State=?,Country=?,SplemailID=?,PH_No=? //where SplName=?"); 
				ps2.setString(1,t2.getText());
				 ps2.setString(2,t.getText());
				ps2.setString(3,t1.getText());
				ps2.setString(4,t4.getText());
				 ps2.setString(5,t5.getText());
				ps2.setString(6,t6.getText());
				 ps2.setString(7,t7.getText());
				 ps2.setString(8,t8.getText());
				 ps2.setString(9,t9.getText());
				 ps2.setString(10,String.valueOf(cb1.getSelectedItem()));
				 ps2.executeUpdate();
				 JOptionPane.showMessageDialog(this,"spl_info updated successfully");
				 t.setText("");
				 t1.setText("");
				 t2.setText("");
				 t4.setText("");
				 t5.setText("");
				 t6.setText("");
				 t7.setText("");
				 t8.setText("");
				 t9.setText("");
				}
			 catch(Exception e6)
				{
				 System.out.println("yyyyyyyyyyyyyyy"+e6);
				}
			}
		 if(e.getSource()==b2)
			{
			 setVisible(false);
		 	 Supplier s1=new Supplier();
			}
		 if(e.getSource()==b4)
			{
			 setVisible(true);
			 int i=JOptionPane.showConfirmDialog(this,"Is SupplierName & SplID same as u want ?");
			 if(i==0)
				{
				 cb1.setVisible(false);
				 l1.setBounds(140,50,80,30);
				 t2.setBounds(240,50,150,30);
				 l2.setVisible(false);
				 t3.setVisible(false);
				 b4.setVisible(false);
				 l3.setVisible(true);
				 t1.setVisible(true);
				 l4.setVisible(true);
				 t.setVisible(true);
				 s.setVisible(true);
				 l5.setVisible(true);
				 t4.setVisible(true);
				 l6.setVisible(true);
				 l7.setVisible(true);
				 l8.setVisible(true);
				 l9.setVisible(true);
				 l10.setVisible(true);
				 t5.setVisible(true);
				 t6.setVisible(true);
				 t7.setVisible(true);
				 t8.setVisible(true);
				 t9.setVisible(true);
				 b1.setVisible(true);
				 b2.setVisible(false);
				 b3.setVisible(true);
				}
			 if(i==1)
				{
				 setVisible(true);
				 t2.setText("");
				 t3.setText("");
				}
			 if(i==2)
				{
				 setVisible(true);
				}
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 upSupplier us=new upSupplier();
			}
		}
	 public static void main(String arg[])
		{
		 upSupplier us=new upSupplier();
		}
	}