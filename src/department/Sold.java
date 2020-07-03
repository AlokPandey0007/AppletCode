package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Sold extends JFrame implements ActionListener
	{
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	 JTextField t1,t2,t3,t4,t5;
	 JButton b1,b2,b3;
	 JComboBox cb1,cb2;
	 static   Connection con ;
	 Sold()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Sale Invoice");
		 Font f1=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 l1=new JLabel("Sale Invoice");
		 Font f2=new Font("arial",Font.BOLD,16);
		 l1.setFont(f1);
		 l2=new JLabel("Item's Category:");
		 l3=new JLabel("Item:");
		 l8=new JLabel("Current Stock:");
		 l4=new JLabel("Date Of Sale:");
		 l5=new JLabel("Units Sold:");
		 l6=new JLabel("Price/Unit:");
		 l7=new JLabel("Amount Payable:");
		 b1=new JButton("Calculate Amount");
		 b2=new JButton("Save");
		 b3=new JButton("Back");
		 t1=new JTextField(20);
		 t2=new JTextField(20);
		 t3=new JTextField(20);
		 t4=new JTextField(20);
		 t5=new JTextField(20);
		 cb1=new JComboBox();
		 cb2=new JComboBox();
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(l6);
		 add(l7);
		 add(l8);
		 add(b1);
		 add(b2);
		 add(b3);
		 add(cb1);
		 add(cb2);
		 add(t1);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(t5);
		 cb1.addItem("Select Category");
		 l2.setFont(f2);
		 l3.setFont(f2);
		 l4.setFont(f2);
		 l5.setFont(f2);
		 l6.setFont(f2);
		 l7.setFont(f2);
		 l8.setFont(f2);
		 l1.setBounds(160,60,500,40);
		 l2.setBounds(80,130,200,35);
		 l3.setBounds(80,180,200,35);
		 l8.setBounds(80,230,200,35);
		 l4.setBounds(80,280,200,35);
		 l5.setBounds(80,330,200,35);
		 l6.setBounds(80,380,200,35);
		 l7.setBounds(80,500,200,35);
		 b1.setBounds(220,450,140,35);
		 b2.setBounds(240,550,100,35);
		 b3.setBounds(240,600,100,35);
		 cb1.setBounds(290,130,200,30);
		 cb2.setBounds(290,180,200,30);
		 t1.setBounds(290,230,200,30);
		 t2.setBounds(290,280,200,30);
		 t3.setBounds(290,330,200,30);
		 t5.setBounds(290,380,200,30);
		 t4.setBounds(290,500,200,30);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 l7.setVisible(false);
		 t4.setVisible(false);
		 b2.setVisible(false);
		 cb1.addActionListener(this);
		 cb2.addActionListener(this);
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			//  Class.forName("com.mysql.jdbc.Driver");
                  con   = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
	
			 PreparedStatement ps1=con.prepareStatement("select Categories from Category");
			 ResultSet rs=ps1.executeQuery();
			 while(rs.next())
				{
				 cb1.addItem(rs.getString(1));
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
		 if(e.getSource()==cb1)
			{
		 	 try
				{
				 cb2.removeAllItems();
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			//  Class.forName("com.mysql.jdbc.Driver");
               //        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps2=con.prepareStatement("select distinct IName from Items where Category=?");
				 ps2.setString(1,String.valueOf(cb1.getSelectedItem()));
				 ResultSet rs1=ps2.executeQuery();
				 while(rs1.next())
					{
					 cb2.addItem(rs1.getString(1));
					}
				}
			 catch(Exception ee)
				{
				 System.out.print("Exception is: "+ee);
				}
			}
		 if(e.getSource()==b1)
			{
			 l7.setVisible(true);
			 t4.setVisible(true);
			 String S=t3.getText();
			 String S1=t5.getText();
			 int v=Integer.parseInt(S);
			 int w=Integer.parseInt(S1);
			 int q=v*w;
			 String S2=String.valueOf(q);
			 t4.setText(S2);
			 b2.setVisible(true);
			}
		 if(e.getSource()==b2)
			{
			 if(t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||cb1.getSelectedItem().equals("Select Category"))   
				{
				 JOptionPane.showMessageDialog(this,"Some Fields are Empty");
				}
			 else
				{
				 int s=0; 
				 int s1=0;
				 setVisible(true);
				 int i=JOptionPane.showConfirmDialog(this,"Are you sure ?");
                                 if(i==0)
					{
					 try
						{
	//		 			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			//  Class.forName("com.mysql.jdbc.Driver");
                 //      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps1=con.prepareStatement("select * from Items where IName=?");
						 ps1.setString(1,(String)cb2.getSelectedItem());
						 ResultSet rs=ps1.executeQuery();
						 while(rs.next())
					 		{
					 		 s=Integer.parseInt(rs.getString(4));
							}
						 if(s<(Integer.parseInt(t3.getText())))
							{
							 JOptionPane.showMessageDialog(this,"Sorry U have not so many items");
							 t3.setText("");
							}
						 else
							{
							 try
								{
								 PreparedStatement ps=con.prepareStatement("insert into Purchase values(?,?,?,?,?,?,?,?,?)");
								 ps.setString(1,String.valueOf(cb1.getSelectedItem()));
								 ps.setString(2,String.valueOf(cb2.getSelectedItem()));
								 ps.setString(3,"----");
								 ps.setString(4,t1.getText());
								 ps.setString(5,t2.getText());
								 ps.setString(6,t3.getText());
								 ps.setString(7,t5.getText());
								 ps.setString(8,t4.getText());
								 ps.setString(9,"Sale");
								 ps.executeUpdate();
								 PreparedStatement ps2=con.prepareStatement("Update Items set CurrentStock=? where IName=?");
								 ps2.setString(1,String.valueOf(Integer.parseInt(t1.getText())-Integer.parseInt(t3.getText())));
								 ps2.setString(2,String.valueOf(cb2.getSelectedItem()));
								 ps2.executeUpdate();
								 PreparedStatement ps3=con.prepareStatement("select * from Items where IName=?");
								 ps3.setString(1,(String)cb2.getSelectedItem());
								 ResultSet rs1=ps3.executeQuery();
								 while(rs1.next())
					 				{
					 				 s1=Integer.parseInt(rs1.getString(5));
									}
								 if(s1>(Integer.parseInt(t1.getText())-Integer.parseInt(t3.getText())))
									{
									 JOptionPane.showMessageDialog(this,"your stock is below minimum level,pls purchase more stock");
									}
								 t2.setText("");
			 	 				 t3.setText("");
			 					 t4.setText("");
			 					 t5.setText("");
			 					 t1.setText("");
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
			 		 t1.setText("");
					}
				 if(i==2)
					{
					 setVisible(true);
					}
				}				 
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
			 StockDetails d4=new StockDetails();
			}
		 if(e.getSource()==cb2)
			{
			 try
				{
				 t1.setEnabled(false);
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			//  Class.forName("com.mysql.jdbc.Driver");
             //          Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps3=con.prepareStatement("select CurrentStock from Items where IName=?");
				 ps3.setString(1,(String)cb2.getSelectedItem());
				 ResultSet rs2=ps3.executeQuery();
				 while(rs2.next())
					{
					 t1.setText(rs2.getString(1));
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
		 Sold s1=new Sold();
		}
	}
		