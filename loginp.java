package fin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class loginp
{
	JLabel userl,userp,fk;
	JTextField userid;
	JPasswordField userpass;

	void str()
	{
	JFrame ab = new JFrame();
	ab.setSize(500,500);
	ab.setLayout(null);
	ab.setVisible(true);
	ab.setTitle("Login Page");
	ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel bc = new JLabel("Welcome to Our Login Page!!!");
	bc.setFont(new Font(null,Font.BOLD,15));
	bc.setBounds(125,-10,300,100);
	ab.add(bc);
	
	JLabel fk = new JLabel();
	ImageIcon img=new ImageIcon("electric.png.png");
	fk.setIcon(img);
	fk.setBounds(30,60,900,800);
	ab.add(fk);
	
	JButton login = new JButton("Login");
	login.setBounds(100,325,90,30);
	login.setBackground(Color.GRAY);
	ab.add(login);
	JButton Reset = new JButton("Reset");
	ab.add(Reset);
	Reset.setBackground(Color.GRAY);
	Reset.setBounds(200,325,90,30);
	 userl = new JLabel("Username:");
	userl.setBounds(50,180,80,100);
	ab.add(userl);
	 userp = new JLabel("Password:");
	userp.setBounds(50,220,200,100);
	ab.add(userp);
	 userid = new JTextField();
	userid.setBounds(150,220,150,20);
	ab.add(userid);
	userid.setBackground(Color.GRAY);
	 userpass = new JPasswordField();
	userpass.setBounds(150,265,150,20);
	userpass.setBackground(Color.GRAY);
	ab.add(userpass);
	
	login.addActionListener(new ActionListener()
	{
public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==login)
     {
    	 HashMap<String,String> login = new HashMap<String,String>();
    	 String uid = userid.getText();
    	 String password = String.valueOf(userpass.getPassword());

		 login.put("dhruv","ddd");

 		login.put("bhanu","bbb");
    	 
    	 if(login.containsKey(uid))
    	 {
    		 if(login.get(uid).equals(password))
    		 {
    			JOptionPane.showMessageDialog(null,"login Successful");
    			ab.dispose();
    	    	  uid = userid.getText();
    	    	  password =userpass.getText();
    	    	  
    	    	  try {
    	    		  conn c = new conn();
    	    		  String query = "insert into login values('"+uid+"','"+password+"')";
    	    		  c.s.executeUpdate(query);
    	    		  JOptionPane.showMessageDialog(null,"Data Added to the Database");
    	    	  }catch(Exception e1)
    	    	  {
    	    		  e1.printStackTrace();
    	    	  }
    	    	  Dashboard dashboard = new Dashboard();
    	    	  dashboard.dasg();
    			
    		 }
    		 else
    		 {
    			 JOptionPane.showMessageDialog(null,"Login Failed");
    		 }
    	 }
    	 
     }
}
	});
	
	Reset.addActionListener(new ActionListener()
	{
public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==Reset)
     {
    	 userid.setText("");
    	 userpass.setText("");
     }
}
	});
	
	}

	public static void main(String[]args)
	{
		loginp hh = new loginp();
		hh.str();
	}
}