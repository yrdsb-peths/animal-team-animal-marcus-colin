import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TitleScreen class shows the game's title and instructions.
 * Waits for the player to press space to begin the game.
 * 
 * @author Marcus and Colin
 * @version May 2025
 */
public class TitleScreen extends World
{
    // Title label to display the game name
    Label titleLabel = new Label("Hungry Elephant", 60);

    /**
     * Constructor: sets up the title screen with labels and an elephant.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 pixels and cell size of 1x1
        super(600, 400, 1); 

        // Add the title label in the center-top of the screen
        addObject(titleLabel, getWidth() / 2, 200);

        // Call helper method to add additional objects (instructions and elephant)
        prepare();
    }

    /**
     * Called repeatedly while the title screen is active.
     * Waits for the player to press space to start the game.
     */
    public void act()
    {
        // If the space key is pressed, switch to the main game world
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();     // Create a new game world
            Greenfoot.setWorld(gameWorld);         // Set it as the current world
        }
    }

    /**
     * Prepares the screen by adding an elephant and instructions for the player.
     */
    private void prepare()
    {
        // Create and add an elephant sprite for decoration
        Elephant elephant = new Elephant();
        addObject(elephant, 376, 114);

        // Reposition the elephant to center-top
        elephant.setLocation(312, 103);

        // Instruction label: how to start the game
        Label label = new Label("Press <space> to start", 40);
        addObject(label, 290, 278);
        label.setLocation(310, 263);  // Adjusted placement

        // Instruction label: how to control the elephant
        Label label2 = new Label("Use \u2190 and \u2192 to move", 40);  // Unicode arrows
        addObject(label2, 295, 332);
        label2.setLocation(310, 307);  // Adjusted placement
    }
}

