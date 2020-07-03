package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class SaleTable extends JFrame implements ActionListener
	{
	 JButton b1;
	 int count,i=0;
	 static Connection con;
	 SaleTable()
		{
		 try
			{
			 setSize(650,700);
		 	 setLayout(null);
	//		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//		 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
			 // Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();
	
			 PreparedStatement ps=con.prepareStatement("select count(*) from Purchase");
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
				{
				 count=rs.getInt(1);
				}
		 	 setTitle("Purchase Details");
			 Color c=new Color(50,200,150);
			 b1=new JButton("Back");
			 b1.setForeground(Color.black);
			 b1.setBounds(230,550,100,35);
			 String s[]={"ItemCategory","Item","Date","Units","Price/Unit","AmountPayable"};
			 String s1[][]=new String[count][6];
			 PreparedStatement ps1=con.prepareStatement("select * from Purchase where Status=?");
			ps1.setString(1,"Sale");
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next())
				{
				 s1[i][0]=rs1.getString(1);
				 s1[i][1]=rs1.getString(2);
				 s1[i][2]=rs1.getString(5);
				 s1[i][3]=rs1.getString(6);
				 s1[i][4]=rs1.getString(7);
				 s1[i][5]=rs1.getString(8);
				 i++;
				}
			 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			 JTable jt=new JTable(s1,s);
			 JScrollPane jp=new JScrollPane(jt,v,h);
			 add(jp);
			 add(b1);
			 jp.setBounds(0,5,640,400);
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
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
			{
			 setVisible(false);
			 StkDetail sd=new StkDetail();
			}
		}
	 public static void main(String arg[])
		{
		 SaleTable st1=new SaleTable();
		}
	}
		 	 
		 	 
			