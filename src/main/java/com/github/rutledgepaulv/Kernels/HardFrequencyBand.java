package com.github.rutledgepaulv.kernels;


import com.github.rutledgepaulv.utilities.Range;

public class HardFrequencyBand extends Kernel
{
	//fields
	public Range range;
	public double factor;
	
	//parameterized constructor
	public HardFrequencyBand(Range _range, double _factor)
	{
		range = _range;
		factor = _factor;
	}
	
	//returns the given factor if within the bounds of the range, otherwise returns 1
	public double GetFactor(double x, double y) 
	{
		double radius = Math.sqrt(x*x+y*y);
		return range.IsInRange(radius, true) ? factor : 1;
	}

}
