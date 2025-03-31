import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Customer implements ActionListener 
{
	Label lblHead, lblId, lblName, lblPhone, lblEmail;
	TextField txtId, txtName, txtPhone, txtEmail;
	TextArea txaCust;
	Button btnShow, btnAdd, btnDel, btnUpdt, btnBack;
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
		txtPhone=new TextField();
		txtEmail=new TextField();
		txaCust=new TextArea();
		btnShow=new Button("Show Customers");
		btnAdd=new Button("Add");
		btnDel=new Button("Delete");
		btnUpdt=new Button("Update");
		btnBack=new Button("Back");
		
		lblHead.setBounds(50,20,200,30);
		lblId.setBounds(40, 50,100,30);
		lblName.setBounds(40, 100,100,30);
		lblPhone.setBounds(40, 150, 100, 30);
		lblEmail.setBounds(40, 200, 100, 30);
		txtId.setBounds(140,50,100,30);
		txtName.setBounds(140, 100,100,30);
		txtPhone.setBounds(140, 150, 100, 30);
		txtEmail.setBounds(140, 200, 100, 30);
		btnShow.setBounds(110, 620,120,30);
		btnAdd.setBounds(50, 250, 60, 30);
		btnDel.setBounds(110, 250, 60, 30);
		btnUpdt.setBounds(170, 250, 60, 30);
		txaCust.setBounds(70, 300, 300, 300);
		btnBack.setBounds(110,660,120,30);
		btnShow.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdt.addActionListener(this);
		btnBack.addActionListener(this);
		
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
		f.add(btnAdd);
		f.add(btnDel);
		f.add(btnUpdt);
		f.add(btnBack);
        f.setTitle("Customer Management System");
        f.setSize(700, 700);
        f.setLayout(null);
        f.setVisible(true);
		f.setBackground(new Color(230,230,250));
	}
	public static void main(String[] args) 
	{
        new Customer();
    }
    public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btnAdd)
			addCust();
		if(ae.getSource()==btnDel)
			delCust();
		if(ae.getSource()==btnUpdt)
			updtCust();
		if(ae.getSource()==btnShow)
			viewCust();   
		if(ae.getSource()==btnBack)
			new RestaurantManagement1();
    }
	void addCust()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String nam=txtName.getText();
		String phone=txtPhone.getText();
		String email=txtEmail.getText();
		String strsql="INSERT INTO customers VALUES ('"+id+"','"+nam+"','"+phone+"','"+email+"')";
		System.out.println(strsql);
		
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void delCust()
	{
		try
		{
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			PreparedStatement stmt =null;	
		String id=txtId.getText();
		String nam=txtName.getText();
		String phone=txtPhone.getText();
		String email=txtEmail.getText();
		String strsql="DELETE FROM customers WHERE id='"+id+"'";
		System.out.println(strsql);
		stmt=con.prepareStatement(strsql);
		stmt.executeUpdate();
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void updtCust()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String nam=txtName.getText();
		String phone=txtPhone.getText();
		String email=txtEmail.getText();
		String strsql="UPDATE customers SET id='"+id+"', Name='"+nam+"',Phone='"+phone+"',Email='"+email+"' WHERE id='"+id+"'";
		System.out.println(strsql);
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
    void viewCust()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String strsql="SELECT * FROM customers";
		System.out.println(strsql);
		ResultSet rsData=stmt.executeQuery(strsql);
		txaCust.setText("");
		while(rsData.next())
		{
			int id=rsData.getInt("id");	
		String nam=rsData.getString("Name");
		String phone=rsData.getString("phone_number");
		String email=rsData.getString("email");
		txaCust.append("Id: "+id+ "  Name: "+nam+ " Phone: "+phone+ " Email: "+email+ "\n");
		}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
    
}