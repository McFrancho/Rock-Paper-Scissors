package com.company;

import java.util.Scanner;

public class Main {

    //This code was written by McFrancho Studios for beginners ^ ^

    static String result;
    static String userChoice;
    static int userScore = 0;
    static int computerScore = 0;
    static int turns;

    public static void main(String[] args) {

        System.out.println("Hello, Welcome to the Game of Rock, Paper, Scissors");

        System.out.println("Instructions: You are expected to input the first letter of your choice as shown below : "
                + "\nR = Rock" + "\nP = Paper" + "\nS = Scissors" +
                "\nDon't forget the output depends solely on your input");

        numberofTurns();
        if (turns % 2 == 0) {
            System.out.println("Error : Number of turns cannot be an even number. Select an odd number please");
        } else {
            System.out.println("Let's play!!!");

        for (int i = 0; i < turns; i++) {
            computerChoice();
            getUserChoice();
//          validateUserChoice();
            checkWinner();
        }
        }
        declareWinner();

    }

    /*
    This method creates an array
    Then it generates a random number
    Finally, it assigns the random number to an index in our array
     */
    private static String computerChoice() {
        String[] arrayOfRPS = {"Rock", "Paper", "Scissors"};

        int randomSelect = (int) (Math.random() * 3);
        result = arrayOfRPS[randomSelect];
        System.out.println("Rock... Paper... Scissors...");
        return result;
    }

    private static int numberofTurns() {
        Scanner sp = new Scanner(System.in);
        System.out.println("Please enter the number of turns(Number times you want to play) : ");
        turns = sp.nextInt();
        return turns;
    }

    //this method helps to get the user's choice
    private static String getUserChoice() {
        Scanner sc = new Scanner(System.in);

        userChoice = sc.nextLine();
        return userChoice;
    }

//    private static void validateUserChoice() {
//        if (!(getUserChoice().equalsIgnoreCase("R")
//                || getUserChoice().equalsIgnoreCase("S")
//                || getUserChoice().equalsIgnoreCase("P"))) {
//            System.out.println("input again");
//            getUserChoice();
//        }
//}

    //This method helps to check the winner
    private static void checkWinner() {
        if ((userChoice.equalsIgnoreCase("R") && result.equals("Rock"))
                || (userChoice.equalsIgnoreCase("P") && result.equals("Paper"))
                || (userChoice.equalsIgnoreCase("S") && result.equals("Scissors"))){

            System.out.println("This turn is invalid because we both showed the same option :" +
                    "\nYou chose " + userChoice + "\nI chose " + result);

        }
        else if(userChoice.equalsIgnoreCase("R") && result.equals("Scissors")
                || userChoice.equalsIgnoreCase("P") && result.equals("Rock")
                || userChoice.equalsIgnoreCase("S") && result.equals("Paper")) {

            userScoreKeeper();
        }
        else if(userChoice.equalsIgnoreCase("R") && result.equals("Paper")
                || userChoice.equalsIgnoreCase("P") && result.equals("Scissors")
                || userChoice.equalsIgnoreCase("S") && result.equals("Rock")) {

            computerScoreKeeper();
        }

    }

    private static void computerScoreKeeper() {
        computerScore += 1;
        System.out.println("Kudos to me!!! I won this turn");

    }

    private static void userScoreKeeper() {
        userScore += 1;
        System.out.println("Bravo!!! You won this turn");
    }

    private static void declareWinner() {
        System.out.println("Game Over!!!");

        if (userScore > computerScore) {
            System.out.println("You won this game with " + userScore + " turns"
                   + "\nYour Score : " + userScore + "\nMy Score : " + computerScore);
        }
        else if (userScore < computerScore) {
            System.out.println("I won this game with " + userScore + " turns"
                   + "\nYour Score : " + userScore + "\nMy Score : " + computerScore);
        }

        else {
            System.out.println("Nobody won this game. It's a tie!!!"
                    + "\nYour Score : " + userScore + "\nMy Score : " + computerScore);
        }
    }


}
