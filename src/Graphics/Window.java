package Graphics;
import javax.swing.JFrame;

public class Window extends JFrame
{
	//fields
	private static final long serialVersionUID = 1L;
	private int width, height;
	public Pane pane;
	
	//constructor
	public Window(int _width, int _height, String title)
	{
		width = _width;
		height = _height;
		
		setSize(width+16, height+39);
		setTitle(title);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane = new Pane(width,height);
		add(pane);
	}
}
