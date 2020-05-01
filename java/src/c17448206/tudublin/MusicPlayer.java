package c17448206.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;
import java.util.Random;

//MusicPlayer class will be used to actually play the music

public class MusicPlayer extends UserInterface
{
    Minim minim;
    AudioSample as;
    UserInterface ui;
    Twizz twizz;
    FoodSpawn foodSpawn;
    LoveScale loveScale;
    Visuals visuals;

    Random random = new Random();

    public int frameSize = 1024;
    public int sampleRate = 44100;
    public int speed = 2;
    public float frameToSecond = sampleRate / (float) frameSize;
    public double foodX;
    public double foodY;
    public double dist;
    public int score;

    public MusicPlayer(UserInterface ui)
    {
        this.ui = ui;
    }

    public void setup()
    {
        minim = new Minim(this); 
        foodSpawn = new FoodSpawn(this);
        loveScale = new LoveScale(this);
        visuals = new Visuals(this);
        as = minim.loadSample("mix.mp3", frameSize);
        twizz = new Twizz(this, as.bufferSize());
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

    public void circleVisual()
	{
        float offs = 0;
        float lerpedw = 0;
	    float average = 0;
		strokeWeight(2);
		float cx = width / 2;
		float cy = height / 2;

		for(int i = 0 ; i < as.bufferSize() ; i ++)
		{
			float theta = map(i, 0, as.bufferSize(), 0, TWO_PI);
			float x = cx + sin(theta) * cx * abs(as.left.get(i));
			float y = cy + cos(theta) * cx * abs(as.left.get(i));
			stroke(
				map(i + offs, 0, as.bufferSize(), 0, 255) % 255
				,255
				,255
			);
			line(cx, cy, x, y);
            
        }
		offs += average * 100f;		
    }
    
    public void lineVisual()
    {
        float offs = 0;
        float average = 0;
        int i;
        float x;
        int y;

        float startX = 1;
        float startY = 10;
        float oppositeX = 1499;

        for(i = 0; i < as.bufferSize(); i++)
        {
            stroke(
				map(i + offs, 0, as.bufferSize(), 0, 255) % 255
				,255
				,255
            );
            
            x = startX * 500 * abs(as.left.get(i));

            line(startX, startY, x, startY);
            line(oppositeX, startY, oppositeX - x, startY);
            startY = (startY + 45) % WinHeight;
        }
        offs += average * 100f;	

    }
    
    public void draw()
    {
        background(0);
        score = loveScale.getScore(); //assignment to update the score variable

        //Controlling code for background visuals as game progresses
        if (score > 4 && score < 10)
        {
            circleVisual();
        }
        else if (score > 9)
        {
            circleVisual();
            lineVisual();
        }

        twizz.drawTwizz();
        foodSpawn.render();
        loveScale.render();
        

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

        if (checkKey('e') || checkKey('E'))
        {
            loveScale.incrementScore();
        }

        //Food X and Y co-ords
        foodX = foodSpawn.getRandX();
        foodY = foodSpawn.getRandY();

        //Pass co-ords of food to Twizz Class by calling get dist. dist is then passed back to main
        dist = twizz.getDist(foodX, foodY);
        
        //if distance between twizz and food is less than 40px, change foods co-ords. Food is "eaten"
        if (dist < 40)
        {
            loveScale.incrementScore();
            /*  do-while loop here is used to respawn the food once it has been eaten. The controlling code inside of the 
                brackets is used to stop the food from spawning inside of the rect drawn by LoveScale                  */ 
            do
            {
                foodSpawn.randX = random.nextInt(1500);
                foodSpawn.randY = random.nextInt(800);
            } while (foodSpawn.randX > 1240 && foodSpawn.randX < 1500 && foodSpawn.randY > 0 && foodSpawn.randY < 110);
        }

    }
}