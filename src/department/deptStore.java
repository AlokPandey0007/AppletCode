package department;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class deptStore extends JFrame implements ActionListener
	{
	 public deptStore()
		{
		 setSize(600,700);
		 setLayout(null);
		 setTitle("Departmental Store");
		 Font f1=new Font("algerian",Font.BOLD,30); 
		 JLabel l1=new JLabel("Project On Inventory Store");
		 java.util.Date d1=new java.util.Date();
		 JLabel l11=new JLabel(String.valueOf(d1));
		 Font f2=new Font("monotype corsiva",Font.BOLD,25);
		 Font f3=new Font("arial",Font.BOLD,16);
		 JLabel l2=new JLabel("Submitted To:");
		 JLabel l3=new JLabel("Submitted By:");
		 JLabel l4=new JLabel("Alok Kumar Pandey");
		 JLabel l5=new JLabel("170607324");
		 Color c=new Color(50,200,150);
		 getContentPane().setBackground(c);
		 l1.setForeground(Color.black);
		 l11.setForeground(Color.black);
		 l2.setForeground(Color.black);
		 l3.setForeground(Color.black);
		 l1.setFont(f1);
		 l11.setFont(f3);
		 l1.setBounds(50,100,500,40);
		 l11.setBounds(300,10,300,40);
		 add(l11);
		 l2.setFont(f2);
		 l3.setFont(f2);
		 l4.setFont(f3);
		 l5.setFont(f3);
		 l2.setBounds(30,400,200,30);
		 l3.setBounds(380,400,200,30);
		 l4.setBounds(380,420,200,30);
		 l5.setBounds(380,440,200,30);
		 JButton b1=new JButton("Continue");
		 b1.setBackground(c);
		 b1.setForeground(Color.black);
		 b1.setBounds(470,610,100,30);
		 add(l1);
		 add(l2);
		 add(l3);
		 add(l4);
		 add(l5);
		 add(b1);
		 b1.addActionListener(this);
		 setVisible(true);
		}
	 public void actionPerformed(ActionEvent e)
		{
		 setVisible(false);
		 login d2=new login();
		}
	 public static void main(String arg[])
		{
		 
		 deptStore d1=new deptStore();
		}
	}
   		 