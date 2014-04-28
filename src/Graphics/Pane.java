package Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Pane extends JPanel implements Runnable
{
	//fields
	private static final long serialVersionUID = 1L;
	private BufferedImage buffer;
	private int width, height;
	Thread runner = null;
	
	//parameterized constructor
	public Pane(int _width, int _height)
	{
		runner = new Thread(this);
		width = _width;
		height = _height;
		
		buffer = new BufferedImage(_width,_height, BufferedImage.TYPE_INT_RGB);
		runner.start();
	}
	
	//sets pixel color on buffer
	public void SetPixel(int x, int y, Color c)
	{
		buffer.setRGB(x, y, c.getRGB());
		repaint();
	}
	
	//sets buffer from color array
	public void SetBuffer(Color[][] _buffer)
	{
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
				buffer.setRGB(x, y, _buffer[x][y].getRGB());
		repaint();
	}
	
	//repaints screen from buffer
	public void paintComponent(Graphics g)
	{
		g.drawImage(buffer, 0, 0, width, height, null);
	}

	//thread calls this every % millisecond
	public void run() 
	{
		repaint();
		try 
		{
			Thread.sleep(100);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
}
