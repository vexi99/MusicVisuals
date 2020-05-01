package c17448206.tudublin;

import processing.core.*;

public class LoveScale extends PApplet
{
    UserInterface ui;

    //variables
    int playerScore;
    int i;
    int rectXPos;
    int remainder;
    int randomIntRed;
    int randomIntGreen;
    int randomIntBlue;

    public LoveScale(UserInterface ui)
    {
        this.ui = ui; 
    }

    public void render()
    {
        ui.noFill();
        ui.rect(1240,10,250,100);
        //smaller rect drawn inside of the larger rectangle above, to fill it in.
        //ui.fill(255, 102, 255);
        update();
        ui.rect(1240,10,rectXPos,100);
    }

    public void update()
    {
        ui.fill((randomIntRed % 255), (randomIntBlue % 255), (randomIntGreen % 255));
        randomIntRed++;
        randomIntBlue++;
        randomIntGreen++;

        //code to try stop the all black colour, to avoid blending into the background.

        if (randomIntRed == 0)
        {
            randomIntRed += 15;
        }

        if (randomIntGreen == 0)
        {
            randomIntRed += 15;
        }

        if (randomIntBlue == 0)
        {
            randomIntRed += 15;
        }
    }

    public void incrementScore()
    {
        playerScore++;
        //rectXPos incremented by 25 each time user eats food to allow the bar to move up the scale
        rectXPos += 50;
        System.out.println(playerScore);

        //Remainder variable used to see if player score has gone past 10, meaning the scale must be reset
        remainder = playerScore % 5;

        if (remainder == 0)
        {
            rectXPos = 0;
        }
    }

    public int getScore()
    {
        return playerScore;
    }

    
}