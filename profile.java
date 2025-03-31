import java.awt.*;
class profile
{
	Frame f=new Frame();
	Label lbl1, lbl2, lblTotal;
	Button btnAdd, btnSub,btnMul,btnDiv;   
	profile(){   
    Frame f = new Frame ("Calculator");  
        
	lbl1 = new Label ("First Number");   
    lbl2 = new Label ("Second Number");
	lblTotal = new Label ("Display Calculated values"); 	
    txt1 = new TextField();
	txt2 = new TextField();
	btnAdd= new Button("Add");
	btnSub= new Button("Subtract");
	btnMul= new Button("Multiply");
	btnDiv= new Button("Divide");
	
    
    lbl1.setBounds(40, 100,100,30);  
	txt1.setBounds(140, 100,100,30); 
	lbl2.setBounds(40, 150, 100, 30); 
	txt2.setBounds(140, 150, 100, 30); 	
 	lblTotal.setBounds(50, 200, 150, 30); 
	btnAdd.setBounds(50, 300, 60, 30); 
	btnSub.setBounds(110, 300, 60, 30); 
	btnMul.setBounds(230, 300, 60, 30); 
	btnDiv.setBounds(170, 300, 60, 30); 
	btnAdd.addActionListener(this);
	btnSub.addActionListener(this);
	btnMul.addActionListener(this);
	btnDiv.addActionListener(this);

    // adding textfields to the frame    
    f.add(lbl1);  
    f.add(txt1); 
	f.add(lbl2);
	f.add(txt2);
	f.add(lblTotal);
	f.add(btnAdd);
	f.add(btnSub);
	f.add(btnMul);
	f.add(btnDiv);
	
       
    f.setSize(400,400);    
    f.setLayout(null);    
    f.setVisible(true);    
}    
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==btnAdd)
		lblTotal.setText(Integer.toString(Integer.parseInt(txt1.getText())+Integer.parseInt(txt2.getText())));
	if(ae.getSource()==btnSub)
		lblTotal.setText(Integer.toString(Integer.parseInt(txt1.getText())-Integer.parseInt(txt2.getText())));
	if(ae.getSource()==btnMul)
		lblTotal.setText(Integer.toString(Integer.parseInt(txt1.getText())*Integer.parseInt(txt2.getText())));
	if(ae.getSource()==btnDiv)
		lblTotal.setText(Integer.toString(Integer.parseInt(txt1.getText())/Integer.parseInt(txt2.getText())));
}

public static void main(String args[])
{
	profile cal= new profile();
}
}