package c17448206.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

//MusicPlayer class will be used to actually play the music

public class MusicPlayer extends PApplet
{
    Minim minim;
    AudioSample as;
    UserInterface ui;

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
        as = minim.loadSample("Risar - Rientre Meditio.mp3", frameSize);
    }


    /*public void startStop()
    {
        as.stop();
        as.trigger();
    }
*/
}