package c17448206.tudublin;

import processing.core.*;
import java.util.Random;

public class FoodSpawn extends PApplet
{

    UserInterface ui;
    Random rand = new Random();

    int randX = rand.nextInt(1500);
    int randY = rand.nextInt(800);

    int hello = randX;

    public FoodSpawn(UserInterface ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        ui.fill(255);
        ui.circle(randX,randY,25);
    }

    public int getRandX()
    {
        return randX;
    }

    public int getRandY()
    {
        return randY;
    }

    public static void wait(int ms)
    {
        //controlling code to slow down food spawn
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}