package c17448206.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

//MusicPlayer class will be used to actually play the music

public class UserInterface extends PApplet
{
    Twizz twizz;
    MusicPlayer musicPlayer;

    int WinHeight = 800;
    int WinWidth = 1500;
    int speed = 1;

    public void settings()
    {
        size(WinWidth,WinHeight);
    }

    public void setup()
    {
        musicPlayer = new MusicPlayer(this);
    }

    //Begin of keyPress code
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
    //end of keyPress code

    

}
