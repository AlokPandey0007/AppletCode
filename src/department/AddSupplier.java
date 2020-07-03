package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class AddSupplier extends JFrame implements ActionListener
	{
	 int id=000;
	 JTextField t2,t4,t5,t6,t7,t8,t9,t10;
	 JLabel l1,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	 JButton b1,b2;
	 JTextArea t1;
	static Connection con;
	 AddSupplier( )
		{
		 setSize(600,750);
		 setLayout(null);
		 setTitle("Supplier Record");
		 Font F=new Font("arial",Font.BOLD,16);
		 Font F1=new Font("algerian",Font.BOLD,30);
		 Color c=new Color(50,200,150);
		 t1=new JTextArea(15,15);
		 t2=new JTextField(15);
		 t4=new JTextField(15);
		 t5=new JTextField(15);
		 t6=new JTextField(15);
		 t7=new JTextField(15);
		 t8=new JTextField(15);
		 t9=new JTextField(15);
		 t10=new JTextField(15);
		 l1=new JLabel("Supplier Record");
		 l3=new JLabel("Supplier's Name :");
		 l4=new JLabel("Address:");
		 l5=new JLabel("Spl_email ID :");	
		 l6=new JLabel("PH No:");
		 l7=new JLabel("VAT No :");
		 l8=new JLabel("PAN No :");
		 l9=new JLabel("City:");
		 l10=new JLabel("State:");
		 l11=new JLabel("Country:");
		 b1=new JButton("Add");
		 b2=new JButton("Back");
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 l5.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 l7.setForeground(Color.black);
		 l8.setForeground(Color.black);
		 l9.setForeground(Color.black);
		 l10.setForeground(Color.black);
		 l11.setForeground(Color.black);
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
		 b1.setBackground(c);
		 b2.setBackground(c);
		 add(t1);
		 add(l1);
		 add(l3);
		 add(l4);
		 add(t2);
		 add(l5);
		 add(t4);
		 add(l6);
		 add(t5);
		 add(l7);
		 add(t6);
		 add(l8);
		 add(t7);
		 add(b1);
		 add(b2);
		 add(t8);
		 add(l9);
		 add(t9);
		 add(l10);
		 add(t10);
		 add(l11);
		 l1.setBounds(160,40,400,30);
		 l3.setBounds(90,100,150,30);
		 l4.setBounds(90,150,150,30);
		 l9.setBounds(90,270,150,30);
		 l10.setBounds(90,320,150,30);
		 l11.setBounds(90,370,150,30);
		 l5.setBounds(90,420,150,30);
		 l6.setBounds(90,470,150,30);
		 l7.setBounds(90,520,150,30);
		 l8.setBounds(90,570,150,30);
		 t2.setBounds(250,100,160,30);
		 t1.setBounds(250,150,160,100);
		 t8.setBounds(250,270,160,30);
		 t9.setBounds(250,320,160,30);
		 t10.setBounds(250,370,160,30);
		 t4.setBounds(250,420,160,30);
		 t5.setBounds(250,470,160,30);
		 t6.setBounds(250,520,160,30);
		 t7.setBounds(250,570,160,30);
		 b1.setBounds(140,620,100,35);
		 b2.setBounds(290,620,100,35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l9.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l4.setForeground(Color.black);
		 l5.setForeground(Color.black);
		 l6.setForeground(Color.black);
		 l7.setForeground(Color.black);
		 l8.setForeground(Color.black);
		 l10.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		 JScrollPane s=new JScrollPane(t1,v,h);
		 s.setBounds(250,150,160,100);
		 add(s);		 
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	public void actionPerformed(ActionEvent e)
		{
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			 Supplier s1=new Supplier();
			}
		 if(e.getSource()==b1)
			{
			 if(t2.getText().equals("")||t1.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals(""))
				{
				 JOptionPane.showMessageDialog(this,"Some Fields Are Empty");
				}
			 else
				{			 
			 	 try
					{
				 //	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 //	 Connection con=DriverManager.getConnection("jdbc:odbc:Emp1");
                       //Class.forName("com.mysql.jdbc.Driver");
                        con = DBConnection.DBConnection();			
                       PreparedStatement ps1=con.prepareStatement("select max(SupplierID) from SplTabel");
					 ResultSet rs=ps1.executeQuery();
					 if(rs.next()==true)
						{
					 	 id=rs.getInt(1)+1;
						}
					 PreparedStatement ps=con.prepareStatement("insert into SplTabel values(?,?,?,?,?,?,?,?,?,?)");
					 ps.setInt(1,id);
					 ps.setString(2,t2.getText());
					 ps.setString(3,t1.getText());
					 ps.setString(4,t8.getText());
					 ps.setString(5,t9.getText());
					 ps.setString(6,t10.getText());
					 ps.setString(7,t4.getText());
					 ps.setString(8,t5.getText());
					 ps.setString(9,t6.getText());
					 ps.setString(10,t7.getText());
					 ps.executeUpdate();
					 con.close();
					 JOptionPane.showMessageDialog(this,"Congrets! Spl_Info added");
			  		 JOptionPane.showMessageDialog(this,"Supplier ID is: "+id);
					}
			 	 catch(Exception e1)
					{
				 	 System.out.println("exception is"+e1);
					}
				}
			 t2.setText("");
			 t1.setText("");
			 t4.setText("");
			 t5.setText("");
			 t6.setText("");
			 t7.setText("");
			 t8.setText("");
			 t9.setText("");
			 t10.setText("");
			 t2.requestFocus();
			}
		}
	 public static void main(String arg[ ])
		{
		 AddSupplier as=new AddSupplier( );
		}
	}
		