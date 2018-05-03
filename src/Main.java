
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener
{

	//Declare all the GUI elements
	JPanel panel;
	
	JLabel lblInstructions;

	JLabel lblAngleA;
	JLabel lblAngleB;
	JLabel lblPerimiter;
	JLabel lblHeight;
	JLabel lblArea;
	JLabel lblCircumRadius;
	JLabel lblCircumArea;
	JLabel lblCircumfrence;
	JLabel lblAngles;
	JLabel lblTriangleType;
	
	JTextField txtSideA;
	JTextField txtSideB;
	JTextField txtSideC;
	JTextField txtAngleC;
	
	JButton btnCreate;
	
	//boolean that tells the program if its reading from a text file
	boolean reading = false;
	
	//Constructor
	public Main() 
	{
		// initiate the GUI
        initUI();
    }
	
	private void initUI() 
	{ 
		//Set up the GUI window
		setTitle("Triangle Class");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Set up the area where the GUI is displayed
        panel = new JPanel();
        panel.setLayout(null);

        //sets up the label that instructs the user what to do
        lblInstructions = new JLabel("Enter the 3 sides and angle C:");
        lblInstructions.setBounds(50, 10, 280, 20);  
        panel.add(lblInstructions);
        
        //sets up the labels that print the results              
        lblPerimiter = new JLabel("Perimeter: ");
        lblPerimiter.setBounds(50, 150, 280, 20);  
        panel.add(lblPerimiter);
        
        lblHeight = new JLabel("Height: ");
        lblHeight.setBounds(50, 170, 280, 20);  
        panel.add(lblHeight);
        
        lblArea = new JLabel("Area: ");
        lblArea.setBounds(50, 190, 280, 20);  
        panel.add(lblArea);
        
        lblCircumRadius = new JLabel("Circumradius: ");
        lblCircumRadius.setBounds(50, 210, 280, 20);  
        panel.add(lblCircumRadius);
        
        lblCircumArea = new JLabel("Circumarea: ");
        lblCircumArea.setBounds(50, 230, 280, 20);  
        panel.add(lblCircumArea);
        
        lblCircumfrence = new JLabel("Circumference: ");
        lblCircumfrence.setBounds(180, 150, 280, 20);  
        panel.add(lblCircumfrence);
        
        lblTriangleType = new JLabel("other Angles: ");
        lblTriangleType.setBounds(180, 170, 280, 20);  
        panel.add(lblTriangleType);
        
        lblAngles = new JLabel("Type: ");
        lblAngles.setBounds(180, 190, 280, 20);  
        panel.add(lblAngles);
        
        //sets up the area where the user enters the first name
        txtSideA = new JTextField("Side A");
        txtSideA.setBounds(50, 30, 190, 20);  
        panel.add(txtSideA);
        
        //sets up the area where the user enters the last name
        txtSideB = new JTextField("Side B");
        txtSideB.setBounds(50, 50, 190, 20);  
        panel.add(txtSideB);
        
        //sets up the area where the user enters the last name
        txtSideC = new JTextField("Side C");
        txtSideC.setBounds(50, 70, 190, 20);  
        panel.add(txtSideC);
        
        //sets up the area where the user enters the last name
        txtAngleC = new JTextField("Angle C");
        txtAngleC.setBounds(50, 90, 190, 20);  
        panel.add(txtAngleC);
        
        //sets up the button to parse from the text box
        btnCreate = new JButton("Create Triangle");
        btnCreate.setBounds(50, 120, 140,20);
        btnCreate.addActionListener(this);
        panel.add(btnCreate);        
        
        //makes the gui visible when its rendered
        this.getContentPane().add(panel);
	
	}
	
	public static void main(String[] args) 
	{
		//displays the gui window
		EventQueue.invokeLater(() -> {
            Main MAIN = new Main();
            MAIN.setVisible(true);
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnCreate)
		{
			try 
			{
				Triangle t = new Triangle(Float.parseFloat(txtSideA.getText()), Float.parseFloat(txtSideB.getText()), Float.parseFloat(txtSideC.getText()), Float.parseFloat(txtAngleC.getText()));
				ArrayList<Float> tempAngles = t.getAngles();
				lblAngles.setText("Angles: " + Float.toString(tempAngles.get(1)) + ", " + Float.toString(tempAngles.get(2)));
				lblArea.setText("Area: " + Float.toString(t.getArea()));
				lblPerimiter.setText("Perimeter: " + Float.toString(t.findPerimeter()));
				lblHeight.setText("Height: " + Float.toString(t.getHeight()));
				lblCircumRadius.setText("Circumradius: " + Float.toString(t.findCircumradius()));
				lblCircumArea.setText("Circumarea: " + Float.toString(t.findCircumarea()));
				lblCircumfrence.setText("Circumfrence: " + Float.toString(t.findCircumfrence()));
				lblTriangleType.setText("Type: " + t.findType());
				
			}
			catch (Exception error)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(error);
			}
			
		}
	}

}