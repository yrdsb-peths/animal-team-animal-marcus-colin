import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Apple class defines how an apple behaves in the game.
 * Apples fall down the screen and trigger game over if they reach the bottom.
 */
public class Apple extends Actor
{
    int speed = 1;  // Speed at which the apple falls

    /**
     * Called repeatedly while the game is running.
     * Moves the apple downward and checks if it has hit the bottom of the screen.
     */
    public void act()
    {
        // Move the apple down by 'speed' pixels
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);

        // Get a reference to the current world (MyWorld)
        MyWorld world = (MyWorld) getWorld();

        // If the apple has reached the bottom of the screen
        if (getY() >= world.getHeight())
        {
            world.gameOver();            // End the game
            world.removeObject(this);   // Remove the apple from the world
        }
    }

    /**
     * Sets the falling speed of the apple.
     * @param spd The new speed to fall at
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
