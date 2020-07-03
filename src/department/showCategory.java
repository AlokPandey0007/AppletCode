package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class showCategory extends JFrame implements ActionListener
	{
	 JButton b1;
	 JTable jt;
	 int count,i=0;
	 static Connection con;
 	 showCategory()
		{
		 try
			{
			 setSize(600,700);
			 setLayout(null);
			 setTitle("showCategory");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con =DBConnection.DBConnection();
	
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 PreparedStatement ps=con.prepareStatement("select count(*) from Category");
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
				{
				 count=rs.getInt(1);
				}
			 Color c=new Color(50,200,150);
			 b1=new JButton("Back");
			 b1.setForeground(Color.black);
			 b1.setBounds(220,550,100,35);
			 Font f1=new Font("arial",Font.BOLD,15);
			 String s[]={"Categories"};
			 String s1[][]=new String[count][1];
			 PreparedStatement ps1=con.prepareStatement("select * from Category");
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
			 	{
				 s1[i][0]=rs1.getString(1);
				 i++;
				}
			 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			 jt=new JTable(s1,s);
			 JScrollPane jp=new JScrollPane(jt,v,h);
			 jp.setBounds(140,50,250,400);
			 add(jp);
			 add(b1);
			 b1.addActionListener(this);
			 b1.setBackground(c);
			 getContentPane().setBackground(c);
			 setVisible(true);
			}
		 catch(Exception e)
			{
			 System.out.println(e);
			}
		}
	 public void actionPerformed(ActionEvent e1)
		{
		 if(e1.getSource()==b1)
			{
			 setVisible(false);
			 Category c1=new Category();
			}
		/* if(e1.getSource()==b2)
			{
			 try
				{
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
				 PreparedStatement ps2=con.prepareStatement("delete from Category where Categories=?");
				 ps2.setString(1,String.valueOf(jt.getSelectedRow()));
				 ps2.executeUpdate();
				}
			 catch(Exception e)
				{
				 
				}
			}*/
		}
	 public static void main(String arg[])
		{
		 showCategory sc=new showCategory();
		}
	}