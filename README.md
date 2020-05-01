# Music Visualiser Project

Name:David Tilson

Student Number: C17448206

# Description of the assignment
This assignment is a game based Audio Visualiser which features my cat Twizz. The objective of the game is to move the character using WASD controls to eat the food which is randomly generated on screen. Each food eaten goes towards your overall score, at intervals of 10 new visuals start to spawn. The music provided in the background was mixed by myself, it was taken from a livestream I did with my decks, I thought you would appreciate it in conjunction with the game itself.

[Link to my mix which I featured in this project](https://youtu.be/XuPx7XSoTN4)

# Instructions
Basic WASD controls to move Twizz. Food is randomly generated on the screen which the user has to eat to gain score.

# How it works
The program is mainly run from the MusicPlayer.java file. This file is effectively the main function which calls upon all of the other objects and classes to run them in the right sequence from the draw() method. For example we use this draw() method to hold the if statements which cause the program to start rendering background effects once the player gets 10 score:

```Java
//Controlling code for background visuals as game progresses
        if (score > 10 && score < 20)
        {
            circleVisual();
        }
        else if (score > 19)
        {
            circleVisual();
            lineVisual();
        }
```

The character model for Twizz is handed within the Twizz class itself, in the drawTwizz() method. This method is then called within the draw() method in MusicPlayer.

The food is randomly generated using Java's inbuilt Random package which I imported in this project. The food is given a random X and Y co-ordinate using the nextInt() function in the Random package. Controlling code is then added in a do-while loop to stop food from spawning behind the scoreboard, stopping the player from finding it. 

```Java
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
```
The distance between Twizz and the food is calculated using pythagorus's theorem within the getDist() method in Twizz.java. The X and Y co-ordinates of the food is then taken away from Twizz's X and Y co-ords to give the distance between the two. These two distances, called xDist and yDist are then placed within pythagorus's theorem using the help of the "Math" imported package. This then gives one distance between Twizz and the Food. Pythagorus's theorem is used here as the distance between Twizz and the Food will always be a right angled triangle. This is then passed back to the dist variable in MusicPlayer.Java. If the distance between twizz and the food is less than 40px, the food is "eaten", player score is incremented and food is spawned at a new random location.

```Java
public double getDist(double foodX, double foodY)
    {
        /*
            getDist checks the distance between Twizz and the food by passing two arguments, X and Y co-ords of food
        */

        //twizzXPos has 60px added onto it to allow xDist to be taken from the centre of Twizz, rather than the top left corner, as 60 is half of the width
        xDist = (twizzXPos + 60) - foodX;
        yDist = (twizzYPos + 35) - foodY;

        //hypo variable is the hypothenuse of xDist and yDist, which is put into a pythagoras theorem
        hypo = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)); //raised to the power of 2

        //hypo passed back to caller
        return hypo;
    }
```


# What I am most proud of in the assignment
In this assignment I am most proud of my ability to self learn. I was sick and missed the final few lectures regarding the Audio aspect of the course, this lead to me having to catch up by myself. I think I made a good attempt at it considering. It was a challenging but interesting assignment which I dreaded starting, but once I delved into it I really enjoyed completing the project.

I also really enjoyed actually applying everything I learned throughout the semester into one large project. This solidifed many new ways of coding that I picked up and has really given me a base into realistic coding, rather than learning from a page/slides. Allowing me to properly apply my book learning to a "real" project.

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

