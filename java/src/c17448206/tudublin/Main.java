package c17448206.tudublin;

//import example.CubeVisual;
//import example.MyVisual;

public class Main
{	

	public void visual()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Visual());
	}

	public void musicPlayer()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MusicPlayer());
	}
	
	public static void main(String[] args)
	{
		Main main = new Main();
		main.musicPlayer();			
	}
}