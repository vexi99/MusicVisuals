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
        stroke(255);
        twizz.drawTwizz();

        if (checkKey(' '))
        {
            as.stop();
			as.trigger();
        }

        if (checkKey('w') || checkKey('W'))
        {
            System.out.println("w pressed");
            twizz.twizzYPos -= speed;
        }

        if (checkKey('a') || checkKey('A'))
        {
            System.out.println("a pressed");
            twizz.twizzXPos -= speed;
        }

        if (checkKey('s') || checkKey('S'))
        {
            System.out.println("s pressed");
            twizz.twizzYPos += speed;
        }

        if (checkKey('d') || checkKey('D'))
        {
            System.out.println("d pressed");
            twizz.twizzXPos += speed;
        }

        if (checkKey('e') || checkKey('E'))
        {
            System.out.println("e pressed");
		
        }
    }
}