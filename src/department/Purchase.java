package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Purchase extends JFrame implements ActionListener
	{
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	 JTextField t1,t2,t3,t4,t5,t6;
	 JButton b1,b2,b3;
	 JComboBox cb2,cb3,cb5;
	 static Connection con ;
	 Purchase()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Purchase");
		 Font f1=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Material Receipt");
		 Font f2=new Font("arial",Font.BOLD,16);
		 l1.setFont(f1);
		 l2=new JLabel("Item's Category:");
		 l3=new JLabel("Item:");
		 l4=new JLabel("Supplier Name:");
		 l5=new JLabel("Current Stock:");
		 l6=new JLabel("Date Of Order:");
		 l7=new JLabel("Units Ordered:");
		 l8=new JLabel("Price/Unit:");
		 l9=new JLabel("Amount Payable:");
		 b1=new JButton("Calculate Amount");
		 b2=new JButton("Save");
		 b3=new JButton("Back");
		 t1=new JTextField(20);
		 t2=new JTextField(20);
		 t3=new JTextField(20);
		 t4=new JTextField(20);
		 t5=new JTextField(20);
		 t6=new JTextField(20);
		 cb5=new JComboBox();
		 cb2=new JComboBox();
		 cb3=new JComboBox();
		 cb3.addItem("Select Category");
		 cb2.addItem("Choose Supplier");
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(l6);
		 add(l7);
		 add(l8);
		 add(l9);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(cb5);
		 add(cb2);
		 add(cb3);
		 add(t1);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(t5);
		 add(t6);
		 l2.setFont(f2);
		 l3.setFont(f2);
		 l4.setFont(f2);
		 l5.setFont(f2);
		 l6.setFont(f2);
		 l7.setFont(f2);
		 l8.setFont(f2);
		 l9.setFont(f2);
		 l1.setBounds(150,40,500,40);
		 l2.setBounds(50,100,200,40);
		 l3.setBounds(50,150,200,40);
		 l4.setBounds(50,200,200,40);
		 l5.setBounds(50,250,200,40);
		 l6.setBounds(50,300,200,40);
		 l7.setBounds(50,350,200,40);
		 l8.setBounds(50,400,200,40);
		 l9.setBounds(50,500,200,40);
		 b2.setBounds(210,550,100,35);
		 b3.setBounds(210,600,100,35);
		 cb3.setBounds(300,100,200,30);
		 cb5.setBounds(300,150,200,30);
		 cb2.setBounds(300,200,200,30);
		 t2.setBounds(300,250,200,30);
		 t3.setBounds(300,300,200,30);
		 t4.setBounds(300,350,200,30);
		 t5.setBounds(300,400,200,30);
		 b1.setBounds(200,450,140,35);
		 t6.setBounds(300,500,200,30);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 l9.setVisible(false);
		 t6.setVisible(false);
		 b2.setVisible(false);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 l5.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 l7.setForeground(Color.black);
		 l8.setForeground(Color.black);
		 l9.setForeground(Color.black);
		 cb3.addActionListener(this);
		 cb5.addActionListener(this);
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
	
			 PreparedStatement ps1=con.prepareStatement("select Categories from Category");
			 ResultSet rs=ps1.executeQuery();
			 while(rs.next())
				{
				 cb3.addItem(rs.getString(1));
				}
			 PreparedStatement ps3=con.prepareStatement("select SplName from SplTabel");
			 ResultSet rs2=ps3.executeQuery();
			 while(rs2.next())
				{
				 cb2.addItem(rs2.getString(1));
				}
			}
		 catch(Exception e)
			{
			 System.out.println(e);
			}
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e1)
		{
		 if(e1.getSource()==b1)
			{
			 l9.setVisible(true);
			 t6.setVisible(true);
			 String S=t4.getText( );
			 String S1=t5.getText( );
			 int v=Integer.parseInt(S);
			 int w=Integer.parseInt(S1);
			 int q=v*w;
			 String S2=String.valueOf(q);
			 t6.setText(S2);
			 b2.setVisible(true);			 
			}
		 if(e1.getSource()==b2)
			{
			 if(t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||cb3.getSelectedItem().equals("Select Category")||cb2.getSelectedItem().equals("Choose Supplier"))   
				{
				 JOptionPane.showMessageDialog(this,"Some Fields are Empty");
				}
			 else
				{
				 int s=0;
				 setVisible(true);
				 int i=JOptionPane.showConfirmDialog(this,"Are you sure ?");
				 if(i==0)
					{
					 try
						{
	//		 			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
               //        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps1=con.prepareStatement("select * from Items where IName=?");
						 ps1.setString(1,(String)cb5.getSelectedItem());
						 ResultSet rs=ps1.executeQuery();
						 while(rs.next())
					 		{
					 		 s=Integer.parseInt(rs.getString(3));
							}
						 if(s<(Integer.parseInt(t2.getText())+Integer.parseInt(t4.getText())))
						{
							 JOptionPane.showMessageDialog(this,"Sorry U can't purchase so many items,pls less some amount");
							}
						 else
							{
							 try
								{
								 PreparedStatement ps=con.prepareStatement("insert into Purchase values(?,?,?,?,?,?,?,?,?)");
								 ps.setString(1,String.valueOf(cb3.getSelectedItem()));
								 ps.setString(2,String.valueOf(cb5.getSelectedItem()));
								 ps.setString(3,String.valueOf(cb2.getSelectedItem()));
								 ps.setString(4,t2.getText());
								 ps.setString(5,t3.getText());
								 ps.setString(6,t4.getText());
								 ps.setString(7,t5.getText());
								 ps.setString(8,t6.getText());
								 ps.setString(9,"Purchase");
								 ps.executeUpdate();
								 PreparedStatement ps2=con.prepareStatement("Update Items set CurrentStock=? where IName=?");
								 ps2.setString(1,String.valueOf((Integer.parseInt(t4.getText())+Integer.parseInt(t2.getText()))));
								 ps2.setString(2,String.valueOf(cb5.getSelectedItem()));
								 ps2.executeUpdate();
								 JOptionPane.showMessageDialog(this,"Congrets! Purchase info added");
								 t2.setText("");
			 	 				 t3.setText("");
			 					 t4.setText("");
			 					 t5.setText("");
			 					 t6.setText("");
								}
							  catch(Exception a1)
								{
								}
							}
						}
					 catch(Exception a)
						{
						}
					}
				 if(i==1)
					{
					 setVisible(true);
					 t2.setText("");
			 	 	 t3.setText("");
			 		 t4.setText("");
			 		 t5.setText("");
			 		 t6.setText("");
					}
				 if(i==2)
					{
					 setVisible(true);
					}	
				}
			}
		 if(e1.getSource()==b3)
			{
			 setVisible(false);
			 StockDetails d4=new StockDetails();
			}
		 if(e1.getSource()==cb3)
			{
		 	 try
				{
				 cb5.removeAllItems();	
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  //Class.forName("com.mysql.jdbc.Driver");
            //           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps2=con.prepareStatement("select distinct IName from Items where Category=?");
				 ps2.setString(1,(String)cb3.getSelectedItem());
				 ResultSet rs1=ps2.executeQuery();
				 while(rs1.next())
					{
					 cb5.addItem(rs1.getString(1));
					}
				}
			 catch(Exception ee)
				{
				 System.out.print("Exception is: "+ee);
				}
			}
		 if(e1.getSource()==cb5)
			{
			 try
				{
				 t2.setEnabled(false);
				 t2.setForeground(Color.black);
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  //Class.forName("com.mysql.jdbc.Driver");
              //         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps3=con.prepareStatement("select CurrentStock from Items where IName=?");
				 ps3.setString(1,(String)cb5.getSelectedItem());
				 ResultSet rs2=ps3.executeQuery();
				 while(rs2.next())
					{
					 t2.setText(rs2.getString(1));
					}
				}
			 catch(Exception ee1)
				{
				 System.out.print("Exception is: "+ee1);
				}
			}
		
		}
	 public static void main(String arg[])
		{
		 Purchase p1=new Purchase();
		}
	}
		