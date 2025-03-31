import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
public class Login implements ActionListener
{
    Label lblUser,lblPass;
    TextField txtUser,txtPass;
    Button btnLogin,btnRegister, btnReset;
	Login()
	{
		Frame f = new Frame ("Frame1");  
        lblUser=new Label("Username");
		lblPass=new Label("Password");
		txtUser=new TextField();
		txtPass=new TextField();
		txtPass.setEchoChar('*');
		btnLogin=new Button("Login");
		btnRegister=new Button("Register");
		btnReset=new Button("Reset");
		
		lblUser.setBounds(40, 100,100,30);  
		txtUser.setBounds(140, 100,100,30); 
		lblPass.setBounds(40, 150, 100, 30); 
		txtPass.setBounds(140, 150, 100, 30); 	
		btnLogin.setBounds(50, 300, 60, 30); 
		btnRegister.setBounds(110, 300, 60, 30); 
		btnReset.setBounds(170, 300, 60, 30); 
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnReset.addActionListener(this);
		
		f.add(lblUser);  
		f.add(txtUser); 
		f.add(lblPass);
		f.add(txtPass);
		f.add(btnLogin);
		f.add(btnRegister);
		f.add(btnReset);
		f.setSize(400,400);    
		f.setLayout(null);    
		f.setVisible(true); 
		f.setTitle("Restaurant Management System");
		f.setBackground(new Color(230,230,250));
    }
	public static void main(String args[])
	{
		Login log= new Login();
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnLogin)
			logData();
		if(ae.getSource()==btnRegister)
			registerData();
		if(ae.getSource()==btnReset)
			txtUser.setText("");
            txtPass.setText("");
	}
	void logData()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String nam=txtUser.getText();
		String pass=txtPass.getText();
		String strsql="SELECT * FROM login WHERE username='"+nam+"'and password='"+pass+"'";
		System.out.println(strsql);
		ResultSet rsData=stmt.executeQuery(strsql);
		if(rsData.next())
		{
			txtUser.setText(rsData.getString("Username"));
			txtPass.setText(rsData.getString("Password"));
			
			new RestaurantManagement1();
		}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void registerData()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String nam=txtUser.getText();
		String pass=txtPass.getText();
		String strsql="INSERT INTO login VALUES ('"+nam+"','"+pass+"')";
		System.out.println(strsql);
		System.out.println("Added successfully");
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}