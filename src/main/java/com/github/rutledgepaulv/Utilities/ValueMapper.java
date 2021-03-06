package com.github.rutledgepaulv.utilities;

public class ValueMapper
{
	//fields
	double[][] pixels;
	private int width, height;
	private Range range;
	
	//parameterized constructor
	public ValueMapper(double[][] input)
	{
		pixels = input;
		width = pixels[0].length;
	    height = pixels.length;
	    range = FindRange(pixels);
	}
	
	//discovers the range for the data
	public static Range FindRange(double[][] values)
	{
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		
		for(int row = 0; row < values.length; row++)
			for(int col = 0; col < values[row].length; col++)
			{
				min = (values[row][col]<min)?values[row][col]:min;
				max = (values[row][col]>max)?values[row][col]:max;
			}
				
		return new Range(min,max);
	}
	
	//maps the values to the given range
	public double[][] GetLinearMap(Range map_to)
	{
		double[][] result = new double[height][width];
		double scale = range.GetScalingFactor(map_to);
		
		for(int row = 0; row < height; row++)
			for(int col = 0; col < width; col++)
				result[row][col] = map_to.min+scale*pixels[row][col];
			
		return result;
	}
	
	//maps the values to the given range logarithmically
	public double[][] GetLogarithmicMap(Range map_to, double intensity)
	{
		double[][] values = new double[height][width];
		
		for(int row = 0; row < height; row++)
			for(int col = 0; col < width; col++)
				values[row][col] = Math.log(1+intensity*pixels[row][col]);
		
		Range temp = FindRange(values);
		double scale = temp.GetScalingFactor(map_to);
		double[][] result = new double[height][width];
		
		for(int row = 0; row < height; row++)
			for(int col = 0; col < width; col++)
				result[row][col] = map_to.min+scale*values[row][col];
			
		return result;
	}
}
