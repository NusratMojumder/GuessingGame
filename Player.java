/**
 * The Players of the Gue55ing Game
 * Player 1 is the Human Player
 * Player 2 is the Computer
 *
 * Class contains Asccessor, Mutator and Display methods for the fields
 * @author (Nusrat Mojumder)
 * @version (Version 1, Date 23.03.2018)
 */
public class Player
{
    private String name;
    private int score;
    private int guesses;

    /**
     * Default Constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        score = 0;
        guesses = 0;
    }

    /**
     * User Defined Constructor for objects of class Player
     */
    public Player(String playerName)
    {
        name = playerName;
        score = 0;
        guesses = 0;
    }

    /**
     * Display method for Player class
     * Return the current state of the player object
     */
    public String displayPlayer()
    {
        return "Name : " + name + ", Score: " + score + ", Last Guess: " + guesses;
    }

    /**
     * Returns the last number guessed for the current round
     */
    public int getGuesses()
    {
        return guesses;
    }

    /**
     * Returns the Player Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns each Player's score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Update the last number guessed for the current round
     */
    public void setGuesses(int remainingGuesses)
    {
        guesses = remainingGuesses;
    }

    /**
     * Setting the Player's Name
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Update Player's current score
     */
    public void setScore(int currentScore)
    {
        score = currentScore;
    }
}
