package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class SplTable extends JFrame implements ActionListener
	{
	 JButton b1;
	 int count,i=0;
	 static Connection con;
	 SplTable()
		{
		 try
			{
			 setSize(600,700);
		 	 setLayout(null);
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
	
			 PreparedStatement ps=con.prepareStatement("select count(*) from SplTabel");
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
				{
				 count=rs.getInt(1);
				}
		 	 setTitle("All Spl_Details");
			 Color c=new Color(50,200,150);
			 b1=new JButton("Back");
			 b1.setBounds(200,550,100,35);
			 String s[]={"SupplierID","SplName","Address","City","State","Country","Spl_email ID","PH No","VAT No","PAN No"};
			 String s1[][]=new String[count][10];
			 PreparedStatement ps1=con.prepareStatement("select * from SplTabel");
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 s1[i][0]=String.valueOf(rs1.getInt(1));
				 s1[i][1]=rs1.getString(2);
				 s1[i][2]=rs1.getString(3);
				 s1[i][3]=rs1.getString(4);
				 s1[i][4]=rs1.getString(5);
				 s1[i][5]=rs1.getString(6);
				 s1[i][6]=rs1.getString(7);
				 s1[i][7]=rs1.getString(8);
				 s1[i][8]=rs1.getString(9);
				 s1[i][9]=rs1.getString(10);
				 i++;
				}
			 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			 JTable jt=new JTable(s1,s);
			 JScrollPane jp=new JScrollPane(jt,v,h);
			 add(jp);
			 add(b1);
			 jp.setBounds(0,5,590,450);
		 	 b1.setBackground(c);
			 b1.addActionListener(this);
			 getContentPane().setBackground(c);
			 setVisible(true);
			}
		  catch(Exception ee)
			{
			 System.out.println(ee);
			}
		  
		}
	 public void actionPerformed(ActionEvent ae)
		{
		 setVisible(false);
		 SplDetails sd=new SplDetails();
		}
	 public static void main(String arg[])
		{
		 SplTable st=new SplTable();
		}
	}
		 	 
		 	 
			