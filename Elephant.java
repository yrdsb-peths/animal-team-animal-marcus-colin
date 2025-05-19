import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephant-trumpets-growls-6047.mp3");
    GreenfootImage[]idle = new GreenfootImage[8];
    
    public Elephant()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        removeTouching(Apple.class);
        
        animateElephant();
    }
    
    public void eat()
    {
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.createApple();
        elephantSound.play();
    }
}


    
