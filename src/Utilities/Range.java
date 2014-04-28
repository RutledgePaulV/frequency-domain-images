package Utilities;

public class Range 
{
	//fields
	public double min;
	public double max;
	
	//parameterized constructor
	public Range(double _min, double _max)
	{
		min = _min;
		max = _max;
	}
	
	//returns span
	public double GetSpan()
	{
		return max - min;
	}
	
	//gets the scaling factor
	public double GetScalingFactor(Range map_to)
	{
		return map_to.GetSpan()/GetSpan();
	}
	
	//determines if a value is within this range or not
	public boolean IsInRange(double value, boolean closed_interval)
	{
		if(!closed_interval)
			return (value > min && value < max);
		else
			return (value >= min && value <= max);
	}
}
