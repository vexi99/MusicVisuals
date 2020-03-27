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
        twizz = new Twizz(this);
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

    

    public void draw()
    {
        background(0);
        stroke(255);
        //twizz.drawTwizz();

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
