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

    public LoveScale(UserInterface ui)
    {
        this.ui = ui; 
    }

    public void render()
    {
        ui.noFill();
        ui.rect(1240,10,250,100);
        //smaller rect drawn inside of the larger rectangle above, to fill it in.
        ui.fill(255, 102, 255);
        ui.rect(1240,10,rectXPos,100);
    }

    public void incrementScore()
    {
        playerScore++;
        //rectXPos incremented by 25 each time user eats food to allow the bar to move up the scale
        rectXPos += 25;
        System.out.println(playerScore);

        //Remainder variable used to see if player score has gone past 10, meaning the scale must be reset
        remainder = playerScore % 10;

        if (remainder == 0)
        {
            rectXPos = 0;
        }
    }

    
}