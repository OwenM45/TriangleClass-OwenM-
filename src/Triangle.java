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
		angles.add(angleC);
		isValid();
	}
	
	void isValid()
	{
		if (sides.get(0) + sides.get(1) < sides.get(2))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (sides.get(1) + sides.get(2) < sides.get(0))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (sides.get(0) + sides.get(2) < sides.get(1))
		{
			JOptionPane.showMessageDialog(null, "Triangle was invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ArrayList<Float> getAngles()
	{
		double angleA = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(angles.get(0))) * sides.get(0)) / sides.get(2)));
		float angleAf = (float)angleA;
		angles.add(angleAf);
		float anglesTotal = (angles.get(0) + angles.get(1));
		float angleB = 180 - anglesTotal;
		angles.add(angleB);
		return angles;
	}
	
	public float getArea()
	{
		double areaD = 0.5 * sides.get(0) * sides.get(1) * Math.sin(Math.toRadians(angles.get(1)));
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
		double circumfrenceD = Math.PI * (circumradius * 2);
		circumfrence = (float)circumfrenceD;
		return circumfrence;
	}
	
	public String findType()
	{
		float a = sides.get(0);
		float b = sides.get(1);
		float c = sides.get(2);
		
		if (a > b && a > c)
		{
			if (c + b == a)
			{
				type = "Right angle";
			}
			else if (c + b < a)
			{
				type = "Acute";
			}
			else if (c + b > a)
			{
				type = "Obtuse";
			}
		}
		else if (b > a && b > c)
		{
			if (c + a == b)
			{
				type = "Right angle";
			}
			else if (c + a < b)
			{
				type = "Acute";
			}
			else if (c + a > b)
			{
				type = "Obtuse";
			}
		}
		else if (c > b && c > a)
		{
			if (b + a == c)
			{
				type = "Right angle";
			}
			else if (b + a < c)
			{
				type = "Acute";
			}
			else if (b + a > c)
			{
				type = "Obtuse";
			}
		}
		else if (a == b && b == c)
		{
			type = "Acute";
		}
		
		return type;
	}
	
	
}
