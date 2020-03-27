package c17448206.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

public class MusicPlayer extends PApplet
{
    Minim minim;
    AudioSample as;

    int frameSize = 1024;
    int sampleRate = 44100;
    float frameToSecond = sampleRate / (float) frameSize;

    public void settings()
    {
        size(1024,500);
    }

    public void setup()
    {
        minim = new Minim(this);
        as = minim.loadSample("Risar - Rientre Meditio.mp3", frameSize);
    }

    public void keyPressed()
	{
		if (key == ' ')
		{
			as.stop();
			as.trigger();
		}

	}

    public void draw()
    {
        background(0);
        stroke(255);
    }
}