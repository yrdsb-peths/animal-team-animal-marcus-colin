import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant class defines the player character.
 * The elephant can move left and right, animate, and eat apples to gain points.
 */
public class Elephant extends Actor
{
    // Sound played when the elephant eats an apple
    GreenfootSound elephantSound = new GreenfootSound("elephant-trumpets-growls-6047.mp3");

    // Arrays to hold animation frames for right-facing and left-facing elephant
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right";  // Tracks the current direction the elephant is facing

    // Timer to control animation speed
    SimpleTimer animationTimer = new SimpleTimer();

    /**
     * Constructor: Loads the animation frames, scales them, and sets the initial image.
     */
    public Elephant()
    {
        // Load and scale images for right-facing animation
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);  // Resize image to fit nicely
        }

        // Load, mirror, and scale images for left-facing animation
        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();  // Flip the image to face left
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();  // Start animation timer

        // Set initial image to the first frame facing right
        setImage(idleRight[0]);
    }

    int imageIndex = 0;  // Tracks current animation frame

    /**
     * Handles the animation by switching images every 100 milliseconds.
     */
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;  // Not enough time has passed for the next frame
        }
        animationTimer.mark();  // Reset timer

        // Set the image depending on the direction the elephant is facing
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
        }
        else
        {
            setImage(idleLeft[imageIndex]);
        }

        imageIndex = (imageIndex + 1) % idleRight.length;  // Loop through animation frames
    }

    /**
     * Called repeatedly while the game is running.
     * Handles movement, eating apples, and animation.
     */
    public void act()
    {
        // Move left
        if (Greenfoot.isKeyDown("left"))
        {
            move(-2);             // Move to the left
            facing = "left";      // Update facing direction
        }

        // Move right
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2);              // Move to the right
            facing = "right";     // Update facing direction
        }

        eat();                    // Check for and handle eating apples

        animateElephant();        // Animate the elephant
    }

    /**
     * Checks if the elephant is touching an apple.
     * If so, removes the apple, plays sound, increases score, and spawns a new apple.
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);         // Remove the apple being touched
            MyWorld world = (MyWorld) getWorld();
            world.createApple();                 // Spawn a new apple
            world.increaseScore();               // Increase the score
            elephantSound.play();                // Play eating sound
        }
    }
}



    
