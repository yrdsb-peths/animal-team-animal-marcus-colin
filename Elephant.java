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
    GreenfootImage idle = new GreenfootImage("images/elephant_idle_idle0.png");
    
    public Elephant()
    {
        setImage(idle);
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
    }
    
    public void eat()
    {
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.createApple();
        elephantSound.play();
    }
}


    
