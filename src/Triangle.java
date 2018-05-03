import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Triangle 
{
	ArrayList<Float> sides = new ArrayList<Float>();  
	
	ArrayList<Float> angles = new ArrayList<Float>();  
	
	float area;
	float height;
	float perimeter;
	float circumradius;
	float circumarea;
	float circumfrence;
	String type;
	
	//Constructor
	public Triangle(float sideA, float sideB, float sideC, float angleC) 
	{
		sides.add(sideA);
		sides.add(sideB);
		sides.add(sideC);
		isValid();
	}
	
	void isValid()
	{
		if (sides.get(1) + sides.get(2) < sides.get(3))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (sides.get(2) + sides.get(3) < sides.get(1))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (sides.get(1) + sides.get(3) < sides.get(2))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ArrayList<Float> getAngles()
	{
		double angleA = Math.asin((Math.sin(angles.get(0)) * sides.get(0)) / sides.get(2));
		float angleAf = (float)angleA;
		angles.add(angleAf);
		float angleB = 180 - (angles.get(0) + angles.get(1));
		angles.add(angleB);
		return angles;
	}
	
	public float getArea()
	{
		double areaD = 0.5 * sides.get(0) * sides.get(1) * Math.sin(angles.get(1));
		area = (float)areaD;
		return area;
	}
	
	public float getHeight()
	{
		height = 2*(area/sides.get(2));
		return height;
	}
	
	public float findPerimeter()
	{
		perimeter = sides.get(0) + sides.get(1) + sides.get(2);
		return perimeter;
	}
	
	public float findCircumradius()
	{
		circumradius = area/(perimeter/2);
		return circumradius;
	}
	
	public float findCircumarea()
	{
		double circumareaD  = Math.PI * (circumradius * circumradius);
		circumarea = (float)circumareaD;
		return circumarea;
	}
	
	public float findCircumfrence()
	{
		double circumfrenceD = Math.PI * circumradius;
		return circumfrence;
	}
	
	public String findType()
	{
		float a = sides.get(0);
		float b = sides.get(1);
		float c = sides.get(2);
		
		return type;
	}
	
	
}
