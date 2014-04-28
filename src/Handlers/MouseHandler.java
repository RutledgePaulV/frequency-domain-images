package Handlers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Utilities.ImageMatrix;
import Utilities.Range;
import Utilities.ValueMapper;
import Fourier.Complex;
import Fourier.ComplexArrayWrap;
import Fourier.FFT;
import Fourier.FFT.Direction;
import Graphics.Pane;

public class MouseHandler implements MouseListener
{
	//give access to these
	ComplexArrayWrap matrix;
	Pane pane, pane2;
	int radius;
	
	//constructor
	public MouseHandler(Pane _pane, Pane _pane2, ComplexArrayWrap _matrix, int _radius)
	{
		super();
		matrix = _matrix;
		pane = _pane;
		pane2 = _pane2;
		radius = _radius;
	}

	//each time the mouse gets clicked
	public void mouseClicked(MouseEvent arg0) 
	{
		int xCenter = arg0.getX();
		int yCenter = arg0.getY();
		
		for(int x = xCenter - radius; x < xCenter + radius; x++)
			for(int y = yCenter - radius; y < yCenter + radius; y++)
				if(x >= 0 && x < matrix.size && y>=0 && y < matrix.size)
					matrix.values[x][y] = new Complex();
		
		ValueMapper mapper = new ValueMapper(matrix.GetRepresentation(ComplexArrayWrap.Representation.Magnitude));
		ImageMatrix frequency_domain = new ImageMatrix(mapper.GetLogarithmicMap(new Range(0,1),100000));
		pane.SetBuffer(frequency_domain.matrix);
		
		ComplexArrayWrap inverse = FFT.Transform(matrix, Direction.Reverse);
		ValueMapper mapper2 = new ValueMapper(inverse.GetRepresentation(ComplexArrayWrap.Representation.Magnitude));
		ImageMatrix inverse_domain = new ImageMatrix(mapper2.GetLinearMap(new Range(0,0.80)));
		pane2.SetBuffer(inverse_domain.matrix);
	}

	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0){}
	public void mousePressed(MouseEvent arg0){}
	public void mouseReleased(MouseEvent arg0){}

}
