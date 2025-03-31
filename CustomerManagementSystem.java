import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Customer implements ActionListener 
{
	Label lblHead, lblId, lblName, lblPhone, lblEmail;
	TextField txtId, txtName, txtPhone, txtEmail;
	TextArea txaCust;
	Button btnShow;
    public Customer() 
	{
        Frame f=new Frame("Customer Management");
		lblHead=new Label("Customer Management System");
		lblId=new Label("Customer Id");
		lblName=new Label("Customer Name");
		lblPhone=new Label("Customer Contact");
		lblEmail=new Label("Customer Email");
		txtId=new TextField();
		txtName=new TextField();
		txtPhone=new TextField():
		txtEmail=new TextField();
		txaCust=new TextArea();
		btnShow=new Button("Show Customers");
		
		lblHead.setBounds(100, 100, 300, 30);
		lblId.setBounds(100, 100, 300, 30);
		lblName.setBounds(100, 100, 300, 30);
		lblPhone.setBounds(100, 100, 300, 30);
		lblEmail.setBounds(100, 100, 300, 30);
		txtId.setBounds(100, 100, 300, 30);
		txtName.setBounds(100, 100, 300, 30);
		txtPhone.setBounds(100, 100, 300, 30);
		txtEmail.setBounds(100, 100, 300, 30);
		txaCust.setBounds(100, 100, 300, 30);
		btnShow.setBounds(100, 100, 300, 30);
		btnShow.addActionListener(this);
		
		f.add(lblHead);
		f.add(lblId);
		f.add(lblName);
		f.add(lblPhone);
		f.add(lblEmail);
		f.add(txtId);
		f.add(txtName);
		f.add(txtPhone);
		f.add(txtEmail);
		f.add(txaCust);
		f.add(btnShow);
        f.setTitle("Customer Management System");
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
	}
	public static void main(String[] args) 
	{
        new CustomerManagementSystem();
    }
    public void actionPerformed(ActionEvent ae) 
	{
        viewCust();        // Code to add a new customer
    }
    void viewCust()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		
		String strsql="SELECT * FROM menu";
		System.out.println(strsql);
		ResultSet rsData=stmt.executeQuery(strsql);
		txaCust.setText("");
		while(rsData.next())
		{
			int id=rsData.getInt("id");	
		String nam=rsData.getString("Name");
		String phone=rsData.getString("phone_number");
		String email=rsData.getString("email");
		txaArea.append("Id: "+id+ "  Name: "+nam+ " Phone: "+phone+ " Email: "+email+ "\n");
		}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
    
}