import java.util.Scanner;

public class PigPlay {

    private Die die1;
    private Die die2;
    private Scanner scan;
    private boolean finished = false;
    private boolean player1Won = false;
    private boolean player1Turn = true;
    private int player1Points = 0;
    private int player2Points = 0;
    private int currentPoints = 0;

    public PigPlay() {
        die1 = new Die();
        scan = new Scanner(System.in);
    }

    public int dieEyes() {
        return die1.getFaceValue();
    }

    public void rollDie() {
        die1.roll();
    }

    public void welcomeToGame() {
        System.out.println("Velkommen til Pig spillet");
    }

    public void gameOver() {
        if (this.player1Won) {
            System.out.println("Spiller et har vundet");
        }
        else {
            System.out.println("Spiller to har vundet");
        }
    }

    private void takeTurn() {
        rollDie();
        this.currentPoints += dieEyes();
        System.out.println("Du har slået: " + dieEyes());
        System.out.println();
        if (this.player1Turn) {
            if (dieEyes() == 1) {
                System.out.println("Du har mistet dine points svarende til " + (this.currentPoints - 1));
                System.out.println();
                this.player1Turn = false;
                this.currentPoints = 0;
                System.out.println("Det er nu spiller to til at kaste som er på " + player2Points);
                System.out.println();
            }
            else if (this.player1Points + this.currentPoints >= 100) {
                this.player1Won = true;
                this.finished = true;
            } else {
                System.out.println("Du er oppe på " + this.currentPoints + " points");
            }
        } else {
            if (dieEyes() == 1) {
                System.out.println("Du har mistet dine points svarende til " + (this.currentPoints - 1));
                System.out.println();
                this.player1Turn = true;
                this.currentPoints = 0;
                System.out.println("Det er nu spiller et til at kaste som er på " + player1Points);
                System.out.println();
            }
            else if (this.player2Points + this.currentPoints >= 100) {
                this.player1Won = false;
                this.finished = true;
            } else {
                System.out.println("Du er oppe på " + this.currentPoints + " points");
            }
        }
    }

    public void startGame() {
        welcomeToGame();
        while (!this.finished) {
            System.out.print("Vil du kaste en terning? Eller stoppe og beholde dine points. Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                if (player1Turn) {
                    player1Points += currentPoints;
                    player1Turn = false;
                    System.out.println();
                    System.out.println("Spiller et er på " + player1Points + " points");
                    System.out.println();
                    System.out.println("Det er nu spiller to til at kaste som er på " + player2Points);
                    System.out.println();
                    this.currentPoints = 0;
                    takeTurn();
                } else {
                    player2Points += currentPoints;
                    player1Turn = true;
                    System.out.println();
                    System.out.println("Spiller to er på " + player2Points + " points");
                    System.out.println();
                    System.out.println("Det er nu spiller et til at kaste som er på " + player1Points);
                    System.out.println();
                    this.currentPoints = 0;
                    takeTurn();
                }
            } else {
                takeTurn();
            }
        }
        gameOver();
    }
}
