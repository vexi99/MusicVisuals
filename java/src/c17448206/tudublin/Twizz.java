package c17448206.tudublin;

import processing.core.*;


public class Twizz extends PApplet
{

    UserInterface ui;

    //variables 
    int winHeight = 1500; //window height
    int winLength = 800; //window Length
    int twizLength = 120;
    int twizHeight = 70;
    int twizzYPos = (winLength / 2); // half of window height and length so twizz spawns in middle of screen
    int twizzXPos = (winHeight / 2);
    int xDist = 0; //x distance between twizz and food
    int yDist = 0; //y distance between twizz and food
    int foodX = 0;
    int foodY = 0;
    double hypo; //hypothenuse variable

    public PVector pos;


    public Twizz(UserInterface ui)
    {
        this.ui = ui;
        pos = new PVector(twizzXPos, twizzYPos); 
    }

    public void drawTwizz()
    {
        ui.stroke(255,255,255);
        ui.noFill();
        ui.rect(twizzXPos,  twizzYPos, twizLength, twizHeight); //lx , ly, w, h. body of twizz
        ui.triangle(twizzXPos, twizzYPos, (twizzXPos + 20),  (twizzYPos - 35) ,(twizzXPos +40), twizzYPos); //x1,y1 x2,y2 x3,y3
        ui.triangle((twizzXPos+80), twizzYPos, (twizzXPos + 100),  (twizzYPos - 35),(twizzXPos + 120), twizzYPos); //x1,y1 x2,y2 x3,y3
        ui.circle((twizzXPos + 25), (twizzYPos + 23), 25);
        ui.circle((twizzXPos + 95), (twizzYPos + 23), 25);
        ui.fill(255);
        ui.triangle((twizzXPos + 50), (twizzYPos + 27), (twizzXPos + 70), (twizzYPos + 27) ,(twizzXPos + 60), (twizzYPos + 43));
        ui.line((twizzXPos + 60), (twizzYPos + 43), (twizzXPos + 60), (twizzYPos + 48));
        ui.line((twizzXPos + 60), (twizzYPos + 48), (twizzXPos + 75), (twizzYPos + 55));
        ui.line((twizzXPos + 60), (twizzYPos + 48), (twizzXPos + 45), (twizzYPos + 55));
    }


    public void update()
    {

    }


}