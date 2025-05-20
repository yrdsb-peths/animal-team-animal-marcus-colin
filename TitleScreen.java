import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @author (Marcus and Colin
 * @version may 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,376,114);
        elephant.setLocation(483,109);
        Label label = new Label("Press <space> to start", 40);
        addObject(label,290,278);
        label.setLocation(309,263);
        elephant.setLocation(297,102);
        elephant.setLocation(312,103);
        Label label2 = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label2,295,332);
        label2.setLocation(315,299);
        label2.setLocation(310,307);
    }
}
