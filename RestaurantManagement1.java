import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RestaurantManagement1 implements ActionListener
{
	Label lblHead;
	Button btnMenu, btnOrder, btnCustomer, btnTable;
	RestaurantManagement1()
	{
		Frame f=new Frame("Restaurant Management System");
		lblHead=new Label("Restaurant Management System");
		btnMenu=new Button("Menu Management");
		btnOrder=new Button("Order Management");
		btnCustomer=new Button("Customer Management");
		btnTable=new Button("Table Management");
		
		lblHead.setBounds(20, 50, 200, 20);
		btnMenu.setBounds(100, 100, 150, 20);
		btnOrder.setBounds(100, 150, 150, 20);
		btnCustomer.setBounds(100, 200, 150, 20);
		btnTable.setBounds(100, 250, 150, 20);
		btnMenu.addActionListener(this);
		btnOrder.addActionListener(this);
		btnCustomer.addActionListener(this);
		btnTable.addActionListener(this);
		
		f.add(lblHead);
		f.add(btnMenu);
		f.add(btnOrder);
		f.add(btnCustomer);
		f.add(btnTable);
		f.setSize(700,700);    
		f.setLayout(null);    
		f.setVisible(true); 
		f.setTitle("Restaurant Management System");
		f.setBackground(new Color(230,230,250));
	}
	public static void main(String args[])
	{
		
		RestaurantManagement1 rst=new RestaurantManagement1();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object source=ae.getSource();
		if(source==btnOrder)
		{
			new Order();
		}
		else if(source==btnMenu)
		{
			new MenuPage();
		}
		else if(source==btnCustomer)
		{
			new Customer();
		}
		else if(source==btnTable)
		{
			new Tables();
		}
		
	}
}
		