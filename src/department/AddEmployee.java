package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class AddEmployee extends JFrame implements ActionListener
	{
	 int id=100;
	 JTextField t2,t3,t5,t6,t7,t8,t9;
	 JLabel l1,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	 JButton b1,b2;
	 JComboBox c1;
	 JTextArea t4; 
	static Connection con;
	 AddEmployee( )
		{
		 setSize(600,700);
		 setLayout(null);
		 Font F=new Font("arial",Font.BOLD,15);
		 Font F1=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 t2=new JTextField(15);
		 t3=new JTextField(15);
		 t4=new JTextArea(25,25);
		 t5=new JTextField(15);
		 t6=new JTextField(15);
		 t7=new JTextField(15);
		 t8=new JTextField(15);
		 t9=new JTextField(15);
		 l1=new JLabel("Employee Record");
		 l3=new JLabel("First Name :");
		 l4=new JLabel("Last Name :");
		 l5=new JLabel("Emp_email ID :");
		 l6=new JLabel("Address :");	
		 l7=new JLabel("PH No :");
		 l8=new JLabel("Position :");
		 l9=new JLabel("City :");
		 l10=new JLabel("State :");
		 l11=new JLabel("Country :");
		 b1=new JButton("Add");
		 b2=new JButton("Back");
		 c1=new JComboBox();
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 l5.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l7.setForeground(Color.black);
		 l8.setForeground(Color.black);
		 l9.setForeground(Color.black);
		 l10.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 c1.setForeground(Color.black);
		 String S7[]={"Managing Director","General Manager","Executive Director","Manager","Astt.Manager"};
		 c1=new JComboBox( S7);
		 l1.setFont(F1);
		 l3.setFont(F);
		 l4.setFont(F);
		 l5.setFont(F);
		 l6.setFont(F);
		 l7.setFont(F);
		 l8.setFont(F);
		 l9.setFont(F);
		 l10.setFont(F);
		 l11.setFont(F);
		 b1.setFont(F);
		 b2.setFont(F);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 add(l1);
		 add(l3);
		 add(l4);
		 add(t2);
		 add(t3);
		 add(l5);
		 add(t4);
		 add(l6);
		 add(t5);
		 add(l9);
		 add(t7);
		 add(l10);
		 add(t8);
		 add(l11);
		 add(t9);
		 add(l7);
		 add(t6);
		 add(l8);
		 add(b1);
		 add(b2);
		 add(c1);
		 l1.setBounds(140,40,400,30);
		 l3.setBounds(90,100,150,30);
		 l4.setBounds(90,140,150,30);
		 l6.setBounds(90,180,150,30);
		 l9.setBounds(90,270,150,30);
		 l10.setBounds(90,310,150,30);
		 l11.setBounds(90,350,150,30);
		 l5.setBounds(90,390,150,30);
		 l7.setBounds(90,430,150,30);
		 l8.setBounds(90,470,150,30);
		 t2.setBounds(250,100,160,30);
		 t3.setBounds(250,140,160,30);
		 t4.setBounds(250,180,160,80);
		 t5.setBounds(250,270,160,30);
		 t6.setBounds(250,310,160,30);
		 t7.setBounds(250,350,160,30);
		 t8.setBounds(250,390,160,30);
		 t9.setBounds(250,430,160,30);
		 c1.setBounds(250,470,160,30);
		 b1.setBounds(140,530,100,35);
		 b2.setBounds(290,530,100,35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		 JScrollPane s=new JScrollPane(t4,v,h);
		 s.setBounds(250,180,160,80);
		 add(s);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b1)
			{
			 if(t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals(""))
				{
				 JOptionPane.showMessageDialog(this,"Some Fields Are Empty");
				}
			 else
		 		{
			 	 try
					{
				 	// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 	// Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
                      // Class.forName("com.sqlserver.jdbc.Driver");
                     
			 		  con = DBConnection.DBConnection();
					PreparedStatement ps=con.prepareStatement("select max(EmpID) from emptabel");
				 	 ResultSet rs=ps.executeQuery();
			 	 	 if(rs.next()==true)
						{
						 id=rs.getInt(1)+1;						
						}
					 PreparedStatement ps1=con.prepareStatement("insert into emptabel values(?,?,?,?,?,?,?,?,?,?)");				 
					 ps1.setInt(1,id);
					 ps1.setString(2,t2.getText());
					 ps1.setString(3,t3.getText());
					 ps1.setString(4,t4.getText());
					 ps1.setString(5,t5.getText());
					 ps1.setString(6,t6.getText());
					 ps1.setString(7,t7.getText());
					 ps1.setString(8,t8.getText());
					 ps1.setString(9,t9.getText());
					 ps1.setString(10,(String)c1.getSelectedItem());
					 JOptionPane.showMessageDialog(this,"Congrets! Emp_Info added");
			 		 JOptionPane.showMessageDialog(this,"EmpID is:  "+id);
					 ps1.executeUpdate();
					 con.close();
					}
			 	 catch(Exception e2)
					{
					 System.out.println("Exception is: "+e2);
					}
				}
			 
			 t2.setText("");
			 t3.setText("");
			 t4.setText("");
			 t5.setText("");
			 t6.setText("");
			 t7.setText("");
			 t8.setText("");
			 t9.setText("");
			 t2.requestFocus();
			}
		  if(e.getSource()==b2)
			{
			 setVisible(false);
			 Employees e1=new Employees();
			}
		}
	  public static void main(String arg[ ])
		{
		 AddEmployee ae=new AddEmployee( );
		}
	}
		