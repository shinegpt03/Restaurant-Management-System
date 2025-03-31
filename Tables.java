import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Tables implements ActionListener
{
    Label lblId, lblTbno, lblCapacity;
    TextField txtId, txtTbno, txtCapacity;
	TextArea txaTable;
    Button btnAdd, btnUpdate, btnDelete, btnShow, btnBack;

    public Tables() 
	{
		Frame f=new Frame("Tables Availability");
		
		lblId = new Label("Id:");
        lblTbno = new Label("Table no.:");
		lblCapacity = new Label("Table Capacity:");
        txtId = new TextField(10);
		txtTbno=new TextField(20);
		txtCapacity=new TextField(20);
		txaTable=new TextArea();
		btnAdd = new Button("Add");
		btnUpdate = new Button("Update");
		btnDelete = new Button("Delete");
		btnShow=new Button("Show");
		btnBack=new Button("Back");
		
		lblId.setBounds(40, 100,100,30);  
		txtId.setBounds(140, 100,100,30); 
		lblTbno.setBounds(40, 150, 100, 30); 
		txtTbno.setBounds(140, 150, 100, 30); 
		lblCapacity.setBounds(40, 200, 100, 30);
		txtCapacity.setBounds(140, 200, 100, 30); 
		txaTable.setBounds(300, 50, 300, 300);
		btnAdd.setBounds(50, 300, 60, 30);
		btnUpdate.setBounds(110, 300, 60, 30);
		btnDelete.setBounds(170, 300, 60, 30);
		btnShow.setBounds(230, 300, 60, 30);
		btnBack.setBounds(110, 350,120,30);
		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnShow.addActionListener(this);
		btnBack.addActionListener(this);
       
        f.setTitle("Tables Availability");
        f.setSize(700, 700);
        f.setLayout(new FlowLayout());
		f.setLayout(null);    
		f.setVisible(true); 
		f.setBackground(new Color(230,230,250));

        // Add components to the frame
        f.add(lblId);
        f.add(txtId);
        f.add(lblTbno);
        f.add(txtTbno);
		f.add(lblCapacity);
		f.add(txtCapacity);
		f.add(txaTable);
        f.add(btnAdd);
		f.add(btnUpdate);
		f.add(btnDelete);
		f.add(btnShow);
		f.add(btnBack);

	}
	public static void main(String[] args) 
	{
        new Tables();
    }
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btnAdd)
			addData();
		if(ae.getSource()==btnUpdate)
			updtData();
		if(ae.getSource()==btnDelete)
			delData();
		if(ae.getSource()==btnShow)
			showData();
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
		String tbno=txtTbno.getText();
		String cap=txtCapacity.getText();
		String strsql="INSERT INTO tables VALUES ('"+id+"','"+tbno+"','"+cap+"')";
		System.out.println(strsql);
		System.out.println("Added successfully");
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
		String tbno=txtTbno.getText();
		String cap=txtCapacity.getText();
		String strsql="UPDATE tables SET id='"+id+"',table_number='"+tbno+"', capacity='"+cap+"' WHERE id='"+id+"'";
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
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		String id=txtId.getText();
		String tbno=txtTbno.getText();
		String cap=txtCapacity.getText();
		String strsql="DELETE FROM tables WHERE id='"+id+"',table_number='"+tbno+"', capacity='"+cap+"'";
		System.out.println(strsql);
		int countInsert=stmt.executeUpdate(strsql);
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	void showData()
	{
		try
		(
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			Statement stmt =con.createStatement();	
		)
		{
		
		String strsql="SELECT * FROM tables";
		System.out.println(strsql);
		ResultSet rsData=stmt.executeQuery(strsql);
		txaTable.setText("");
		while(rsData.next())
		{
			int id=rsData.getInt("id");	
		String tbno=rsData.getString("table_number");
		String cap=rsData.getString("capacity");
		txaTable.append("Id: "+id+ "  Table Number: "+tbno+ " Capacity: "+cap+ "\n");
		}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}