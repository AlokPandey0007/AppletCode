package department;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class upItem extends JFrame implements ActionListener
	{
	 TextField t1,t2,t3,t4,t5;
	 JLabel l1,l2,l3,l4,l5;
	 JButton b1,b2,b3;
	 JComboBox cb1,cb2;
	 static Connection con;
	 upItem()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Update Item Information");
		 Color c=new Color(50,200,150);
		 b1=new JButton("Update");
		 b2=new JButton("Back");
		 b3=new JButton("Refresh");
		 t1=new TextField(20);
		 t2=new TextField(20);
		 t3=new TextField(20);
		 t4=new TextField(20);
		 t5=new TextField(20);
		 l1=new JLabel("Item:");
		 l2=new JLabel("Item's Category:");
		 l3=new JLabel("Maximum Stock :");
		 l4=new JLabel("Current Stock:");
		 l5=new JLabel("Minimum Stock:");
		 cb1=new JComboBox();
		 cb1.addItem("Select Item");
		 add(b1);
		 add(b2);
		 add(b3);
		 add(t1);
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(t2);
		 add(t3);
		 add(t4);
		 add(cb1);
		 add(t5);
		 cb1.setBounds(200,200,200,30);
		 l1.setBounds(140,100,100,30);
		 t1.setBounds(250,100,150,30);
		 l2.setBounds(140,160,100,30);
		 t2.setBounds(250,160,150,30);
		 l3.setBounds(140,220,100,30);
		 t3.setBounds(250,220,150,30);
		 l4.setBounds(140,280,100,30);
		 t4.setBounds(250,280,150,30);
		 l5.setBounds(140,340,100,30); 
		 t5.setBounds(250,340,150,30);
		 b1.setBounds(100,500,100,35);
		 b2.setBounds(250,500,100,35);
		 b3.setBounds(400,500,100,35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 b3.setForeground(Color.black);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b3.setBackground(c);
		 l1.setVisible(false);
		 l2.setVisible(false);
		 l3.setVisible(false);
		 l4.setVisible(false);
		 l5.setVisible(false);
		 t1.setVisible(false);
		 t2.setVisible(false);
		 t3.setVisible(false);	 
		 t4.setVisible(false);
		 t5.setVisible(false);
		 b1.setVisible(false);
		 b3.setVisible(false);
		 cb1.addActionListener(this);
		 setVisible(true);
		 getContentPane().setBackground(c);
		 try
			{
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
                        		
	
			 PreparedStatement ps=con.prepareStatement("select IName from Items");
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
				 l3.setVisible(true);
				 l4.setVisible(true);
				 l5.setVisible(true);
				 t1.setVisible(true);
				 t2.setVisible(true);
				 t3.setVisible(true);
				 t4.setVisible(true);
				 t5.setVisible(true);
				 cb1.setVisible(false);
				 b1.setVisible(true);
				 b2.setVisible(false);
				 b3.setVisible(true);
				 t4.setEnabled(false);
	//			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//			 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			  Class.forName("com.mysql.jdbc.Driver");
                       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps1=con.prepareStatement("select * from Items where IName=?");
				 ps1.setString(1,String.valueOf(cb1.getSelectedItem()));
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next())
					{
					 t1.setText(rs1.getString(1));
					 t2.setText(rs1.getString(2));
					 t3.setText(rs1.getString(3));
					 t4.setText(rs1.getString(4));
					 t5.setText(rs1.getString(5));
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
			  Class.forName("com.mysql.jdbc.Driver");
                       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/emp1","root","");
			
		PreparedStatement ps2=con.prepareStatement("update Items set IName=?,Category=?,MaximumStock=?,MinimumStock=? where IName=?");
				 ps2.setString(1,t1.getText());
				 ps2.setString(2,t2.getText());
				 ps2.setString(3,t3.getText());
				 ps2.setString(4,t5.getText());
				 ps2.setString(5,String.valueOf(cb1.getSelectedItem()));
				 ps2.executeUpdate();
				 JOptionPane.showMessageDialog(this,"spl_info updated successfully");
				 t1.setText("");
				 t2.setText("");
				 t3.setText("");
				 t4.setText("");
				 t5.setText("");
				}
			 catch(Exception e6)
				{
				 System.out.println(e6);
				}
			}
		 if(e.getSource()==b2)
			{
			 setVisible(false);
		 	 Item1 i=new Item1();
			}
		 if(e.getSource()==b3)
			{
			 setVisible(false);
		 	 upItem ui=new upItem();
			}
		}
	 public static void main(String arg[])
		{
		 upItem ui=new upItem();
		}
	}