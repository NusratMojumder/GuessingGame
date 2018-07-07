The aim of GuessingGame is for a person and the computer to compete against other to correctly guess a hidden number.

A game consists of four rounds. For each round a number between 1 and 100 (inclusive) is randomly generated and the players (person and computer) take turns to guess the number. The round ends when the correct guess is given or each player has had three guesses.

If a player guesses the number correctly then they are awarded points according to how many attempts were taken to guess the number. If the round ends without either player guessing correctly then the points are awarded to each player according to how close they were to the hidden number.

At the end of the four rounds the player with the highest cumulative score wins the game.

The following are the game rules:

• If the number is not guessed correctly then a message is displayed indicating whether the entered number was higher or lower than the hidden number and the other player takes a turn. Note this means that after each turn the range of possible numbers is reduced.

• If the player enters a number between 1 and 100 but not within the range of possible numbers (as explained above), then the player is given a warning message but is not given a chance to renter the number.

• If the player enters a number less than 1 or greater than 100, then a warning message is displayed and the player is invited to enter another number (with no penalty).

• If the player enters non-numeric characters, then a warning message is displayed and the player is invited to enter another number (with no penalty).

• If the human player enters 999 this indicates that they have decided to abandon the round. To simulate this for the computer player, at the start of each round, generate a random number between 1 and 20. This number will be known as the ‘abandon round indicator’. Then before each guess the computer player makes, generate a random number between 1 and 20. If this number is the same as the ‘abandon round indicator’ then the round is abandoned. If these numbers are not the same, the computer continues with its guess of the hidden number. o Abandoning a round means no scores are assigned to either player for that round.

• If a player correctly guesses the number then the round ends, points are awarded to this player according to how many attempts have been made. Note the total number of attempts includes attempts by both players. The other player scores zero for the game.

• If the round ends and no player has guessed the number then each player is awarded a score according to the proximity of their last guess to the hidden number, as follows: score = 10 – proximity-of-last-guess
