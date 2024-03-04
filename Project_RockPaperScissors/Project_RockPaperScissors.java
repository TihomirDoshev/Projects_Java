package Foundamentals.Lesson2_DataTypesAndVariables.Project_RockPaperScissors;


import java.util.Random;
import java.util.Scanner;

public class Project_RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerStone = 0;
        int playerScissors = 0;
        int playerPaper = 0;
        int computerStone = 0;
        int computerScissors = 0;
        int computerPaper = 0;
        int playerWins = 0;
        int playerLosses = 0;
        int draw = 0;
        int totalGames = 0;

        String[] knh = {"Stone", "Scissors", "Paper"};
        String compMove = knh[new RandSom().nextInt(knh.length)];

        System.out.println("Choose (Stone, Scissors or Paper)");
        String player;

        while (true) {
            player = scanner.nextLine();
            compMove = knh[new Random().nextInt(knh.length)];


            if (player.equals("Stop")) {
                System.out.printf("Played games: %d%n", totalGames);
                System.out.printf("Wins: %d%n", playerWins);
                System.out.printf("Loses: %d%n", playerLosses);
                System.out.printf("Equals %d%n", draw);
                System.out.printf("Play with: Stone %d, Scissors %d, Paper %d%n", playerStone, playerScissors, playerPaper);
                System.out.printf("Computer play with: Stone %d, Scissors %d, Paper %d%n", computerStone, computerScissors, computerPaper);
                break;
            }

            if (player.equals("Stone") || player.equals("Scissors") || player.equals("Paper")) {
                System.out.println("Computer play : " + compMove);

                switch (compMove) {
                    case "Stone" -> computerStone++;
                    case "Scissors" -> computerScissors++;
                    case "Paper" -> computerPaper++;
                }
                if (player.equals(compMove)) {
                    if (player.equals("Stone")) {
                        playerStone++;
                    } else if (player.equals("Scissors")) {
                        playerScissors++;
                    } else {
                        playerPaper++;
                    }

                    draw++;
                    System.out.println("The game is equals!");
                    System.out.println("Try again ! To stop the game, type Stop.");

                } else if (player.equals("Stone")) {
                    playerStone++;
                    if (compMove.equals("Paper")) {
                        playerLosses++;
                        System.out.println("You loose!");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    } else if (compMove.equals("Scissors")) {
                        playerWins++;
                        System.out.println("You win!");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    }

                } else if (player.equals("Paper")) {
                    playerPaper++;
                    if (compMove.equals("Scissors")) {
                        playerLosses++;
                        System.out.println("You loose.");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    } else if (compMove.equals("Stone")) {
                        playerWins++;
                        System.out.println("You win!");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    }
                } else {
                    if (compMove.equals("Stone")) {
                        playerScissors++;
                        playerLosses++;
                        System.out.println("You loose.");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    } else if (compMove.equals("Paper")) {
                        playerScissors++;
                        playerWins++;
                        System.out.println("You win!");
                        System.out.println("Try again ! To stop the game, type Stop.");
                    }
                }
                totalGames++;
            } else {
                System.out.println(player + " Not a valid move. Try again.");
                continue;
            }
        }
    }
}
