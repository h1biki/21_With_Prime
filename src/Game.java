import java.util.Scanner;

public class Game
{
    public void startGame()
    {
        Player player = new Player();
        Player computer = new Player();
        boolean isPlayerRegistered = false;
        String option = "";
        while (!option.equals("4"))
        {
            displayMenu();
            System.out.println("Please Choose Your Option:");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine().trim();// option 1, 2, 3, 4

            switch (option) {
                case "1":
                    String humanName = nameAssign();
                    player.setName(humanName);
                    computer.setName("Computer");
                    isPlayerRegistered = true;
                    break;

                case "2":
                    if (isPlayerRegistered)
                    {
                            System.out.println("Please Enter The Round Number You Want To Play");
                            int round = scanner.nextInt();
                            scanner.nextLine();

                        while (round > 10 || round < 0)
                        {
                            System.out.println("Please input a valid round number.");
                            round = scanner.nextInt();
                            scanner.nextLine();
                        }

                        for (int i = 0; i < round; i++)
                        {
                            System.out.println("");
                            System.out.println("Round: " + (i + 1));
                            playersPlaytile(player, computer);
                        }
                            judgeWinner(player, computer);
                            isPlayerRegistered = false;

                    }else
                        {
                            System.out.println("Please enter your name before start the game...");
                        }
                    break;

                case "3":
                    help();
                    break;

                case "4":
                    System.out.println("Game exited. Good Bye!");
                    break;

                default:

                    System.out.println("!!Invalid input, please input a valid option listed above!!");
                    break;
            }
        }

    }

    public String nameAssign()// menu 1
    {
        System.out.println("Please input your name.");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        while (userName.length() > 10 || userName.length() < 3)
        {
            System.out.println("Your input is invalid, the player's name must contain more than 3 letters and less than 10 letters, please re-input the name.");
            userName = scanner.nextLine().trim();
        }
        System.out.println("Gamer name assignment progress successfully finished.");
        System.out.println("Game will start shortly...");
        return userName;
    }

    public int computerPlay(Player computer, int gameTotal)
    {
        int randomlyChoose = 0;

        RNG random = new RNG(0, computer.getTiles().length - 1);
        randomlyChoose = random.generateNumber();// randomly generate

        Tile tile = computer.getTile(randomlyChoose);

        int totalScore = computer.getScore();

        computer.setLastTilePlayed(tile);
        gameTotal = gameTotal + tile.getValue();// game total value increment
        if (gameTotal <= 21)
        {
            totalScore += tile.getScore();
            computer.setScore(totalScore);
        }

        System.out.println("Computer plays tile " + computer.getLastTilePlayed().getValue() + ". Game total is now "
                + gameTotal + ". Computer score is " + totalScore + ".");
        System.out.println("");
        return gameTotal;
    }

    public int humanPlay(Player player, int gameTotal)
    {
        int chosenTileIndex = 0;
        for (int i = 0; i < player.getTiles().length; i++)// list human obtained tiles
        {
            int value = player.getTiles()[i].getValue();
            int score = player.getTiles()[i].getScore();
            int order = i + 1;
            System.out.println(order + "---" + "Tile value:" + value + "   Tile score:" + score);
        }
        System.out.println("Select your tile to play");
        Scanner scanner = new Scanner(System.in);// human choose a tile to play
        chosenTileIndex = scanner.nextInt();
        scanner.nextLine();

        Tile tile = player.getTile(chosenTileIndex - 1);

        int totalScore = player.getScore();
        player.setLastTilePlayed(tile);
        gameTotal += tile.getValue();
        if (gameTotal <= 21)
        {
            totalScore += tile.getScore();
            player.setScore(totalScore);
        }

        System.out.println(player.getName() + " plays tile " + player.getLastTilePlayed().getValue()
                + ". Game total is now " + gameTotal + ". " + player.getName() + " score is " + totalScore + ".");
        System.out.println("");
        return gameTotal;
    }

    // menu 2
    public void playersPlaytile(Player player, Player computer)
    {
        RNG rng = new RNG(0, 1);
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
            do
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
            do
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
            System.out.println("Because " + player.getName() + " didn't use 5, deduct 3 points. Now " + player.getName() + " points is " + player.getScore() + " .");
        }
        if (computer.hasFive())
        {
            computer.setScore(computer.getScore() - 3);
            System.out.println("Because " + computer.getName() + " didn't use 5, deduct 3 points. Now " + computer.getName() + " points is " + computer.getScore() + " .");
        }

        if (player.getScore() > computer.getScore())
        {
            System.out.println("");
            System.out.println(player.getName() + " won the round!");
            player.setRoundsWon(player.getRoundsWon() + 1);
            player.setScore(player.getScore() + 5);
            System.out.println("Because " + player.getName() + " won the round, bonus 5 points. Now "  + player.getName() + " point is " + player.getScore() + " .");
        } else
        {
            System.out.println("");
            System.out.println(computer.getName() + " won the round!");
            computer.setRoundsWon(computer.getRoundsWon() + 1);
            computer.setScore(computer.getScore() + 5);
            System.out.println("Because " + computer.getName() + " won the round, bonus 5 points. Now "  + computer.getName() + " point is " + computer.getScore() + " .");

        }
    }

    // menu 3
    public void help()
    {
        System.out.println("option 1 is to register a new name for a new gamer");
        System.out.println("option 2 is to start playing tiles between you and the computer");
        System.out.println("option 3 is to display the help menu");
        System.out.println("option 4 is to exit the game");
    }

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


    public void judgeWinner(Player player, Player computer)
    {
        if (player.getRoundsWon() < computer.getRoundsWon())
        {
            System.out.println("Game over! Computer win! better next time...");
        } else if (player.getRoundsWon() > computer.getRoundsWon())
        {
            System.out.println("Congratulations! you win!!");
        } else
        {
            System.out.println("OMG is a tie!!!");
        }
    }
}