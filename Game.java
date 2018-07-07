import java.util.Scanner;

/**
 * This is a Guessing Game played between a Human Player and Computer
 * There are 6 total guesses for each round
 * Who goes first is chosen randomly
 * Scores are assigned based on Attempts Required for correct guess
 * Or Proximity of last guess to Correct Number
 * The Player with most points after 4 rounds, Wins
 *
 * @author (Nusrat Mojumder)
 * @version (version 1, 23.3.2018)
 */

public class Game
{           
    private boolean abandonRound;
    private boolean playerOneCorrectGuess;
    private boolean playerTwoCorrectGuess;

    private Player player1;
    private Player player2;
    private RandomNumber randomNumberObj;

    /**
     * Default Constructor for objects of class Game
     */
    public Game()
    {
        player1 = new Player("Human");
        player2 = new Player("Computer");
        randomNumberObj = new RandomNumber();

        abandonRound = false;
        playerOneCorrectGuess = false;
        playerTwoCorrectGuess = false;
    }

    /**
     * User Defined Constructor for objects of class Game
     */
    public Game(Player human, Player comp, RandomNumber randomObj)
    {
        player1 = human;
        player2 = comp;
        randomNumberObj = randomObj;

        abandonRound = false;
        playerOneCorrectGuess = false;
        playerTwoCorrectGuess = false;
    }

    /**
     * Method to assign score to one player guessed correctly
     * Score is awarded according to how many attempts have been made
     */
    public void assignCorrectGuessScore(Player player, int remainingGuess)
    {
        switch (remainingGuess)
        {
            case 5 : System.out.println(player.getName() + " scores 20");
            player.setScore(player.getScore() + 20);
            break;
            case 4 : System.out.println(player.getName() + " scores 15");
            player.setScore(player.getScore() + 15);
            break;
            case 3 : System.out.println(player.getName() + " scores 11");
            player.setScore(player.getScore() + 11);
            break;
            case 2 : System.out.println(player.getName() + " scores 8");
            player.setScore(player.getScore() + 8);
            break;
            case 1 : System.out.println(player.getName() + " scores 6");
            player.setScore(player.getScore() + 6);
            break;
            case 0 : System.out.println(player.getName() + " scores 5");
            player.setScore(player.getScore() + 5);
            break;
        }
    }

    /**
     * Method to assign score to each player if No one guessed correctly
     * Each player is awarded score according to the proximity of 
     * their last guess to the hidden number
     */
    public void assignProximityScore(Player player, int correctNumber)
    {
        int score = 10 - Math.abs(player.getGuesses() - correctNumber);
        if (score > 0)
        {
            System.out.println(player.getName() + " scores " + score);
            player.setScore(player.getScore() + score);
        }
        else
            System.out.println(player.getName() + " scores 0");
    }

    /**
     * Method to decide what scores each player will be assigned
     */
    public void decideScore(int remainingGuess,  int correctNumber)
    {
        if (!(abandonRound))
        {   
            if (playerOneCorrectGuess)
            {
                assignCorrectGuessScore(player1, remainingGuess);
                System.out.println(player2.getName().toUpperCase() + 
                    " scores 0");
            }
            else if (playerTwoCorrectGuess)
            {
                assignCorrectGuessScore(player2, remainingGuess);
                System.out.println(player1.getName().toUpperCase() + 
                    " scores 0");    
            }
            else
            {
                assignProximityScore(player1, correctNumber);
                assignProximityScore(player2, correctNumber);
            }
        }

        System.out.println("\n*****CURRENT SCORE*****\n" +
            player1.getName().toUpperCase() + " :\t"+player1.getScore() + 
            "\n"+player2.getName().toUpperCase() + " :\t" + player2.getScore());

        System.out.println("**********\n");
    }

    /**
     * Method to decide which player won 
     * Player with highest score after 4 rounds wins 
     */
    public void decideWinner()
    {
        System.out.println("\n*****TOTAL SCORE*****\n"+
            player1.getName().toUpperCase()+" :\t" + player1.getScore() +
            "\n"+player2.getName().toUpperCase() + " :\t" + 
            player2.getScore());

        if (player1.getScore() > player2.getScore())
            System.out.println("*****" + player1.getName().toUpperCase() + 
                ", WINS THE GAME*****");
        else if (player2.getScore() > player1.getScore())
            System.out.println("*****" + player2.getName().toUpperCase() + 
                ", WINS THE GAME*****");
        else
            System.out.println("*****IT WAS A TIE*****");

        player1.setScore(0);
        player2.setScore(0);
    }

    /**
     * Method to check is the correct numer was guessed
     * If guessed number is higher or lower than correct number, 
     * range is updated
     */
    public boolean guessingGame(Player player, int currentGuess, int correctNumber)
    {
        if (player.getGuesses() == correctNumber)
        {
            System.out.println("GUESSED CORRECTLY!!! CONGRATULATIONS!!!\n");
            return true;
        }
        else if (player.getGuesses() < randomNumberObj.getLowerLimit() || 
        player.getGuesses() > randomNumberObj.getUpperLimit())
        {
            System.out.println("Guess OUT OF RANGE\nThe lower limit is " + 
                randomNumberObj.getLowerLimit() + " and The Upper limit is " + 
                randomNumberObj.getUpperLimit() + "\n");
        }
        else if (player.getGuesses() < correctNumber)
        {
            System.out.println("Guess is BELOW the Correct Number\n");
            randomNumberObj.setLowerLimit(player.getGuesses() + 1);
        }
        else if (player.getGuesses() > correctNumber)
        {
            System.out.println("Guess is ABOVE the Correct Number\n");
            randomNumberObj.setUpperLimit(player.getGuesses() - 1);
        }

        System.out.println("**********");
        return false;
    }  

    /**
     * Method to check if the input String is Numeric or not
     * Used to check the user Guess
     */
    public boolean isStringNumeric(String str)
    {
        for (char ch : str.toCharArray())
        {
            if (!(Character.isDigit(ch)))
                return false; 
        }

        return true;
    }

    /**
     * Method to check if Human player has input name correctly
     * Name can only contain characters except all spaces, including leading 
     * and trailing spaces
     * Must be between 1 and 8 characters in length (inclusive)
     */
    public void nameValidation()
    {

        System.out.println("Please Enter your Name");
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String name = sc.nextLine();
            name = name.trim();

            if (name.length() < 1 || name.length() > 8)
            {
                System.out.println("Invalid Input, Enter within 1 to 8 Characters\n");
            }
            else
            {
                player1.setName(name);
                break;
            }
        }
    }

    /**
     * Method to take input from the Human Player
     * The input is check if Numeric or not
     * The input is checked for the abandon indicator 999
     * The input is checked if its within range of 1-100
     */
    public int playerOneGuess(int correctNumber, int remainingGuess)
    {
        System.out.println("It's the turn of " + player1.getName().toUpperCase());
        System.out.println("The number is between " + randomNumberObj.getLowerLimit() + " and " + 
            randomNumberObj.getUpperLimit() + "\n");

        System.out.println("Please enter a guess");
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String guessedVal = sc.next();
            if (isStringNumeric(guessedVal))
            {
                player1.setGuesses(Integer.parseInt(guessedVal));

                if (player1.getGuesses() == 999)
                {
                    abandonRound = true;
                    System.out.println("*****" + player1.getName().toUpperCase() + 
                        ", ABANDONS ROUND*****\nNo Scores Assigned");
                    break;
                }
                else if (player1.getGuesses() < 0 || player1.getGuesses() > 100)
                {
                    System.out.println("Invalid Input, Enter a number within range and between 1 and 100\n");
                }
                else
                { 
                    playerOneCorrectGuess = guessingGame(player1, player1.getGuesses(), correctNumber);
                    remainingGuess--;
                    System.out.println("Guesses Remaining " + remainingGuess);
                    break;
                }
            }
            else
                System.out.println("Invalid Input, Enter a NUMERIC value\n");  
        }

        return remainingGuess;
    }

    /**
     * Method to generate guess from the Computer Player
     * A random number between 1 and 20 is generated the ‘abandon round indicator’
     * Before each guess computer player generates a random number between 1 and 20
     * If this number matches the ‘abandon round indicator’ then the round is abandoned
     * Otherwise,Computer randomly genertes guess within given range
     */
    public int playerTwoGuess(int abandonRoundIndicator, int correctNumber, int remainingGuess)
    {
        System.out.println("It's the turn of " + player2.getName().toUpperCase());
        int computerAbandonGuess = randomNumberObj.generateRandomNumber(1, 20);

        if (computerAbandonGuess == abandonRoundIndicator)
        { 
            System.out.println("*****" + player2.getName().toUpperCase() + ", ABANDONS ROUND*****\n"+ 
                "No Scores Assigned");
            abandonRound = true;
        }
        else
        {
            System.out.println("The number is between " + randomNumberObj.getLowerLimit() +
                " and " + randomNumberObj.getUpperLimit() +"\n");
            player2.setGuesses(randomNumberObj.generateRandomNumber
                (randomNumberObj.getLowerLimit(), randomNumberObj.getUpperLimit()));

            System.out.println(player2.getName().toUpperCase() + " Guessed : " + player2.getGuesses() + "\n");
            playerTwoCorrectGuess = guessingGame(player2, player2.getGuesses(), correctNumber);
            remainingGuess--;
            System.out.println("Guesses Remaining " + remainingGuess);
        }

        return remainingGuess;
    }

    /**
     * This is the starting point of the Game
     * Game runs for 4 rounds, total 6 guesses in each
     * Whose turn is first is randomly chosen
     * After each round score is assigned
     * Player with highest total score wins
     */
    public void startGame()
    {
        int round = 1;
        System.out.println("*****WELCOME TO THE GUE55ING GAME!*****" + "\n" +
            "Guess the correct number, or as close as you can get to earn points!" + "\n" +
            "You have 3 Guesses in each of the 4 rounds!" + "\n" +
            "The Player with highest points, WINS!!!!\n");

        System.out.println("**********");

        nameValidation();   

        System.out.println("\nWelcome " + player1.getName().toUpperCase() + 
            ", You Will be Playing Against " + player2.getName().toUpperCase() + "\n");
        System.out.println("*****GAME BEGINS*****");

        while (round <= 4)
        { 
            System.out.println("*****ROUND : " + round + "*****\n");
            randomNumberObj.setLowerLimit(1);
            randomNumberObj.setUpperLimit(100);

            int numberToGuess = randomNumberObj.generateRandomNumber
                (randomNumberObj.getLowerLimit(), randomNumberObj.getUpperLimit());

            playerOneCorrectGuess = false;
            playerTwoCorrectGuess = false;
            abandonRound = false;
            int remainingGuess = 6;

            int abandonRoundIndicator = randomNumberObj.generateRandomNumber(1,20);
            int playerTurn = randomNumberObj.generateRandomNumber(1, 2);
            System.out.println("**********");

            while (remainingGuess != 0)
            {
                if (playerTurn == 1)
                {
                    remainingGuess = playerOneGuess(numberToGuess, remainingGuess);
                    if (abandonRound || playerOneCorrectGuess || playerTwoCorrectGuess) break;

                    remainingGuess = playerTwoGuess(abandonRoundIndicator, numberToGuess, remainingGuess);
                    if (abandonRound || playerOneCorrectGuess || playerTwoCorrectGuess) break;

                }
                else
                {
                    remainingGuess = playerTwoGuess(abandonRoundIndicator, numberToGuess, remainingGuess);
                    if (abandonRound || playerOneCorrectGuess || playerTwoCorrectGuess) break;

                    remainingGuess = playerOneGuess(numberToGuess, remainingGuess);
                    if (abandonRound || playerOneCorrectGuess || playerTwoCorrectGuess) break;
                }   
            }

            System.out.println("Correct Number was : " + numberToGuess);
            decideScore(remainingGuess, numberToGuess);
            round++;
        }

        decideWinner();
        System.out.println("*****GAME OVER*****");
    }
}