/**
 * Generates Random Numbers required in Game.
 *
 * @author (Nusrat Mojumder)
 * @version (Version: 1, Date: 30.3.2018)
 */
public class RandomNumber
{
    private int lowerLimit;
    private int upperLimit;

    /**
     * Default Constructor for objects of class RandomNumber
     */
    public RandomNumber()
    {
        lowerLimit = 1;
        upperLimit = 100;
    }

    /**
     * User Defined Constructor for objects of class RandomNumber
     */
    public RandomNumber(int minLimit, int maxLimit)
    {
        lowerLimit = minLimit;
        upperLimit = maxLimit;
    }

    /**
     * Randomly generate a number within a Range 
     * @param  min is the minimum range
     * @param  max is the maximum range
     * @return randomNum, a randomly generated number
     */
    public int generateRandomNumber(int min, int max)
    {
        return min + (int)(Math.random() * (max-min+1)); 
    }

    /**
     * Return the value of lower limit of range
     */
    public int getLowerLimit(){
        return lowerLimit;
    }

    /**
     * Return the value of upper limit of range
     */
    public int getUpperLimit(){
        return upperLimit;
    }

    /**
     * Setting the value of lower limit of range
     */
    public void setLowerLimit(int min){
        lowerLimit = min;
    }

    /**
     * Setting the value of upper limit of range
     */
    public void setUpperLimit(int max){
        upperLimit = max;
    }
}
