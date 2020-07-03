package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ItemTable extends JFrame implements ActionListener
	{
	 JButton b1;
	 int count,i=0;
	 static Connection con;
	 ItemTable()
		{
		 try
			{
			 setSize(600,700);
		 	 setLayout(null);
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
	
			 PreparedStatement ps=con.prepareStatement("select count(*) from Items");
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
				{
				 count=rs.getInt(1);
				}
		 	 setTitle("All Items_Details");
			 Color c=new Color(50,200,150);
			 b1=new JButton("Back");
			 b1.setBounds(240,550,100,35);
			 String s[]={"IName","Category","Maximum Stock","Current Stock","Minimum Stock"};
			 String s1[][]=new String[count][5];
			 PreparedStatement ps1=con.prepareStatement("select * from Items");
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 s1[i][0]=rs1.getString(1);
				 s1[i][1]=rs1.getString(2);
				 s1[i][2]=rs1.getString(3);
				 s1[i][3]=rs1.getString(4);
				 s1[i][4]=rs1.getString(5);
				 i++;
				}
			 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			 JTable jt=new JTable(s1,s);
			 JScrollPane jp=new JScrollPane(jt,v,h);
			 add(jp);
			 add(b1);
			 jp.setBounds(0,5,590,400);
			 b1.addActionListener(this);
			 b1.setBackground(c);
			 getContentPane().setBackground(c);
			 b1.setForeground(Color.black);
			 setVisible(true);
			}
		  catch(Exception ee)
			{
			 System.out.println(ee);
			}
		}
	 public void actionPerformed(ActionEvent e1)
		{
		 setVisible(false);
		 Item1 i=new Item1();
		}
	 public static void main(String arg[])
		{
		 ItemTable it=new ItemTable();
		}
	}
		 	 
		 	 
			