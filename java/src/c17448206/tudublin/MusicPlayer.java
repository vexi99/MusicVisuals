package c17448206.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

//MusicPlayer class will be used to actually play the music

public class MusicPlayer extends UserInterface
{
    Minim minim;
    AudioSample as;
    UserInterface ui;
    Twizz twizz;

    public int frameSize = 1024;
    public int sampleRate = 44100;
    public int speed = 1;
    public float frameToSecond = sampleRate / (float) frameSize;

    public MusicPlayer(UserInterface ui)
    {
        this.ui = ui;
    }

    public void setup()
    {
        minim = new Minim(this); 
        twizz = new Twizz(this);
        as = minim.loadSample("Risar - Rientre Meditio.mp3", frameSize);
        colorMode(HSB);
    }

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    
    public void draw()
    {
        background(0);
        for(int i = 0; i < as.bufferSize(); i++)
        {
            stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
        }
        twizz.drawTwizz();

        //Stop/Start music
        if (checkKey(' '))
        {
            as.stop();
			as.trigger();
        }

        //Begin of movement code
        if (checkKey('w') || checkKey('W'))
        {
            twizz.twizzYPos -= speed;
        }

        if (checkKey('a') || checkKey('A'))
        {
            twizz.twizzXPos -= speed;
        }

        if (checkKey('s') || checkKey('S'))
        {
            twizz.twizzYPos += speed;
        }

        if (checkKey('d') || checkKey('D'))
        {
            twizz.twizzXPos += speed;
        }
    }
}