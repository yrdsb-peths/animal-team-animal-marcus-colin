import greenfoot.*;  // Import Greenfoot classes

/**
 * The main world where the game takes place.
 * Handles score tracking, level progression, and spawning apples.
 */
public class MyWorld extends World {
    
    public int score = 0;               // Tracks the current score
    Label scoreLabel;                   // Label object to display the score
    int level = 1;                      // Game level, increases as score increases

    /**
     * Constructor: Sets up the world, adds player and initial apple, and displays score.
     */
    public MyWorld() {
        super(600, 400, 1, false);  // Create a new world with 600x400 pixels and no auto repainting

        // Create and add the player-controlled Elephant to the world
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);  // Place elephant in the center

        // Create and add the score label
        scoreLabel = new Label(0, 80);  // Start score at 0, font size 80
        addObject(scoreLabel, 50, 50);  // Place label in the top-left corner

        // Spawn the first apple
        createApple();
    }

    /**
     * Increases the score by 1 and updates the label.
     * Every 5 points, the level increases by 1.
     */
    public void increaseScore() {
        score++;                        // Increase score
        scoreLabel.setValue(score);    // Update score label

        // Increase level every time the score is a multiple of 5
        if (score % 5 == 0) {
            level += 1;
        }
    }

    /**
     * Displays the "Game Over" message in the center of the screen.
     */
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 100);  // Create a "Game Over" label
        addObject(gameOverLabel, 300, 200);  // Place it in the center
    }

    /**
     * Spawns a new apple at a random x-position at the top of the screen.
     * The apple's speed increases with the level.
     */
        public void createApple() {
            Apple apple = new Apple();     // Create a new Apple object
            apple.setSpeed(level);         // Set its speed based on the current level
            int x = Greenfoot.getRandomNumber(600);  // Random x-position
            int y = 0;                     // Start at the top of the screen
            addObject(apple, x, y);        // Add the apple to the world
        }
}

