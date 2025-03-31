import java.awt.*;
import java.awt.event.*;

public class MenuWindow 
{
	Label lblMenu;
	TextArea txaMenu;
	
    public MenuWindow() 
	{ 
		Frame f=new Frame("Display Menu");
		lblMenu = new Label("Menu Items:");
		txaMenu = new TextArea();
        f.setTitle("Menu");
        f.setSize(500, 500);

        // Sample menu items (replace with your actual menu items)
        
        

        // Set layout manager to null for simplicity
        f.setLayout(null);

        
        lblMenu.setBounds(60, 30, 100, 20);
        txaMenu.setBounds(100, 50, 360, 200);

        // Add components to the frame
        f.add(lblMenu);
        f.add(txaMenu);

       

        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuWindow();
    }
}
