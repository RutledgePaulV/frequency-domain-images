import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Fourier.*;
import Graphics.*;
import Handlers.*;
import Kernels.*;
import Utilities.*;

public class Initial
{
	public static void main(String[] args) throws IOException
	{
		//reading in an image
		BufferedImage input = ImageIO.read(new File("Images/clown.png"));
		
		//converting image into array of colors
		ImageMatrix image = new ImageMatrix(input);
		
		//wrapping image with an object to access various color spaces
		Manipulator manipulator = new Manipulator(image.matrix);
		
		//creating windows
		Window window1 = new Window(input.getWidth(),input.getHeight(),"Spacial Domain");
		Window window2 = new Window(input.getWidth(),input.getHeight(),"Frequency Domain");
		Window window3 = new Window(input.getWidth(),input.getHeight(),"Inverse Frequency");
		
		//spacing windows out
		window2.setLocation(window1.getLocation().x + window1.getWidth(),window1.getLocation().y);
		window3.setLocation(window2.getLocation().x + window2.getWidth(),window2.getLocation().y);
		
		//creating complex array from grayscale color space
		ComplexArrayWrap original = new ComplexArrayWrap(manipulator.GetColorSpace(Manipulator.ColorSpace.Greyscale));
		//transforming image to frequency domain
		ComplexArrayWrap transformed = FFT.Transform(original, FFT.Direction.Forward);
		
		/////////////////////////////
		/////////////////////////////
		// APPLY FILTERS HERE BEFORE TRANSFORMING BACK INTO SPACIAL DOMAIN
		
		
				//apply this for a gaussian blur
		/*
		Gaussian gaussian_filter = new Gaussian(100,0.5);
		transformed.Convolve(gaussian_filter);
		*/
		
		
				//apply this for edge detection
				//note that the lower bound on the range is not ZERO
				//in order to preserve image brightness as determined by central pixel
		
		
		
		HardFrequencyBand band_filter = new HardFrequencyBand(new Range(0.5,1),0);
		transformed.Convolve(band_filter);
		
		
		
		/////////////////////////////
		/////////////////////////////
		
		
		//transforming frequency domain image back into spacial domain
		ComplexArrayWrap inverse = FFT.Transform(transformed, FFT.Direction.Reverse);
		
		//these objects map the frequency domain values to the visible spectrum
		//Range original_range = ValueMapper.FindRange(original.GetRepresentation(ComplexArrayWrap.Representation.Magnitude));
		ValueMapper mapper = new ValueMapper(transformed.GetRepresentation(ComplexArrayWrap.Representation.Magnitude));
		ValueMapper mapper2 = new ValueMapper(inverse.GetRepresentation(ComplexArrayWrap.Representation.Magnitude));
		
		//getting the visible spectrum version of the frequency domain
		ImageMatrix frequency_domain = new ImageMatrix(mapper.GetLogarithmicMap(new Range(0,1),100000));
		//getting visible spectrum version of the spacial domain
		ImageMatrix inverse_frequency = new ImageMatrix(mapper2.GetLinearMap(new Range(0,0.80)));
		
		//setting the buffers for each window to display
		window1.pane.SetBuffer(image.matrix);
		window2.pane.SetBuffer(frequency_domain.matrix);
		window3.pane.SetBuffer(inverse_frequency.matrix);
		
		//adding a mouse handler so that user can see effects of filtering by clicking
		window2.pane.addMouseListener(new MouseHandler(window2.pane,window3.pane,transformed,5));
	}
}
