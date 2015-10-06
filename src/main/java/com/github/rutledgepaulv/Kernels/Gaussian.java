package com.github.rutledgepaulv.kernels;

public class Gaussian extends Kernel
{

	//fields
	double magnitude, radius;
	
	//parameterized constructor
	public Gaussian(double _magnitude, double _radius) 
	{
		radius = _radius;
		magnitude = _magnitude;
	}

	//calculates 2 dimensional gaussian based on magnitude, radius, and relative position to edges of domain
	public double GetFactor(double width_ratio, double height_ratio)
	{
		double exp = -(width_ratio*width_ratio + height_ratio*height_ratio)/(2*radius*radius);
		return magnitude * Math.exp(exp);
	}

}
