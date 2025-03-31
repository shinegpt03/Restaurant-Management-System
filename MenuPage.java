import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MenuPage implements ActionListener
{
    Label lblId, lblName, lblPrice, lblMenu;
    TextField txtId, txtName, txtPrice;
	TextArea txaArea;
    Button btnAdd, btnUpdate, btnDelete, btnView, btnBack;

    public MenuPage() 
	{
		Frame f=new Frame("Menu");
		lblId=new Label("Id");
		lblName = new Label("Name:");
        lblPrice = new Label("Price:");
		lblMenu = new Label("Menu Items:");
		txtId=new TextField(10);
		txtName = new TextField(20);
        txtPrice = new TextField(10);
		txaArea=new TextArea();
		btnAdd = new Button("Add");
		btnUpdate = new Button("Update");
		btnDelete = new Button("Delete");
		btnView=new Button("View Menu");
		btnBack=new Button("Back");
		
		lblId.setBounds(40, 50,100,30);
		txtId.setBounds(140,50,100,30);
		lblName.setBounds(40, 100,100,30);  
		txtName.setBounds(140, 100,100,30); 
		lblPrice.setBounds(40, 150, 100, 30); 
		txtPrice.setBounds(140, 150, 100, 30);
		lblMenu.setBounds(300, 20,100,30);		
		txaArea.setBounds(300, 50, 300, 300);
		btnAdd.setBounds(50, 300, 60, 30);
		btnUpdate.setBounds(110, 300, 60, 30);
		btnDelete.setBounds(170, 300, 60, 30);
		btnView.setBounds(230,300,60,30);
		btnBack.setBounds(110, 350,120,30);
		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnView.addActionListener(this);
		btnBack.addActionListener(this);
       
        f.setTitle("Menu Page");
        f.setSize(700, 700);
        f.setLayout(new FlowLayout());
		f.setLayout(null);    
		f.setVisible(true);
		f.setBackground(new Color(230,230,250));		

        // Add components to the frame
		f.add(lblId);
		f.add(txtId);
        f.add(lblName);
        f.add(txtName);
        f.add(lblPrice);
        f.add(txtPrice);
		f.add(lblMenu);
		f.add(txaArea);
        f.add(btnAdd);
		f.add(btnUpdate);
		f.add(btnDelete);
		f.add(btnView);
		f.add(btnBack);

	}
	public static void main(String[] args) 
	{
        new MenuPage();
    }
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btnAdd)
			addData();
		if(ae.getSource()==btnUpdate)
			updtData();
		if(ae.getSource()==btnDelete)
			delData();
		if(ae.getSource()==btnView)
			viewData();
		if(ae.getSource()==btnBack)
			new RestaurantManagement1();
    }
    void addData()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String nam=txtName.getText();
		String price=txtPrice.getText();
		String strsql="INSERT INTO menu VALUES ('"+id+"','"+nam+"','"+price+"')";
		System.out.println(strsql);
		
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void updtData()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String nam=txtName.getText();
		String price=txtPrice.getText();
		String strsql="UPDATE menu SET id='"+id+"', Name='"+nam+"',Price='"+price+"' WHERE id='"+id+"'";
		System.out.println(strsql);
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void delData()
	{
		try
		{
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			PreparedStatement stmt =null;	
		String id=txtId.getText();
		String nam=txtName.getText();
		String price=txtPrice.getText();
		String strsql="DELETE FROM menu WHERE id='"+id+"'";
		System.out.println(strsql);
		stmt=con.prepareStatement(strsql);
		stmt.executeUpdate();
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void viewData()
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
		txaArea.setText("");
		while(rsData.next())
		{
			String id=rsData.getString("id");	
		String nam=rsData.getString("Name");
		String price=rsData.getString("price");
		txaArea.append(id+ "\t" +nam+ "\t"+price+ "\n");
		}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}