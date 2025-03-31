import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Order implements ActionListener 
{
	Label lblId, lblMenu, lblQuantity;
	TextField txtId, txtMenu, txtQuantity;
	Button btnAdd, btnUpdt, btnDel, btnBack;
    public Order() 
	{
		Frame f=new Frame("Orders");
		lblId=new Label("Id");
		lblMenu=new Label("Menu Id");
		lblQuantity=new Label("Quantity");
		txtId=new TextField();
		txtMenu=new TextField();
		txtQuantity=new TextField();
		btnAdd=new Button("Add");
		btnUpdt=new Button("Update");
		btnDel=new Button("Delete");
		btnBack=new Button("Back");
		
		lblId.setBounds(40, 50,100,30);
		txtId.setBounds(140,50,100,30);
		lblMenu.setBounds(40, 100,100,30);  
		txtMenu.setBounds(140, 100,100,30); 
		lblQuantity.setBounds(40, 150, 100, 30); 
		txtQuantity.setBounds(140, 150, 100, 30);
		btnAdd.setBounds(50, 300, 60, 30);
		btnUpdt.setBounds(110, 300, 60, 30);
		btnDel.setBounds(170, 300, 60, 30);
		btnBack.setBounds(110, 350,120,30);
		btnAdd.addActionListener(this);
		btnUpdt.addActionListener(this);
		btnDel.addActionListener(this);
		btnBack.addActionListener(this);
		
        f.setTitle("Order Management System");
        f.setSize(500, 500);
        f.setLayout(new FlowLayout());
		f.setLayout(null);    
		f.setVisible(true);
		f.setBackground(new Color(230,230,250));
		
		f.add(lblId);
		f.add(lblMenu);
		f.add(lblQuantity);
		f.add(txtId);
		f.add(txtMenu);
		f.add(txtQuantity);
		f.add(btnAdd);
		f.add(btnUpdt);
		f.add(btnDel);
		f.add(btnBack);
		
	}
	public static void main(String[] args) 
	{
        new Order();
    }
    public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btnAdd)
		addOrder();
		if(ae.getSource()==btnUpdt)
		updtOrder();
		if(ae.getSource()==btnDel)
		delOrder();
		if(ae.getSource()==btnBack)
			new RestaurantManagement1();
    }
    void addOrder()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String menu=txtMenu.getText();
		String quan=txtQuantity.getText();
		String strsql="INSERT INTO orders VALUES ('"+id+"','"+menu+"','"+quan+"')";
		System.out.println(strsql);
		
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void updtOrder()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String menu=txtMenu.getText();
		String quan=txtQuantity.getText();
		String strsql="UPDATE orders SET id='"+id+"', menu_id='"+menu+"',quantity='"+quan+"' WHERE id='"+id+"'";
		System.out.println(strsql);
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void delOrder()
	{
		try
		{
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			PreparedStatement stmt =null;	
		String id=txtId.getText();
		String menu=txtMenu.getText();
		String quan=txtQuantity.getText();
		String strsql="DELETE FROM orders WHERE id='"+id+"'";
		System.out.println(strsql);
		stmt=con.prepareStatement(strsql);
		stmt.executeUpdate();
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}