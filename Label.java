import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Label class that allows you to display a textual value on screen.
 * 
 * The Label is an actor, so you can add it to a world just like any other actor.
 * You can change the text, font size, and colors during the game.
 * 
 * This is a useful utility class for displaying scores, messages, or instructions.
 * 
 * @author Amjad Altadmri 
 * @version 1.1
 */
public class Label extends Actor
{
    // Text to display
    private String value;

    // Font size of the text
    private int fontSize;

    // Border (outline) color of the text
    private Color lineColor = Color.BLACK;

    // Fill (inside) color of the text
    private Color fillColor = Color.WHITE;

    // Transparent background
    private static final Color transparent = new Color(0, 0, 0, 0);

    /**
     * Create a new label initialized with an integer value and font size.
     * Converts the integer to a string internally.
     * 
     * @param value The number to display
     * @param fontSize The size of the font
     */
    public Label(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }

    /**
     * Create a new label initialized with a string and font size.
     * 
     * @param value The text to display
     * @param fontSize The size of the font
     */
    public Label(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();  // Draw the initial label image
    }

    /**
     * Set the label to a new string value.
     * 
     * @param value The new text to display
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();  // Refresh the image with new text
    }

    /**
     * Set the label to a new integer value.
     * 
     * @param value The new number to display
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();  // Refresh the image with new text
    }

    /**
     * Set the outline (border) color of the text.
     * 
     * @param lineColor The new outline color
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();  // Refresh image with new color
    }

    /**
     * Set the fill (main) color of the text.
     * 
     * @param fillColor The new fill color
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();  // Refresh image with new color
    }

    /**
     * Redraw the label with the current value, font size, and colors.
     * This is called internally whenever the label needs to be updated.
     */
    private void updateImage()
    {
        // Creates a new GreenfootImage with transparent background, fill color, and line color
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}
