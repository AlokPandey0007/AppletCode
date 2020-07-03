package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class login extends JFrame implements ActionListener
	{
	 int a;
	 JLabel l1,l2,l11;
	 JTextField t1;
	 TextField t2;
	 JButton b1,b2;
	 login()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Departmental Store");
		 Font f1=new Font("castellar",Font.BOLD,18);
		 Font f2=new Font("bradley hand itc",Font.BOLD,15);
		 Font f3=new Font("arial",Font.BOLD,15);
		 Color c=new Color(50,200,150);
		 l1= new JLabel("User Name: ");
	 	 l2= new JLabel("Password: ");
		 java.util.Date d1=new java.util.Date();
		 l11=new JLabel(String.valueOf(d1));
		 b1=new JButton("Submit");
		 b2=new JButton("Exit");
	 	 t1= new JTextField(15);
	 	 t2= new TextField(15);
		 t2.setEchoChar('*');
		 add(l1);
		 add(l2);
		 add(t1);
		 add(t2);
		 add(b1);
		 add(b2);
		 add(l11);
		 l1.setFont(f1);
		 l11.setFont(f3);
		 l2.setFont(f1);
		 t1.setFont(f2);
		 t2.setFont(f2);
		 b1.setBackground(c);
		 b2.setBackground(c);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 l1.setBounds(120,200,150,35);
		 l2.setBounds(120,250,150,35);
		 t1.setBounds(290,200,150,35);
		 t2.setBounds(290,250,150,35);
		 b1.setBounds(160,400,100,35);
		 b2.setBounds(320,400,100,35);
		 l11.setBounds(300,10,300,40);
		 b1.setForeground(Color.black);
		 b2.setForeground(Color.black);
		 l1.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 getContentPane().setBackground(c);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 String s=t1.getText();
		 String s1=t2.getText();
		 if(e.getSource()==b2)
			{
			 setVisible(false);
			}
		 else if(s.equals("admin")&&s1.equals("admin")&&e.getSource()==b1)
			{
		 	 JOptionPane.showMessageDialog(this,"congragulations!login successful");
		 	 setVisible(false);
		  	 InventoryStore d1=new InventoryStore();
			}
		 else 
			{
			 JOptionPane.showMessageDialog(this,"Sorry!username and password is not correct");
		 	 t1.setText("");
			 t2.setText("");
			 t1.requestFocus();
			}
		}
	 public static void main(String ar[])
		{
		 login d2=new login();
		}
	}