import java.util.Scanner;

public class NumberGuessingGame {
    public static int getRandomNumber(int minimumNumber, int maximumNumber){
        return(int)(Math.random()*(maximumNumber - minimumNumber +1)+minimumNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chances = 10;
        int finalScore = 0;
        boolean wantToPlayAgain = true;
        int roundsPlayed = 1;

        System.out.println("WELCOME!");
        System.out.println("Guess the correct number in "+chances+" and win the game.");

        while(wantToPlayAgain){
            int random = getRandomNumber(1,100);
            boolean guessNum = false;
            System.out.println("Round"+roundsPlayed+":");

            for(int i=0; i<chances; i++){
                System.out.println("Enter the number: ");
                int getNum = scanner.nextInt();
                if(getNum == random){
                    guessNum = true;
                    finalScore = (chances - i);
                    System.out.println("You guessed the correct number.");
                    break;
                }
                else if(getNum > random){
                    System.out.println("Too high.");
                }
                else{
                    System.out.println("Too low.");
                }
            }

            if(!guessNum){
                System.out.println("Sorry, no chances left. The correct number is " + random);
            }

            System.out.println("Score for round"+roundsPlayed+" is : "+finalScore);
            System.out.println("Find it out interesting? Want to play again? (yes/no)");
            String playAgain = scanner.next();

            wantToPlayAgain = playAgain.equalsIgnoreCase("yes");
            roundsPlayed++;
        }
        System.out.println("Thank You!");
    }
}