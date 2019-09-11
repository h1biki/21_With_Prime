/**
 * class Game include the gaming rules and display, which is the core part of the gaming program
 *
 * @author (Zixi Zhao)
 * @version (10-9-2019)
 */

import java.util.Scanner;

public class Game
{
    /**
     * Method for starting the program
     *
     * @return    void
     */

    public void startGame()
    {
        Player player = new Player();
        Player computer = new Player();//create both player's object
        boolean isPlayerRegistered = false;//flag of whether human player's name has assigned
        String option = "";//select option from the main menu
        while (!option.equals("4"))//this loop keeps game running until player pressed 4
        {
            displayMenu();
            System.out.println("Please Choose Your Option:");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine().trim();//receiving option from the player

            switch (option) {
                case "1":
                    player.setName(nameAssign());
                    computer.setName("Computer");
                    isPlayerRegistered = true;//after name assignment setted flag to true
                    break;
                case "2":
                    if (isPlayerRegistered)//check flag
                    {
                        System.out.println("Please Enter The Round Number You Want To Play: ");
                        int round = scanner.nextInt();
                        scanner.nextLine();//receiving rounds that player wants to play
                        while (round > 10 || round < 0)//this loop check the rules of the round number
                        {
                            System.out.println("Rounds number should be greater than 0 and less than 10.");
                            System.out.println("Please input a valid round number: ");
                            round = scanner.nextInt();
                            scanner.nextLine();
                        }
                        for (int i = 0; i < round; i++)//this loop start playing the game until reached the received round number
                        {
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Round: " + (i + 1));
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            playersPlaytile(player, computer);
                        }
                        judgeWinner(player, computer);//judge the winner
                        isPlayerRegistered = false;//flag setted to false, in order to start a fresh new game
                    }
                    else
                    {
                        System.out.println("Please Assign Your Name Before Playing...");//if player not registered asked to input name
                    }
                    break;
                case "3":
                    help();//display help menu
                    break;
                case "4":
                    System.out.println("Game exited. Good Bye!");//game exit
                    break;
                default:
                    System.out.println("!!Invalid input, please input a valid option listed above!!");//player has invalid input
                    break;
            }
        }
    }

    /**
     * To assign a player name. When get input from keyboard then return the input as human player's name,
     * if the name doesn't follow the naming rules then ask player to re-input the name
     *
     * @return    String userName
     */
    // menu 1
    public String nameAssign()
    {
        System.out.println("Please Input Your Name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine().trim();
        while (userName.length() > 10 || userName.length() < 3)
        {
            System.out.println("The player's name should contains more than 3 letters and less than 10 letters.");
            System.out.println("Please re-input the name: ");
            userName = scanner.nextLine().trim();
        }
        System.out.println("Gamer name assignment progress successfully finished.");
        System.out.println("Game will start shortly...");
        return userName;
    }

    /**
     * The computer's gaming logic
     *
     * @param  Player computer, int gameTotal
     * @return    int gameTotal
     */
    public int computerPlay(Player computer, int gameTotal)
    {
        RNG random = new RNG(0, computer.getTiles().length - 1);//genarate a random tile index from 0 to the max index of tiles[]
        int randomlyChoose = random.generateNumber();// randomly generate
        Tile tilePlayed = computer.getTile(randomlyChoose);//method getTile has 2 functions, returned tile played and replace the tiles[]
        computer.setLastTilePlayed(tilePlayed);
        int totalScore = computer.getScore();
        gameTotal += tilePlayed.getValue();// game total value increment
        if (gameTotal <= 21)
        {
            totalScore += tilePlayed.getScore();
            computer.setScore(totalScore);
        }
        System.out.println("Computer plays tile " + computer.getLastTilePlayed().getValue() + ". Game total is now "
                + gameTotal + ". Computer score is " + totalScore + ".");
        System.out.println("");
        return gameTotal;
    }

    /**
     * The human's gaming logic
     *
     * @param  Player player, int gameTotal
     * @return    int gameTotal
     */
    public int humanPlay(Player player, int gameTotal)
    {
        for (int i = 0; i < player.getTiles().length; i++)// list human obtained tiles
        {
            int value = player.getTiles()[i].getValue();
            int score = player.getTiles()[i].getScore();
            int tileOrder = i + 1;
            System.out.println(tileOrder + "---" + "Tile value:" + value + "   Tile score:" + score);
        }
        System.out.println("");
        System.out.println("Select Your Tile To Play: ");
        Scanner scanner = new Scanner(System.in);// human choose a tile to play
        int chosenTileIndex = scanner.nextInt();
        scanner.nextLine();
        Tile tilePlayed = player.getTile(chosenTileIndex - 1);//method getTile has 2 functions, returned tile played and replace the tiles[]
        player.setLastTilePlayed(tilePlayed);
        int totalScore = player.getScore();
        gameTotal += tilePlayed.getValue();
        if (gameTotal <= 21)
        {
            totalScore += tilePlayed.getScore();
            player.setScore(totalScore);
        }
        System.out.println(player.getName() + " plays tile " + player.getLastTilePlayed().getValue()
                + ". Game total is now " + gameTotal + ". " + player.getName() + " score is " + totalScore + ".");
        System.out.println("");
        return gameTotal;
    }

    /**
     * Tthe interactive part between human player and computer player
     *
     * @param  Player player, Player computer
     * @return    void
     */
    // menu 2
    public void playersPlaytile(Player player, Player computer)
    {
        RNG rng = new RNG(0, 1);//generate 0 or 1
        int randomNumber = rng.generateNumber();
        int gameTotal = 0;
        computer.setScore(0);
        player.setScore(0);
        computer.givePlayersTile();
        player.givePlayersTile();
        if (randomNumber == 0)
        {
            System.out.println(player.getName() + " is the first one who start the game");
            System.out.println("");
            do//play until gameTotal over 21
            {
                // human start first
                gameTotal = humanPlay(player, gameTotal);
                if (gameTotal >= 21)
                {
                    break;
                }
                gameTotal = computerPlay(computer, gameTotal);
            } while (gameTotal < 21);
        } else
        {
            System.out.println(computer.getName() + " is the first one who start the game");
            System.out.println("");
            do//play until gameTotal over 21
            {
                // computer start first
                gameTotal = computerPlay(computer, gameTotal);
                if (gameTotal >= 21)
                {
                    break;
                }
                gameTotal = humanPlay(player, gameTotal);
            } while (gameTotal < 21);
        }

        if (player.hasFive())
        {
            player.setScore(player.getScore() - 3);
            System.out.println("Because " + player.getName() + " didn't use 5, deduct 3 points. Now "
                    + player.getName() + " points is " + player.getScore() + ".");
            System.out.println("");
        }

        if (computer.hasFive())
        {
            computer.setScore(computer.getScore() - 3);
            System.out.println("Because " + computer.getName() + " didn't use 5, deduct 3 points. Now "
                    + computer.getName() + " points is " + computer.getScore() + ".");
            System.out.println("");
        }

        if (player.getScore() > computer.getScore())
        {
            System.out.println("==============================Round Statistics===========================");
            System.out.println(player.getName() + " won the round!");
            player.setRoundsWon(player.getRoundsWon() + 1);
            player.setScore(player.getScore() + 5);
            System.out.println("Because " + player.getName() + " won the round, bonus 5 points. Now "
                    + player.getName() + " point is " + player.getScore() + ".");
            System.out.println("=========================================================================");
            System.out.println("");
        }
        else if (player.getScore() < computer.getScore())
        {
            System.out.println("==============================Round Statistics===========================");
            System.out.println(computer.getName() + " won the round!");
            computer.setRoundsWon(computer.getRoundsWon() + 1);
            computer.setScore(computer.getScore() + 5);
            System.out.println("Because " + computer.getName() + " won the round, bonus 5 points. Now "
                    + computer.getName() + " point is " + computer.getScore() + ".");
            System.out.println("=========================================================================");
            System.out.println("");
        }
        else
        {
            System.out.println("==============================Round Statistics===========================");
            System.out.println("It's a tie round!");
            System.out.println("=========================================================================");
            System.out.println("");
        }
    }

    /**
     * To display the help menu
     *
     * @return    void
     */
    // menu 3
    public void help()
    {
        System.out.println("");
        System.out.println("-----------------------------HELP MENU-----------------------------");
        System.out.println("===================================================================");
        System.out.println("Option 1 is to register a new name for a new gamer");
        System.out.println("PLEASE REGISTER YOUR NAME FIRST");
        System.out.println("OTHERWISE, THE GAME WON'T START YOUR YOU");
        System.out.println("*******************************************************************");
        System.out.println("Option 2 is to start playing tiles between you and the computer");
        System.out.println("AFTER NAME REGISTERED YOU CAN PRESS 2 TO START GAMING WITH COMPUTER");
        System.out.println("*******************************************************************");
        System.out.println("Option 3 is to display the help menu");
        System.out.println("THIS IS WAHT YOU ARE READING NOW ^-^");
        System.out.println("*******************************************************************");
        System.out.println("Option 4 is to exit the game");
        System.out.println("SOMETIME ESCAPE IS AN OPTION =_=");
        System.out.println("===================================================================");
        System.out.println("");
    }

    /**
     * To display the main menu
     *
     * @return    void
     */
    public void displayMenu()
    {
        System.out.println("");
        System.out.println("============================================");
        System.out.println("*    Welcome To The 21-With-Prime Game!    *");
        System.out.println("*                                          *");
        System.out.println("* Please select from the following options *");
        System.out.println("*     Press 1 to register a new player     *");
        System.out.println("*       Press 2 to start a new game        *");
        System.out.println("*        Press 3 to view help menu         *");
        System.out.println("*             Press 4 to exit              *");
        System.out.println("============================================");
        System.out.println("");
    }

    /**
     * Judge the winner according to their rounds won, who won more rounds becomes the final winner
     *
     * @param  Player player, Player computer
     * @return    void
     */
    public void judgeWinner(Player player, Player computer)
    {
        if (player.getRoundsWon() < computer.getRoundsWon())
        {
            System.out.println("==============================Game Statistics============================");
            System.out.println(player.getName() + " won " + player.getRoundsWon() + " rounds.");
            System.out.println(computer.getName() + " won " + computer.getRoundsWon() + " rounds.");
            System.out.println("Game over! Computer win! better next time...");
            System.out.println("=========================================================================");
            System.out.println("");
        } else if (player.getRoundsWon() > computer.getRoundsWon())
        {
            System.out.println("==============================Game Statistics============================");
            System.out.println(player.getName() + " won " + player.getRoundsWon() + " rounds.");
            System.out.println(computer.getName() + " won " + computer.getRoundsWon() + " rounds.");
            System.out.println("Game over! Congratulations! you win!!");
            System.out.println("=========================================================================");
            System.out.println("");
        } else
        {
            System.out.println("==============================Game Statistics============================");
            System.out.println(player.getName() + " won " + player.getRoundsWon() + " rounds.");
            System.out.println(computer.getName() + " won " + computer.getRoundsWon() + " rounds.");
            System.out.println("Game over! OMG is a tie!!!");
            System.out.println("=========================================================================");
            System.out.println("");
        }
    }
}